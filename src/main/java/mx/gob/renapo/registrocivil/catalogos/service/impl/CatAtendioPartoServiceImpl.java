package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatAtendioPartoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatAtendioPartoService;
import mx.gob.renapo.registrocivil.catalogos.dto.CatAtendioPartoDTO;

@Data
@Service
public class CatAtendioPartoServiceImpl implements CatAtendioPartoService {

    @Autowired
    private CatAtendioPartoDAO catAtendioPartoDAO;

	@Override
	public boolean crearAtendioParto(String descripcion) {
		System.out.println(descripcion);
		CatAtendioParto atendioParto = new CatAtendioParto();
		atendioParto.setDescripcion(descripcion);
		atendioParto.setVersion(1L);
		catAtendioPartoDAO.guardarRegistro(atendioParto);
		return false;
	}

	@Override
	public boolean actualizarAtendioParto(String descripcion) {
		System.out.println(descripcion);
		catAtendioPartoDAO.prueba(descripcion);
		return false;
	}

	@Override
	public boolean eliminarAtendioParto(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatAtendioPartoDTO findById(Long id) {
        CatAtendioParto atendioParto =catAtendioPartoDAO.recuperarRegistro(id);
        CatAtendioPartoDTO atendioPartoDTO = new CatAtendioPartoDTO();
        if(atendioParto!=null) {
            atendioPartoDTO.setId(atendioParto.getId());
            atendioPartoDTO.setDescripcion(atendioParto.getDescripcion());
        }
		return atendioPartoDTO;
	}

	@Override
	public List<CatAtendioPartoDTO> findAll() {

        List<CatAtendioParto> atendioPartoList = catAtendioPartoDAO.listarRegistros();
        List<CatAtendioPartoDTO> atendioPartoDTOList = new ArrayList<CatAtendioPartoDTO>();
        CatAtendioPartoDTO atendioPartoDTO = null;
        if(atendioPartoList.size()>0) {
            for(CatAtendioParto atendioParto: atendioPartoList) {

                atendioPartoDTO = new CatAtendioPartoDTO();
                atendioPartoDTO.setId(atendioParto.getId());
                atendioPartoDTO.setDescripcion(atendioParto.getDescripcion());
                atendioPartoDTOList.add(atendioPartoDTO);

            }

        }

        return atendioPartoDTOList;
	}


	
	

}
