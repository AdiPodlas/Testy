package Testw.Test2.Ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.*;

@Service
public class AdvertisementService {

    private int nextId = 1;

    @Autowired
    private AdvertisementRepository advertisementRepository;


    public Advertisement addAdvertisement(AdvertisementRequest request) {
        Advertisement newAdvertisement = new Advertisement(
                nextId,
                request.getTitle(),
                request.getContent(),
                LocalDateTime.now(),
                request.getAuthorEmail()
        );
        advertisementRepository.save(newAdvertisement);
        nextId++;
        return newAdvertisement;
    }

    public List<AdvertisementSummary> getAllAdvertisements() {
        List<Advertisement> fromDb = advertisementRepository.findAll();
        List<AdvertisementSummary> summaryList = new ArrayList<>();
        for (Advertisement ad : fromDb) {
            summaryList.add(new AdvertisementSummary(ad.getId(), ad.getTitle(), ad.getCreationDate()));
        }
        return summaryList;
    }


 //   public List<Advertisement> getMostReadPosts(int id) {
 //
 //   }
   public boolean deleteAdById(int id){
        if (advertisementRepository.existsById(id)) {
            advertisementRepository.deleteById(id);
            return true;
        }
       return false;
   }

    public void deleteAllAdvertisement() {
        advertisementRepository.deleteAll();
    }
}
