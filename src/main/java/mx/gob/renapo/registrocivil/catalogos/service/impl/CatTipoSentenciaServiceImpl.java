package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoSentenciaDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoSentenciaDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoSentencia;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoSentenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatTipoSentenciaServiceImpl implements CatTipoSentenciaService {

    @Autowired
    private CatTipoSentenciaDAO tipoSentenciaDAO;

	@Override
	public boolean crearTipoSentencia(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarTipoSentencia(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTipoSentencia(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatTipoSentenciaDTO findById(Long id) {
        CatTipoSentenciaDTO tipoSentenciaDTO = new CatTipoSentenciaDTO();
        CatTipoSentencia tipoSentencia = tipoSentenciaDAO.recuperarRegistro(id);

        if(tipoSentencia!=null) {
            tipoSentenciaDTO.setId(tipoSentencia.getId());
            tipoSentenciaDTO.setDescripcion(tipoSentencia.getDescripcion());
        }
		return tipoSentenciaDTO;
	}

	@Override
	public List<CatTipoSentenciaDTO> findAll() {
        List<CatTipoSentenciaDTO> tipoSentenciaDTOList = new ArrayList<CatTipoSentenciaDTO>();
        List<CatTipoSentencia> tipoSentenciaList = tipoSentenciaDAO.listarRegistros();
        CatTipoSentenciaDTO tipoSentenciaDTO = null;
        if(tipoSentenciaList.size()>0) {
            for(CatTipoSentencia tipoSentencia: tipoSentenciaList) {
                tipoSentenciaDTO = new CatTipoSentenciaDTO();
                tipoSentenciaDTO.setId(tipoSentencia.getId());
                tipoSentenciaDTO.setDescripcion(tipoSentencia.getDescripcion());
                tipoSentenciaDTOList.add(tipoSentenciaDTO);
            }

        }

		return tipoSentenciaDTOList;
	}

	



}
