package Testw.Test2.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT AVG(b.price) FROM Category c JOIN c.books b WHERE c.id = :categoryId")
    Double getAveragePriceByCategoryId(@Param("id") Long categoryId);

    @Query("SELECT SUM(b.price * b.availableCopies) FROM Category c JOIN c.books b WHERE c.id = :categoryId")
    Double getTotalValueByCategoryId2(@Param("Id") Long categoryId);

}
