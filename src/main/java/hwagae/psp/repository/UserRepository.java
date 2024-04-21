package hwagae.psp.repository;

import hwagae.psp.entity.com.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}