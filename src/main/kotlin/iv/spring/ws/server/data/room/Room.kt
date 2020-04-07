package iv.spring.ws.server.data.room

import iv.spring.ws.server.data.user.User
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "room")
data class Room (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        var id: Long?,
        @Column(name = "name", nullable = false, unique = true)
        var name: String,
        @Column(name = "create_date", nullable = false)
        var createDate: Calendar,
        @Column(name = "host", nullable = false)
        var host:String,
        @Column(name = "live", nullable = false)
        var live: Boolean,
        @Column(name = "last_connect_date", nullable = false)
        var lastConnectDate: Calendar,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "host", referencedColumnName = "login", insertable = false, updatable = false)
        var user: User
): Serializable