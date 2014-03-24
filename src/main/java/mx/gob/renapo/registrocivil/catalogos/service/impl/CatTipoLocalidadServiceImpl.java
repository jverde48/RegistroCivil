package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoLocalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoLocalidad;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoLocalidadService;

@Service
@Data
public class CatTipoLocalidadServiceImpl implements CatTipoLocalidadService {
	
	@Autowired
	private CatTipoLocalidadDAO tipoLocalidadDAO;

	@Override
	public List<CatTipoLocalidadDTO> findAll() {
		List<CatTipoLocalidadDTO> tipoLocalidadDTOList = new ArrayList<CatTipoLocalidadDTO>();
		List<CatTipoLocalidad> tipoLocalidadList = tipoLocalidadDAO.listarRegistros();
		CatTipoLocalidadDTO tipoLocalidadDTO = null;
		if(tipoLocalidadList.size()>0) {
			for(CatTipoLocalidad tipoLocalidad: tipoLocalidadList) {
				tipoLocalidadDTO = new CatTipoLocalidadDTO();
				tipoLocalidadDTO.setId(tipoLocalidad.getId());
				tipoLocalidadDTO.setDescripcion(tipoLocalidad.getDescripcion());
				tipoLocalidadDTOList.add(tipoLocalidadDTO);
			}
		}
		return tipoLocalidadDTOList;
	}

	@Override
	public CatTipoLocalidadDTO findById(Long id) {
		CatTipoLocalidadDTO tipoLocalidadDTO = new CatTipoLocalidadDTO();
		CatTipoLocalidad tipoLocalidad = tipoLocalidadDAO.recuperarRegistro(id);
		if(tipoLocalidad!=null) {
			tipoLocalidadDTO.setId(tipoLocalidad.getId());
			tipoLocalidadDTO.setDescripcion(tipoLocalidad.getDescripcion());
		}
		return tipoLocalidadDTO;
	}
	
	

}
