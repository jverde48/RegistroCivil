package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.bean.AtendioPartoBean;
import mx.gob.renapo.registrocivil.catalogos.dao.CatAtendioPartoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatAtendioPartoService;

@Data
@Service
public class CatAtendioPartoServiceImpl implements CatAtendioPartoService {

    @Autowired
    private CatAtendioPartoDAO catAtendioPartoDAO;

	@Override
	public boolean crearAtendioParto(String descripcion) {
		System.out.println(descripcion);
		CatAtendioParto atendioParto = new CatAtendioParto();
		atendioParto.setDescripcion(descripcion);
		atendioParto.setVersion(1L);
		catAtendioPartoDAO.guardarRegistro(atendioParto);
		return false;
	}

	@Override
	public boolean actualizarAtendioParto(String descripcion) {
		System.out.println(descripcion);
		catAtendioPartoDAO.prueba(descripcion);
		return false;
	}

	@Override
	public boolean eliminarAtendioParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatAtendioParto findById(Long id) {

		return catAtendioPartoDAO.recuperarRegistro(id);
	}

	@Override
	public List<CatAtendioParto> findAll() {

		return catAtendioPartoDAO.listarRegistros();
	}


	
	

}
