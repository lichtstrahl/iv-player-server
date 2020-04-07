package iv.spring.ws.server.data.room

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository: JpaRepository<Room, Long> {
    fun findByHost(login: String): List<Room>
}