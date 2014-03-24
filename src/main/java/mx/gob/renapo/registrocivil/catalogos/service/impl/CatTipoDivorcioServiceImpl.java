package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoDivorcioDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDivorcioDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDivorcio;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoDivorcioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatTipoDivorcioServiceImpl implements CatTipoDivorcioService {

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
		CatTipoDivorcio tipoDivorcio = tipoDivorcioDAO.recuperarRegistro(id);
        CatTipoDivorcioDTO tipoDivorcioDTO = new CatTipoDivorcioDTO();

        if(tipoDivorcio!=null) {
            tipoDivorcioDTO.setId(tipoDivorcio.getId());
            tipoDivorcioDTO.setDescripcion(tipoDivorcio.getDescripcion());
        }
		return tipoDivorcioDTO;
	}

	@Override
	public List<CatTipoDivorcioDTO> findAll() {
		List<CatTipoDivorcioDTO> tipoDivorcioDTOList = new ArrayList<CatTipoDivorcioDTO>();
        List<CatTipoDivorcio> tipoDivorcioList = tipoDivorcioDAO.listarRegistros();
        CatTipoDivorcioDTO tipoDivorcioDTO = null;

        for(CatTipoDivorcio tipoDivorcio: tipoDivorcioList) {
            tipoDivorcioDTO = new CatTipoDivorcioDTO();
            tipoDivorcioDTO.setId(tipoDivorcio.getId());
            tipoDivorcioDTO.setDescripcion(tipoDivorcio.getDescripcion());
            tipoDivorcioDTOList.add(tipoDivorcioDTO);
        }
		return tipoDivorcioDTOList;
	}



}
