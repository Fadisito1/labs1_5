package culturoteca;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationRunnerClass {

    public static void main(String[] args) {
        // Arranca la aplicación Spring Boot
        SpringApplication.run(ApplicationRunnerClass.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("La aplicación Spring Boot ha arrancado correctamente!");
        };
    }
}