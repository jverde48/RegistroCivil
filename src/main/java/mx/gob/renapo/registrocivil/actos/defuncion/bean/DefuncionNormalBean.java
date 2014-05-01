package mx.gob.renapo.registrocivil.actos.defuncion.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 02:01 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.dto.ActaDefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.service.DefuncionService;
import mx.gob.renapo.registrocivil.actos.defuncion.service.impl.DefuncionServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatSituacionLaboralServiceImpl;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import org.springframework.stereotype.Component;


@ManagedBean(name="defuncionNormalBean")
@ViewScoped
@Data
@Component
public class DefuncionNormalBean extends DefuncionesPrincipalBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(DefuncionNormalBean.class);

    private String idComponen;
    @PostConstruct
    public void init() {
        setListaPaisesFinado(getPaisService().findAll());
        setListaPaisesInegiFinado(getInegiPaisService().findAll());
        setListaPaisesDeclarante(getPaisService().findAll());
        setListaPaisesInegiDeclarante(getInegiPaisService().findAll());
        setListaPaisesInegiLugarFallecimiento(getInegiPaisService().findAll());
        setListaPaisesInegiTestigoUno(getInegiPaisService().findAll());
        setListaPaisesTestigoUno(getPaisService().findAll());
        setListaPaisesInegiTestigoDos(getInegiPaisService().findAll());
        setListaPaisesTestigoDos(getPaisService().findAll());
        setListaPaisesConyuge(getPaisService().findAll());
        setListaPaisesProgenitorUno(getPaisService().findAll());
        setListaPaisesProgenitorDos(getPaisService().findAll());
        setListaParentesco(getParentescoService().findAll());
        setListaEscolaridad(getEscolaridadService().findAll());
        setListaSituacionLaboral(getSituacionLaboralService().findAll());
        setListaEstadoCivil(getEstadoCivilService().findAll());
        setListaPuesto(getPuestoService().findAll());
        setListaLugarFallece(getLugarFalleceService().findAll());
        setListaDestinoCadaver(getDestinoCadaverService().findAll());
        idComponen="fieldConyugeFinado";

    }


    /**
     * Metodo para guardar un nuevo registro de Defuncion
     */

    public void guardaRegistroNormalDefuncion() throws IOException {
        getDefuncionDTO().setNormal(true);
        getDefuncionDTO().setHistorico(false);
        getDefuncionDTO().setEspecial(false);

        System.out.println("Entro +++++++++++++++++++++++++++++++++++++");
        setDefuncionDetalle(getDefuncionService().guardarDefuncion(getDefuncionDTO(),getExistenciaConyuge(),
                                                              getExistenciaProgenitorUno(), getExistenciaProgenitorDos()));
        if (getDefuncionDetalle().getCodigoRespuesta().equals(0)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_DEFUNCION));
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Ocurri\u00f3 un error al guardar el registro.", ""));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");

        }
    }



    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("FINA"))
            getDefuncion().setFinado(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FCONYU"))
            getDefuncion().setConyuge(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FPUNO"))
            getDefuncion().setProgenitorUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FPDOS"))
            getDefuncion().setProgenitorDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("DCATE"))
            getDefuncion().setDeclarante(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FTUNO"))
            getDefuncion().setTestigoUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FTDOS"))
            getDefuncion().setTestigoDos(persona);

    }

    public void restorePersona(String tipoPersona) {
        logger.info(":::RESTAURANDO VALORES::::");

        if (!"".equals(tipoPersona) && tipoPersona.equals("FINA"))
            getDefuncion().setFinado(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FCONYU"))
            getDefuncion().setConyuge(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FPUNO"))
            getDefuncion().setProgenitorUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FPDOS"))
            getDefuncion().setProgenitorDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FDCATE"))
            getDefuncion().setDeclarante(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FTUNO"))
            getDefuncion().setTestigoUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("FTDOS"))
            getDefuncion().setTestigoDos(new PersonaDTO());

    }


}
