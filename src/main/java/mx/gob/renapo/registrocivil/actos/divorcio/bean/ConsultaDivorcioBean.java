package mx.gob.renapo.registrocivil.actos.divorcio.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.service.impl.DivorcioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEscolaridadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatSituacionLaboralDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDivorcioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatColoniaLocalidadServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatEscolaridadServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatEstadoCivilServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatEstadoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatInegiEstadoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatInegiMunicipioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatInegiPaisServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatMunicipioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatPaisServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatParentescoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatPuestoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatSituacionLaboralServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatTipoDivorcioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatTipoLocalidadServiceImpl;
import mx.gob.renapo.registrocivil.comun.bean.BusquedaBean;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@ManagedBean(name="consultaDivorcioBean")
@ViewScoped
@Component
public class ConsultaDivorcioBean extends BusquedaBean implements Serializable{
	
	private static Logger log = Logger.getLogger(ConsultaDivorcioBean.class);

	String seleccionBusqueda = "";
	
	
	public void realizarBusquedaDivorcio(){
		log.info("Tipo Busqueda :::::: " + getTipoBusqueda());

      
        
        restablecerValoresBusqueda();
	}
	
	 public void renderBusqueda() {
	         if (getSeleccionBusqueda().equals("CD")) {
	            setCurp(false);
	            setVacio(false);
	            setCadena(true);
	            setNumeroActa(false);
	            setDatosPersonales(false);
	        } else if (getSeleccionBusqueda().equals("NA")){
	            setCurp(false);
	            setVacio(false);
	            setCadena(false);
	            setNumeroActa(true);
	            setDatosPersonales(false);
	        } else {
	            setCurp(false);
	            setVacio(true);
	            setCadena(false);
	            setNumeroActa(false);
	            setDatosPersonales(false);
	        }
	    }
	 
	 private void restablecerValoresBusqueda() {
	        setCurp(false);
	        setVacio(true);
	        setCadena(false);
	        setNumeroActa(false);
	        setDatosPersonales(false);
	        setSeleccionBusqueda("SL");
	    }
}
