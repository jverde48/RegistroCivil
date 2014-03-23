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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatLugarFalleceServiceImpl implements CatLugarFalleceService {

    @Autowired
    private CatLugarFalleceDAO lugarFalleceDAO;

    @Override
    public CatLugarFalleceDTO findById(Long id) {
        CatLugarFallece lugarFallece = lugarFalleceDAO.recuperarRegistro(id);

        CatLugarFalleceDTO catLugarFalleceDTO = new CatLugarFalleceDTO();
        catLugarFalleceDTO.setId(lugarFallece.getId());
        catLugarFalleceDTO.setDescripcion(lugarFallece.getDescripcion());

        return catLugarFalleceDTO;
    }

    @Override
    public List<CatLugarFalleceDTO> findAll() {
        List<CatLugarFallece> listaCatLugarFallece = lugarFalleceDAO.listarRegistros();
        List<CatLugarFalleceDTO> listaCatLugarFalleceDTO = null;

        if (listaCatLugarFallece != null && !listaCatLugarFallece.isEmpty()) {
            listaCatLugarFalleceDTO  = new ArrayList<CatLugarFalleceDTO>();
            for (CatLugarFallece lugarFallece : listaCatLugarFallece) {
                CatLugarFalleceDTO catLugarFalleceDTO = new CatLugarFalleceDTO();
                catLugarFalleceDTO.setId(lugarFallece.getId());
                catLugarFalleceDTO.setDescripcion(lugarFallece.getDescripcion());

                listaCatLugarFalleceDTO.add(catLugarFalleceDTO);
            }
        }

        return listaCatLugarFalleceDTO;
    }

}
