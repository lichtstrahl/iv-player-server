package iv.spring.ws.server.ws

import iv.spring.ws.server.service.TicTacService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class TicTacWebSocket: TextWebSocketHandler() {
    @Autowired
    lateinit var ticTacService: TicTacService

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        ticTacService.handleMessage(message.payload)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        ticTacService.afterConnectionOpen(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        ticTacService.afterConnectionClose(session)
    }
}