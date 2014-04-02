package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatOficialDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficial;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 04:24
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class CatOficialServiceImpl implements CatOficialService {

    @Autowired
    private CatOficialDAO oficialDAO;

    @Override
    public boolean crearAtendioParto(OficialDTO oficialDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean actualizarAtendioParto(OficialDTO oficialDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean eliminarAtendioParto(Long id) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OficialDTO findById(Long id) {
        OficialDTO oficialDTO = null;
        CatOficial oficialEntity = oficialDAO.recuperarRegistro(id);

        if (oficialEntity != null) {
            oficialDTO = new OficialDTO();
            oficialDTO.setId(oficialEntity.getId());
            oficialDTO.setNombre(oficialEntity.getDescripcion());
            oficialDTO.setNumeroOficial(oficialEntity.getNumOficial());
        }

        return oficialDTO;
    }

    @Override
    public List<OficialDTO> findAll() {
        List<OficialDTO> listaOficialDTO = null;
        List<CatOficial> listaOficialEntity = oficialDAO.listarRegistros();

        if (listaOficialEntity != null && !listaOficialEntity.isEmpty()) {
            listaOficialDTO = new ArrayList<OficialDTO>();

            for (CatOficial oficialEntity : listaOficialEntity) {
                OficialDTO oficialDTO = new OficialDTO();
                oficialDTO.setId(oficialEntity.getId());
                oficialDTO.setNombre(oficialEntity.getDescripcion());
                oficialDTO.setNumeroOficial(oficialEntity.getNumOficial());

                listaOficialDTO.add(oficialDTO);
            }
        }

        return listaOficialDTO;
    }
}
