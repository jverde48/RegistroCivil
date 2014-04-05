package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoDivorcioDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDivorcioDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDivorcio;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoDivorcioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatTipoDivorcioServiceImpl implements CatTipoDivorcioService {

    private static Logger logger = Logger.getLogger(CatTipoDivorcioServiceImpl.class);

    @Autowired
    private CatTipoDivorcioDAO tipoDivorcioDAO;

	@Override
	public boolean crearTipoDivorcio(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarTipoDivorcio(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTipoDivorcio(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatTipoDivorcioDTO findById(Long id) {
        CatTipoDivorcio tipoDivorcio = null;
        CatTipoDivorcioDTO tipoDivorcioDTO = new CatTipoDivorcioDTO();
		try {
            tipoDivorcio = tipoDivorcioDAO.recuperarRegistro(id);
            if(tipoDivorcio!=null) {
                tipoDivorcioDTO.setId(tipoDivorcio.getId());
                tipoDivorcioDTO.setDescripcion(tipoDivorcio.getDescripcion());
            }
        }catch (Exception e) {
             logger.error("Error: " + e);
        }

		return tipoDivorcioDTO;
	}

	@Override
	public List<CatTipoDivorcioDTO> findAll() {
		List<CatTipoDivorcioDTO> tipoDivorcioDTOList = new ArrayList<CatTipoDivorcioDTO>();

        try {
            List<CatTipoDivorcio> tipoDivorcioList = tipoDivorcioDAO.listarRegistros();
            CatTipoDivorcioDTO tipoDivorcioDTO = null;

            for(CatTipoDivorcio tipoDivorcio: tipoDivorcioList) {
                tipoDivorcioDTO = new CatTipoDivorcioDTO();
                tipoDivorcioDTO.setId(tipoDivorcio.getId());
                tipoDivorcioDTO.setDescripcion(tipoDivorcio.getDescripcion());
                tipoDivorcioDTOList.add(tipoDivorcioDTO);
            }
        }catch (Exception e) {
             logger.error("Error: " + e);
        }

		return tipoDivorcioDTOList;
	}



}
