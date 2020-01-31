package app;

import app.entities.Vehicle;
import app.repositories.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@SpringBootApplication
public class SimpleRestApiWithSpringbootUsingDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRestApiWithSpringbootUsingDtoApplication.class, args);
    }

    @Component
    class DemoCommandLineRunner implements CommandLineRunner {


        private VehicleRepository vehicleRepository;

        public DemoCommandLineRunner(VehicleRepository vehicleRepository) {
            this.vehicleRepository = vehicleRepository;
        }

        @Override
        public void run(String... args) throws Exception {

            Vehicle audi = new Vehicle();
            audi.setId(UUID.randomUUID());
            audi.setVehicleIdentityNumber("Reg#1234");
            audi.setMake("Audi");
            audi.setModel("Q5");

            vehicleRepository.save(audi);

            Vehicle tesla = new Vehicle();
            tesla.setId(UUID.randomUUID());
            tesla.setVehicleIdentityNumber("Reg#6789");
            tesla.setMake("Tesla");
            tesla.setModel("Model S");

            vehicleRepository.save(tesla);
        }
    }
}