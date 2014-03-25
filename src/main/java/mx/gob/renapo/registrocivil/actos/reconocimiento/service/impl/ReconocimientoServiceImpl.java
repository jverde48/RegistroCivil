package mx.gob.renapo.registrocivil.actos.reconocimiento.service.impl;

import mx.gob.renapo.registrocivil.actos.reconocimiento.dao.ReconocimientoDAO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.util.Utileria;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 24/03/14
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReconocimientoServiceImpl {

    private ReconocimientoDAO reconocimientoDAO;

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param reconocimientoDTO
     */
    public void guardarReconocimiento(ReconocimientoDTO reconocimientoDTO) {
        Reconocimiento reconocimientoEntity = new Reconocimiento();









        reconocimientoDAO.guardarRegistro(reconocimientoEntity);


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
