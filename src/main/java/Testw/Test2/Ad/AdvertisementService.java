package Testw.Test2.Ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
                advertisementRepository.getMaxId()+1,
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
            summaryList.add(new AdvertisementSummary(ad.getId(), ad.getTitle(),ad.getContent(), ad.getCreationDate()));
        }
        return summaryList;
    }

    public Advertisement getAdById(int id) {
        Optional<Advertisement> fromDB = advertisementRepository.findById(id);
        if (fromDB.isEmpty()) {
            return null;
        }
        Advertisement advertisement = fromDB.get();
        advertisement.incrementReadCount();
        advertisementRepository.save(advertisement);
        return advertisement;
    }


      public List<Advertisement> getMostReadAds() {
      return advertisementRepository.findByOrderByReadCountDesc();
      }
    public boolean deleteAdById(int id) {
        if (advertisementRepository.existsById(id)) {
            advertisementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAllAdvertisement() {
        advertisementRepository.deleteAll();
    }

    public List<Advertisement> getMostReadCountAds(int count) {
        return advertisementRepository.findByOrderByReadCountDesc(Pageable.ofSize(count));
    }


    public List<String> getBytext(String query) {
        List<Advertisement> listOfAds = advertisementRepository.getContainingText(query);
        List<String> result = new ArrayList<String>();
        for (Advertisement ad : listOfAds){
            result.add(ad.getContent());
        }
        return result ;
    }
}

