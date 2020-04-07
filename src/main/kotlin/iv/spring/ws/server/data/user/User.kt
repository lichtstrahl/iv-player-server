package iv.spring.ws.server.data.user

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        var id: Long?,
        @Column(name = "login", nullable = false, unique = true)
        var login: String,
        @Column(name = "password", nullable = false)
        var password: String,
        @Column(name = "first_name", nullable = false)
        var firstName: String,
        @Column(name = "last_name", nullable = false)
        var lastName: String,
        @Column(name = "last_access_time", nullable = false)
        var lastAccessTime: Calendar,
        @Column(name = "uuid", nullable = false, unique = true)
        var uuid: String
): Serializable