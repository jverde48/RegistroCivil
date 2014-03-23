package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatCompareceDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatCompareceDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatComparece;
import mx.gob.renapo.registrocivil.catalogos.service.CatCompareceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CatCompareceServiceImpl implements CatCompareceService {

    @Autowired
    private CatCompareceDAO compareceDAO;

	@Override
	public boolean crearComparece(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarComparece(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarComparece(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatCompareceDTO findById(Long id) {
        CatCompareceDTO compareceDTO = null;
		CatComparece compareceEntity = compareceDAO.recuperarRegistro(id);

        if (compareceEntity != null) {
            compareceDTO = new CatCompareceDTO();
            compareceDTO.setId(compareceEntity.getId());
            compareceDTO.setDescripcion(compareceEntity.getDescripcion());
        }

		return compareceDTO;
	}

	@Override
	public List<CatCompareceDTO> findAll() {
		List<CatCompareceDTO> listaCompareceDTO = null;
        List<CatComparece> listaCompareceEntity = compareceDAO.listarRegistros();

        if (listaCompareceEntity != null && !listaCompareceEntity.isEmpty()) {
            listaCompareceDTO = new ArrayList<CatCompareceDTO>();

            for (CatComparece comparece : listaCompareceEntity) {
                CatCompareceDTO compareceDTO = new CatCompareceDTO();
                compareceDTO.setId(comparece.getId());
                compareceDTO.setDescripcion(comparece.getDescripcion());
            }
        }

		return listaCompareceDTO;
	}

	

}
