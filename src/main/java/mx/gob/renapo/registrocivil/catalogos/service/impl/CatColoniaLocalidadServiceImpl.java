package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatColoniaLocalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.catalogos.service.CatColoniaLocalidadService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;
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

    @Autowired
    private UtileriaService utileriaService;

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

    @Override
    public List<LocalidadDTO> findAllByMunicipio(MunicipioDTO municipioDTO) {
        List<LocalidadDTO> listaLocalidadDTO = null;
        List<CatInegiLocalidad> listaInegiLocalidad = coloniaLocalidadDAO.findAllByMunicipio(
                utileriaService.recuperarInegiMunicipio(municipioDTO));

        if (listaInegiLocalidad != null && !listaInegiLocalidad.isEmpty()) {
            listaLocalidadDTO = new ArrayList<LocalidadDTO>();

            for (CatInegiLocalidad inegiLocalidad : listaInegiLocalidad) {
                LocalidadDTO localidadDTO = new LocalidadDTO();

                localidadDTO.setId(inegiLocalidad.getId());
                localidadDTO.setNombreLocalidad(inegiLocalidad.getNombre());

                listaLocalidadDTO.add(localidadDTO);
            }
        }

        return listaLocalidadDTO;
    }

	public CatColoniaLocalidadDAO getColoniaLocalidadDAO() {
		return coloniaLocalidadDAO;
	}

	public void setColoniaLocalidadDAO(CatColoniaLocalidadDAO coloniaLocalidadDAO) {
		this.coloniaLocalidadDAO = coloniaLocalidadDAO;
	}

	public UtileriaService getUtileriaService() {
		return utileriaService;
	}

	public void setUtileriaService(UtileriaService utileriaService) {
		this.utileriaService = utileriaService;
	}
}
