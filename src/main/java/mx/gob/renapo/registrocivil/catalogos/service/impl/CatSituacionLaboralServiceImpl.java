package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatSituacionLaboralDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatSituacionLaboralDTO;
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
	public CatSituacionLaboralDTO findById(Long id) {
        CatSituacionLaboralDTO situacionLaboralDTO = new CatSituacionLaboralDTO();
        CatSituacionLaboral catSituacionLaboral = situacionLaboralDAO.recuperarRegistro(id);
        if(catSituacionLaboral!=null) {
            situacionLaboralDTO.setId(catSituacionLaboral.getId());
            situacionLaboralDTO.setDescripcion(catSituacionLaboral.getDescripcion());
        }
		return situacionLaboralDTO;
	}

	@Override
	public List<CatSituacionLaboralDTO> findAll() {
        List<CatSituacionLaboralDTO> situacionLaboralDTOList = new ArrayList<CatSituacionLaboralDTO>();
        List<CatSituacionLaboral> catSituacionLaboralList = situacionLaboralDAO.listarRegistros();
        CatSituacionLaboralDTO situacionLaboralDTO = null;
        if(catSituacionLaboralList.size()>0) {
            for(CatSituacionLaboral catSituacionLaboral: catSituacionLaboralList) {
                situacionLaboralDTO.setId(catSituacionLaboral.getId());
                situacionLaboralDTO.setDescripcion(catSituacionLaboral.getDescripcion());
                situacionLaboralDTOList.add(situacionLaboralDTO);
            }
        }
		return situacionLaboralDTOList;
	}

    public CatSituacionLaboralDAO getSituacionLaboralDAO() {
        return situacionLaboralDAO;
    }

    public void setSituacionLaboralDAO(CatSituacionLaboralDAO situacionLaboralDAO) {
        this.situacionLaboralDAO = situacionLaboralDAO;
    }

}
