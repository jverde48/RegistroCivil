package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_OFICIAL")
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatOficial extends SequenceGenerator {
	
	 public CatOficial(){}
	 
	 @Column(name = "NOMBRE", nullable=false)
	 private String descripcion;

	 @Column(name = "NUM_OFICIAL", nullable=true)
	 private Long numOficial;
	 
	 @OneToOne
	 @JoinColumn(name = "ID_OFICIALIA", nullable=true)
	 private CatOficialia idOficialia;
}
