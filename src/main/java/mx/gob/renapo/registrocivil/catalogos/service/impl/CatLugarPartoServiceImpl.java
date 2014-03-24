package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatLugarPartoDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatLugarParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatLugarPartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatLugarPartoServiceImpl implements CatLugarPartoService {

    @Autowired
    private CatLugarPartoDAO lugarPartoDAO;

	@Override
	public boolean crearLugarParto(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarLugarParto(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarLugarParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatLugarParto findById(Long id) {

		return lugarPartoDAO.recuperarRegistro(id);
	}

	@Override
	public List<CatLugarParto> findAll() {

		return lugarPartoDAO.listarRegistros();
	}

    public void setLugarPartoDAO(CatLugarPartoDAO lugarPartoDAO) {
        this.lugarPartoDAO = lugarPartoDAO;
    }

    public CatLugarPartoDAO getLugarPartoDAO() {
        return this.lugarPartoDAO;
    }

}
