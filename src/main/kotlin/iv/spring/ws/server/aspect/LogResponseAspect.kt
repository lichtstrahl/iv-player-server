package iv.spring.ws.server.aspect

import iv.spring.ws.server.data.dto.BaseResponse
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class LogResponseAspect {

    @Pointcut("@annotation(LogAspect)")
    fun logMethods() {}

    @AfterReturning(pointcut = "logMethods()", returning = "result")
    fun afterReturn(joinPoint: JoinPoint, result: Any) {
        if (result is BaseResponse<*>) {
            println("RESPONSE: $result")
        }
    }

}