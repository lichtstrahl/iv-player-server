package iv.spring.ws.server.controller

import iv.spring.ws.server.data.room.RoomCreateDTO
import iv.spring.ws.server.data.room.RoomEntityDTO
import iv.spring.ws.server.data.room.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/rooms")
class RoomController {

    @Autowired
    lateinit var roomService: RoomService

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
    @GetMapping("/for")
    fun getRoomsForUser(@RequestParam(name = "login") login: String): List<RoomEntityDTO> {
        return roomService.getRoomListForUser(login)
    }
}