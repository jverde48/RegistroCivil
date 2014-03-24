package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatEstadoCivilDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstadoCivil;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class CatEstadoCivilServiceImpl implements CatEstadoCivilService {

    @Autowired
    private CatEstadoCivilDAO estadoCivilDAO;

	@Override
	public boolean crearEstadoCivil(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarEstadoCivil(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarEstadoCivil(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatEstadoCivilDTO findById(Long id) {
        CatEstadoCivilDTO estadoCivilDTO = null;
        CatEstadoCivil estadoCivilEntity = estadoCivilDAO.recuperarRegistro(id);

        if (estadoCivilEntity != null) {
            estadoCivilDTO = new CatEstadoCivilDTO();
            estadoCivilDTO.setId(estadoCivilEntity.getId());
            estadoCivilDTO.setDescripcion(estadoCivilEntity.getDescripcion());
        }

		return estadoCivilDTO;
	}

	@Override
	public List<CatEstadoCivilDTO> findAll() {
        List<CatEstadoCivilDTO> listaEstadoCivilDTO = null;
        List<CatEstadoCivil> listaEstadoCivilEntity = estadoCivilDAO.listarRegistros();

        if (listaEstadoCivilEntity != null && !listaEstadoCivilEntity.isEmpty()) {
            listaEstadoCivilDTO = new ArrayList<CatEstadoCivilDTO>();

            for (CatEstadoCivil estadoCivil : listaEstadoCivilEntity) {
                CatEstadoCivilDTO estadoCivilDTO = new CatEstadoCivilDTO();
                estadoCivilDTO.setId(estadoCivil.getId());
                estadoCivilDTO.setDescripcion(estadoCivil.getDescripcion());

                listaEstadoCivilDTO.add(estadoCivilDTO);
            }
        }

		return listaEstadoCivilDTO;
	}
}
