package iv.spring.ws.server.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.socket.WebSocketSession

@Service
class TicTacService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    fun afterConnectionClose(socketSession: WebSocketSession) {
        logger.info("connection close")
    }

    fun afterConnectionOpen(socketSession: WebSocketSession) {
        logger.info("connection open")
    }

    fun handleMessage(message: String) {
        logger.info("Handle message: $message")
    }
}