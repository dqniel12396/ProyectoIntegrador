package dh.backend.clinicaMVC.controller;

import dh.backend.clinicaMVC.models.Odontologo;
import dh.backend.clinicaMVC.models.Paciente;
import dh.backend.clinicaMVC.services.IOdontologoService;
import dh.backend.clinicaMVC.services.IPacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vista")
public class VistaController {
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;

    public VistaController(IPacienteService pacienteService, IOdontologoService odontologoService) {
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping("/buscarPaciente")
    public String buscarPacientePorId(Model model, @RequestParam Integer id){
        Paciente paciente = pacienteService.buscarPorId(id);
        model.addAttribute("especialidad", "Paciente");
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index";
    }

    @GetMapping("/buscarOdontologo")
    public String buscarOdontologoPorId(Model model, @RequestParam Integer id){
        Odontologo odontologo = odontologoService.buscarUnOdontologo(id);
        model.addAttribute("especialidad", "odontologo");
        model.addAttribute("nombre", odontologo.getNombre());
        model.addAttribute("apellido", odontologo.getApellido());
        return "index";
    }
}
