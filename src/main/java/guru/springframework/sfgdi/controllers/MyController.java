package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;
    
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
    public String sayHello() {
        System.out.println("hello World!!!");
        
        return "Hi folks!";
    }
    
    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
