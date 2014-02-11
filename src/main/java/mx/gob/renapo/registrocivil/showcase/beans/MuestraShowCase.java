package mx.gob.renapo.registrocivil.showcase.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "showCaseBean")
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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se envío la prueba"));  
		
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
	
	public void reset() {
		fecha = null;
		cajaTexto = "";
		listaValores = new ArrayList<String>();
		mapaValoresHijo = new DefaultTreeNode();
		mapaValoresPadre = new DefaultTreeNode();
		mapaValoresHijoSegundo = new DefaultTreeNode();
	}

	public String getCajaTexto() {
		return cajaTexto;
	}

	public void setCajaTexto(String cajaTexto) {
		this.cajaTexto = cajaTexto;
	}

	public String getCajaTextoEnriquecida() {
		return cajaTextoEnriquecida;
	}

	public void setCajaTextoEnriquecida(String cajaTextoEnriquecida) {
		this.cajaTextoEnriquecida = cajaTextoEnriquecida;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getListaValores() {
		return listaValores;
	}

	public void setListaValores(List<String> listaValores) {
		this.listaValores = listaValores;
	}

	public TreeNode getMapaValoresPadre() {
		return mapaValoresPadre;
	}

	public void setMapaValoresPadre(TreeNode mapaValoresPadre) {
		this.mapaValoresPadre = mapaValoresPadre;
	}

	public TreeNode getMapaValoresHijo() {
		return mapaValoresHijo;
	}

	public void setMapaValoresHijo(TreeNode mapaValoresHijo) {
		this.mapaValoresHijo = mapaValoresHijo;
	}

	public TreeNode getMapaValoresHijoSegundo() {
		return mapaValoresHijoSegundo;
	}

	public void setMapaValoresHijoSegundo(TreeNode mapaValoresHijoSegundo) {
		this.mapaValoresHijoSegundo = mapaValoresHijoSegundo;
	}

	public UploadedFile getArchivo() {
		return archivo;
	}

	public void setArchivo(UploadedFile archivo) {
		this.archivo = archivo;
	}

}
