package iv.spring.ws.server.ws

import iv.spring.ws.server.service.WSService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class WSHandler: TextWebSocketHandler() {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var wsService: WSService

    override fun handleTextMessage(session:WebSocketSession, message: TextMessage) {
        wsService.handleMessage(message.payload)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
        logger.debug("connect")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
        logger.debug("disconnect")
    }
}