package mx.gob.renapo.registrocivil.actos.divorcio.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;

@ManagedBean(name="divorcioHistoricoBean")
@ViewScoped
@Data
@Component
public class DivorcioHistoricoBean extends DivorcioBean implements Serializable {

	private static Logger logger = Logger.getLogger(DivorcioNormalBean.class);
	
	
	@Autowired
	private DivorcioBean divorcioBean;
	
	@PostConstruct
    public void init() {
   
        setPaises(getPaisService().findAll());
        setPaisesInegi(getInegiPaisService().findAll());
        setEscolaridadList(getEscolaridadService().findAll());
        setSituacionLaboralList(getSituacionLaboralService().findAll());
        setPosicionTrabajoList(getPuestoService().findAll());
        setParentescoList(getParentescoService().findAll());
        setEstadoCivilList(getEstadoCivilService().findAll());
        setTipoDivorcioList(getTipoDivorcioService().findAll());
        setEstadosActa(getEstadoService().recuperarPorPais(getPaisService().findMexico()));
    }
	
	 /**
     * Metodo para guardar un nuevo registro de divorcio
     */
    public void guardaRegistroDivorcio() throws IOException {
    	getDivorcioDTO().setNormal(false);
   	 	getDivorcioDTO().setHistorico(true);
   	 	getDivorcioDTO().setEspecial(false); 
   	 	
   	 	divorcioBean.setDivorcioDetalle(getDivorcioDetalle());
    	
         setDivorcioDetalle(getDivorcioService().guardarDivorcio(getDivorcioDTO()));

         if(getDivorcioDetalle().getCodigoRespuesta() == 0){
        	 FacesContext context = FacesContext.getCurrentInstance();
             context.getExternalContext().getFlash().setKeepMessages(true);

             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                     FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

             ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
             externalContext.redirect(externalContext.getRequestContextPath()
                     .concat(ConstantesComunes.DETALLE_DIVORCIO));
         }else {
        	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,"Ocurri\u00f3 un error al guardar el registro.", ""));
             RequestContext.getCurrentInstance().execute("errorDialog.show()");
         }
    }
    
    
    public void consultaMunicipiosMatrimonio(){
    	setMunicipiosMatrimonio(getMunicipioService().recuperarMunicipiosPorEstado(getDivorcioDTO().getActaMatrimonio().getActaMatrimonioDTO().getEntidadRegistro()));
    }
    
    public void consultaMunicipiosDivorcio(){
    	setMunicipiosDivorcio(getMunicipioService().recuperarMunicipiosPorEstado(getDivorcioDTO().getActaDivorcio().getEntidadRegistro()));
    }
    
    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("DIVORCIADO_UNO"))
            getDivorcioDTO().setDivorciadoUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("DIVORCIADO_DOS"))
            getDivorcioDTO().setDivorciadoDos(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_UNO"))
            getDivorcioDTO().setTestigoUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_DOS"))
            getDivorcioDTO().setTestigoDos(persona);
    }
    
    public void restorePersona(String tipoPersona) {
        logger.info(":::RESTAURANDO VALORES::::");
        
        if (!"".equals(tipoPersona) && tipoPersona.equals("DIVORCIADO_UNO"))
            getDivorcioDTO().setDivorciadoUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("DIVORCIADO_DOS"))
            getDivorcioDTO().setDivorciadoDos(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_UNO"))
            getDivorcioDTO().setTestigoUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_DOS"))
            getDivorcioDTO().setTestigoDos(new PersonaDTO());
    }
}
