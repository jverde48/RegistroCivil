package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatSituacionLaboralDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatSituacionLaboral;
import mx.gob.renapo.registrocivil.catalogos.service.CatSituacionLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatSituacionLaboralServiceImpl implements
		CatSituacionLaboralService {

    @Autowired
    private CatSituacionLaboralDAO situacionLaboralDAO;

	@Override
	public boolean crearSituacionLaboral(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarSituacionLaboral(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarSituacionLaboral(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatSituacionLaboral findById(Long id) {

		return situacionLaboralDAO.recuperarRegistro(id);
	}

	@Override
	public List<CatSituacionLaboral> findAll() {

		return situacionLaboralDAO.listarRegistros();
	}

    public CatSituacionLaboralDAO getSituacionLaboralDAO() {
        return situacionLaboralDAO;
    }

    public void setSituacionLaboralDAO(CatSituacionLaboralDAO situacionLaboralDAO) {
        this.situacionLaboralDAO = situacionLaboralDAO;
    }

}
