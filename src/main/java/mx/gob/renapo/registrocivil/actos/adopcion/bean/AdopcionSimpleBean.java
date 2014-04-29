package mx.gob.renapo.registrocivil.actos.adopcion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
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


@Data
@Component
@ViewScoped
@ManagedBean(name = "adopcionSimpleBean")
public class AdopcionSimpleBean extends AdopcionPrincipalBean implements Serializable {

    private static Logger logger = Logger.getLogger(AdopcionSimpleBean.class);

    boolean mostrarDatosAdoptado;


    @PostConstruct
    public void init() {
        setPaises(getPaisService().findAll());
        setPaisesInegi(getInegiPaisService().findAll());
        setTipoLocalidadList(getTipoLocalidadService().findAll());
        setEstadoCivilList(getEstadoCivilService().findAll());
        getAdopcionDTO().getPersona().setPaisNacimiento(getPaisService().findMexico());

        if(getEstadoCivilList()!=null) {
            for(CatEstadoCivilDTO estadoCivil: getEstadoCivilList()) {
                if(estadoCivil.getDescripcion().equals("Soltero")) {
                    getAdopcionDTO().getPersona().setEstadoCivil(estadoCivil);
                    break;
                }
            }
        }

        setEstadosAdoptado(getEstadoService().recuperarPorPais
                (getAdopcionDTO().getPersona().getPaisNacimiento()));


    }



    public void onRowSelect() {
        mostrarDatosAdoptado = true;
        //Se debe buscar el progenitor del adoptado
    }

    /**
     * Metodo para guardar un nuevo registro de adopcion
     */
    public void guardaRegistro() throws IOException {
        getAdopcionDTO().getActaAdopcion().setTipoOperacion(ConstantesComunes.TIPO_OPERACION_NACIONAL);

        setDetalleAdopcion(getAdopcionService().guardarAdopcion
                (getAdopcionDTO(), getExistenciaAbueloUnoAdoptante(), getExistenciaAbueloDosAdoptante()));

        if(getDetalleAdopcion().getCodigoError()==ConstantesComunes.CODIGO_EXITOSO) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_INFO,"Exito", "El registro se ha guardado correctamente."));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_ADOPCION));
        }
        else if(getDetalleAdopcion().getCodigoError()==ConstantesComunes.CODIGO_ERROR) {
            FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage
                            (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al generar el acta de nacimiento"));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
    }

    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("ADOPTADO"))
            getAdopcionDTO().setPersona(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ADOPTANTE"))
            getAdopcionDTO().setAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("PUADOPTANTE"))
            getAdopcionDTO().setPadreUnoAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("PDADOPTANTE"))
            getAdopcionDTO().setPadreDosAdoptante(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("TESTIGOU"))
            getAdopcionDTO().setTestigoUno(persona);
        else if(!"".equals(tipoPersona) && tipoPersona.equals("TESTIGOD"))
            getAdopcionDTO().setTestigoDos(persona);
    }
}
