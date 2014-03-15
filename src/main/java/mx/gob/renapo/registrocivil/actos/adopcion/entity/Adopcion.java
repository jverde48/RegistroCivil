package mx.gob.renapo.registrocivil.actos.adopcion.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ADOPCION")
@Data
@EqualsAndHashCode(callSuper=false)
public class Adopcion extends SequenceGenerator implements Serializable {

	public Adopcion(){
	}
	
	/**
     * Propiedades que forman parte de la informacion del acta
     */
	@Column(name = "CADENA", nullable = false)
    private String cadena;
	
	@Column(name = "CRIP_ADOPTADO", nullable = true)
    private String cripAdoptado;
	
	@OneToOne
	@JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = false)
	private CatInegiLocalidad localidadRegistro;
	 
	@OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = false)
    private CatOficialia oficialia;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
    private Date fechaRegistro;
	
	@Column(name = "FECHA_RESOLUCION", nullable = true)
    private Date fechaResolucion;
	
	@Column(name = "FOJA", nullable = true)
    private String foja;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "TOMO", nullable = true)
    private String tomo;
    
  //TODO verificar generacion de GUID
    
  //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;
    
    @Column(name = "NUM_ACTA_ADOPCION", nullable = true)
    private String numActaAdopcion;
    
    @Column(name = "RESOLUCION_SENTENCIA", nullable = true)
    private String resolucionSentencia;
    
    @Column(name = "TRIBUNAL", nullable = true)
    private String tribunal;
	
	 /**
	 * Propiedades de personas que forman parte del acto de reconocimiento
	 */
	
	@OneToOne
    @JoinColumn(name = "ADOPTADO", nullable = false)
    private Persona adoptado;
	
	@OneToOne
    @JoinColumn(name = "ADOPTANTE_UNO", nullable = true)
    private Persona adoptanteUno;
	
	@OneToOne
    @JoinColumn(name = "ADOPTANTE_DOS", nullable = true)
    private Persona adoptanteDos;
	
	@Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;
    
    
}
