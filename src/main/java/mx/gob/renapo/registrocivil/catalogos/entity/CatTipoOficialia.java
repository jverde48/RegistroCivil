package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "CAT_TIPO_OFICIALIA")
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatTipoOficialia extends Catalogo {

	public CatTipoOficialia(){}
}
