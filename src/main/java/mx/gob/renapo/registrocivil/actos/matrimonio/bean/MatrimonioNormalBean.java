package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
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

    private static Logger log = Logger.getLogger(MatrimonioNormalBean.class);

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

        asignarValorEstadoCivil();
        asignarValorSituacionLaboral();
        asignarValorParentesco();
        asignarValorEscolaridad();
        asignarValorPuesto();
        asignarValoresTipoLocalidad();
    }

    public void registrarMatrinonio() throws IOException {
        getMatrimonio().setNormal(true);
        getMatrimonio().setHistorico(false);
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

    public void setPersona(PersonaDTO persona, String tipoPersona) {
        log.info("LA PERSONA: " + persona);
        log.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("CUNO"))
            getMatrimonio().setContrayenteUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("CDOS"))
            getMatrimonio().setContrayenteDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("CSUNO"))
            getMatrimonio().setConsentimientoContrayenteUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("CSDOS"))
            getMatrimonio().setConsentimientoContrayenteDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PUNO"))
            getMatrimonio().setProgenitorUnoContrayenteUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("MUNO"))
            getMatrimonio().setProgenitorDosContrayenteUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PDOS"))
            getMatrimonio().setProgenitorUnoContrayenteDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("MDOS"))
            getMatrimonio().setProgenitorDosContrayenteDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TUNO"))
            getMatrimonio().setTestigoUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TDOS"))
            getMatrimonio().setTestigoDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TTRES"))
            getMatrimonio().setTestigoTres(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TCUATRO"))
            getMatrimonio().setTestigoCuatro(persona);
    }

    public void restorePersona(String tipoPersona) {
        log.info(":::RESTAURANDO VALORES::::");
        if (!"".equals(tipoPersona) && tipoPersona.equals("CUNO"))
            getMatrimonio().setContrayenteUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("CDOS"))
            getMatrimonio().setContrayenteDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("CSUNO"))
            getMatrimonio().setConsentimientoContrayenteUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("CSDOS"))
            getMatrimonio().setConsentimientoContrayenteDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PUNO"))
            getMatrimonio().setProgenitorUnoContrayenteUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("MUNO"))
            getMatrimonio().setProgenitorDosContrayenteUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("PDOS"))
            getMatrimonio().setProgenitorUnoContrayenteDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("MDOS"))
            getMatrimonio().setProgenitorDosContrayenteDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TUNO"))
            getMatrimonio().setTestigoUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TDOS"))
            getMatrimonio().setTestigoDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TTRES"))
            getMatrimonio().setTestigoTres(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TCUATRO"))
            getMatrimonio().setTestigoCuatro(new PersonaDTO());
    }
}
