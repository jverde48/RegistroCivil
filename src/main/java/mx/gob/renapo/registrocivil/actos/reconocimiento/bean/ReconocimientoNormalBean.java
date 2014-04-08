package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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

        setListaEstadoReconocido(getEstadoService().findAll());
        setListaEstadoReconocedor(getEstadoService().findAll());
        setListaEstadoTestigoUno(getEstadoService().findAll());
        setListaEstadoTestigoDos(getEstadoService().findAll());
        setListaEstadoPersonaConsentimiento(getEstadoService().findAll());
        setListaEstadoAbueloUnoProgenitor(getEstadoService().findAll());
        setListaEstadoAbueloDosProgenitor(getEstadoService().findAll());

        setListaEstadoInegiReconocido(getInegiEstadoService().findAll());
        setListaEstadoInegiReconocedor(getInegiEstadoService().findAll());
        setListaEstadoInegiTestigoUno(getInegiEstadoService().findAll());
        setListaEstadoInegiTestigoDos(getInegiEstadoService().findAll());
        setListaEstadoInegiPersonaConsentimiento(getInegiEstadoService().findAll());
        setListaEstadoInegiAbueloUnoProgenitor(getInegiEstadoService().findAll());
        setListaEstadoInegiAbueloDosProgenitor(getInegiEstadoService().findAll());

        setListaLocalidadReconocido(getLocalidadService().findAll());
        setListaLocalidadReconocedor(getLocalidadService().findAll());
        setListaLocalidadTestigoUno(getLocalidadService().findAll());
        setListaLocalidadTestigoDos(getLocalidadService().findAll());
        setListaLocalidadPersonaConsentimiento(getLocalidadService().findAll());
        setListaLocalidadAbueloUnoProgenitor(getLocalidadService().findAll());
        setListaLocalidadAbueloDosProgenitor(getLocalidadService().findAll());

        setListaLocalidadColoniaInegiReconocedor(getLocalidadService().findAll());
        setListaLocalidadColoniaInegiTestigoUno(getLocalidadService().findAll());
        setListaLocalidadColoniaInegiTestigoDos(getLocalidadService().findAll());
        setListaLocalidadColoniaInegiPersonaConsentimiento(getLocalidadService().findAll());
        setListaLocalidadColoniaInegiAbueloUnoProgenitor(getLocalidadService().findAll());
        setListaLocalidadColoniaInegiAbueloDosProgenitor(getLocalidadService().findAll());

        setListaMunicipioReconocido(getMunicipioService().findAll());
        setListaMunicipioReconocedor(getMunicipioService().findAll());
        setListaMunicipioTestigoUno(getMunicipioService().findAll());
        setListaMunicipioTestigoDos(getMunicipioService().findAll());
        setListaMunicipioPersonaConsentimiento(getMunicipioService().findAll());
        setListaMunicipioAbueloUnoProgenitor(getMunicipioService().findAll());
        setListaMunicipioAbueloDosProgenitor(getMunicipioService().findAll());

        setListaMunicipioInegiReconocido(getInegiMunicipioService().findAll());
        setListaMunicipioInegiReconocedor(getInegiMunicipioService().findAll());
        setListaMunicipioInegiTestigoUno(getInegiMunicipioService().findAll());
        setListaMunicipioInegiTestigoDos(getInegiMunicipioService().findAll());
        setListaMunicipioInegiPersonaConsentimiento(getInegiMunicipioService().findAll());
        setListaMunicipioInegiAbueloUnoProgenitor(getInegiMunicipioService().findAll());
        setListaMunicipioInegiAbueloDosProgenitor(getInegiMunicipioService().findAll());

        setListaPaisReconocido(getPaisService().findAll());
        setListaPaisReconocedor(getPaisService().findAll());
        setListaPaisTestigoUno(getPaisService().findAll());
        setListaPaisTestigoDos(getPaisService().findAll());
        setListaPaisPersonaConsentimiento(getPaisService().findAll());
        setListaPaisAbueloUnoProgenitor(getPaisService().findAll());
        setListaPaisAbueloDosReconocedor(getPaisService().findAll());

        setListaPaisInegiReconocido(getInegiPaisService().findAll());
        setListaPaisInegiReconocedor(getInegiPaisService().findAll());
        setListaPaisInegiTestigoUno(getInegiPaisService().findAll());
        setListaPaisInegiTestigoDos(getInegiPaisService().findAll());
        setListaPaisInegiPersonaConsentimiento(getInegiPaisService().findAll());
        setListaPaisInegiAbueloUnoProgenitor(getInegiPaisService().findAll());
        setListaPaisInegiAbueloDosProgenitor(getInegiPaisService().findAll());

        setListaParentescoReconocedor(getParentescoService().findAll());
        setListaParentescoTestigoUno(getParentescoService().findAll());
        setListaParentescoTestigoDos(getParentescoService().findAll());
        setListaParentescoPersonaConsentimiento(getParentescoService().findAll());
        setListaParentescoAbueloUnoProgenitor(getParentescoService().findAll());
        setListaParentescoAbueloDosProgenitor(getParentescoService().findAll());

        setListaTipoLocalidadReconocido(getTipoLocalidadService().findAll());
        setListaTipoLocalidadReconocedor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadTestigoUno(getTipoLocalidadService().findAll());
        setListaTipoLocalidadTestigoDos(getTipoLocalidadService().findAll());
        setListaTipoLocalidadPersonaConsentimiento(getTipoLocalidadService().findAll());
        setListaTipoLocalidadAbueloUnoProgenitor(getTipoLocalidadService().findAll());
        setListaTipoLocalidadAbueloDosProgenitor(getTipoLocalidadService().findAll());



    }

    public void registrarReconocimiento() {
        if (getReconocimientoService().registrarReconocimiento(getReconocimiento(),getPersonaOtorgaConsentimiento())) {

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

            //ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            //externalContext.redirect(externalContext.getRequestContextPath()
            //        .concat(ConstantesComunes.DETALLE_MATRIMONIO));

        }
    }



}