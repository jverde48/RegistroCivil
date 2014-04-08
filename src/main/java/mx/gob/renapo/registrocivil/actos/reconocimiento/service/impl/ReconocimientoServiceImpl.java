package mx.gob.renapo.registrocivil.actos.reconocimiento.service.impl;

import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dao.ReconocimientoDAO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.service.ReconocimientoService;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import java.util.Date;

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
    private PersonaDAO personaDAO;

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param reconocimientoDTO
     */
    public boolean registrarReconocimiento(ReconocimientoDTO reconocimientoDTO, Integer personaOtorgaConsentimiento) {

        try {

            Reconocimiento reconocimiento = new Reconocimiento();

            //Propiedades del Reconocimiento

            reconocimiento.setActaNacimiento(null);
            reconocimiento.setCadena("");
            reconocimiento.setCripReconocido("Crip Reconocido");
            reconocimiento.setLocalidadRegistro(utileriaService.recuperarLocalidad
                    (reconocimientoDTO.getActaNacimientoReconocido().getLocalidadRegistro()));
            reconocimiento.setOficialia(utileriaService.recuperarOficialia
                    (reconocimientoDTO.getActaNacimientoReconocido().getOficialia()));
            reconocimiento.setFechaRegistro(new Date());
            reconocimiento.setFoja("");
            reconocimiento.setLibro("");
            reconocimiento.setTomo("");

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

            reconocimiento.setVersion(1L);

            //personaDAO.guardarRegistro(utileriaService.mapearDtoAEntityPersona
            // (reconocimientoDTO.getPersonaConsentimiento()));
            reconocimientoDAO.guardarRegistro(reconocimiento);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

        /**
         * Metodo para la edicion de un reconocimiento
         * @param reconocimientoDTO
         */
        void editarReconocimiento(ReconocimientoDTO reconocimientoDTO) {

        }

        public void setReconocimientoDAO(ReconocimientoDAO reconocimientoDAO) {
            this.reconocimientoDAO = reconocimientoDAO;
        }

        public ReconocimientoDAO getReconocimientoDAO() {
            return this.reconocimientoDAO;
        }

}
