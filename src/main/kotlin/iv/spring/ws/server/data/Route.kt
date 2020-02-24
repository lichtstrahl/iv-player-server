package iv.spring.ws.server.data

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "route")
data class Route(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        val id: Long,
        @Column(name = "name", nullable = false)
        var name: String
): Serializable