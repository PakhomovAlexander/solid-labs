import core.Car;
import impl.CarImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Car car() {
        return new CarImpl("Nissan", 100, 10);
    }
}