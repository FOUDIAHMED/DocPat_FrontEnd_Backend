package ahmed.foudi.DocPat.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
    @Bean
    public CommandLineRunner initAdmin(AdminService adminService) {
        return args -> {
            adminService.createDefaultAdmin();
        };
    }
}
