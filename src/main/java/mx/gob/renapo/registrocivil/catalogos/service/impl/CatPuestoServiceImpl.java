package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatPuestoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPuesto;
import mx.gob.renapo.registrocivil.catalogos.service.CatPuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class CatPuestoServiceImpl implements CatPuestoService {

    @Autowired
    private CatPuestoDAO puestoDAO;

    @Override
    public boolean crearPuesto(CatPuestoDTO puestoDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean actualizarPuesto(CatPuestoDTO puestoDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean eliminarPuesto(Long id) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CatPuestoDTO findById(Long id) {
        CatPuestoDTO puestoDTO = null;
        CatPuesto puestoEntity = puestoDAO.recuperarRegistro(id);

        if (puestoEntity != null) {
            puestoDTO = new CatPuestoDTO();
            puestoDTO.setId(puestoEntity.getId());
            puestoDTO.setDescripcion(puestoEntity.getDescripcion());
        }

        return puestoDTO;
    }

    @Override
    public List<CatPuestoDTO> findAll() {
        List<CatPuestoDTO> listaCatPuestoDTO = null;
        List<CatPuesto> lisaPuestoEntity = puestoDAO.listarRegistros();

        if (lisaPuestoEntity != null && !lisaPuestoEntity.isEmpty()) {
            listaCatPuestoDTO = new ArrayList<CatPuestoDTO>();

            for (CatPuesto puestoEntity : lisaPuestoEntity) {
                CatPuestoDTO catPuestoDTO = new CatPuestoDTO();
                catPuestoDTO.setId(puestoEntity.getId());
                catPuestoDTO.setDescripcion(puestoEntity.getDescripcion());

                listaCatPuestoDTO.add(catPuestoDTO);
            }
        }

        return listaCatPuestoDTO;
    }
}
