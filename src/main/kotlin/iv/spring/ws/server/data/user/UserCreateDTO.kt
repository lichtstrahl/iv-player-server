package iv.spring.ws.server.data.user


data class UserCreateDTO(
        var login: String,
        var password: String,
        var firstName: String,
        var lastName: String
)