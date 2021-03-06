package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoPartoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoPartoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoPartoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatTipoPartoServiceImpl implements CatTipoPartoService {

    private static Logger logger = Logger.getLogger(CatTipoPartoServiceImpl.class);

    @Autowired
    private CatTipoPartoDAO tipoPartoDAO;

	@Override
	public boolean crearTipoParto(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarTipoParto(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTipoParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatTipoPartoDTO findById(Long id) {
        CatTipoPartoDTO catTipoPartoDTO = new CatTipoPartoDTO();
        try {
            CatTipoParto catTipoParto = tipoPartoDAO.recuperarRegistro(id);

            if(catTipoParto!=null) {
                catTipoPartoDTO.setId(catTipoParto.getId());
                catTipoPartoDTO.setDescripcion(catTipoParto.getDescripcion()
                );
            }
        } catch (Exception e) {
             logger.error("Error: " +  e);
        }
		return catTipoPartoDTO;
	}

	@Override
	public List<CatTipoPartoDTO> findAll() {
        List<CatTipoPartoDTO>  catTipoPartoDTOList = new ArrayList<CatTipoPartoDTO>();
        try {
            List<CatTipoParto> catTipoPartoList = tipoPartoDAO.listarRegistros();
            CatTipoPartoDTO catTipoPartoDTO = null;
            if(catTipoPartoList.size()>0) {
                for(CatTipoParto catTipoParto: catTipoPartoList) {
                    catTipoPartoDTO = new CatTipoPartoDTO();
                    catTipoPartoDTO.setId(catTipoParto.getId());
                    catTipoPartoDTO.setDescripcion(catTipoParto.getDescripcion());
                    catTipoPartoDTOList.add(catTipoPartoDTO);
                }
            }
        }catch (Exception e) {
           logger.error("Error: " +  e);
        }

		return catTipoPartoDTOList;
	}

    public CatTipoPartoDAO getTipoPartoDAO() {
        return tipoPartoDAO;
    }

    public void setTipoPartoDAO(CatTipoPartoDAO tipoPartoDAO) {
        this.tipoPartoDAO = tipoPartoDAO;
    }

}
