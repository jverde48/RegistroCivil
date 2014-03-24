package mx.gob.renapo.registrocivil.catalogos.service.impl;


import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatOficialiaDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Data
@Service
public class CatOficialiaServiceImpl implements CatOficialiaService {

    @Autowired
    private CatOficialiaDAO oficialiaDAO;


    @Override
    public boolean crearOficialia(OficialiaDTO oficialiaDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean actualizarOficialia(OficialiaDTO oficialiaDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean eliminarOficialia(Long id) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OficialiaDTO findById(Long id) {
        OficialiaDTO oficialiaDTO = null;
        CatOficialia oficialiaEntity = oficialiaDAO.recuperarRegistro(id);

        if (oficialiaEntity != null) {
            oficialiaDTO = new OficialiaDTO();
            oficialiaDTO.setId(oficialiaEntity.getId());
            oficialiaDTO.setIdRenapo(oficialiaEntity.getIdRenapo());
            oficialiaDTO.setNombreOficialia(oficialiaEntity.getDescripcion());
            oficialiaDTO.setMunicipio(Utileria.mapearEntityADtoMunicipio(oficialiaEntity.getMunicipio()));
            oficialiaDTO.setTipoOficialia(Utileria.mapeaEntityTipoOficialiaADTO(oficialiaEntity.getTipoOficialia()));
            oficialiaDTO.setOficial(Utileria.mapeaEntityOficialADTO(oficialiaEntity.getIdOficial()));
        }

        return oficialiaDTO;
    }

    @Override
    public List<OficialiaDTO> findAll() {
        List<OficialiaDTO> listaOficialiaDTO = null;
        List<CatOficialia> listaOficialiaEntity = oficialiaDAO.listarRegistros();

        if (listaOficialiaEntity != null && !listaOficialiaEntity.isEmpty()) {
            listaOficialiaDTO = new ArrayList<OficialiaDTO>();

            for (CatOficialia oficialiaEntity : listaOficialiaEntity) {
                OficialiaDTO oficialiaDTO = new OficialiaDTO();
                oficialiaDTO.setId(oficialiaEntity.getId());
                oficialiaDTO.setIdRenapo(oficialiaEntity.getIdRenapo());
                oficialiaDTO.setNombreOficialia(oficialiaEntity.getDescripcion());
                oficialiaDTO.setMunicipio(Utileria.mapearEntityADtoMunicipio(oficialiaEntity.getMunicipio()));
                oficialiaDTO.setTipoOficialia(Utileria.mapeaEntityTipoOficialiaADTO(oficialiaEntity.getTipoOficialia()));
                oficialiaDTO.setOficial(Utileria.mapeaEntityOficialADTO(oficialiaEntity.getIdOficial()));
            }
        }

        return listaOficialiaDTO;
    }
}
