package Testw.Test2.Ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

   public List<Advertisement> findByOrderByReadCountDesc();

}
