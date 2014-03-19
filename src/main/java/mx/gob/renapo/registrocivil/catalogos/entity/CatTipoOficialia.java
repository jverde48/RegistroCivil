package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_TIPO_OFICIALIA")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatTipoOficialia extends Catalogo {

	public CatTipoOficialia(){}
}
