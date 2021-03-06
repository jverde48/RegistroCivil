package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.service.ReconocimientoService;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Data
@Component
@ViewScoped
@ManagedBean(name = "reconocimientoNormalBean")
public class ReconocimientoNormalBean extends ReconocimientoBean implements Serializable {

    @Autowired
    private ReconocimientoDTO reconocimientoDTO;

    private static Logger log = Logger.getLogger(ReconocimientoBean.class);

    @PostConstruct
    public void cargarInformacion() {

        setListaEstadoCivilReconocido(getEstadoCivilService().findAll());
        setListaEstadoCivilReconocedor(getEstadoCivilService().findAll());
        setListaEstadoCivilTestigoUno(getEstadoCivilService().findAll());
        setListaEstadoCivilTestigoDos(getEstadoCivilService().findAll());
        setListaEstadocivilPersonaConsentimiento(getEstadoCivilService().findAll());
        setListaEstadoCivilAbueloUnoProgenitor(getEstadoCivilService().findAll());
        setListaEstadoCivilAbueloDosProgenitor(getEstadoCivilService().findAll());
        setListaEstadoCivilPadreSanguineo(getEstadoCivilService().findAll());

        setListaPaisReconocido(getPaisService().findAll());
        setListaPaisReconocedor(getPaisService().findAll());
        setListaPaisTestigoUno(getPaisService().findAll());
        setListaPaisTestigoDos(getPaisService().findAll());
        setListaPaisPersonaConsentimiento(getPaisService().findAll());
        setListaPaisAbueloUnoProgenitor(getPaisService().findAll());
        setListaPaisAbueloDosReconocedor(getPaisService().findAll());
        setListaPaisPadreSanguineo(getPaisService().findAll());

        setListaPaisInegiReconocido(getInegiPaisService().findAll());
        setListaPaisInegiReconocedor(getInegiPaisService().findAll());
        setListaPaisInegiTestigoUno(getInegiPaisService().findAll());
        setListaPaisInegiTestigoDos(getInegiPaisService().findAll());
        setListaPaisInegiPersonaConsentimiento(getInegiPaisService().findAll());
        setListaPaisInegiAbueloUnoProgenitor(getInegiPaisService().findAll());
        setListaPaisInegiAbueloDosProgenitor(getInegiPaisService().findAll());
        setListaPaisInegiPadreSanguineo(getInegiPaisService().findAll());

        setListaParentescoReconocedor(getParentescoService().findAll());
        setListaParentescoTestigoUno(getParentescoService().findAll());
        setListaParentescoTestigoDos(getParentescoService().findAll());
        setListaParentescoPersonaConsentimiento(getParentescoService().findAll());
        setListaParentescoAbueloUnoProgenitor(getParentescoService().findAll());
        setListaParentescoAbueloDosProgenitor(getParentescoService().findAll());
        setListaParentescoPadreSanguineo(getParentescoService().findAll());

        setListaTipoLocalidadReconocido(getTipoLocalidadService().findAll());
        setListaTipoLocalidadReconocedor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadTestigoUno(getTipoLocalidadService().findAll());
        setListaTipoLocalidadTestigoDos(getTipoLocalidadService().findAll());
        setListaTipoLocalidadPersonaConsentimiento(getTipoLocalidadService().findAll());
        setListaTipoLocalidadAbueloUnoProgenitor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadAbueloDosProgenitor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadPadreSanguineo(getTipoLocalidadService().findAll());

    }

    public void registrarReconocimiento() throws IOException {

        setReconocimientoDetalle(getReconocimientoService().registrarReconocimiento
                (getReconocimiento(),getPersonaOtorgaConsentimiento()));

        if (getReconocimientoDetalle().getCodigoRespuesta().equals(0)) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_RECONOCIMIENTO));

        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Ocurri\u00f3 un error al guardar el registro.", ""));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");

        }
    }

    public void setPersona(PersonaDTO persona, String tipoPersona) {
        log.info("LA PERSONA: " + persona);
        log.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("R"))
            getReconocimiento().setReconocido((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("RE"))
            getReconocimiento().setReconocedor((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("AUNO"))
            getReconocimiento().setAbueloUnoProgenitor((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ADOS"))
            getReconocimiento().setAbueloDosProgenitor((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("C"))
            getReconocimiento().setPersonaConsentimiento((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TUNO"))
            getReconocimiento().setTestigoUno((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TDOS"))
            getReconocimiento().setTestigoDos((persona));
        else if (!"".equals(tipoPersona) && tipoPersona.equals("P"))
            getReconocimiento().setPadreSanguineo((persona));
    }

    public void restorePersona(String tipoPersona) {
        log.info(":::RESTAURANDO VALORES::::");
        if (!"".equals(tipoPersona) && tipoPersona.equals("R"))
            getReconocimiento().setReconocido(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("RE"))
            getReconocimiento().setReconocedor(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("AUNO"))
            getReconocimiento().setAbueloUnoProgenitor(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("ADOS"))
            getReconocimiento().setAbueloDosProgenitor(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("C"))
            getReconocimiento().setPersonaConsentimiento(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TUNO"))
            getReconocimiento().setTestigoUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TDOS"))
            getReconocimiento().setTestigoDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("P"))
            getReconocimiento().setPadreSanguineo(new PersonaDTO());
    }

    public void setActa() {
        log.info("El ACTA: ");

    }

    public void restoreActa() {
        log.info(":::RESTAURANDO VALORES::::");

    }

}