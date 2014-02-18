package mx.gob.renapo.registrocivil.showcase.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

import lombok.Data;

@ManagedBean(name = "showCaseBean")
@Data
public class MuestraShowCase {
	
	private String cajaTexto;
	private String cajaTextoEnriquecida;
	private Date fecha;
	private String nombre;
	private List<String> listaValores;
	private TreeNode mapaValoresPadre;
	private TreeNode mapaValoresHijo;
	private TreeNode mapaValoresHijoSegundo;
	private UploadedFile archivo;
	
	public String prueba() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se envio la prueba"));  
		
		listaValores = new ArrayList<String>();
		listaValores.add("Uno");
		listaValores.add("Dos");
		listaValores.add("Tres");
		
		mapaValoresPadre = new DefaultTreeNode("raiz", null);
		
		mapaValoresHijo = new DefaultTreeNode("Valor Uno", mapaValoresPadre);
		mapaValoresHijo = new DefaultTreeNode("Valor Dos", mapaValoresPadre);
		mapaValoresHijo = new DefaultTreeNode("Valor Tres", mapaValoresPadre);
		mapaValoresHijo = new DefaultTreeNode("Valor Cuatro", mapaValoresPadre);
		mapaValoresHijo = new DefaultTreeNode("Valor Cinco", mapaValoresPadre);
		mapaValoresHijoSegundo = new DefaultTreeNode("Valor Seis", mapaValoresHijo);
		mapaValoresHijoSegundo = new DefaultTreeNode("Valor Siete", mapaValoresHijo);
		mapaValoresHijoSegundo = new DefaultTreeNode("Valor Ocho", mapaValoresHijo);
		mapaValoresHijoSegundo = new DefaultTreeNode("Valor Nueve", mapaValoresHijo);
		mapaValoresHijoSegundo = new DefaultTreeNode("Valor Diez", mapaValoresHijo);
		mapaValoresHijoSegundo = new DefaultTreeNode("Valor Once", mapaValoresHijo);
		
		return "index";
	}
	
	private void reset() {
        // TODO Auto-generated method stub

    }
	
public void validarFecha(FacesContext facesContex, UIComponent uiComponent, Object obj){
        
        if(!(obj instanceof Date)){
            FacesMessage msg = 
                    new FacesMessage("E-mail validation failed.", 
                            "Invalid E-mail format.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
        }
    }

}
