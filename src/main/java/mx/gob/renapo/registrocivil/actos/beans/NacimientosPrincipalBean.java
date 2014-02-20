package mx.gob.renapo.registrocivil.actos.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name = "nacimientosPrincipalBean")
@Data
@ViewScoped
public class NacimientosPrincipalBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String templateTipoRegistroNacimiento;
	
	@PostConstruct
	public void init() {
		templateTipoRegistroNacimiento = "";
	}
	
	public void cambiarTemplateTipoRegistroNacimiento(Integer tipoRegistro) {
		if(tipoRegistro==1) {
			templateTipoRegistroNacimiento = ConstantesComunes.TEMPLATE_NACIMIENTOS_NORMAL;
		}
		else if(tipoRegistro==2) {
			templateTipoRegistroNacimiento = ConstantesComunes.TEMPLATE_NACIMIENTOS_HISTORICO;
		}
		else if(tipoRegistro==3) {
			templateTipoRegistroNacimiento = ConstantesComunes.TEMPLATE_NACIMIENTOS_ESPECIAL;
		}
	}

}
