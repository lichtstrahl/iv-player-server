package iv.spring.ws.server.controller

import iv.spring.ws.server.aspect.LogAspect
import iv.spring.ws.server.data.dto.AuthResponse
import iv.spring.ws.server.data.dto.BaseResponse
import iv.spring.ws.server.data.dto.FreeDTO
import iv.spring.ws.server.data.user.UserCreateDTO
import iv.spring.ws.server.data.user.UserEntityDTO
import iv.spring.ws.server.data.user.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/users")
class UserController: BaseController() {

    @Autowired
    lateinit var userService: UserService

    @LogAspect
    @ResponseBody
    @PostMapping("/create")
    fun createUser(@RequestBody userDTO: UserCreateDTO): UserEntityDTO {
        return userService.createUser(userDTO)
    }

    @LogAspect
    @ResponseBody
    @GetMapping("/auth")
    fun authUser(@RequestParam(name = "login") login: String, @RequestParam(name = "password") password: String)
            : BaseResponse<AuthResponse> {
        val auth: Boolean = userService.authUser(login, password)
        val user: UserEntityDTO = userService.getUser(login)
        return BaseResponse.ok(AuthResponse(user, auth))
    }

    @LogAspect
    @ResponseBody
    @GetMapping("/login/free")
    fun isFreeLogin(@RequestParam(name = "login") login: String): FreeDTO {
        val free = userService.loginFree(login)
        return FreeDTO(free)
    }
}