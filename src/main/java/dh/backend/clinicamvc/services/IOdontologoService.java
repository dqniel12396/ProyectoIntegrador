package dh.backend.clinicamvc.services;




import dh.backend.clinicamvc.entity.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IOdontologoService {
    Odontologo agregarOdontologo(Odontologo odontologo);

    Odontologo buscarUnOdontologo(int id);
    List<Odontologo> buscarTodosOdontologos();
    void modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Integer id) throws ResourceNotFoundException;
}