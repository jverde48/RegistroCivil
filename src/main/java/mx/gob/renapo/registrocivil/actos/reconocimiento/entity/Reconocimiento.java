package mx.gob.renapo.registrocivil.actos.reconocimiento.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RECONOCIMIENTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class Reconocimiento extends SequenceGenerator implements Serializable{

    public Reconocimiento() {

    }

    /**
     * Propiedades que forman parte de la informacion del acta
     */
    @OneToOne
    @JoinColumn(name = "ACTA_NACIMIENTO", nullable = false)
    private Nacimiento actaNacimiento;
    
    @Column(name = "CADENA", nullable = false)
    private String cadena;
    
    @Column(name = "CRIP_RECONOCIDO", nullable = false)
    private String cripReconocido;
    
    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = false)
    private CatInegiLocalidad localidadRegistro;
    
    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = false)
    private CatOficialia oficialia;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private Date fechaRegistro;
    
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

    /**
     * Propiedades de personas que forman parte del acto de reconocimiento
     */
    
    @OneToOne
    @JoinColumn(name = "PROGENITOR_UNO_RECONOCEDOR", nullable = true)
    private Persona progenitorUnoReconocedor;

    @OneToOne
    @JoinColumn(name = "PROGENITOR_DOS_RECONOCEDOR", nullable = true)
    private Persona progenitorDosReconocedor;

    @OneToOne
    @JoinColumn(name = "PERSONA_CONSEN", nullable = true)
    private Persona personaConsen;
    
    @OneToOne
    @JoinColumn(name = "PERSONA_CONSEN_PARENT", nullable = true)
    private CatParentesco personaConsenParent;
    
    @OneToOne
    @JoinColumn(name = "RECONOCEDOR", nullable = true)
    private Persona reconocedor;
    
    @OneToOne
    @JoinColumn(name = "RECONOCIDO", nullable = false)
    private Persona reconocido;
    
    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;
    
    @OneToOne
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;
    
    @OneToOne
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;
}
