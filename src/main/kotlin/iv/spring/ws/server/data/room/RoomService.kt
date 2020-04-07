package iv.spring.ws.server.data.room

import iv.spring.ws.server.data.user.User
import iv.spring.ws.server.data.user.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class RoomService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)


    @Autowired
    lateinit var roomRepository: RoomRepository
    @Autowired
    lateinit var userRepository: UserRepository


    fun createRoom(dto: RoomCreateDTO): RoomEntityDTO {
        val user:User? = userRepository.findByLogin(dto.login)

        user?.let {
            var newRoom = Room(
                    null,
                    dto.name,
                    Calendar.getInstance(),
                    dto.login,
                    true,
                    Calendar.getInstance(),
                    user
            )
            newRoom = roomRepository.save(newRoom)
            return RoomEntityDTO(
                    newRoom.id!!,
                    newRoom.name,
                    newRoom.createDate,
                    newRoom.host,
                    newRoom.live,
                    newRoom.lastConnectDate
            )
        }

        val error = "User with login=${dto.login} not found"
        logger.warn(error)
        throw RuntimeException(error)
    }
}