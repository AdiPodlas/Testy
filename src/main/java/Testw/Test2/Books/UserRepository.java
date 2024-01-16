package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>{



    @Query("SELECT sum(b.price) FROM Cart c join c.books b WHERE c.owner.id = :userId")
    Optional<Double> getTotalCartValueForUser(@Param("userId") Long userId);
}
