package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatEscolaridadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEscolaridadDTO;
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
	public CatEscolaridadDTO findById(Long id) {
        CatEscolaridadDTO escolaridadDTO = new CatEscolaridadDTO();
        CatEscolaridad catEscolaridad = escolaridadDAO.recuperarRegistro(id);
        if(catEscolaridad!=null) {
            escolaridadDTO.setId(catEscolaridad.getId());
            escolaridadDTO.setDescripcion(catEscolaridad.getDescripcion());
        }
		return escolaridadDTO;
	}

	@Override
	public List<CatEscolaridadDTO> findAll() {
        List<CatEscolaridadDTO> escolaridadDTOList = new ArrayList<CatEscolaridadDTO>();
        List<CatEscolaridad> catEscolaridadList = escolaridadDAO.listarRegistros();
        CatEscolaridadDTO escolaridadDTO = null;
        if(catEscolaridadList.size()>0) {
           for(CatEscolaridad catEscolaridad: catEscolaridadList) {
               escolaridadDTO = new CatEscolaridadDTO();
               escolaridadDTO.setId(catEscolaridad.getId());
               escolaridadDTO.setDescripcion(catEscolaridad.getDescripcion());
               escolaridadDTOList.add(escolaridadDTO);
           }
        }
		return escolaridadDTOList;
	}

    public void setEscolaridadDAO(CatEscolaridadDAO escolaridadDAO) {
        this.escolaridadDAO = escolaridadDAO;
    }

    public CatEscolaridadDAO getEscolaridadDAO() {
        return this.escolaridadDAO;
    }
	
	
}
