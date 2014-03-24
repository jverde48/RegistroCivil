package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatRegimenDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatRegimenDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatRegimen;
import mx.gob.renapo.registrocivil.catalogos.service.CatRegimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatRegimenServiceImpl implements CatRegimenService {

    @Autowired
    private CatRegimenDAO regimenDAO;

	@Override
	public boolean crearRegimen(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarRegimen(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarRegimen(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatRegimenDTO findById(Long id) {
		CatRegimenDTO regimenDTO = new CatRegimenDTO();
        CatRegimen regimen = regimenDAO.recuperarRegistro(id);
        if(regimen!=null) {
            regimenDTO.setId(regimen.getId());
            regimenDTO.setDescripcion(regimen.getDescripcion());
        }
		return regimenDTO;
	}

	@Override
	public List<CatRegimenDTO> findAll() {
        List<CatRegimenDTO> regimenDTOList = new ArrayList<CatRegimenDTO>();
		List<CatRegimen> regimenList = regimenDAO.listarRegistros();
        CatRegimenDTO regimenDTO = null;
        for(CatRegimen regimen: regimenList) {
            regimenDTO = new CatRegimenDTO();
            regimenDTO.setId(regimen.getId());
            regimenDTO.setDescripcion(regimen.getDescripcion());
            regimenDTOList.add(regimenDTO);
        }
		return regimenDTOList;
	}



}
