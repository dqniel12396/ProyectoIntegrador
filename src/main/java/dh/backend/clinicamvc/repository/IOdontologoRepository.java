package dh.backend.clinicamvc.repository;

import dh.backend.clinicamvc.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {

}
