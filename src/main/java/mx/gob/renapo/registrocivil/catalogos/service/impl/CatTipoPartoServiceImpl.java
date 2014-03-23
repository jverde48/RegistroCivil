package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoPartoDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoPartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatTipoPartoServiceImpl implements CatTipoPartoService {

    @Autowired
    private CatTipoPartoDAO tipoPartoDAO;

	@Override
	public boolean crearTipoParto(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarTipoParto(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTipoParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatTipoParto findById(Long id) {

		return tipoPartoDAO.recuperarRegistro(id);
	}

	@Override
	public List<CatTipoParto> findAll() {

		return tipoPartoDAO.listarRegistros();
	}

    public CatTipoPartoDAO getTipoPartoDAO() {
        return tipoPartoDAO;
    }

    public void setTipoPartoDAO(CatTipoPartoDAO tipoPartoDAO) {
        this.tipoPartoDAO = tipoPartoDAO;
    }

}
