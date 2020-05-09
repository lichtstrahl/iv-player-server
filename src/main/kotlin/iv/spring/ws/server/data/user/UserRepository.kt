package iv.spring.ws.server.data.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByLogin(login: String): User?

    fun findByCurrentRoomId(id: Long): List<User>
}