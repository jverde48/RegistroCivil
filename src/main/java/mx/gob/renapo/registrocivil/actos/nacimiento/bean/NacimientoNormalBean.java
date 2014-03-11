package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "registroNormalNacimientoBean")
@ViewScoped
public class NacimientoNormalBean extends NacimientosPrincipalBean implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * Propiedad DTO de nacimiento
     */
    private NacimientoDTO nacimientoDTO;

    /**
     * Propiedad de NacimientoService
     */
    @Autowired
    private NacimientoServiceImpl nacimientoService;

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
        nacimientoDTO.setRegistrado(getRegistrado());
        nacimientoDTO.setProgenitorUno(getProgenitorUno());
        nacimientoDTO.setProgenitorUno(getProgenitorDos());
        nacimientoDTO.setAbueloUnoProgenitorUno(getAbueloUnoProgenitorUno());
        nacimientoDTO.setAbueloDosProgenitorUno(getAbueloDosProgenitorUno());
        nacimientoDTO.setAbuelaUnoProgenitorDos(getAbueloUnoProgenitorDos());
        nacimientoDTO.setAbueloDosProgenitorDos(getAbueloDosProgenitorDos());
        nacimientoDTO.setTestigoUno(getTestigoUno());
        nacimientoDTO.setTestigoDos(getTestigoDos());

         nacimientoService.guardarNacimiento(nacimientoDTO);

    }


    //Getter y Setters
    public NacimientoServiceImpl getNacimientoService() {
        return nacimientoService;
    }

    public void setNacimientoService(NacimientoServiceImpl nacimientoService) {
        this.nacimientoService = nacimientoService;
    }

    public NacimientoDTO getNacimientoDTO() {
        return nacimientoDTO;
    }

    public void setNacimientoDTO(NacimientoDTO nacimientoDTO) {
        this.nacimientoDTO = nacimientoDTO;
    }
	

}
