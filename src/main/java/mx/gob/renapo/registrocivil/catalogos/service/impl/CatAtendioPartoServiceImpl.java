package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatAtendioPartoService;

@Service
public class CatAtendioPartoServiceImpl implements
		CatAtendioPartoService {

	@Override
	public boolean crearAtendioParto(String descripcion) {
		System.out.println(descripcion);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarAtendioParto(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarAtendioParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatAtendioParto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatAtendioParto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
