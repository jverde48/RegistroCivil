package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoOficialiaDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoOficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoOficialiaService;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoOficialia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 4:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Data
public class CatTipoOficialiaServiceImpl implements CatTipoOficialiaService {

    @Autowired
    private CatTipoOficialiaDAO tipoOficialiaDAO;

    public List<CatTipoOficialiaDTO> findAll() {
        List<CatTipoOficialiaDTO> tipoOficialiaDTOList = new ArrayList<CatTipoOficialiaDTO>();
        List<CatTipoOficialia> tipoOficialiaList = tipoOficialiaDAO.listarRegistros();
        CatTipoOficialiaDTO tipoOficialiaDTO = null;

        if (tipoOficialiaList.size()>0) {
            for(CatTipoOficialia tipoOficialia: tipoOficialiaList) {
                tipoOficialiaDTO = new CatTipoOficialiaDTO();
                tipoOficialiaDTO.setId(tipoOficialia.getId());
                tipoOficialiaDTO.setDescripcion(tipoOficialia.getDescripcion());
                tipoOficialiaDTOList.add(tipoOficialiaDTO);
            }
        }
       return tipoOficialiaDTOList;
    }

    public CatTipoOficialiaDTO findById(Long id) {

        CatTipoOficialiaDTO tipoOficialiaDTO = new CatTipoOficialiaDTO();
        CatTipoOficialia tipoOficialia = tipoOficialiaDAO.recuperarRegistro(id);

        if(tipoOficialia!=null) {
            tipoOficialiaDTO.setId(tipoOficialia.getId());
            tipoOficialiaDTO.setDescripcion(tipoOficialia.getDescripcion());
        }
        return tipoOficialiaDTO;
    }

}
