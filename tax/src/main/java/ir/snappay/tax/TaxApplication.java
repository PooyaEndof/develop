package ir.snappay.tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "ir.snappay.tax.model.repository")
public class TaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxApplication.class, args);
    }

}
