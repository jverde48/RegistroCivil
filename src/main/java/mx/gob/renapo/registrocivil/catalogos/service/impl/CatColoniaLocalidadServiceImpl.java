package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatColoniaLocalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;
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
    public LocalidadDTO findById(Long id) {
        LocalidadDTO localidadDTO = null;
        CatInegiLocalidad inegiLocalidadEntity = coloniaLocalidadDAO.recuperarRegistro(id);

        if (inegiLocalidadEntity != null) {
            localidadDTO = new LocalidadDTO();
            localidadDTO.setId(inegiLocalidadEntity.getId());
            localidadDTO.setNombreLocalidad(inegiLocalidadEntity.getNombre());
        }

        return localidadDTO;
    }

    @Override
    public List<LocalidadDTO> findAll() {
        List<LocalidadDTO> listaColoniaLocalidad = null;
        List<CatInegiLocalidad> listaInegiLocalidadEntity = coloniaLocalidadDAO.listarRegistros();

        if (listaInegiLocalidadEntity != null && !listaInegiLocalidadEntity.isEmpty()) {
            listaColoniaLocalidad = new ArrayList<LocalidadDTO>();

            for (CatInegiLocalidad inegiLocalidad : listaInegiLocalidadEntity) {
                LocalidadDTO coloniaLocalidad = new LocalidadDTO();
                coloniaLocalidad.setId(inegiLocalidad.getId());
                coloniaLocalidad.setNombreLocalidad(inegiLocalidad.getNombre());

                listaColoniaLocalidad.add(coloniaLocalidad);
            }
        }

        return listaColoniaLocalidad;
    }
}
