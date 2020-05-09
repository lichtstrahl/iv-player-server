package iv.spring.ws.server.data.dto

data class BaseResponse<T>(
        var errorCode: Int,
        var errorMsg: String?,
        var data: T?
) {
    companion object {
        const val OK  = 0
        const val ROOM_NOT_ACTIVE = 1
        const val NOT_FOUND = 404

        fun <T> ok(data:T): BaseResponse<T> = BaseResponse(OK, null, data)
        fun <T> error(code: Int, errorMsg: String): BaseResponse<T> = BaseResponse(code, errorMsg, null)
    }
}