package dh.backend.clinicaMVC;

import dh.backend.clinicaMVC.db.H2Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaMVCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaMVCApplication.class, args);
        H2Connection.crearTablas();
    }

}
