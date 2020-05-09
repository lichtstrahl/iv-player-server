package iv.spring.ws.server.controller

import iv.spring.ws.server.data.dto.BaseResponse
import iv.spring.ws.server.error.ServerException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

abstract class BaseController {
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServerException::class)
    fun handleException(exception: ServerException): BaseResponse<String> {
        return BaseResponse.error(exception.errorCode, exception.msg)
    }
}