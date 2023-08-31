package Testw.Test2.Game;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Logger {
    void log(String message){
        System.out.println(new Date().toString()+ " " +message);
    }
}
