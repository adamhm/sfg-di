package guru.springframework.sfgdi.config;

import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {
    
    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }
    
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService() {
        return petServiceFactory().getPetService("dog");
    }
    
    @Profile("cat")
    @Bean
    PetService catPetService() {
        return petServiceFactory().getPetService("cat");
    }
    
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }
    
    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }
    
    @Profile("EN")
    @Bean
    I18nEngishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEngishGreetingService(englishGreetingRepository);
    }
    
    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishService() {
        return new I18nSpanishGreetingService();
    }
    
    // @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }
    
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }
    
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
    
}
