package iv.spring.ws.server.data.user

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*
import java.util.stream.Collectors

@Service
class UserService {
    val TEMP_UUID = "temp"
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)


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

        return toEntityUserDTO(newUser)
    }

    fun authUser(login: String, password: String): Boolean {
        val user = userRepository.findByLogin(login)

        return if (user != null) {
            return user.password == password
        } else {
            logger.warn("User with login=$login not found")
            false
        }
    }

    fun loginFree(login: String): Boolean {
        return userRepository.findByLogin(login) == null
    }

    fun getUser(login: String): UserEntityDTO {
        val user = userRepository.findByLogin(login)

        user?.let {
            return toEntityUserDTO(user)
        }

        val error = "User with login=$login not found"
        logger.warn(error)
        throw RuntimeException(error)
    }

    fun toEntityUserDTO(user: User): UserEntityDTO
            = UserEntityDTO(
            user.id!!,
            user.login,
            user.password,
            user.firstName,
            user.lastName,
            user.lastAccessTime,
            user.uuid
    )

    fun toEntityUserDTO(users: List<User>): List<UserEntityDTO>
            = users
                .stream()
                .map { this.toEntityUserDTO(it) }
                .collect(Collectors.toList())

    private fun generateUUID(id: Long, login: String)
            = String.format("%d-%s-%02d", id, login, Random().nextInt(100))
}