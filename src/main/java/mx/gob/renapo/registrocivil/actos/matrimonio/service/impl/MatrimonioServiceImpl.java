package mx.gob.renapo.registrocivil.actos.matrimonio.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dao.MatrimonioDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
//import mx.gob.renapo.registrocivil.comun.dao.DomicilioDAO;
//import mx.gob.renapo.registrocivil.comun.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.util.MatrimonioUtilService;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
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

    @Autowired
    private CatOficialiaService oficialiaService;

    @Override
    public MatrimonioDTO registrarMatrimonio(MatrimonioDTO matrimonioDTO,
                         Integer consentimientoUno, Integer consentimientoDos) {
        Matrimonio matrimonio = null;
        MatrimonioDTO matrimonioDTOResponse = null;
        //personaDAO.guardarRegistro(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteUno()));


        try {
            matrimonio = new Matrimonio();

            //propiedades del Acta de matrimonio
            matrimonio.setTomo(matrimonioDTO.getActaMatrimonioDTO().getTomo() != null ?
                    matrimonioDTO.getActaMatrimonioDTO().getTomo().toUpperCase() : "");
            matrimonio.setLibro(matrimonioDTO.getActaMatrimonioDTO().getLibro() != null ?
                    matrimonioDTO.getActaMatrimonioDTO().getTomo().toUpperCase() : "");
            matrimonio.setFoja(matrimonioDTO.getActaMatrimonioDTO().getFoja() != null ?
                    matrimonioDTO.getActaMatrimonioDTO().getTomo().toUpperCase() : "");

            matrimonio.setActaBis(0);
            matrimonio.setCadena("");//TODO GENERAR CADENA
            matrimonio.setNumeroActaMatrimonio(matrimonioDTO.getActaMatrimonioDTO().getNumeroActa() != null ?
                    matrimonioDTO.getActaMatrimonioDTO().getNumeroActa() : "");
            matrimonio.setFechaRegistro(new Date());

            matrimonio.setImArchivo("");
            matrimonio.setImNombre("");
            matrimonio.setSello("");
            matrimonio.setSelloImg("");

            matrimonio.setAutorizacionDgrc("");
            matrimonio.setVersion(1L);

            if (matrimonioDTO.isNormal()) {
                if (matrimonioDTO.getActaMatrimonioDTO().getTipoOperacion().equals(2))
                    matrimonio.setTranscripcion(matrimonioDTO.getActaMatrimonioDTO().getTranscripcion().toString());
            } else
                matrimonio.setTranscripcion("");

            if (matrimonioDTO.isHistorico())
                matrimonio.setLlaveOriginal(matrimonioDTO.getActaMatrimonioDTO().getLlaveOriginal());
            else
                matrimonio.setLlaveOriginal("");

            if (matrimonioDTO.isHistorico())
                matrimonio.setOficialia(utileriaService.recuperarOficialia(
                        matrimonioDTO.getActaMatrimonioDTO().getOficialia()));
            else
                matrimonio.setOficialia(/*utileriaService.recuperarOficialia(
                matrimonioDTO.getActaMatrimonioDTO().getOficialia()*)*/utileriaService.recuperarOficialia(
                        oficialiaService.findOficialia(1L)));//TODO SPRING SECURITY


            matrimonio.setRegimen(utileriaService.recuperarRegimen(
                    matrimonioDTO.getActaMatrimonioDTO().getRegimenDTO()));

            matrimonio.setTipoOperacion(matrimonioDTO.getActaMatrimonioDTO().getTipoOperacion());

            if (matrimonioDTO.isNormal())
                matrimonio.setTipoCaptura('N');
            else if (matrimonioDTO.isHistorico())
                matrimonio.setTipoCaptura('H');
            else
                matrimonio.setTipoCaptura('E');

            //Datos de los contrayentes
            matrimonio.setContrayenteUno(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteUno()));
            matrimonio.setContrayenteDos(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteDos()));

            if (matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteUno() != null)
                matrimonio.setEscolaridadContrayenteUno(utileriaService.recuperarEscolaridad(
                        matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteUno()));

            if (matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteDos() != null)
                matrimonio.setEscolaridadContrayenteDos(utileriaService.recuperarEscolaridad(
                        matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteDos()));

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteUno() != null)
                matrimonio.setOcupacionContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOContrayenteUno().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteDos() != null)
                matrimonio.setOcupacionContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOContrayenteDos().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteUno() != null)
                matrimonio.setPosicionTrabajoContrayenteUno(utileriaService.recuperarPuesto(
                        matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteUno()));

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteDos() != null)
                matrimonio.setPosicionTrabajoContrayenteDos(utileriaService.recuperarPuesto(
                        matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteDos()));

            if (matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteUno() != null)
                matrimonio.setSituacionLaboralContrayenteUno(utileriaService.recuperarSituacionLaboral(
                        matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteUno()));

            if (matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteDos() != null)
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

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOProgenitorUnoContrayenteUno() != null)
                matrimonio.setOcupacionMadreContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOProgenitorUnoContrayenteUno().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOProgenitorDosContrayenteUno() != null)
                matrimonio.setOcupacionPadreContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOProgenitorDosContrayenteUno().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOProgenitorUnoContrayenteDos() != null)
                matrimonio.setOcupacionMadreContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOProgenitorUnoContrayenteDos().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOProgenitorDosContrayenteDos() != null)
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

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOTestigoUno() != null)
                matrimonio.setOcupacionTestigoUno(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOTestigoUno().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOTestigoDos() != null)
                matrimonio.setOcupacionTestigoDos(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOTestigoDos().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOTestigoTres() != null)
                matrimonio.setOcupacionTestigoTres(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOTestigoTres().getDescripcion());

            if (matrimonioDTO.getEstadisticosDTO().getPuestoDTOTestigoCuatro() != null)
                matrimonio.setOcupacionTestigoCuatro(matrimonioDTO.getEstadisticosDTO().
                        getPuestoDTOTestigoCuatro().getDescripcion());

            if (matrimonioDTO.getParentescoTestigoUno() != null)
                matrimonio.setParentescoTestigoUno(utileriaService.recuperarParentesco(
                        matrimonioDTO.getParentescoTestigoUno()));

            if (matrimonioDTO.getParentescoTestigoDos() != null)
                matrimonio.setParentescoTestigoDos(utileriaService.recuperarParentesco(
                        matrimonioDTO.getParentescoTestigoDos()));

            if (matrimonioDTO.getParentescoTestigoTres() != null)
                matrimonio.setParentescoTestigoTres(utileriaService.recuperarParentesco(
                        matrimonioDTO.getParentescoTestigoTres()));

            if (matrimonioDTO.getParentescoTestigoCuatro() != null)
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
            e.printStackTrace();
            matrimonioDTOResponse = new MatrimonioDTO();
            matrimonioDTOResponse.setCodigoRespuesta(1);
            matrimonioDTOResponse.setMensajeError(
                    utileriaService.getStackTrace(e));
            return  matrimonioDTOResponse;
        }
    }
}
