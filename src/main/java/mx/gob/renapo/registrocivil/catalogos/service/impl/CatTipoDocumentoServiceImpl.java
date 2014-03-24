package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoDocumentoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDocumentoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDocumento;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoDocumentoService;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatTipoDocumentoServiceImpl implements CatTipoDocumentoService {

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
		CatTipoDocumento tipoDocumento = tipoDocumentoDAO.recuperarRegistro(id);
        CatTipoDocumentoDTO tipoDocumentoDTO = new CatTipoDocumentoDTO();
        if(tipoDocumento!=null) {
            tipoDocumentoDTO.setId(tipoDocumento.getId());
            tipoDocumentoDTO.setDescripcion(tipoDocumento.getDescripcion());
        }
		return tipoDocumentoDTO;
	}

	@Override
	public List<CatTipoDocumentoDTO> findAll() {
        List<CatTipoDocumentoDTO> tipoDocumentoDTOList = new ArrayList<CatTipoDocumentoDTO>();
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
		return tipoDocumentoDTOList;
	}



}
