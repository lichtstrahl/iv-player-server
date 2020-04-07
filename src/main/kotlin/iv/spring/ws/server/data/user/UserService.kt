package iv.spring.ws.server.data.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {
    val TEMP_UUID = "temp"

    @Autowired
    lateinit var userRepository: UserRepository

    fun createUser(dto: UserCreateDTO): UserEntityDTO {
        var newUser: User = User(
                null,
                dto.login,
                dto.password,
                dto.firstName,
                dto.lastName,
                Calendar.getInstance(),
                TEMP_UUID
        )

        // Сохранили в БД, теперь обработаем создание UUID
        val newID = userRepository.save(newUser).id!!
        newUser = userRepository.getOne(newID)
        newUser.uuid = generateUUID(newID, newUser.login)
        userRepository.flush()

        return UserEntityDTO(
                newID,
                newUser.login,
                newUser.password,
                newUser.firstName,
                newUser.lastName,
                newUser.lastAccessTime,
                newUser.uuid
        )
    }

    private fun generateUUID(id: Long, login: String)
            = String.format("%d-%s-%02d", id, login, Random().nextInt(100))
}