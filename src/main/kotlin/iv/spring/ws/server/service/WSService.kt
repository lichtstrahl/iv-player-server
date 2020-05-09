package iv.spring.ws.server.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.socket.WebSocketSession

@Service
class WSService {
    private val logger:Logger = LoggerFactory.getLogger(this.javaClass)
    fun afterConnectionClose(socketSession:WebSocketSession) {
        logger.debug("connection close")
    }

    fun afterConnectionOpen(socketSession: WebSocketSession) {
        logger.debug("connection open")
    }

    fun handleMessage(message: String) {
        logger.debug("Handle message")
        logger.info(message)
    }
}