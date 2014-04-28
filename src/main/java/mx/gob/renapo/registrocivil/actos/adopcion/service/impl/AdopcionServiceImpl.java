package mx.gob.renapo.registrocivil.actos.adopcion.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.adopcion.dao.AdopcionDAO;
import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;
import mx.gob.renapo.registrocivil.actos.adopcion.entity.Adopcion;
import mx.gob.renapo.registrocivil.actos.adopcion.service.AdopcionService;
import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<AdopcionDTO> consultaAdopcionPorNumeroActa(int anio, String cadena) {
        List<AdopcionDTO> adopcionDTOs =  new ArrayList<AdopcionDTO>();
        List<Adopcion> adopciones =  new ArrayList<Adopcion>();

        try {
            adopciones = adopcionDAO.consultaActaNumeroActaAnioRegistro(anio,cadena);
            if (adopciones!=null && !adopciones.isEmpty())
                for (Adopcion adopcion:adopciones)
                    adopcionDTOs.add(mapearEntityADtoAdopcion(adopcion));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adopcionDTOs;
    }

    @Override
    public List<AdopcionDTO> consultaAdopcionPorCadena(String cadenaValue) {
        List<AdopcionDTO> adopcionDTOs =  new ArrayList<AdopcionDTO>();
        List<Adopcion> adopciones =  new ArrayList<Adopcion>();

        try {
            adopciones =  adopcionDAO.consultaActaCadena(cadenaValue);

            if (!adopciones.isEmpty())
                for(Adopcion adopcion : adopciones)
                    adopcionDTOs.add(mapearEntityADtoAdopcion(adopcion));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adopcionDTOs;
    }

    private AdopcionDTO mapearEntityADtoAdopcion(Adopcion adopcionEntity) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(adopcionEntity.getFechaRegistro());
        adopcionDTO.setPersona(utileria.mapearEntityDTOPersona(adopcionEntity.getAdoptado()));
        adopcionDTO.setAdoptante(utileria.mapearEntityDTOPersona(adopcionEntity.getAdoptanteDos()));
        adopcionDTO.setProgenitor(utileria.mapearEntityDTOPersona(adopcionEntity.getAdoptanteUno()));
        //adopcionDTO.getActaAdopcion().setLocalidadRegistro(adopcionEntity.getA);
        //adopcionDTO.getActaAdopcion().setOficialia(adopcionEntity.getOficialia());
        adopcionDTO.getActaAdopcion().setCadena(adopcionEntity.getCadena());
        //adopcionDTO.getActaAdopcion().setEntidadRegistro(adopcionEntity.getLocalidadRegistro().getMunicipio().);
        //adopcionDTO.getActaAdopcion().setMunicipioRegistro(adopcionEntity.getLocalidadRegistro().getMunicipio());
        adopcionDTO.getActaAdopcion().setFoja(adopcionEntity.getFoja());
        adopcionDTO.getActaAdopcion().setLibro(adopcionEntity.getLibro());
        adopcionDTO.getActaAdopcion().setAnioRegistro(String.valueOf(calendar.get(Calendar.YEAR)));
        adopcionDTO.getActaAdopcion().setFechaRegistro(adopcionEntity.getFechaRegistro());

        if (adopcionEntity.getPadreUnoAdoptante() != null)
            adopcionDTO.setPadreUnoAdoptante(utileria.mapearEntityDTOPersona(adopcionEntity.getPadreUnoAdoptante()));
        if (adopcionEntity.getPadreDosAdoptante() != null)
            adopcionDTO.setPadreDosAdoptante(utileria.mapearEntityDTOPersona(adopcionEntity.getPadreDosAdoptante()));
        adopcionDTO.setTestigoUno(utileria.mapearEntityDTOPersona(adopcionEntity.getTestigoUno()));
        adopcionDTO.setTestigoDos(utileria.mapearEntityDTOPersona(adopcionEntity.getTestigoDos()));

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

        if (padreUnoAdoptante)
            adopcionEntity.setPadreUnoAdoptante(utileria.mapearDtoAEntityPersona(adopcionDTO.getPadreUnoAdoptante()));
        if (padreDosAdoptante)
            adopcionEntity.setPadreDosAdoptante(utileria.mapearDtoAEntityPersona(adopcionDTO.getPadreDosAdoptante()));
        adopcionEntity.setTestigoUno(utileria.mapearDtoAEntityPersona(adopcionDTO.getTestigoUno()));
        adopcionEntity.setTestigoDos(utileria.mapearDtoAEntityPersona(adopcionDTO.getTestigoDos()));

        return  adopcionEntity;
    }
}
