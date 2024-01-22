package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository <User, Long>{

    @Query("SELECT coalesce(sum(b.price),0) FROM Cart c join c.books b WHERE c.owner.id = :userId")
    double getTotalCartValueForUser(@Param("userId") Long userId);
}
