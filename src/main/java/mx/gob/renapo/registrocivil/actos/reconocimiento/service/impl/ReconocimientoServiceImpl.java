package mx.gob.renapo.registrocivil.actos.reconocimiento.service.impl;

import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dao.ReconocimientoDAO;
//import mx.gob.renapo.registrocivil.actos.reconocimiento.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.service.ReconocimientoService;
import mx.gob.renapo.registrocivil.actos.reconocimiento.util.ReconocimientoUtilService;
import mx.gob.renapo.registrocivil.catalogos.dao.CatOficialiaDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 24/03/14
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Service
public class ReconocimientoServiceImpl implements ReconocimientoService{

    @Autowired
    private ReconocimientoDAO reconocimientoDAO;

    @Autowired
    private UtileriaService utileriaService;

    @Autowired
    ReconocimientoUtilService reconocimientoUtilService;

    @Autowired
    ReconocimientoDTO reconocimientoDTO;

    @Autowired
    CatOficialiaDAO  oficialiaDAO;

    //@Autowired
    //private PersonaDAO personaDAO;

    /**
     * Metodo para el registro de un nuevo reconocimiento
     * @param reconocimientoDTO
     */
    public ReconocimientoDTO registrarReconocimiento(ReconocimientoDTO reconocimientoDTO,
                                                     Integer personaOtorgaConsentimiento) {

        Reconocimiento reconocimiento = null;
        ReconocimientoDTO reconocimientoDTORespuesta = null;

        try {

            reconocimiento = new Reconocimiento();

            //Propiedades del Acta del Reconocimiento

            reconocimiento.setCadena(reconocimientoDTO.getActaDTO().getCadena());

            if(reconocimientoDTO.getActaDTO().getFechaRegistro()!=null){
                reconocimiento.setFechaRegistro(reconocimientoDTO.getActaDTO().getFechaRegistro());
            }else{
                reconocimiento.setFechaRegistro(new Date());
            }

            reconocimiento.setFoja(reconocimientoDTO.getActaDTO().getFoja());
            reconocimiento.setLibro(reconocimientoDTO.getActaDTO().getLibro());
            reconocimiento.setTomo(reconocimientoDTO.getActaDTO().getTomo());
            reconocimiento.setLocalidadRegistro(utileriaService.recuperarLocalidad
                    (reconocimientoDTO.getActaDTO().getLocalidadRegistro()));
            reconocimiento.setOficialia(utileriaService.recuperarOficialia
                    (reconocimientoDTO.getActaDTO().getOficialia()));
            reconocimiento.setNumeroActa(reconocimientoDTO.getActaDTO().getNumeroActa());

            //Datos del Acta de Nacimiento del Reconocido

            reconocimiento.setTomoReconocido(reconocimientoDTO.getActaNacimientoReconocido().getTomo());
            reconocimiento.setLibroReconocido(reconocimientoDTO.getActaNacimientoReconocido().getLibro());
            reconocimiento.setFojaReconocido(reconocimientoDTO.getActaNacimientoReconocido().getFoja());
            reconocimiento.setFechaRegistroReconocido(reconocimientoDTO.getActaNacimientoReconocido().getFechaRegistro());
            reconocimiento.setNumeroActaReconocido(reconocimientoDTO.getActaNacimientoReconocido().getNumeroActa());
            reconocimiento.setLocalidadRegistroReconocido(utileriaService.recuperarLocalidad
                    (reconocimientoDTO.getActaNacimientoReconocido().getLocalidadRegistro()));
            reconocimiento.setOficialiaReconocido(utileriaService.recuperarOficialia
                    (reconocimientoDTO.getActaNacimientoReconocido().getOficialia()));

            reconocimiento.setActaNacimiento(null);

            //Archivo

            reconocimiento.setImArchivo("");
            reconocimiento.setSello("");
            reconocimiento.setSelloImg("");

            reconocimiento.setPersonaConsenParent(utileriaService.recuperarParentesco
                    (reconocimientoDTO.getParentescoConsentimientoPersonaDTO()));

            //Personas del Reconocimiento

            if (personaOtorgaConsentimiento.equals(4)){
                reconocimiento.setPersonaConsen(utileriaService.mapearDtoAEntityPersona
                        (reconocimientoDTO.getPersonaConsentimiento()));
            };

            reconocimiento.setProgenitorUnoReconocedor(utileriaService.mapearDtoAEntityPersona
                    (reconocimientoDTO.getAbueloUnoProgenitor()));
            reconocimiento.setProgenitorDosReconocedor(utileriaService.mapearDtoAEntityPersona
                    (reconocimientoDTO.getAbueloDosProgenitor()));
            reconocimiento.setReconocedor(utileriaService.mapearDtoAEntityPersona(reconocimientoDTO.getReconocedor()));
            reconocimiento.setReconocido(utileriaService.mapearDtoAEntityPersona(reconocimientoDTO.getReconocido()));
            reconocimiento.setTestigoUno(utileriaService.mapearDtoAEntityPersona(reconocimientoDTO.getTestigoUno()));
            reconocimiento.setTestigoDos(utileriaService.mapearDtoAEntityPersona(reconocimientoDTO.getTestigoDos()));
            reconocimiento.setPadreSanguineo(utileriaService.mapearDtoAEntityPersona(reconocimientoDTO.getPadreSanguineo()));

            reconocimiento.setVersion(1L);
            reconocimiento.setFechaCreacion(new Date());

            //personaDAO.guardarRegistro(utileriaService.mapearDtoAEntityPersona
            // (reconocimientoDTO.getPersonaConsentimiento()));

            //reconocimientoDAO.guardarRegistro(reconocimiento);
            reconocimientoDTORespuesta = reconocimientoUtilService.mapeaEntityReconocimientoDTO
                    (reconocimientoDAO.guardarRegistro(reconocimiento));

            return reconocimientoDTORespuesta;

        } catch (Exception e) {
            e.printStackTrace();
            reconocimientoDTORespuesta = new ReconocimientoDTO();
            reconocimientoDTORespuesta.setCodigoRespuesta(1);
            reconocimientoDTORespuesta.setMensajeError(utileriaService.getStackTrace(e));
            return reconocimientoDTORespuesta;

        }

    }

        /**
         * Metodo para la edicion de un reconocimiento
         * @param reconocimientoDTO
         */
        void editarReconocimiento(ReconocimientoDTO reconocimientoDTO) {

        }

        /**
         * Metodo para la eliminación de un Reconocimiento
         */
        public void eliminarReconocimiento(Long idReconocimiento){

            try{

                Reconocimiento reconocimiento = reconocimientoDAO.recuperarRegistro(idReconocimiento);

                reconocimiento.setFechaBorrado(new Date());
                reconocimientoDAO.borrarRegistro(reconocimiento);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    /**
     * Metodo para consultar un reconocimiento por la cadena
     * @param cadena
     * @return ReconocimientoDTO
     */
    public List<ReconocimientoDTO> consultaReconocimientoCadena(String cadena) {

        System.out.println("Service por Cadena");

        List<ReconocimientoDTO> reconocimientoDTOList = new ArrayList<ReconocimientoDTO>();
        List<Reconocimiento> reconocimientoList = new ArrayList<Reconocimiento>();
        try {
            reconocimientoList = reconocimientoDAO.consultaActaCadena(cadena);

            if(reconocimientoList!=null || !reconocimientoList.isEmpty()) {
                for(Reconocimiento reconocimiento: reconocimientoList) {
                    reconocimientoDTOList.add(mapearEntityADtoReconocimiento(reconocimiento));
                }
            }
        }catch (Exception e) {
        }
        return reconocimientoDTOList;
    }

    /**
     * Metodo para consultar un reconocimiento por numero de Acta
     * @param anio, numeroActa
     * @return ReconocimientoDTO
     */
    public List<ReconocimientoDTO> consultaReconocimientoNumeroActa(Integer anio, String numeroActa) {

        List<ReconocimientoDTO> reconocimientDTOList = new ArrayList<ReconocimientoDTO>();
        List<Reconocimiento> reconocimientoList = new ArrayList<Reconocimiento>();
        try {
            reconocimientoList = reconocimientoDAO.consultaActaNumeroActaAnioRegistro(anio,numeroActa);
            if(reconocimientoList!=null || !reconocimientoList.isEmpty()) {
                for(Reconocimiento reconocimiento: reconocimientoList) {
                    reconocimientDTOList.add(mapearEntityADtoReconocimiento(reconocimiento));
                }

            }
        }catch (Exception e) {
            e.printStackTrace();

        }
        return reconocimientDTOList;
    }

    public ReconocimientoDTO mapearEntityADtoReconocimiento(Reconocimiento reconocimiento){

        reconocimientoDTO.setId(reconocimiento.getId());
        reconocimientoDTO.getActaDTO().setCadena(reconocimiento.getCadena());
        reconocimientoDTO.getActaDTO().setFechaRegistro(reconocimiento.getFechaRegistro());
        reconocimientoDTO.getActaDTO().setFoja(reconocimiento.getFoja());
        reconocimientoDTO.getActaDTO().setLibro(reconocimiento.getLibro());
        reconocimientoDTO.getActaDTO().setTomo(reconocimiento.getTomo());
        reconocimientoDTO.getActaDTO().setLocalidadRegistro(utileriaService.mapeaEntityInegiADtoLocalidad(
                reconocimiento.getLocalidadRegistro()));

        reconocimiento.setOficialia(oficialiaDAO.findOficialia(reconocimiento.getOficialia().getId()));

        if(reconocimiento.getOficialia()!=null)
            reconocimientoDTO.getActaDTO().setOficialia(utileriaService.mapeaEntityOficialiaADTO(
                reconocimiento.getOficialia()));

        reconocimientoDTO.getActaDTO().setNumeroActa(reconocimiento.getNumeroActa());

        //Datos del Acta de Nacimiento del Reconocido

        reconocimientoDTO.getActaNacimientoReconocido().setTomo(reconocimiento.getTomoReconocido());
        reconocimientoDTO.getActaNacimientoReconocido().setLibro(reconocimiento.getLibroReconocido());
        reconocimientoDTO.getActaNacimientoReconocido().setFoja(reconocimiento.getFojaReconocido());
        reconocimientoDTO.getActaNacimientoReconocido().setFechaRegistro(reconocimiento.getFechaRegistroReconocido());
        reconocimientoDTO.getActaNacimientoReconocido().setNumeroActa(reconocimiento.getNumeroActaReconocido());
        reconocimientoDTO.getActaNacimientoReconocido().setLocalidadRegistro(utileriaService.mapeaEntityInegiADtoLocalidad(
                reconocimiento.getLocalidadRegistroReconocido()));

        reconocimiento.setOficialiaReconocido(oficialiaDAO.findOficialia(reconocimiento.getOficialiaReconocido().getId()));

        if(reconocimiento.getOficialiaReconocido()!=null)
        reconocimientoDTO.getActaNacimientoReconocido().setOficialia(utileriaService.mapeaEntityOficialiaADTO(
                reconocimiento.getOficialiaReconocido()));

        //Personas del Reconocimiento

        if (reconocimiento.getPersonaConsen()!=null){
            reconocimientoDTO.setPersonaConsentimiento(utileriaService.mapearEntityDTOPersona(
                    reconocimiento.getPersonaConsen()));
        }

        reconocimientoDTO.setAbueloUnoProgenitor(utileriaService.mapearEntityDTOPersona(
                reconocimiento.getProgenitorUnoReconocedor()));
        reconocimientoDTO.setAbueloDosProgenitor(utileriaService.mapearEntityDTOPersona(
                reconocimiento.getProgenitorDosReconocedor()));
        reconocimientoDTO.setReconocedor(utileriaService.mapearEntityDTOPersona(reconocimiento.getReconocedor()));
        reconocimientoDTO.setReconocido(utileriaService.mapearEntityDTOPersona(reconocimiento.getReconocido()));
        reconocimientoDTO.setTestigoUno(utileriaService.mapearEntityDTOPersona(reconocimiento.getTestigoUno()));
        reconocimientoDTO.setTestigoDos(utileriaService.mapearEntityDTOPersona(reconocimiento.getTestigoDos()));
        reconocimientoDTO.setPadreSanguineo(utileriaService.mapearEntityDTOPersona(reconocimiento.getPadreSanguineo()));

        if(reconocimiento.getFechaBorrado()!=null){
            reconocimientoDTO.setEstatusRegistro(0); //Dato Vigente
        }else{
            reconocimientoDTO.setEstatusRegistro(1); //Dato baja
        }

        return reconocimientoDTO;
    }

    public void setReconocimientoDAO(ReconocimientoDAO reconocimientoDAO) {
            this.reconocimientoDAO = reconocimientoDAO;
        }

        public ReconocimientoDAO getReconocimientoDAO() {
            return this.reconocimientoDAO;
        }

}
