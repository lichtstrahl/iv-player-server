package iv.spring.ws.server.data.room

import java.util.*

data class RoomEntityDTO(
        var id: Long,
        var name: String,
        var createDate: Calendar,
        var host: String,
        var live: Boolean,
        var lastConnectDate: Calendar
)