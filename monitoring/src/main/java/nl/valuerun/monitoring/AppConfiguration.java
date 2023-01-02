package nl.valuerun.monitoring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

@Configuration
public class AppConfiguration {
    @Bean(name = "maintenanceBean")
    @ApplicationScope
    public MaintenanceState maintenanceStateBean() {
        return new MaintenanceState();
    }
}
