package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 22/03/14
 * Time: 02:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@ViewScoped
@ManagedBean(name = "reconocimientoEspecialBean")
public class ReconocimientoEspecialBean extends ReconocimientoBean implements Serializable{

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

        //Actas
        setListaEstadosActaReconocido(getEstadoService().recuperarPorPais(getPaisService().findMexico()));

    }

    public void registrarReconocimiento() throws IOException {

        setReconocimientoDetalle(getReconocimientoService().registrarReconocimiento
                (getReconocimiento(),getPersonaOtorgaConsentimiento()));

        System.out.println("Especial: "+ getReconocimientoDetalle().getCodigoRespuesta());

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

}
