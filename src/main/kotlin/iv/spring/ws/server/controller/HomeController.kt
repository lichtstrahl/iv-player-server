package iv.spring.ws.server.controller

import iv.spring.ws.server.aspect.LogAspect
import iv.spring.ws.server.data.dto.TestDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @LogAspect
    @ResponseBody
    @GetMapping("/")
    fun home(): TestDTO {
        logger.info("HOME")
        return TestDTO("k1", "v1")
    }
}