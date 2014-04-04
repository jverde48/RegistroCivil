package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_TIPO_OPERACION")
public class CatTipoOperacion extends Catalogo {

    public CatTipoOperacion(){}
    
}
