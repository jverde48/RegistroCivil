package mx.gob.renapo.registrocivil.actos.sentencia.bean;

import lombok.Data;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoSentenciaDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoSentenciaService;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import mx.gob.renapo.registrocivil.actos.sentencia.dto.SentenciaDTO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 4/04/14
 * Time: 05:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@ViewScoped
@ManagedBean(name = "sentenciaBean")
public class SentenciaBean implements Serializable{

    private SentenciaDTO sentenciaDTO;

    private List<CatTipoSentenciaDTO> tipoSentenciaList;

    @Autowired
    private CatTipoSentenciaService tipoSentenciaService;

  /*



    @Autowired
    private CatTipoSentenciaDTO tipoSentenciaDTO;

    private String templateTipoSentencia;  */

    /**
     * Metodo para cambiar el template necesario para el formulario de los
     * padres
     */

   /* @Override
       public void cambiaTemplateProgenitores() {
        if (getDeclarante() ==1 ) {
            templateTipoSentencia = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_DECLARANTE;
        } else if (getDeclarante() == 2) {
            templateTipoSentencia = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_TUTOR;
        }       */


    @PostConstruct //le indicamos al metodocargar informacion debe ejecutarse o debe ser llamado después de la construcción del bean.
    public  void cargarInformacion () {
        tipoSentenciaList = tipoSentenciaService.findAll();
    }
}




