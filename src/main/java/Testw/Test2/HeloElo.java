package Testw.Test2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloElo {
    @GetMapping("/Yo")
    String hello(@RequestParam(required = false) String name) {
        if (name == null){
            name = "Bajlando";}
        System.out.println("qwertyuiop[");
        return "Witaj " + name;
    }
    @GetMapping("/")
    String jolo(@RequestParam(required = false) String surname) {
        if (surname == null){
            surname = "Głąbiu ";}
        return "Spadaj " + surname;
    }

}
