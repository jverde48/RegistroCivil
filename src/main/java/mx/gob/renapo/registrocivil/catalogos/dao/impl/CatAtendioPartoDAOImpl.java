package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatAtendioPartoDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import org.springframework.stereotype.Repository;

@Repository
public class CatAtendioPartoDAOImpl  extends GeneralDAOImpl<CatAtendioParto> implements CatAtendioPartoDAO{

    @Override
    public void prueba(String descripcion) {
        System.out.println(descripcion);
    }
}