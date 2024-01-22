package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByOwner(User owner);

    @Query("SELECT coalesce(sum(b.price), 0) FROM Cart c join c.books b where c.id = :id")
    double getTotal(@Param("id") Long id);
}
