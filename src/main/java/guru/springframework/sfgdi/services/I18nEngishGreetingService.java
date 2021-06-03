package guru.springframework.sfgdi.services;

public class I18nEngishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
