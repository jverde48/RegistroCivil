package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoLocalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoLocalidad;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoLocalidadService;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 24/03/14
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
@Data
@Service
public class CatTipoLocalidadServiceImpl implements CatTipoLocalidadService {

    private static Logger logger = Logger.getLogger(CatTipoLocalidadServiceImpl.class);

    @Autowired
    private CatTipoLocalidadDAO tipoLocalidadDAO;

    @Override
    public CatTipoLocalidadDTO findById(Long id) {
        CatTipoLocalidadDTO tipoLocalidadDTO = null;
        try {
            CatTipoLocalidad tipoLocalidadEntity = tipoLocalidadDAO.recuperarRegistro(id);

            if (tipoLocalidadEntity != null) {
                tipoLocalidadDTO = new CatTipoLocalidadDTO();
                tipoLocalidadDTO.setId(tipoLocalidadEntity.getId());
                tipoLocalidadDTO.setDescripcion(tipoLocalidadEntity.getDescripcion());
            }
        }catch (Exception e) {
            logger.error("Error: " + e);
        }
        return tipoLocalidadDTO;
    }

    @Override
    public List<CatTipoLocalidadDTO> findAll() {
        List<CatTipoLocalidadDTO> listaTipoLocalidad = null;
        try {
            List<CatTipoLocalidad> listaTipoLocalidadEntity = tipoLocalidadDAO.listarRegistros();

            if (listaTipoLocalidadEntity != null && !listaTipoLocalidadEntity.isEmpty()) {
                listaTipoLocalidad = new ArrayList<CatTipoLocalidadDTO>();

                for (CatTipoLocalidad tipoLocalidadEntity : listaTipoLocalidadEntity) {
                    CatTipoLocalidadDTO tipoLocalidadDTO = new CatTipoLocalidadDTO();

                    tipoLocalidadDTO.setId(tipoLocalidadEntity.getId());
                    tipoLocalidadDTO.setDescripcion(tipoLocalidadEntity.getDescripcion());

                    listaTipoLocalidad.add(tipoLocalidadDTO);
                }
            }
        }catch (Exception e) {
            logger.error("Error: " + e);
        }
        return listaTipoLocalidad;
    }
}
