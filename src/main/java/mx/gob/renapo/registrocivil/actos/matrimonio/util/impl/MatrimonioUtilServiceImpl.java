package mx.gob.renapo.registrocivil.actos.matrimonio.util.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.ActaMatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.EstadisticosMatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.util.MatrimonioUtilService;
import mx.gob.renapo.registrocivil.catalogos.dao.CatOficialiaDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 07/04/14
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
@Data
@Service
public class MatrimonioUtilServiceImpl implements MatrimonioUtilService {

    @Autowired
    private UtileriaService utileriaService;

    @Autowired
    private CatOficialiaDAO oficialiaDAO;

    public MatrimonioDTO mapearEntityMatrimonioADTO(Matrimonio matrimonioEntity) {
        MatrimonioDTO matrimonioDTO = new MatrimonioDTO();

        matrimonioDTO.setId(matrimonioEntity.getId());
        //Contrayentes
        matrimonioDTO.setContrayenteUno(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getContrayenteUno()));
        matrimonioDTO.setContrayenteDos(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getContrayenteDos()));

        //Consentimiento contrayentes
        if (matrimonioEntity.getConsenMenorContrayenteUno() != null) {
            matrimonioDTO.setConsentimientoContrayenteUno(utileriaService.mapearEntityDTOPersona(
                    matrimonioEntity.getConsenMenorContrayenteUno()));
        }

        if (matrimonioEntity.getConsenMenorContrayenteDos() != null) {
            matrimonioDTO.setConsentimientoContrayenteDos(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getConsenMenorContrayenteDos()));
        }

        //Padres contrayente uno
        matrimonioDTO.setProgenitorUnoContrayenteUno(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getPadreContrayenteUno()));
        matrimonioDTO.setProgenitorDosContrayenteUno(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getMadreContrayenteUno()));

        //Padres contrayente dos
        matrimonioDTO.setProgenitorUnoContrayenteDos(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getPadreContrayenteDos()));
        matrimonioDTO.setProgenitorDosContrayenteDos(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getMadreContrayenteDos()));

        //Testigos
        matrimonioDTO.setTestigoUno(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getTestigoUno()));
        matrimonioDTO.setTestigoDos(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getTestigoDos()));
        matrimonioDTO.setTestigoTres(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getTestigoTres()));
        matrimonioDTO.setTestigoCuatro(utileriaService.mapearEntityDTOPersona(
                matrimonioEntity.getTestigoCuatro()));

        //Parentesco Testigos
        if (matrimonioEntity.getParentescoTestigoUno() != null)
            matrimonioDTO.setParentescoTestigoUno(utileriaService.mapearEntityADTOParentesco(
                    matrimonioEntity.getParentescoTestigoUno()));

        if (matrimonioEntity.getParentescoTestigoDos() != null)
            matrimonioDTO.setParentescoTestigoDos(utileriaService.mapearEntityADTOParentesco(
                    matrimonioEntity.getParentescoTestigoDos()));

        if (matrimonioEntity.getParentescoTestigoTres() != null)
            matrimonioDTO.setParentescoTestigoTres(utileriaService.mapearEntityADTOParentesco(
                    matrimonioEntity.getParentescoTestigoTres()));

        if (matrimonioEntity.getParentescoTestigoCuatro() != null)
            matrimonioDTO.setParentescoTestigoCuatro(utileriaService.mapearEntityADTOParentesco(
                    matrimonioEntity.getParentescoTestigoCuatro()));

        //Datos Estadisticos contrayentes
        matrimonioDTO.setEstadisticosDTO(mapearDatosEstadisticos(matrimonioEntity));

        //Datos del Acta
        matrimonioDTO.setActaMatrimonioDTO(mapearDatosActa(matrimonioEntity));

        matrimonioDTO.setCodigoRespuesta(0);
        return matrimonioDTO;
    }

    private EstadisticosMatrimonioDTO mapearDatosEstadisticos(Matrimonio matrimonioEntity) {
        EstadisticosMatrimonioDTO estadisticos = new EstadisticosMatrimonioDTO();

        //Contrayentes situacion laboral
        if (matrimonioEntity.getSituacionLaboralContrayenteUno() != null)
            estadisticos.setSituacionLaboralDTOContrayenteUno(utileriaService.mapearEntityADTOSituacionLaboral(
                matrimonioEntity.getSituacionLaboralContrayenteUno()));

        if (matrimonioEntity.getSituacionLaboralContrayenteDos() != null)
            estadisticos.setSituacionLaboralDTOContrayenteDos(utileriaService.mapearEntityADTOSituacionLaboral(
                matrimonioEntity.getSituacionLaboralContrayenteDos()));

        //Contrayentes puesto
        if (matrimonioEntity.getPosicionTrabajoContrayenteUno() != null)
            estadisticos.setPuestoDTOContrayenteUno(utileriaService.mapearEntityADTOPuesto(
                    matrimonioEntity.getPosicionTrabajoContrayenteUno()));

        if (matrimonioEntity.getPosicionTrabajoContrayenteUno() != null)
            estadisticos.setPuestoDTOContrayenteDos(utileriaService.mapearEntityADTOPuesto(
                    matrimonioEntity.getPosicionTrabajoContrayenteUno()));

        //Contrayentes Escolaridad
        if (matrimonioEntity.getEscolaridadContrayenteUno() != null)
            estadisticos.setEscolaridadContrayenteUno(utileriaService.mapearEntityADTOEscolaridad(
                    matrimonioEntity.getEscolaridadContrayenteUno()));

        if (matrimonioEntity.getEscolaridadContrayenteUno() != null)
            estadisticos.setEscolaridadContrayenteDos(utileriaService.mapearEntityADTOEscolaridad(
                    matrimonioEntity.getEscolaridadContrayenteUno()));

        //Padres contrayente uno puesto
        if (matrimonioEntity.getOcupacionPadreContrayenteUno() != null)
            estadisticos.setPuestoDTOProgenitorUnoContrayenteUno(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionPadreContrayenteUno()));

        if (matrimonioEntity.getOcupacionMadreContrayenteUno() != null)
            estadisticos.setPuestoDTOProgenitorDosContrayenteUno(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionMadreContrayenteUno()));

        //Padres contrayente dos puesto
        if (matrimonioEntity.getOcupacionPadreContrayenteDos() != null)
            estadisticos.setPuestoDTOProgenitorUnoContrayenteDos(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionPadreContrayenteDos()));

        if (matrimonioEntity.getOcupacionMadreContrayenteDos() != null)
            estadisticos.setPuestoDTOProgenitorDosContrayenteDos(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionMadreContrayenteDos()));

        //Testigos puesto
        if (matrimonioEntity.getOcupacionTestigoUno() != null)
            estadisticos.setPuestoDTOTestigoUno(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionTestigoUno()));

        if (matrimonioEntity.getOcupacionTestigoDos() != null)
            estadisticos.setPuestoDTOTestigoDos(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionTestigoDos()));

        if (matrimonioEntity.getOcupacionTestigoTres() != null)
            estadisticos.setPuestoDTOTestigoTres(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionTestigoTres()));

        if (matrimonioEntity.getOcupacionTestigoCuatro() != null)
            estadisticos.setPuestoDTOTestigoCuatro(mapearEntityADTOPuesto(
                    matrimonioEntity.getOcupacionTestigoCuatro()));

        return estadisticos;
    }

    private ActaMatrimonioDTO mapearDatosActa(Matrimonio matrimonioEntity) {
        CatOficialia oficialia = null;

        ActaMatrimonioDTO actaDTO = new ActaMatrimonioDTO();

        if (matrimonioEntity.getFechaRegistro() != null)
            actaDTO.setFechaRegistro(matrimonioEntity.getFechaRegistro());

        if (matrimonioEntity.getNumeroActa() != null)
            actaDTO.setNumeroActa(matrimonioEntity.getNumeroActa());

        if (matrimonioEntity.getActaBis() != null)
            actaDTO.setActaBis(matrimonioEntity.getActaBis());

        if (matrimonioEntity.getTomo() != null)
            actaDTO.setTomo(matrimonioEntity.getTomo());

        if (matrimonioEntity.getLibro() != null)
            actaDTO.setLibro(matrimonioEntity.getLibro());

        if (matrimonioEntity.getFoja() != null)
            actaDTO.setFoja(matrimonioEntity.getFoja());

        if (matrimonioEntity.getCadena() != null)
            actaDTO.setCadena(matrimonioEntity.getCadena());

        if (matrimonioEntity.getRegimen() != null)
            actaDTO.setRegimenDTO(utileriaService.mapeaEntityRegimenADTO(
                matrimonioEntity.getRegimen()));

        if (matrimonioEntity.getFechaRegistro() != null)
            actaDTO.setAnioRegistro(String.valueOf(
                    obtenerAnioRegistro(matrimonioEntity.getFechaRegistro())));

        if (matrimonioEntity.getLlaveOriginal() != null)
            actaDTO.setLlaveOriginal(matrimonioEntity.getLlaveOriginal() != null ?
                    matrimonioEntity.getLlaveOriginal() : "");
        if (matrimonioEntity.getOficialia() != null) {
            oficialia = oficialiaDAO.findOficialia(matrimonioEntity.getOficialia().getId());

            actaDTO.setOficialia(utileriaService.mapeaEntityOficialiaADTO(oficialia));
            actaDTO.setOficial(utileriaService.mapeaEntityOficialADTO(
                    oficialia.getIdOficial()));
            actaDTO.setEntidadRegistro(utileriaService.mapearEntityADtoEstado(
                    oficialia.getMunicipio().getEstado()));
            actaDTO.setMunicipioRegistro(utileriaService.mapearEntityADtoMunicipio(
                    oficialia.getMunicipio()));
            actaDTO.setFechaBorrado(matrimonioEntity.getFechaBorrado());
            actaDTO.setFechaRegistro(matrimonioEntity.getFechaRegistro());


            actaDTO.setTipoOperacion(matrimonioEntity.getTipoOperacion());
            actaDTO.setNotasMarginales(null);
        }

        return actaDTO;
    }

    private static CatPuestoDTO mapearEntityADTOPuesto(String puesto) {
        CatPuestoDTO puestoDTO = new CatPuestoDTO();
        puestoDTO.setDescripcion(puesto);

        return puestoDTO;
    }

    private static Integer obtenerAnioRegistro(Date fechaRegistro) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRegistro);

        return calendar.get(Calendar.YEAR);
    }
}
