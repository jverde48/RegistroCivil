package mx.gob.renapo.registrocivil.actos.adopcion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "adopcionHistoricoSimpleBean")
@Data
@ViewScoped
@Component
public class AdopcionHistoricoSimpleBean extends AdopcionPrincipalBean implements Serializable {

    private static Logger logger = Logger.getLogger(AdopcionHistoricoSimpleBean.class);

    @PostConstruct
    public void init() {
        setPaises(getPaisService().findAll());
        setPaisesInegi(getInegiPaisService().findAll());
        setTipoLocalidadList(getTipoLocalidadService().findAll());
        setEstadoCivilList(getEstadoCivilService().findAll());
        getAdopcionHistoricoDTO().getPersona().setPaisNacimiento(getPaisService().findMexico());

        if(getEstadoCivilList()!=null) {
            for(CatEstadoCivilDTO estadoCivil: getEstadoCivilList()) {
                if(estadoCivil.getDescripcion().equals("Soltero")) {
                    getAdopcionHistoricoDTO().getPersona().setEstadoCivil(estadoCivil);
                    break;
                }
            }
        }

        setEstadosAdoptado(getEstadoService().recuperarPorPais
                (getAdopcionHistoricoDTO().getPersona().getPaisNacimiento()));

    }

    /**
     * Metodo para guardar un nuevo registro de adopcion
     */
    public void guardaRegistro() throws IOException {

        getAdopcionHistoricoDTO().getActaAdopcion().setTipoOperacion(ConstantesComunes.TIPO_OPERACION_NACIONAL);

        setDetalleAdopcion((getAdopcionService().guardarAdopcion
                (getAdopcionHistoricoDTO(), getExistenciaAbueloUnoAdoptante(), getExistenciaAbueloDosAdoptante())));

        if(getDetalleAdopcion().getCodigoError()==ConstantesComunes.CODIGO_EXITOSO) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_INFO,"Exito", "Se ha modificado el acta de adopción"));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_ADOPCION));
        }
        else if(getDetalleAdopcion().getCodigoError()==ConstantesComunes.CODIGO_ERROR) {
            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al generar el acta de adopción"));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
    }

    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("ADOPTADO"))
            getAdopcionHistoricoDTO().setPersona(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ADOPTANTE"))
            getAdopcionHistoricoDTO().setAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("PUADOPTANTE"))
            getAdopcionHistoricoDTO().setPadreUnoAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("PDADOPTANTE"))
            getAdopcionHistoricoDTO().setPadreDosAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("TESTIGOU"))
            getAdopcionHistoricoDTO().setTestigoUno(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("TESTIGOD"))
            getAdopcionHistoricoDTO().setTestigoDos(persona);
    }
}
