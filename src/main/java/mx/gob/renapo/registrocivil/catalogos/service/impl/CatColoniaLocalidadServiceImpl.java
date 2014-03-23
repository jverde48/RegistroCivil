package mx.gob.renapo.registrocivil.catalogos.service.impl;

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

@Service
public class CatColoniaLocalidadServiceImpl implements CatColoniaLocalidadService {

    @Autowired
    private CatColoniaLocalidadDAO coloniaLocalidadDAO;

    @Override
    public ColoniaLocalidadDTO findById(Long id) {
        ColoniaLocalidadDTO coloniaLocalidadDTO = null;
        CatInegiLocalidad inegiLocalidad = coloniaLocalidadDAO.recuperarRegistro(id);

        if (inegiLocalidad != null) {
            coloniaLocalidadDTO.setId(inegiLocalidad.getId());
            coloniaLocalidadDTO.setNombreLocalidadColonia(inegiLocalidad.getNombre());
        }

        return coloniaLocalidadDTO;
    }

    @Override
    public List<ColoniaLocalidadDTO> findAll() {
        List<ColoniaLocalidadDTO> listaColoniaLocalidad = null;
        List<CatInegiLocalidad> listaInegiLocalidad = coloniaLocalidadDAO.listarRegistros();

        if (listaInegiLocalidad != null && !listaInegiLocalidad.isEmpty()) {
            listaColoniaLocalidad = new ArrayList<ColoniaLocalidadDTO>();

            for (CatInegiLocalidad inegiLocalidad : listaInegiLocalidad) {
                ColoniaLocalidadDTO coloniaLocalidad = new ColoniaLocalidadDTO();
                coloniaLocalidad.setId(inegiLocalidad.getId());
                coloniaLocalidad.setNombreLocalidadColonia(inegiLocalidad.getNombre());

                listaColoniaLocalidad.add(coloniaLocalidad);
            }
        }

        return listaColoniaLocalidad;
    }
}
