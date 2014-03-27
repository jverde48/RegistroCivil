package mx.gob.renapo.registrocivil.actos.matrimonio.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dao.MatrimonioDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoOperacion;
import mx.gob.renapo.registrocivil.util.Utileria;
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

    @Override
    public boolean registrarMatrimonio(MatrimonioDTO matrimonioDTO) {
        Matrimonio matrimonio = new Matrimonio();

        /**
         * propiedades del Acta de matrimonio
         */
        matrimonio.setActaBis("");
        matrimonio.setAutorizacionDgrc("");

        matrimonio.setCadena("VEMJ910503NA7");

        matrimonio.setCripUno("");
        matrimonio.setCripDos("");

        matrimonio.setTomo("");
        matrimonio.setLibro("");
        matrimonio.setFoja("");

        matrimonio.setFechaRegistro(new Date());
        matrimonio.setNumeroActaMatrimonio("");

        matrimonio.setOficialia(Utileria.mapearDTOAEntityOficialia(
                matrimonioDTO.getActaMatrimonioDTO().getOficialia()));
        matrimonio.setSello("");
        matrimonio.setSelloImg("");
        matrimonio.setImArchivo("");

        matrimonio.setTipoOperacion(new CatTipoOperacion());
        matrimonio.setTranscripcion("");//TODO

        /**
         * Datos de los contrayentes
         */
        matrimonio.setContrayenteUno(Utileria.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteUno()));
        matrimonio.setContrayenteDos(Utileria.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteDos()));

        matrimonio.setEscolaridadContrayenteUno(Utileria.mapearDTOAEntityEscolaridad(
                matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteUno()));

        matrimonio.setEscolaridadContrayenteDos(Utileria.mapearDTOAEntityEscolaridad(
                matrimonioDTO.getEstadisticosDTO().getEscolaridadContrayenteDos()));

        matrimonio.setOcupacionContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOContrayenteUno().getDescripcion());

        matrimonio.setOcupacionContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOContrayenteDos().getDescripcion());

        matrimonio.setPosicionTrabajoContrayenteUno(Utileria.mapearDTOAEntityPuesto(
                matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteUno()));

        matrimonio.setPosicionTrabajoContrayenteDos(Utileria.mapearDTOAEntityPuesto(
                matrimonioDTO.getEstadisticosDTO().getPuestoDTOContrayenteDos()));

        matrimonio.setSituacionLaboralContrayenteUno(Utileria.mapearDTOAEntitySituacionLaboral(
                matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteUno()));

        matrimonio.setSituacionLaboralContrayenteDos(Utileria.mapearDTOAEntitySituacionLaboral(
                matrimonioDTO.getEstadisticosDTO().getSituacionLaboralDTOContrayenteDos()));

        /**
         * Datos de los padres de los contrayentes
         */
        matrimonio.setMadreContrayenteUno(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getProgenitorUnoContrayenteUno()));
        matrimonio.setPadreContrayenteUno(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getProgenitorDosContrayenteUno()));

        matrimonio.setMadreContrayenteDos(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getProgenitorUnoContrayenteDos()));
        matrimonio.setPadreContrayenteDos(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getProgenitorDosContrayenteDos()));

        matrimonio.setOcupacionMadreContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOProgenitorUnoContrayenteUno().getDescripcion());
        matrimonio.setOcupacionPadreContrayenteUno(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOProgenitorDosContrayenteUno().getDescripcion());

        matrimonio.setOcupacionMadreContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOProgenitorUnoContrayenteDos().getDescripcion());
        matrimonio.setOcupacionPadreContrayenteDos(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOProgenitorDosContrayenteDos().getDescripcion());

        /**
         * Datos de los Testigos
         */
        matrimonio.setTestigoUno(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getTestigoUno()));
        matrimonio.setTestigoDos(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getTestigoDos()));
        matrimonio.setTestigoTres(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getTestigoTres()));
        matrimonio.setTestigoCuatro(Utileria.mapearDtoAEntityPersona(
                matrimonioDTO.getTestigoCuatro()));

        matrimonio.setOcupacionTestigoUno(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOTestigoUno().getDescripcion());
        matrimonio.setOcupacionTestigoDos(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOTestigoDos().getDescripcion());
        matrimonio.setOcupacionTestigoTres(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOTestigoTres().getDescripcion());
        matrimonio.setOcupacionTestigoCuatro(matrimonioDTO.getEstadisticosDTO().
                getPuestoDTOTestigoCuatro().getDescripcion());

        matrimonio.setParentescoTestigoUno(Utileria.mapearDTOAEntityParentesco(
                matrimonioDTO.getParentescoTestigoUno()));
        matrimonio.setParentescoTestigoDos(Utileria.mapearDTOAEntityParentesco(
                matrimonioDTO.getParentescoTestigoDos()));
        matrimonio.setParentescoTestigoTres(Utileria.mapearDTOAEntityParentesco(
                matrimonioDTO.getParentescoTestigoTres()));
        matrimonio.setParentescoTestigoCuatro(Utileria.mapearDTOAEntityParentesco(
                matrimonioDTO.getParentescoTestigoCuatro()));

        /**
         * Datos de las personas que consienten el matrimonio
         */
        if (matrimonioDTO.getConsentimientoContrayenteUno() != null ) {
            matrimonio.setConsenMenorContrayenteUno(Utileria.mapearDtoAEntityPersona(
                    matrimonioDTO.getConsentimientoContrayenteUno()));
        }

        if (matrimonioDTO.getConsentimientoContrayenteDos() != null) {
            matrimonio.setConsenMenorContrayenteDos(Utileria.mapearDtoAEntityPersona(
                    matrimonioDTO.getConsentimientoContrayenteDos()));
        }

        return matrimonioDAO.guardarRegistro(matrimonio);
    }
}
