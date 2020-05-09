package iv.spring.ws.server.error

import java.lang.RuntimeException

data class ServerException(
        val msg: String,
        val errorCode: Int
): RuntimeException(msg) {
}