package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatColoniaLocalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.ColoniaLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.catalogos.service.CatColoniaLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:58
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class CatColoniaLocalidadServiceImpl implements CatColoniaLocalidadService {

    @Autowired
    private CatColoniaLocalidadDAO coloniaLocalidadDAO;

    @Override
    public ColoniaLocalidadDTO findById(Long id) {
        ColoniaLocalidadDTO coloniaLocalidadDTO = null;
        CatInegiLocalidad inegiLocalidadEntity = coloniaLocalidadDAO.recuperarRegistro(id);

        if (inegiLocalidadEntity != null) {
            coloniaLocalidadDTO = new ColoniaLocalidadDTO();
            coloniaLocalidadDTO.setId(inegiLocalidadEntity.getId());
            coloniaLocalidadDTO.setNombreLocalidadColonia(inegiLocalidadEntity.getNombre());
        }

        return coloniaLocalidadDTO;
    }

    @Override
    public List<ColoniaLocalidadDTO> findAll() {
        List<ColoniaLocalidadDTO> listaColoniaLocalidad = null;
        List<CatInegiLocalidad> listaInegiLocalidadEntity = coloniaLocalidadDAO.listarRegistros();

        if (listaInegiLocalidadEntity != null && !listaInegiLocalidadEntity.isEmpty()) {
            listaColoniaLocalidad = new ArrayList<ColoniaLocalidadDTO>();

            for (CatInegiLocalidad inegiLocalidad : listaInegiLocalidadEntity) {
                ColoniaLocalidadDTO coloniaLocalidad = new ColoniaLocalidadDTO();
                coloniaLocalidad.setId(inegiLocalidad.getId());
                coloniaLocalidad.setNombreLocalidadColonia(inegiLocalidad.getNombre());

                listaColoniaLocalidad.add(coloniaLocalidad);
            }
        }

        return listaColoniaLocalidad;
    }
}
