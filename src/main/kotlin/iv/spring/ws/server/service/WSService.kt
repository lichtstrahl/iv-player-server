package iv.spring.ws.server.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class WSService {
    private val logger:Logger = LoggerFactory.getLogger(this.javaClass)
    fun afterConnectionClose() {

    }

    fun afterConnectionOpen() {

    }

    fun handleMessage(message: String) {
        logger.debug("Handle message")
        logger.info(message)
    }
}