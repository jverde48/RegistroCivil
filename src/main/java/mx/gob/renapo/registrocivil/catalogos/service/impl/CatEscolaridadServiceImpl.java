package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatEscolaridadDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEscolaridad;
import mx.gob.renapo.registrocivil.catalogos.service.CatEscolaridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatEscolaridadServiceImpl implements CatEscolaridadService {

    @Autowired
    private CatEscolaridadDAO escolaridadDAO;

	@Override
	public boolean crearEscolaridad(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarEscolaridad(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarEscolaridad(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatEscolaridad findById(Long id) {

		return escolaridadDAO.recuperarRegistro(id);
	}

	@Override
	public List<CatEscolaridad> findAll() {

		return escolaridadDAO.listarRegistros();
	}

    public void setEscolaridadDAO(CatEscolaridadDAO escolaridadDAO) {
        this.escolaridadDAO = escolaridadDAO;
    }

    public CatEscolaridadDAO getEscolaridadDAO() {
        return this.escolaridadDAO;
    }
	
	
}
