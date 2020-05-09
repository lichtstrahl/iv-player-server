package iv.spring.ws.server.config

import iv.spring.ws.server.ws.TicTacWebSocket
import iv.spring.ws.server.ws.WSHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WSConfig: WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(wsHandler(), "/ws-handler")
        registry.addHandler(TicTacWebSocket(), "ws/tic-tac")
    }

    @Bean
    fun  wsHandler(): WebSocketHandler = WSHandler()
}