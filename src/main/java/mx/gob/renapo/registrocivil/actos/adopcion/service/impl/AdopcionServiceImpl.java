package mx.gob.renapo.registrocivil.actos.adopcion.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.adopcion.dao.AdopcionDAO;
import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;
import mx.gob.renapo.registrocivil.actos.adopcion.entity.Adopcion;
import mx.gob.renapo.registrocivil.actos.adopcion.service.AdopcionService;
import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Data
public class AdopcionServiceImpl implements AdopcionService{

    private static Logger logger = Logger.getLogger(AdopcionServiceImpl.class);

    @Autowired
    private UtileriaService utileria;

    @Autowired
    private AdopcionDTO adopcionDTO;

    @Autowired
    private AdopcionDAO adopcionDAO;

    /**
     * Metodo para el registro de una
     * nueva adopcion
     * @param adopcionDTO
     */
    public AdopcionDTO guardarAdopcion(AdopcionDTO adopcionDTO, Boolean abueloUnoAdoptante,
                                           Boolean abueloDosAdoptante){
        Adopcion adopcionEntity = mapearAdopcion(adopcionDTO, abueloUnoAdoptante,abueloDosAdoptante);
        try {
            adopcionEntity = adopcionDAO.guardarRegistro(adopcionEntity);
            adopcionDTO = mapearEntityADtoAdopcion(adopcionEntity);
            adopcionDTO.setCodigoError(0);
        }
        catch (Exception e) {
            logger.error("Error: " + e);
            adopcionDTO.setCodigoError(1);
            adopcionDTO.setMensajeError(utileria.getStackTrace(e));
        }

        return adopcionDTO;

    }

    private AdopcionDTO mapearEntityADtoAdopcion(Adopcion adopcionEntity) {
        adopcionDTO.setPersona(utileria.mapearEntityDTOPersona(adopcionEntity.getAdoptado()));
        adopcionDTO.setAdoptante(utileria.mapearEntityDTOPersona(adopcionEntity.getAdoptanteDos()));
        adopcionDTO.setProgenitor(utileria.mapearEntityDTOPersona(adopcionEntity.getAdoptanteUno()));

        return adopcionDTO;
    }

    private Adopcion mapearAdopcion(AdopcionDTO adopcionDTO, Boolean padreUnoAdoptante,
                                    Boolean padreDosAdoptante){
        Adopcion adopcionEntity = new Adopcion();
        LocalidadDTO catInegiLocalidad = new LocalidadDTO();
        catInegiLocalidad.setId(2L);
        OficialiaDTO catOficialia =  new OficialiaDTO();
        catOficialia.setId(1L);
        adopcionDTO.getActaAdopcion().setOficialia(catOficialia);
        adopcionDTO.getActaAdopcion().setLocalidadRegistro(catInegiLocalidad);

        //TODO despues se deberan colocar los valores adecuados correspondientes
        adopcionEntity.setTomo("");
        adopcionEntity.setVersion(1L);
        adopcionEntity.setCadena("");
        adopcionEntity.setLibro("");
        adopcionEntity.setCripAdoptado("");
        adopcionEntity.setFechaRegistro(new Date());
        adopcionEntity.setLocalidadRegistro(
                utileria.recuperarLocalidad(adopcionDTO.getActaAdopcion().getLocalidadRegistro()));
        adopcionEntity.setOficialia(utileria.recuperarOficialia(adopcionDTO.getActaAdopcion().getOficialia()));
        adopcionEntity.setAdoptado(utileria.mapearDtoAEntityPersona(adopcionDTO.getPersona()));
        adopcionEntity.setAdoptanteUno(utileria.mapearDtoAEntityPersona(adopcionDTO.getProgenitor()));
        adopcionEntity.setAdoptanteDos(utileria.mapearDtoAEntityPersona(adopcionDTO.getAdoptante()));

        return  adopcionEntity;
    }
}
