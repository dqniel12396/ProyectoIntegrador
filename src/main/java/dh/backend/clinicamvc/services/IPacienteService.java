package dh.backend.clinicamvc.services;

import dh.backend.clinicamvc.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);

    Paciente buscarPorId(Integer id);

    List<Paciente> buscarTodos();

    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Integer id) throws ResourceNotFoundException;
}
