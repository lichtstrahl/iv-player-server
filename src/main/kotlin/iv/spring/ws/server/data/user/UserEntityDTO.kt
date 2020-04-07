package iv.spring.ws.server.data.user

import java.util.*

data class UserEntityDTO(
        var id: Long,
        var login: String,
        var password: String,
        var firstName: String,
        var lastName: String,
        var lastAccessTime: Calendar,
        var uuid: String
)