package mx.gob.renapo.registrocivil.actos.divorcio.bean;

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

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDivorcioDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDivorcio;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;


@ManagedBean(name="divorcioNormalBean")
@ViewScoped
@Data
@Component
public class DivorcioNormalBean extends DivorcioBean implements Serializable{

	
    private static Logger logger = Logger.getLogger(DivorcioNormalBean.class);
    
   
    /**
     * Variable para habilitar o deshabilitar los campos de 
     * Fecha ejecutoria y Autoridad dependiendo el tipo de Divorcio
     */
    private boolean deshabilitado = false;
    
    private String rutaTestigoUno;
    private String rutaTestigoDos;
    
    private String cadena;
    
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
        
        setCadena("12345678900987654321");
    }
    
    /**
     * Metodo para guardar un nuevo registro de divorcio
     */
    public void guardaRegistroDivorcio() throws IOException {
    	 getDivorcioDTO().setNormal(true);
    	 getDivorcioDTO().setHistorico(false);
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
   
    /**
     * Metodo para habilitar o deshabilitar los campos de 
     * Fecha ejecutoria y Autoridad dependiendo el tipo de Divorcio
     */
    public void habilitarCampos(){
    	
    	String tipoDivorcio = getDivorcioDTO().getActaDivorcio().getTipoDivorcio().getDescripcion();
    
    	if(tipoDivorcio.equals(ConstantesComunes.TIPO_DIVORCIO_ADMINISTRATIVO) || 
    			tipoDivorcio.equals(ConstantesComunes.TIPO_DIVORCIO_INDETERMINADO)){
    		deshabilitado = true;
    		rutaTestigoUno = ConstantesComunes.DIVORCIO_TESTIGO_UNO;
    		rutaTestigoDos = ConstantesComunes.DIVORCIO_TESTIGO_DOS;
    	}else if(tipoDivorcio.equals(ConstantesComunes.TIPO_DIVORCIO_JUDICIAL)){
    		deshabilitado = false;
    		rutaTestigoUno = "";
    		rutaTestigoDos = "";
    	}
    }
    
    /**
     * Metodo para buscar un matrimonio por cadena
     */
    
    public void buscarMatrimonioPorCadena(String cadenaS) throws IOException{
    	logger.debug("CADENA " + getCadena());
    	
    	//getDivorcioDTO().getActaMatrimonio().getActaMatrimonioDTO().setCadena("12345678900987654321");
    	
    	getDivorcioDTO().setActaMatrimonio(getDivorcioService().recuperarMatrimonioPorCadena(cadenaS));
		getDivorcioDTO().setDivorciadoUno(getDivorcioDTO().getActaMatrimonio().getContrayenteUno());
		getDivorcioDTO().setDivorciadoDos(getDivorcioDTO().getActaMatrimonio().getContrayenteDos());
    }
   
    public void setPersona(PersonaDTO persona, String tipoPersona) {
        logger.info("LA PERSONA: " + persona);
        logger.info("TIPO PERSONA: " + tipoPersona);

        if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_UNO"))
            getDivorcioDTO().setTestigoUno(persona);
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_DOS"))
            getDivorcioDTO().setTestigoDos(persona);
    }
    
    public void restorePersona(String tipoPersona) {
        logger.info(":::RESTAURANDO VALORES::::");
        
        if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_UNO"))
            getDivorcioDTO().setTestigoUno(new PersonaDTO());
        else if (!"".equals(tipoPersona) && tipoPersona.equals("TESTIGO_DOS"))
            getDivorcioDTO().setTestigoDos(new PersonaDTO());
    }
}
