package mx.gob.renapo.registrocivil.actos.matrimonio.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dao.MatrimonioDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
import mx.gob.renapo.registrocivil.actos.matrimonio.util.MatrimonioUtilService;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
import mx.gob.renapo.registrocivil.comun.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.comun.service.PersonaService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    MatrimonioUtilService matrimonioUtilService;

    @Autowired
    private UtileriaService utileriaService;

    @Autowired
    private CatOficialiaService oficialiaService;

    @Autowired
    private PersonaDAO personaDAO;

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
            matrimonio.setNumeroActa(matrimonioDTO.getActaMatrimonioDTO().getNumeroActa() != null ?
                    matrimonioDTO.getActaMatrimonioDTO().getNumeroActa() : "");
            matrimonio.setFechaRegistro(new Date());

            matrimonio.setImArchivo("");
            matrimonio.setImNombre("");
            matrimonio.setSello("");
            matrimonio.setSelloImg("");

            matrimonio.setAutorizacionDgrc(matrimonioDTO.getActaMatrimonioDTO().getAutorizacionRg() != null ?
                matrimonioDTO.getActaMatrimonioDTO().getAutorizacionRg() : "");
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
            if (matrimonioDTO.getContrayenteUno().getId() != null)
                matrimonio.setContrayenteUno(personaDAO.recuperarRegistro(matrimonioDTO.getContrayenteUno().getId()));
            else
                matrimonio.setContrayenteUno(utileriaService.mapearDtoAEntityPersona(matrimonioDTO.getContrayenteUno()));

            if (matrimonioDTO.getContrayenteDos().getId() != null)
                matrimonio.setContrayenteDos(personaDAO.recuperarRegistro(matrimonioDTO.getContrayenteDos().getId()));
            else
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
            if (matrimonioDTO.getProgenitorUnoContrayenteUno().getId() != null)
                matrimonio.setPadreContrayenteUno(personaDAO.recuperarRegistro(matrimonioDTO.getProgenitorUnoContrayenteUno().getId()));
            else
                matrimonio.setPadreContrayenteUno(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getProgenitorUnoContrayenteUno()));

            if (matrimonioDTO.getProgenitorDosContrayenteUno().getId() != null)
                matrimonio.setMadreContrayenteUno(personaDAO.recuperarRegistro(matrimonioDTO.getProgenitorDosContrayenteUno().getId()));
            else
                matrimonio.setMadreContrayenteUno(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getProgenitorDosContrayenteUno()));

            if (matrimonioDTO.getProgenitorUnoContrayenteDos().getId() != null)
                matrimonio.setPadreContrayenteDos(personaDAO.recuperarRegistro(matrimonioDTO.getProgenitorUnoContrayenteDos().getId()));
            else
                matrimonio.setPadreContrayenteDos(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getProgenitorUnoContrayenteDos()));

            if (matrimonioDTO.getProgenitorDosContrayenteDos().getId() != null)
                matrimonio.setMadreContrayenteDos(personaDAO.recuperarRegistro(matrimonioDTO.getProgenitorDosContrayenteDos().getId()));
            else
                matrimonio.setMadreContrayenteDos(utileriaService.mapearDtoAEntityPersona(
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
            if (matrimonioDTO.getTestigoUno().getId() != null)
                matrimonio.setTestigoUno(personaDAO.recuperarRegistro(matrimonioDTO.getTestigoUno().getId()));
            else
                matrimonio.setTestigoUno(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getTestigoUno()));

            if (matrimonioDTO.getTestigoDos().getId() != null)
                matrimonio.setTestigoDos(personaDAO.recuperarRegistro(matrimonioDTO.getTestigoDos().getId()));
            else
                matrimonio.setTestigoDos(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getTestigoDos()));

            if (matrimonioDTO.getTestigoTres().getId() != null)
                matrimonio.setTestigoTres(personaDAO.recuperarRegistro(matrimonioDTO.getTestigoTres().getId()));
            else
                matrimonio.setTestigoTres(utileriaService.mapearDtoAEntityPersona(
                        matrimonioDTO.getTestigoTres()));

            if (matrimonioDTO.getTestigoCuatro().getId() != null)
                matrimonio.setTestigoCuatro(personaDAO.recuperarRegistro(matrimonioDTO.getTestigoCuatro().getId()));
            else
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
                if (matrimonioDTO.getConsentimientoContrayenteUno().getId() != null)
                    matrimonio.setConsenMenorContrayenteUno(personaDAO.recuperarRegistro(matrimonioDTO.getConsentimientoContrayenteUno().getId()));
                else
                    matrimonio.setConsenMenorContrayenteUno(utileriaService.mapearDtoAEntityPersona(
                            matrimonioDTO.getConsentimientoContrayenteUno()));
            }

            if (consentimientoDos.equals(4)) {
                if (matrimonioDTO.getConsentimientoContrayenteDos().getId() != null)
                    matrimonio.setConsenMenorContrayenteDos(personaDAO.recuperarRegistro(matrimonioDTO.getConsentimientoContrayenteDos().getId()));
                else
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

    @Override
    public List<MatrimonioDTO> consultarPorCadena(String cadena) throws Exception{
        List<MatrimonioDTO> listaMatrimonioDTO = null;
        List<Matrimonio> listaMatrimonioEntity = matrimonioDAO.consultaActaCadena(cadena);

        if (listaMatrimonioEntity != null && !listaMatrimonioEntity.isEmpty()) {
            listaMatrimonioDTO = new ArrayList<MatrimonioDTO>();

            for (Matrimonio matrimonio : listaMatrimonioEntity) {
                listaMatrimonioDTO.add(matrimonioUtilService.mapearEntityMatrimonioADTO(matrimonio));
            }
        }

        return listaMatrimonioDTO;
    }

    @Override
    public List<MatrimonioDTO> consultarPorNumeroActa(
            String numeroActa, Integer anioRegistro)  throws Exception{
        List<MatrimonioDTO> listaMatrimonioDTO = null;
        List<Matrimonio> listaMatrimonioEntity =
                matrimonioDAO.consultaActaNumeroActaAnioRegistro(anioRegistro, numeroActa);

        if (listaMatrimonioEntity != null && !listaMatrimonioEntity.isEmpty()) {
            listaMatrimonioDTO = new ArrayList<MatrimonioDTO>();

            for (Matrimonio matrimonio : listaMatrimonioEntity) {
                listaMatrimonioDTO.add(matrimonioUtilService.mapearEntityMatrimonioADTO(matrimonio));
            }
        }

        return listaMatrimonioDTO;
    }

    @Override
    public boolean eliminarActoMatrimonio(Long idMatrimonio) {
        try {
            System.out.println("El id: " + idMatrimonio);
            Matrimonio matrimonioEntity = matrimonioDAO.recuperarRegistro(idMatrimonio);
            System.out.println("Matrimonio: " + matrimonioEntity);
            matrimonioEntity.setFechaBorrado(new Date());
            matrimonioDAO.borrarRegistro(matrimonioEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
