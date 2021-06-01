package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        
        System.out.println("============= Primary Bean");
        I18nController i18nController = ctx.getBean(
            I18nController.class,
            "i18nController"
        );
        System.out.println(i18nController.getGreeting());
        
        System.out.println("============= Primary Bean");
        MyController myController = ctx.getBean(
            MyController.class,
            "myController"
        );
        System.out.println(myController.getGreeting());
        
        System.out.println("============= Property");
        PropertyInjectedController propertyInjectedController = ctx.getBean(
            PropertyInjectedController.class,
            "propertyInjectedController"
        );
        System.out.println(propertyInjectedController.getGreeting());
        
        System.out.println("============= Setter");
        SetterInjectedController setterInjectedController = ctx.getBean(
            SetterInjectedController.class,
            "setterInjectedController"
        );
        System.out.println(setterInjectedController.getGreeting());
        
        System.out.println("============= Constructor");
        ConstructorInjectedController constructorInjectedController = ctx.getBean(
            ConstructorInjectedController.class,
            "constructorInjectedController"
        );
        System.out.println(constructorInjectedController.getGreeting());
    }
    
}
