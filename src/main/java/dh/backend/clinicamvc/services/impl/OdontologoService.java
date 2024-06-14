package dh.backend.clinicamvc.services.impl;


import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.repository.IOdontologoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo agregarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarUnOdontologo(Integer id){
        return odontologoRepository.findById(id);
    }
    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoRepository.findAll();
    }


    public void modificarOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }


    public void eliminarOdontologo(Integer id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoOptional = buscarUnOdontologo(id);
        if(odontologoOptional.isPresent())
            odontologoRepository.deleteById(id);
        else throw new ResourceNotFoundException("{\"message\": \"odontologo no encontrado\"}");
    }


}
