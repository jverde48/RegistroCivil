package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatParentescoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatParentesco;
import mx.gob.renapo.registrocivil.catalogos.service.CatParentescoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CatParentescoServiceImpl implements CatParentescoService {


    @Autowired
    private CatParentescoDAO parentescoDAO;

    private static Logger logger = Logger.getLogger(CatParentescoServiceImpl.class);

	@Override
	public boolean crearParentesco(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarParentesco(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarParentesco(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatParentescoDTO findById(Long id) {
        CatParentescoDTO parentescoDTO = new CatParentescoDTO();
        try {
            CatParentesco catParentesco = parentescoDAO.recuperarRegistro(id);
            if(catParentesco!=null) {
                parentescoDTO.setId(catParentesco.getId());
                parentescoDTO.setDescripcion(catParentesco.getDescripcion());
            }
        }
        catch(Exception e) {
           logger.info("Error: " + e);
        }
		return parentescoDTO;
	}

	@Override
	public List<CatParentescoDTO> findAll() {

        CatParentescoDTO parentescoDTO = null;
        List<CatParentescoDTO> parentescoDTOList = new ArrayList<CatParentescoDTO>();
        try {
            List<CatParentesco> catParentescoList = parentescoDAO.listarRegistros();
            if(catParentescoList.size()>0) {
                for(CatParentesco catParentesco: catParentescoList) {
                    parentescoDTO = new CatParentescoDTO();
                    parentescoDTO.setId(catParentesco.getId());
                    parentescoDTO.setDescripcion(catParentesco.getDescripcion());
                    parentescoDTOList.add(parentescoDTO);
                }
            }
        }catch (Exception e) {
            logger.info("Error: " + e);
        }
        return parentescoDTOList;
	}

    public CatParentescoDAO getParentescoDAO() {
        return parentescoDAO;
    }

    public void setParentescoDAO(CatParentescoDAO parentescoDAO) {
        this.parentescoDAO = parentescoDAO;
    }

	
}
