package iv.spring.ws.server.controller

import io.swagger.annotations.ApiOperation
import iv.spring.ws.server.data.dto.BaseResponse
import iv.spring.ws.server.data.room.RoomCreateDTO
import iv.spring.ws.server.data.room.RoomEntityDTO
import iv.spring.ws.server.data.room.RoomService
import iv.spring.ws.server.data.user.UserEntityDTO
import iv.spring.ws.server.data.user.UserService
import iv.spring.ws.server.error.ServerException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/rooms")
class RoomController {

    @Autowired
    lateinit var roomService: RoomService
    @Autowired
    lateinit var userService: UserService

    @ResponseBody
    @PostMapping("/create")
    fun createRoom(@RequestBody dto:RoomCreateDTO): RoomEntityDTO {
        return roomService.createRoom(dto)
    }

    @ResponseBody
    @GetMapping("/all")
    fun getAll(): List<RoomEntityDTO> {
        return roomService.getAllRooms()
    }

    @ResponseBody
    @GetMapping("/for-user")
    @ApiOperation("Получения списка комнат, в которых данный пользователь являлся host-ом")
    fun getRoomsForUser(@RequestParam(name = "login") login: String): List<RoomEntityDTO> {
        return roomService.getRoomListForUser(login)
    }

    @ResponseBody
    @GetMapping("/users")
    @ApiOperation("Получение пользователей в комнате")
    fun getUsersFromRoom(name: String): BaseResponse<List<UserEntityDTO>> {
        val users = roomService.getUsersInRoom(name)
        return BaseResponse.ok(userService.toEntityUserDTO(users))
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServerException::class)
    fun handleException(exception: ServerException): BaseResponse<String> {
        return BaseResponse.error(exception.errorCode, exception.msg)
    }
}