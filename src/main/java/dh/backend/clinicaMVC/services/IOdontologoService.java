package dh.backend.clinicaMVC.services;




import dh.backend.clinicaMVC.models.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IOdontologoService {
    Odontologo agregarOdontologo(Odontologo odontologo);

    Odontologo buscarUnOdontologo(int id);
    List<Odontologo> buscarTodosOdontologos();
}