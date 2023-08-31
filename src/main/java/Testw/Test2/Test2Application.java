package Testw.Test2;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test2Application {

	@Autowired
	Helo hello;
	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println(hello.sayHelo());
	}

}
