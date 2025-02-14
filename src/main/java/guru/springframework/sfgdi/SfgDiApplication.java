package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"guru.springframework.sfgdi", "guru.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        
        
        System.out.println("============= The best pet is: ");
        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println(petController.whichPetIsTheBest());
        
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
        
        System.out.println("-------- Bean Scopes --------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());
        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());
        
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println("--------- Fake data source ---------");
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());
    }
    
}
