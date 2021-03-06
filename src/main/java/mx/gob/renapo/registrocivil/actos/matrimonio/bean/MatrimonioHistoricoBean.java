package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Data
@Component
@ViewScoped
@ManagedBean(name = "matrimonioHistoricoBean")
public class MatrimonioHistoricoBean extends MatrimonioBean {
    private static Logger log = Logger.getLogger(MatrimonioHistoricoBean.class);

    @PostConstruct
    public void cargarInformacion() {
        setListaPaises(getPaisService().findAll());
        setListaPaisesInegi(getInegiPaisService().findAll());
        setListaEstadoCivil(getEstadoCivilService().findAll());
        setListaSituacionLaboral(getSituacionLaboralService().findAll());
        setListaEstadosEstadisticos(getEstadoService().
                recuperarPorPais(getPaisService().findMexico()));
        setListaParentesco(getParentescoService().findAll());
        setListaEscolaridad(getEscolaridadService().findAll());
        setListaPuestos(getPuestoService().findAll());
        setListaRegimen(getRegimenService().findAll());
        setListaTipoLocalidad(getTipoLocalidadService().findAll());

        asignarValorEstadoCivil();
        asignarValorSituacionLaboral();
        asignarValorParentesco();
        asignarValorEscolaridad();
        asignarValorPuesto();
        asignarValoresTipoLocalidad();
    }

    public void registrarMatrinonio() throws IOException {
        getMatrimonio().setNormal(false);
        getMatrimonio().setHistorico(true);
        getMatrimonio().setEspecial(false);

        setMatrimonioDetalle(getMatrimonioService().registrarMatrimonio(getMatrimonio(),
                getConsentimientoContrayenteUno(), getConsentimientoContrayenteDos()));
        if (getMatrimonioDetalle().getCodigoRespuesta().equals(0)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_MATRIMONIO));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Ocurri\u00f3 un error al guardar el registro.", ""));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
    }

    private void asignarValorEstadoCivil() {
        setListaEstadoCivilContrayenteUno(getListaEstadoCivil());
        setListaEstadoCivilContrayenteDos(getListaEstadoCivil());
        setListaEstadoCivilConsentimientoUno(getListaEstadoCivil());
        setListaEstadoCivilConsentimientoDos(getListaEstadoCivil());
        setListaEstadoCivilProgenitorUnoContrayenteUno(getListaEstadoCivil());
        setListaEstadoCivilProgenitorDosContrayenteUno(getListaEstadoCivil());
        setListaEstadoCivilProgenitorUnoContrayenteDos(getListaEstadoCivil());
        setListaEstadoCivilProgenitorDosContrayenteDos(getListaEstadoCivil());
        setListaEstadoCivilTestigoUno(getListaEstadoCivil());
        setListaEstadoCivilTestigoDos(getListaEstadoCivil());
        setListaEstadoCivilTestigoTres(getListaEstadoCivil());
        setListaEstadoCivilTestigoCuatro(getListaEstadoCivil());
    }

    private void asignarValorSituacionLaboral() {
        setListaSituacionLaboralContrayenteUno(getListaSituacionLaboral());
        setListaSituacionLaboralContrayenteDos(getListaSituacionLaboral());
    }

    private void asignarValoresTipoLocalidad() {
        setListaTipoLocalidadContrayenteUno(getListaTipoLocalidad());
        setListaTipoLocalidadContrayenteDos(getListaTipoLocalidad());
        setListaTipoLocalidadConsentimientoUno(getListaTipoLocalidad());
        setListaTipoLocalidadConsentimientoDos(getListaTipoLocalidad());
        setListaTipoLocalidadProgenitorUnoContrayenteUno(getListaTipoLocalidad());
        setListaTipoLocalidadProgenitorDosContrayenteUno(getListaTipoLocalidad());
        setListaTipoLocalidadProgenitorUnoContrayenteDos(getListaTipoLocalidad());
        setListaTipoLocalidadProgenitorDosContrayenteDos(getListaTipoLocalidad());
        setListaTipoLocalidadTestigoUno(getListaTipoLocalidad());
        setListaTipoLocalidadTestigoDos(getListaTipoLocalidad());
        setListaTipoLocalidadTestigoTres(getListaTipoLocalidad());
        setListaTipoLocalidadTestigoCuatro(getListaTipoLocalidad());
    }

    private void asignarValorParentesco() {
        setListaParentescoTestigoUno(getListaParentesco());
        setListaParentescoTestigoDos(getListaParentesco());
        setListaParentescoTestigoTres(getListaParentesco());
        setListaParentescoTestigoCuatro(getListaParentesco());
    }

    private void asignarValorEscolaridad() {
        setListaEscolaridadContrayenteUno(getListaEscolaridad());
        setListaEscolaridadContrayenteDos(getListaEscolaridad());
    }

    private void asignarValorPuesto() {
        setListaPuestoContrayenteUno(getListaPuestos());
        setListaPuestoContrayenteDos(getListaPuestos());
    }
}
