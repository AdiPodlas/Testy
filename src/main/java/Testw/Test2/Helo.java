package Testw.Test2;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class Helo {
    public String sayHelo(){
        return "Helo Elo!";
    }
}
