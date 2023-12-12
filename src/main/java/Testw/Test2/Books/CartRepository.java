package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT sum(b.price) FROM Cart c join c.books b where c.id = :id")
    double getTotal(@Param("id") Long id);

}
