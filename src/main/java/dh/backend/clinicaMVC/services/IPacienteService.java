package dh.backend.clinicaMVC.services;

import dh.backend.clinicaMVC.dao.IDao;
import dh.backend.clinicaMVC.models.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);

    Paciente buscarPorId(Integer id);

    List<Paciente> buscarTodos();
}
