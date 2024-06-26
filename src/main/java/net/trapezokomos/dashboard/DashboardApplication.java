package net.trapezokomos.dashboard;

import net.trapezokomos.dashboard.config.EnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashboardApplication {

    public static void main(String[] args) {
        EnvConfig.loadEnv();
        SpringApplication.run(DashboardApplication.class, args);
    }

}
