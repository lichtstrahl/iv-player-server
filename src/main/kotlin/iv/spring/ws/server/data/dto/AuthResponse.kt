package iv.spring.ws.server.data.dto

import iv.spring.ws.server.data.user.UserEntityDTO

data class AuthResponse(
        var user: UserEntityDTO,
        var auth: Boolean
)