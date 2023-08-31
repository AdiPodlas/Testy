package Testw.Test2.Ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

    boolean existsById(Long id);

    void deleteById(Long id);
}
