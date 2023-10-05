package Testw.Test2.Ad;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

   public List<Advertisement> findByOrderByReadCountDesc();

   public List<Advertisement> findTop5ByOrderByReadCountDesc();
   public List<Advertisement> findByOrderByReadCountDesc(Pageable page);

   @Query("select a from Advertisement a where a.content like concat('%', :query, '%') or a.title like concat('%', :query, '%') ")
   public List<Advertisement> getContainingText(String query);
   @Query("select max(a.id) from Advertisement a")
   public int getMaxId();


}
