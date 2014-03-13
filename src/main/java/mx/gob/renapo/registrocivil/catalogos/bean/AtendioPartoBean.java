package mx.gob.renapo.registrocivil.catalogos.bean;

import javax.faces.bean.ManagedBean;// manda respuesta a la vista como un bean
import javax.faces.bean.ViewScoped;

import mx.gob.renapo.registrocivil.catalogos.service.impl.CatAtendioPartoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.service.CatAtendioPartoService;
import org.springframework.stereotype.Component;

@Data
@Component
@ViewScoped //le estoy diciendo que el bean tiene cierta duracion
@ManagedBean(name="atendioPartoBean")//le estas diciendo a javaserverfaces que lo va a manejar como un bean
@EqualsAndHashCode(callSuper=false)
public class AtendioPartoBean extends CatalogoBean {

	@Autowired
	private CatAtendioPartoServiceImpl catAtendioPartoService;
	
	@Override
	public void crear() {
		catAtendioPartoService.crearAtendioParto(getDescripcion());
		// TODO Auto-generated method stub
		System.out.println(getDescripcion());
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}
}
