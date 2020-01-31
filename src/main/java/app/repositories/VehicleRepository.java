package app.repositories;

import app.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "cars",path = "cars")
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    List<Vehicle> findByMake(@Param("make") String make);
}
