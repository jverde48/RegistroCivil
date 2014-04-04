package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@ViewScoped
@ManagedBean(name = "matrimonioNormalBean")
public class MatrimonioNormalBean extends MatrimonioBean implements Serializable {

    private static Logger log = Logger.getLogger(MatrimonioBean.class);

    @PostConstruct
    public void cargarInformacion() {
        setListaPaises(getPaisService().findAll());

        setListaPaisesInegi(getInegiPaisService().findAll());
        setListaEstadoCivil(getEstadoCivilService().findAll());
        setListaSituacionLaboral(getSituacionLaboralService().findAll());

        setListaParentesco(getParentescoService().findAll());
        setListaEscolaridad(getEscolaridadService().findAll());
        setListaPuestos(getPuestoService().findAll());
        setListaRegimen(getRegimenService().findAll());
        setListaTipoLocalidad(getTipoLocalidadService().findAll());

        asignarValorPais();
        asignarValorPaisInegi();
        asignarValorEstadoCivil();
        asignarValorSituacionLaboral();
        asignarValorParentesco();
        asignarValorEscolaridad();
        asignarValorPuesto();
        asignarValoresTipoLocalidad();
    }

    public void registrarMatrinonio() throws IOException {
        if (getMatrimonioService().registrarMatrimonio(getMatrimonio())) {
            System.out.println("Entro aqui men");

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_MATRIMONIO));
        }
    }

    private void asignarValorPais() {
        setListaPaisesContrayenteUno(getListaPaises());
        setListaPaisesContrayenteDos(getListaPaises());
        setListaPaisesContrayenteConsentimientoUno(getListaPaises());
        setListaPaisesContrayenteConsentimientoDos(getListaPaises());
        setListaPaisesProgenitorUnoContrayenteUno(getListaPaises());
        setListaPaisesProgenitorDosContrayenteUno(getListaPaises());
        setListaPaisesProgenitorUnoContrayenteDos(getListaPaises());
        setListaPaisesProgenitorDosContrayenteDos(getListaPaises());
        setListaPaisesTestigoUno(getListaPaises());
        setListaPaisesTestigoDos(getListaPaises());
        setListaPaisesTestigoTres(getListaPaises());
        setListaPaisesTestigoCuatro(getListaPaises());
    }

    private void asignarValorPaisInegi() {
        setListaPaisesInegiContrayenteUno(getListaPaisesInegi());
        setListaPaisesInegiContrayenteDos(getListaPaisesInegi());
        setListaPaisesInegiConsentimientoUno(getListaPaisesInegi());
        setListaPaisesInegiConsenimientoDos(getListaPaisesInegi());
        setListaPaisesInegiProgenitorUnoContrayenteUno(getListaPaisesInegi());
        setListaPaisesInegiProgenitorDosContrayenteUno(getListaPaisesInegi());
        setListaPaisesInegiProgenitorUnoContrayenteDos(getListaPaisesInegi());
        setListaPaisesInegiProgenitorDosContrayenteDos(getListaPaisesInegi());
        setListaPaisesInegiTestigoUno(getListaPaisesInegi());
        setListaPaisesInegiTestigoDos(getListaPaisesInegi());
        setListaPaisesInegiTestigoTres(getListaPaisesInegi());
        setListaPaisesInegiTestigoCuatro(getListaPaisesInegi());
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
        setListaSituacionLaboralConsentimientoUno(getListaSituacionLaboral());
        setListaSituacionLaboralConsentimientoDos(getListaSituacionLaboral());
        setListaSituacionLaboralProgenitorUnoContrayenteUno(getListaSituacionLaboral());
        setListaSituacionLaboralProgenitorDosContrayenteUno(getListaSituacionLaboral());
        setListaSituacionLaboralProgenitorUnoContrayenteDos(getListaSituacionLaboral());
        setListaSituacionLaboralProgenitorDosContrayenteDos(getListaSituacionLaboral());
        setListaSituacionLaboralTestigoUno(getListaSituacionLaboral());
        setListaSituacionLaboralTestigDos(getListaSituacionLaboral());
        setListaSituacionLaboralTestigoTres(getListaSituacionLaboral());
        setListaSituacionLaboralTestigoCuatro(getListaSituacionLaboral());
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

    @PreDestroy
    private void limpiarDTOMatrimonio() {
        log.info("LIMPIANDO INSTANCIA DE MATRIMONIO.....");
        setMatrimonio(null);
    }
}
