package mx.gob.renapo.registrocivil.comun.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.comun.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.comun.service.PersonaService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 21/04/14
 * Time: 06:37 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private UtileriaService utileriaService;

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    public List<PersonaDTO> findByCurp(String curp) {
        List<PersonaDTO> listaPersonasDTO = null;
        List<Persona> listaPersonasEntity = personaDAO.findByCurp(curp);
        System.out.println("LA LISTA DE PERSONAS: ---- " + listaPersonasEntity);
        if (listaPersonasEntity != null && !listaPersonasEntity.isEmpty()) {
            listaPersonasDTO = new ArrayList<PersonaDTO>();

            for (Persona personaEntity : listaPersonasEntity)
                listaPersonasDTO.add(utileriaService.mapearEntityDTOPersona(personaEntity));
        }

        return listaPersonasDTO;
    }

    @Override
    public List<PersonaDTO> findByCadena(String cadena) {
        List<PersonaDTO> listaPersonasDTO = null;
        List<Persona> listaPersonasEntity = personaDAO.findByCadena(cadena);

        if (listaPersonasEntity != null && !listaPersonasEntity.isEmpty()) {
            listaPersonasDTO = new ArrayList<PersonaDTO>();

            for (Persona personaEntity : listaPersonasEntity)
                listaPersonasDTO.add(utileriaService.mapearEntityDTOPersona(personaEntity));
        }

        return listaPersonasDTO;
    }

    @Override
    public List<PersonaDTO> findByDatosPersonales(HashMap<String, Object> datosPersonales) {
        List<PersonaDTO> listaPersonasDTO = null;
        List<Persona> listaPersonasEntity = personaDAO.findByDatosPersonales(datosPersonales);
        System.out.println("LA LISTA DE PERSONAS: ---- " + listaPersonasEntity);
        if (listaPersonasEntity != null && !listaPersonasEntity.isEmpty()) {
            listaPersonasDTO = new ArrayList<PersonaDTO>();

            for (Persona personaEntity : listaPersonasEntity)
                listaPersonasDTO.add(utileriaService.mapearEntityDTOPersona(personaEntity));
        }

        return listaPersonasDTO;
    }

    @Override
    public PersonaDTO findById(Long id) throws Exception {
        PersonaDTO personaDTO = null;
        Persona persona = personaDAO.recuperarRegistro(id);

        if (persona != null)
            personaDTO = utileriaService.mapearEntityDTOPersona(persona);

        return personaDTO;
    }
}
