package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoOperacionDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoOperacionDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoOperacion;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoOperacionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatTipoOperacionServiceImpl implements CatTipoOperacionService {

    private static Logger logger = Logger.getLogger(CatTipoOperacionServiceImpl.class);

    @Autowired
    private CatTipoOperacionDAO tipoOperacionDAO;

	@Override
	public boolean crearTipoOperacion(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarTipoOperacion(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTipoOperacion(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatTipoOperacionDTO findById(Long id) {
        CatTipoOperacionDTO tipoOperacionDTO = new CatTipoOperacionDTO();

        try {
            CatTipoOperacion tipoOperacion = tipoOperacionDAO.recuperarRegistro(id);
            if(tipoOperacion!=null) {
                tipoOperacionDTO.setId(tipoOperacion.getId());
                tipoOperacionDTO.setDescripcion(tipoOperacion.getDescripcion());
            }
        }catch (Exception e) {
           logger.error("Error: " + e);
        }

		return tipoOperacionDTO;
	}

	@Override
	public List<CatTipoOperacionDTO> findAll() {
        List<CatTipoOperacionDTO> tipoOperacionDTOList = new ArrayList<CatTipoOperacionDTO>();
        try {
            List<CatTipoOperacion> tipoOperacionList = tipoOperacionDAO.listarRegistros();
            CatTipoOperacionDTO tipoOperacionDTO = null;
            if(tipoOperacionList.size()>0) {
                for (CatTipoOperacion tipoOperacion: tipoOperacionList) {
                    tipoOperacionDTO = new CatTipoOperacionDTO();
                    tipoOperacionDTO.setId(tipoOperacion.getId());
                    tipoOperacionDTO.setDescripcion(tipoOperacion.getDescripcion());
                    tipoOperacionDTOList.add(tipoOperacionDTO);
                }
            }
        }catch (Exception e) {
           logger.error("Error: " +  e);
        }

		return tipoOperacionDTOList;
	}



}
