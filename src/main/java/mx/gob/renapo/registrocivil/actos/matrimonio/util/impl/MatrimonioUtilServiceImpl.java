package mx.gob.renapo.registrocivil.actos.matrimonio.util.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.ActaMatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.EstadisticosMatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.util.MatrimonioUtilService;
import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPuesto;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public MatrimonioDTO mapearEntityMatrimonioADTO(Matrimonio matrimonioEntity) {
        MatrimonioDTO matrimonioDTO = new MatrimonioDTO();

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
        matrimonioDTO.setParentescoTestigoUno(utileriaService.mapearEntityADTOParentesco(
                matrimonioEntity.getParentescoTestigoUno()));
        matrimonioDTO.setParentescoTestigoDos(utileriaService.mapearEntityADTOParentesco(
                matrimonioEntity.getParentescoTestigoDos()));
        matrimonioDTO.setParentescoTestigoTres(utileriaService.mapearEntityADTOParentesco(
                matrimonioEntity.getParentescoTestigoTres()));
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
        estadisticos.setSituacionLaboralDTOContrayenteUno(utileriaService.mapearEntityADTOSituacionLaboral(
            matrimonioEntity.getSituacionLaboralContrayenteUno()));
        estadisticos.setSituacionLaboralDTOContrayenteDos(utileriaService.mapearEntityADTOSituacionLaboral(
            matrimonioEntity.getSituacionLaboralContrayenteDos()));

        //Contrayentes puesto
        estadisticos.setPuestoDTOContrayenteUno(utileriaService.mapearEntityADTOPuesto(
                matrimonioEntity.getPosicionTrabajoContrayenteUno()));
        estadisticos.setPuestoDTOContrayenteDos(utileriaService.mapearEntityADTOPuesto(
                matrimonioEntity.getPosicionTrabajoContrayenteDos()));

        //Contrayentes Escolaridad
        estadisticos.setEscolaridadContrayenteUno(utileriaService.mapearEntityADTOEscolaridad(
                matrimonioEntity.getEscolaridadContrayenteUno()));
        estadisticos.setEscolaridadContrayenteDos(utileriaService.mapearEntityADTOEscolaridad(
                matrimonioEntity.getEscolaridadContrayenteDos()));

        //Padres contrayente uno puesto
        estadisticos.setPuestoDTOProgenitorUnoContrayenteUno(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionPadreContrayenteUno()));
        estadisticos.setPuestoDTOProgenitorDosContrayenteUno(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionMadreContrayenteUno()));

        //Padres contrayente dos puesto
        estadisticos.setPuestoDTOProgenitorUnoContrayenteDos(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionPadreContrayenteDos()));
        estadisticos.setPuestoDTOProgenitorDosContrayenteDos(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionMadreContrayenteDos()));

        //Testigos puesto
        estadisticos.setPuestoDTOTestigoUno(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionTestigoUno()));
        estadisticos.setPuestoDTOTestigoDos(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionTestigoDos()));
        estadisticos.setPuestoDTOTestigoTres(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionTestigoTres()));
        estadisticos.setPuestoDTOTestigoCuatro(mapearEntityADTOPuesto(
                matrimonioEntity.getOcupacionTestigoCuatro()));

        return estadisticos;
    }

    private ActaMatrimonioDTO mapearDatosActa(Matrimonio matrimonioEntity) {
        ActaMatrimonioDTO actaDTO = new ActaMatrimonioDTO();


        return actaDTO;
    }

    private static CatPuestoDTO mapearEntityADTOPuesto(String puesto) {
        CatPuestoDTO puestoDTO = new CatPuestoDTO();
        puestoDTO.setDescripcion(puesto);

        return puestoDTO;
    }
}
