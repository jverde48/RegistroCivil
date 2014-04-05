package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;



import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatAtendioPartoDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.catalogos.service.CatAtendioPartoService;
import mx.gob.renapo.registrocivil.catalogos.dto.CatAtendioPartoDTO;

@Data
@Service
public class CatAtendioPartoServiceImpl implements CatAtendioPartoService {
	
	private static Logger logger = Logger.getLogger(CatLugarPartoServiceImpl.class);

    @Autowired
    private CatAtendioPartoDAO catAtendioPartoDAO;

	@Override
	public boolean crearAtendioParto(String descripcion) {
		CatAtendioParto atendioParto = new CatAtendioParto();
		
		try {
			atendioParto.setDescripcion(descripcion);
			atendioParto.setVersion(1L);
			catAtendioPartoDAO.guardarRegistro(atendioParto);
		}catch(Exception e) {
			logger.error("Error: " + e);
		}
		
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
		 CatAtendioPartoDTO atendioPartoDTO = new CatAtendioPartoDTO();
		 try {
			 CatAtendioParto atendioParto =catAtendioPartoDAO.recuperarRegistro(id);      
		        if(atendioParto!=null) {
		            atendioPartoDTO.setId(atendioParto.getId());
		            atendioPartoDTO.setDescripcion(atendioParto.getDescripcion());
		        } 
		 }catch(Exception e) {
			 logger.error("Error: " +  e);
		 }
       
		return atendioPartoDTO;
	}

	@Override
	public List<CatAtendioPartoDTO> findAll() {
		List<CatAtendioPartoDTO> atendioPartoDTOList = new ArrayList<CatAtendioPartoDTO>();
		
		try {
			List<CatAtendioParto> atendioPartoList = catAtendioPartoDAO.listarRegistros();
	        
	        CatAtendioPartoDTO atendioPartoDTO = null;
	        if(atendioPartoList.size()>0) {
	            for(CatAtendioParto atendioParto: atendioPartoList) {

	                atendioPartoDTO = new CatAtendioPartoDTO();
	                atendioPartoDTO.setId(atendioParto.getId());
	                atendioPartoDTO.setDescripcion(atendioParto.getDescripcion());
	                atendioPartoDTOList.add(atendioPartoDTO);

	            }

	        }
		}catch(Exception e) {
			logger.error("Error: " + e);
		}
        

        return atendioPartoDTOList;
	}


	
	

}
