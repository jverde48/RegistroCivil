package mx.gob.renapo.registrocivil.actos.matrimonio.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dao.MatrimonioDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
//import mx.gob.renapo.registrocivil.comun.dao.DomicilioDAO;
//import mx.gob.renapo.registrocivil.comun.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.util.MatrimonioUtilService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class MatrimonioServiceImpl implements MatrimonioService {

    @Autowired
    private MatrimonioDAO matrimonioDAO;

    /*@Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private DomicilioDAO domicilioDAO;
    */

    @Autowired
    MatrimonioUtilService matrimonioUtilService;

    @Autowired
    private UtileriaService utileriaService;

    @Override
    public MatrimonioDTO registrarMatrimonio(MatrimonioDTO matrimonioDTO,
                         Integer consentimientoUno, Integer consentimientoDos) {
        Matrimonio matrimonio = null;
        MatrimonioDTO matrimonioDTOResponse = null;
        //personaDAO.guardarRegistro(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteUno()));


        try {
            matrimonio = new Matrimonio();

            //propiedades del Acta de matrimonio
            matrimonio.setActaBis("");
            matrimonio.setAutorizacionDgrc("");

            matrimonio.setCadena("");//TODO GENERAR CADENA

            matrimonio.setTomo("");
            matrimonio.setLibro("");
            matrimonio.setFoja("");
            matrimonio.setVersion(1L);

            matrimonio.setFechaRegistro(new Date());
            matrimonio.setNumeroActaMatrimonio("");

            /*matrimonio.setOficialia(utileriaService.recuperarOficialia(
                matrimonioDTO.getActaMatrimonioDTO().getOficialia()));*/
            //matrimonio.setOficialia(null); TODO SPRING SECURITY
            matrimonio.setSello("");
            matrimonio.setSelloImg("");
            matrimonio.setImArchivo("");

            matrimonio.setTipoOperacion('R');
            matrimonio.setTranscripcion("");

            //Datos del registro de el alct


            //Datos de los contrayentes
            matrimonio.setContrayenteUno(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteUno()));
            matrimonio.setContrayenteDos(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteDos()));

            matrimonio.setEscolaridadContrayenteUno(utileriaService.recuperarEscolaridad(
                    matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteUno()));

            matrimonio.setEscolaridadContrayenteDos(utileriaService.recuperarEscolaridad(
                    matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteDos()));

            matrimonio.setOcupacionContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOContrayenteUno().getDescripcion());

            matrimonio.setOcupacionContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOContrayenteDos().getDescripcion());

            matrimonio.setPosicionTrabajoContrayenteUno(utileriaService.recuperarPuesto(
                    matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteUno()));

            matrimonio.setPosicionTrabajoContrayenteDos(utileriaService.recuperarPuesto(
                    matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteDos()));

            matrimonio.setSituacionLaboralContrayenteUno(utileriaService.recuperarSituacionLaboral(
                    matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteUno()));

            matrimonio.setSituacionLaboralContrayenteDos(utileriaService.recuperarSituacionLaboral(
                    matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteDos()));

            //Datos de los padres de los contrayentes
            matrimonio.setMadreContrayenteUno(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getProgenitorUnoContrayenteUno()));
            matrimonio.setPadreContrayenteUno(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getProgenitorDosContrayenteUno()));

            matrimonio.setMadreContrayenteDos(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getProgenitorUnoContrayenteDos()));
            matrimonio.setPadreContrayenteDos(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getProgenitorDosContrayenteDos()));

            matrimonio.setOcupacionMadreContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOProgenitorUnoContrayenteUno().getDescripcion());
            matrimonio.setOcupacionPadreContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOProgenitorDosContrayenteUno().getDescripcion());

            matrimonio.setOcupacionMadreContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOProgenitorUnoContrayenteDos().getDescripcion());
            matrimonio.setOcupacionPadreContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOProgenitorDosContrayenteDos().getDescripcion());

            //Datos de los Testigos
            matrimonio.setTestigoUno(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getTestigoUno()));
            matrimonio.setTestigoDos(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getTestigoDos()));
            matrimonio.setTestigoTres(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getTestigoTres()));
            matrimonio.setTestigoCuatro(utileriaService.mapearDtoAEntityPersona(
                    matrimonioDTO.getTestigoCuatro()));

            matrimonio.setOcupacionTestigoUno(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOTestigoUno().getDescripcion());
            matrimonio.setOcupacionTestigoDos(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOTestigoDos().getDescripcion());
            matrimonio.setOcupacionTestigoTres(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOTestigoTres().getDescripcion());
            matrimonio.setOcupacionTestigoCuatro(matrimonioDTO.getEstadisticosDTO().
                    getPuestoDTOTestigoCuatro().getDescripcion());

            matrimonio.setParentescoTestigoUno(utileriaService.recuperarParentesco(
                    matrimonioDTO.getParentescoTestigoUno()));
            matrimonio.setParentescoTestigoDos(utileriaService.recuperarParentesco(
                    matrimonioDTO.getParentescoTestigoDos()));
            matrimonio.setParentescoTestigoTres(utileriaService.recuperarParentesco(
                    matrimonioDTO.getParentescoTestigoTres()));
            matrimonio.setParentescoTestigoCuatro(utileriaService.recuperarParentesco(
                    matrimonioDTO.getParentescoTestigoCuatro()));

            //Datos de las personas que consienten el matrimonio
            if (consentimientoUno.equals(4)) {
                matrimonio.setConsenMenorContrayenteUno(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getConsentimientoContrayenteUno()));
            }

            if (consentimientoDos.equals(4)) {
                matrimonio.setConsenMenorContrayenteDos(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getConsentimientoContrayenteDos()));
            }


            matrimonioDTOResponse = matrimonioUtilService.mapearEntityMatrimonioADTO(
                    matrimonioDAO.guardarRegistro(matrimonio));

            return matrimonioDTOResponse;
        } catch (Exception e) {
            matrimonioDTOResponse = new MatrimonioDTO();
            matrimonioDTOResponse.setCodigoRespuesta(1);
            return  matrimonioDTOResponse;
        }
    }
}
