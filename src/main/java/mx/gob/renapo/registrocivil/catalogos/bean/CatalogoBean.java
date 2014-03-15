package mx.gob.renapo.registrocivil.catalogos.bean;

import lombok.Data;

@Data
public abstract class CatalogoBean {
	
	private String descripcion;
	
	public abstract void crear();
    public abstract void actualizar();
	public abstract void eliminar();
}
