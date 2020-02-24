package iv.spring.ws.server.ws

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class WSHandler: TextWebSocketHandler() {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun handleTextMessage(session:WebSocketSession, message: TextMessage) {
        logger.info("MSG")
    }
}