package iv.spring.ws.server.controller

import iv.spring.ws.server.data.room.RoomCreateDTO
import iv.spring.ws.server.data.room.RoomEntityDTO
import iv.spring.ws.server.data.room.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

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
}