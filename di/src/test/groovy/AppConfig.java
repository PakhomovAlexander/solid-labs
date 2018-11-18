import core.Car;
import impl.CarImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class AppConfig {

    @Bean
    public Car car() {
        return new CarImpl("Nissan", 100, 10);
    }

    @Bean
    public TaxiDriver taxi() {
        return new TaxiDriver(car());
    }
}