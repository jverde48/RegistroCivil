package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoDocumentoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDocumentoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDocumento;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoDocumentoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatTipoDocumentoServiceImpl implements CatTipoDocumentoService {

    private static Logger logger = Logger.getLogger(CatTipoDocumentoServiceImpl.class);

    private CatTipoDocumentoDAO tipoDocumentoDAO;

	@Override
	public boolean crearTipoDocumento(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarTipoDocumento(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTipoDocumento(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatTipoDocumentoDTO findById(Long id) {
        CatTipoDocumentoDTO tipoDocumentoDTO = new CatTipoDocumentoDTO();
        try {
            CatTipoDocumento tipoDocumento = tipoDocumentoDAO.recuperarRegistro(id);

            if(tipoDocumento!=null) {
                tipoDocumentoDTO.setId(tipoDocumento.getId());
                tipoDocumentoDTO.setDescripcion(tipoDocumento.getDescripcion());
            }
        }catch (Exception e) {
            logger.error("Error: " + e);
        }

		return tipoDocumentoDTO;
	}

	@Override
	public List<CatTipoDocumentoDTO> findAll() {
        List<CatTipoDocumentoDTO> tipoDocumentoDTOList = new ArrayList<CatTipoDocumentoDTO>();
        try {
            List<CatTipoDocumento> tipoDocumentoList = tipoDocumentoDAO.listarRegistros();
            CatTipoDocumentoDTO tipoDocumentoDTO = null;
            if(tipoDocumentoList.size()>0) {
                for(CatTipoDocumento tipoDocumento: tipoDocumentoList) {
                    tipoDocumentoDTO = new CatTipoDocumentoDTO();
                    tipoDocumentoDTO.setId(tipoDocumento.getId());
                    tipoDocumentoDTO.setDescripcion(tipoDocumento.getDescripcion());
                    tipoDocumentoDTOList.add(tipoDocumentoDTO);
                }
            }
        }catch (Exception e) {
           logger.error("Error: " + e);
        }
		return tipoDocumentoDTOList;
	}



}
