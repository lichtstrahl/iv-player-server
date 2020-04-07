package iv.spring.ws.server.controller

import iv.spring.ws.server.data.user.UserCreateDTO
import iv.spring.ws.server.data.user.UserEntityDTO
import iv.spring.ws.server.data.user.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api/users")
class UserController {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var userService: UserService

    @ResponseBody
    @PostMapping("/create")
    fun createUser(@RequestBody userDTO: UserCreateDTO): UserEntityDTO {
        return userService.createUser(userDTO)
    }
}