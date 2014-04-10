package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase padre para el acto de nacimiento
 * @author Alejandro Diaz
 *
 */
@Data
public abstract class NacimientosPrincipalBean implements Serializable {

	private static final long serialVersionUID = 1L;

    @Autowired
    private NacimientoDTO nacimientoDTO;

	private String templatePadres = "";
	private Integer padres;

	private Boolean existenciaAbueloUnoProgenitorUno;
	private Boolean existenciaAbueloDosProgenitorUno;
	private Boolean existenciaAbueloUnoProgenitorDos;
	private Boolean existenciaAbueloDosProgenitorDos;

	private Integer comparece;
	private String templateComparece;
	private String templateEstadisticosPadre;
	

	/**
	 * Metodo para cambiar el template necesario para el formulario de los
	 * padres
	 */
	public void cambiaTemplateProgenitores() {
		if (padres == 1) {
			templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO;
		} else if (padres == 2) {
			templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES;
		}
	}

	/**
	 * Metodo para cargar template de comparece
	 */
	public void cambiaTemplateComparece() {
		if (comparece == ConstantesComunes.COMPARCENCIA_OTRO) {
			templateComparece = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COMPARECE;
		}
	}


     public void validaComparecencia(FacesContext context, UIComponent toValidate,
            Object arg) {
        if(nacimientoDTO.getCompareceDTO()!=null){
            if(padres == 1 && nacimientoDTO.getCompareceDTO().getId().intValue() == 2 ||
                    nacimientoDTO.getCompareceDTO().getId().intValue() == 4 ) {
                FacesMessage msg = new FacesMessage("Dato validation failed.",
                        "La comparecencia no es valida debido a que la madre es soltera");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
	}
}
