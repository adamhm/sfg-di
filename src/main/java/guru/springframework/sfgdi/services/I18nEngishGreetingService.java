package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;

public class I18nEngishGreetingService implements GreetingService {
    
    private final EnglishGreetingRepository englishGreetingRepository;
    
    public I18nEngishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }
    
    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
