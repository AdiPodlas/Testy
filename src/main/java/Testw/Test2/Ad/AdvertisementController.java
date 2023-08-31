package Testw.Test2.Ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/ad")
class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;


    @PostMapping("/advertisements")
    public Advertisement addAdvertisement(@RequestBody AdvertisementRequest request) {
        return advertisementService.addAdvertisement(request);
    }

    @GetMapping("/advertisements/{id}")
    public Advertisement getAdById(@PathVariable int id) {
        return advertisementService.getAdById(id);
    }

    @GetMapping("/advertisements")
    public List<AdvertisementSummary> getAllAdvertisements() {

        return advertisementService.getAllAdvertisements();
    }

    @DeleteMapping("/advertisements/{id}")
    public ResponseEntity<String> deleteAdById(@PathVariable int id) {
        boolean succes = advertisementService.deleteAdById(id);

        if (succes) {
            return ResponseEntity.ok("Ogłoszenie zostało usunięte.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   @DeleteMapping("/advertisements")
   public void deleteAllAdvertisement() {
        advertisementService.deleteAllAdvertisement();
   }
 // @GetMapping("/popular/{count}")
 // public List<Advertisement> getPopularPosts(@PathVariable int count) {
 //     return
 // }
}

