package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatNacionalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.NacionalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatNacionalidad;
import mx.gob.renapo.registrocivil.catalogos.service.CatNacionalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 04:03
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class CatNacionalidadServiceImpl implements CatNacionalidadService {

    @Autowired
    private CatNacionalidadDAO nacionalidadDAO;

    @Override
    public NacionalidadDTO findById(Long id) {
        NacionalidadDTO nacionalidadDTO = null;
        CatNacionalidad nacionalidadEntity = nacionalidadDAO.recuperarRegistro(id);

        if (nacionalidadEntity != null) {
            nacionalidadDTO = new NacionalidadDTO();
            nacionalidadDTO.setId(nacionalidadEntity.getId());
            nacionalidadDTO.setNacionalidad(nacionalidadEntity.getDescripcion());
        }

        return nacionalidadDTO;
    }

    @Override
    public List<NacionalidadDTO> findAll() {
        List<NacionalidadDTO> listaNacionalidadDTO = null;
        List<CatNacionalidad> listaNacionalidadEntity = nacionalidadDAO.listarRegistros();

        if (listaNacionalidadEntity != null && !listaNacionalidadEntity.isEmpty()) {
            listaNacionalidadDTO = new ArrayList<NacionalidadDTO>();

            for (CatNacionalidad nacionalidadEntity : listaNacionalidadEntity) {
                NacionalidadDTO nacionalidadDTO = new NacionalidadDTO();
                nacionalidadDTO.setId(nacionalidadEntity.getId());
                nacionalidadDTO.setNacionalidad(nacionalidadEntity.getDescripcion());

                listaNacionalidadDTO.add(nacionalidadDTO);
            }

        }

        return listaNacionalidadDTO;
    }
}
