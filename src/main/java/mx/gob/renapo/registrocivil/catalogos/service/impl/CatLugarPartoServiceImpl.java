package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dao.CatLugarPartoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatLugarPartoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatLugarParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatLugarPartoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatLugarPartoServiceImpl implements CatLugarPartoService {

    private static Logger logger = Logger.getLogger(CatLugarPartoServiceImpl.class);

    @Autowired
    private CatLugarPartoDAO lugarPartoDAO;

	@Override
	public boolean crearLugarParto(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarLugarParto(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarLugarParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatLugarPartoDTO findById(Long id) {
        CatLugarPartoDTO lugarPartoDTO = new CatLugarPartoDTO();
        try {
            CatLugarParto catLugarParto = lugarPartoDAO.recuperarRegistro(id);

            if(catLugarParto!=null) {
                lugarPartoDTO.setId(catLugarParto.getId());
                lugarPartoDTO.setDescripcion(catLugarParto.getDescripcion());
            }

        }catch (Exception e) {
            logger.info("Error: " + e);
        }

		return lugarPartoDTO;
	}

	@Override
	public List<CatLugarPartoDTO> findAll() {
        CatLugarPartoDTO lugarPartoDTO = null;
        List<CatLugarPartoDTO> lugarPartoDTOList = new ArrayList<CatLugarPartoDTO>();
        try {
            List<CatLugarParto> catLugarPartoList = lugarPartoDAO.listarRegistros();
            if(catLugarPartoList.size()>0) {
                for(CatLugarParto catLugarParto: catLugarPartoList) {
                    lugarPartoDTO = new CatLugarPartoDTO();
                    lugarPartoDTO.setId(catLugarParto.getId());
                    lugarPartoDTO.setDescripcion(catLugarParto.getDescripcion());
                    lugarPartoDTOList.add(lugarPartoDTO);
                }
            }
        }catch (Exception e) {
            logger.info("Error: " + e);
        }

        return lugarPartoDTOList;
	}

    public void setLugarPartoDAO(CatLugarPartoDAO lugarPartoDAO) {
        this.lugarPartoDAO = lugarPartoDAO;
    }

    public CatLugarPartoDAO getLugarPartoDAO() {
        return this.lugarPartoDAO;
    }

}
