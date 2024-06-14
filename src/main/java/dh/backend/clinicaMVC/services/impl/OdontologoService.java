package dh.backend.clinicaMVC.services.impl;
import dh.backend.clinicaMVC.dao.IDao;
import dh.backend.clinicaMVC.models.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> OdontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.OdontologoIDao = odontologoIDao;
    }


    public Odontologo registrarOdontologo(Odontologo odontologo){
        return OdontologoIDao.registrar(odontologo);
    }

}
