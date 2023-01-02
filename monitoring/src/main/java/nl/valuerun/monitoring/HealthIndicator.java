package nl.valuerun.monitoring;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class HealthIndicator extends AbstractHealthIndicator {

    @Resource(name = "maintenanceBean")
    MaintenanceState maintenanceState;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // Use the builder to build the health status details that should be reported.
        // If you throw an exception, the status will be DOWN with the exception
        // message.

        if (maintenanceState.inMaintenance()) {
            builder.outOfService()
                    .withDetail("app", "onderhoud");

        } else {

            builder.up()
                    .withDetail("app", "Alive and Kicking")
                    .withDetail("error", "Nothing! I'm good.");
        }
    }
}