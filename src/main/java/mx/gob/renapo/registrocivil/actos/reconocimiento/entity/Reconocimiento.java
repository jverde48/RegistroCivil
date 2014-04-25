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
    @JoinColumn(name = "ACTA_NACIMIENTO", nullable = true)
    private Nacimiento actaNacimiento;
    
    @Column(name = "CADENA", nullable = true)
    private String cadena;
    
    @Column(name = "CRIP_RECONOCIDO", nullable = true)
    private String cripReconocido;
    
    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = true)
    private CatInegiLocalidad localidadRegistro;
    
    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;

    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;
    
    @Column(name = "FOJA", nullable = true)
    private String foja;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name= "NUMERO_ACTA", nullable = true)
    private String numeroActa;
    
    //TODO verificar generacion de GUID
    
    //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;

    /**
     * Propiedades de personas que forman parte del acto de reconocimiento
     */
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROGENITOR_UNO_RECONOCEDOR", nullable = true)
    private Persona progenitorUnoReconocedor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROGENITOR_DOS_RECONOCEDOR", nullable = true)
    private Persona progenitorDosReconocedor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_CONSEN", nullable = true)
    private Persona personaConsen;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_CONSEN_PARENT", nullable = true)
    private CatParentesco personaConsenParent;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECONOCEDOR", nullable = true)
    private Persona reconocedor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECONOCIDO", nullable = true)
    private Persona reconocido;
    
    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE_SANGUINEO")
    private Persona padreSanguineo;

    /**
     * Propiedades que forman parte de la informacion del acta del Reconocido
     */

    @Column(name = "FOJA_RECONOCIDO", nullable = true)
    private String fojaReconocido;

    @Column(name = "LIBRO_RECONOCIDO", nullable = true)
    private String libroReconocido;

    @Column(name = "TOMO_RECONOCIDO", nullable = true)
    private String tomoReconocido;

    @Column(name= "NUMERO_ACTA_RECONOCIDO", nullable = true)
    private String numeroActaReconocido;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO_RECONOCIDO", nullable = true)
    private CatInegiLocalidad localidadRegistroReconocido;

    @OneToOne
    @JoinColumn(name = "OFICIALIA_RECONOCIDO", nullable = true)
    private CatOficialia oficialiaReconocido;

    @Column(name = "FECHA_REGISTRO_RECONOCIDO", nullable = true)
    private Date fechaRegistroReconocido;

}
