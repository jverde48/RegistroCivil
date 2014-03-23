package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatParentescoDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatParentesco;
import mx.gob.renapo.registrocivil.catalogos.service.CatParentescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatParentescoServiceImpl implements CatParentescoService {


    @Autowired
    private CatParentescoDAO parentescoDAO;


	@Override
	public boolean crearParentesco(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarParentesco(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarParentesco(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatParentesco findById(Long id) {

		return parentescoDAO.recuperarRegistro(id);
	}

	@Override
	public List<CatParentesco> findAll() {

		return parentescoDAO.listarRegistros();
	}

    public CatParentescoDAO getParentescoDAO() {
        return parentescoDAO;
    }

    public void setParentescoDAO(CatParentescoDAO parentescoDAO) {
        this.parentescoDAO = parentescoDAO;
    }

	
}
