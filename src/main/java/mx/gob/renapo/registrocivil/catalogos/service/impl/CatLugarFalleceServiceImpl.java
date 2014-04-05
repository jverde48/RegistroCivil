package mx.gob.renapo.registrocivil.catalogos.service.impl;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 23/03/14
 * Time: 03:37 AM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.catalogos.dao.CatLugarFalleceDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatLugarFalleceDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatLugarFallece;
import mx.gob.renapo.registrocivil.catalogos.service.CatLugarFalleceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatLugarFalleceServiceImpl implements CatLugarFalleceService {

    private static Logger logger = Logger.getLogger(CatLugarFalleceServiceImpl.class);

    @Autowired
    private CatLugarFalleceDAO lugarFalleceDAO;

    @Override
    public CatLugarFalleceDTO findById(Long id) {
        CatLugarFalleceDTO catLugarFalleceDTO = new CatLugarFalleceDTO();
        try {
            CatLugarFallece lugarFallece = lugarFalleceDAO.recuperarRegistro(id);
            catLugarFalleceDTO.setId(lugarFallece.getId());
            catLugarFalleceDTO.setDescripcion(lugarFallece.getDescripcion());
        } catch (Exception e) {
            logger.error("Error: " + e);
        }
        return catLugarFalleceDTO;
    }

    @Override
    public List<CatLugarFalleceDTO> findAll() {
        List<CatLugarFalleceDTO> listaCatLugarFalleceDTO = null;
        try {
            List<CatLugarFallece> listaCatLugarFallece = lugarFalleceDAO.listarRegistros();

            if (listaCatLugarFallece != null && !listaCatLugarFallece.isEmpty()) {
                listaCatLugarFalleceDTO = new ArrayList<CatLugarFalleceDTO>();
                for (CatLugarFallece lugarFallece : listaCatLugarFallece) {
                    CatLugarFalleceDTO catLugarFalleceDTO = new CatLugarFalleceDTO();
                    catLugarFalleceDTO.setId(lugarFallece.getId());
                    catLugarFalleceDTO.setDescripcion(lugarFallece.getDescripcion());

                    listaCatLugarFalleceDTO.add(catLugarFalleceDTO);
                }
            }

        } catch (Exception e) {
            logger.error("Error: " + e);
        }


        return listaCatLugarFalleceDTO;
    }

}
