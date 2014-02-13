package mx.gob.renapo.registrocivil.actos.nacimiento.beans;

import lombok.Data;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "registroMatrimonioBean")
@Data
public class RegistroMatrimonioBean {
	
	private String actaBis;
	private String anioRegistro;
	private String tomo;
	private String libro;

}
