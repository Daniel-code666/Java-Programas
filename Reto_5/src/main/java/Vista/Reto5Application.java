package Vista;

import Modelo.RepositorioProducto;
import Controlador.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan("Modelo")
@EnableJdbcRepositories("Modelo")
public class Reto5Application {
    @Autowired
    RepositorioProducto repoProd;
    public static void main(String[] args) {
            SpringApplicationBuilder builder = new SpringApplicationBuilder(Reto5Application.class);
            builder.headless(false);
            ConfigurableApplicationContext context = builder.run(args);
        //SpringApplication.run(Reto5Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            GUI vista = new GUI();
            Controlador controlador = new Controlador(repoProd, vista);
            vista.setControlador(controlador);
            vista.execTable();
        };
    }
}
