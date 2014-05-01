package mx.gob.renapo.registrocivil.actos.divorcio.bean;

import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
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
    private boolean deshabilitado;
    
    private boolean habilitarTestigo;
    
    private String rutaTestigoUno;
    private String rutaTestigoDos;
    
    private String cadena;
    private String numActa;
    private Integer anio;

    @Autowired
    MatrimonioDTO matrimonioDTO;
    
    
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
        setDeshabilitado(true);
        setHabilitarTestigo(false);
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
                     FacesMessage.SEVERITY_ERROR,getDivorcioDetalle().getTituloMensaje(), ""));
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
    		habilitarTestigo = false;
    		rutaTestigoUno = ConstantesComunes.DIVORCIO_TESTIGO_UNO;
    		rutaTestigoDos = ConstantesComunes.DIVORCIO_TESTIGO_DOS;
    	}else if(tipoDivorcio.equals(ConstantesComunes.TIPO_DIVORCIO_JUDICIAL)){
    		deshabilitado = false;
    		habilitarTestigo = true;
    		rutaTestigoUno = "";
    		rutaTestigoDos = "";
    	}
    }
    
    /**
     * Metodo para buscar un matrimonio por cadena
     */
    
    public void buscarMatrimonioPorCadena() throws IOException{

        setMatrimonioDTO(getDivorcioService().recuperarMatrimonioPorCadena(getCadena()));
        setContrayentesDivorciados();

    }

    /**
     * Metodo para buscar un matrimonio por numero de acta y anio de registro
     */
    public void buscarMatrimonioPorNumeroActa() throws IOException{

        setMatrimonioDTO(getDivorcioService().recuperarMatrimonioPorNumeroActa(getAnio(),getNumActa()));
        setContrayentesDivorciados();

    }

    public void setContrayentesDivorciados() throws IOException{

        if(getMatrimonioDTO().getCodigoRespuesta() == 0){
            getDivorcioDTO().setActaMatrimonio(getMatrimonioDTO());
            getDivorcioDTO().setDivorciadoUno(getDivorcioDTO().getActaMatrimonio().getContrayenteUno());
            getDivorcioDTO().setDivorciadoDos(getDivorcioDTO().getActaMatrimonio().getContrayenteDos());

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.REGISTRO_NORMAL_DIVORCIO));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Registro de Matrimonio no encontrado o tal vez ya fue dado de baja", ""));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
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
