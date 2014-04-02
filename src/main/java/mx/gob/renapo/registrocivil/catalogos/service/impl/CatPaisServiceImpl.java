package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatPaisDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.catalogos.service.CatPaisService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/20/14
 * Time: 1:10 PM
 * implementacion de service del catalogo de pais
 */
@Data
@Service
public class CatPaisServiceImpl implements CatPaisService {


    @Autowired
    private CatPaisDAO paisDAO;

    public List<PaisDTO> findAll() {
        List<CatPais> paisListEntity = paisDAO.listarRegistros();
        List<PaisDTO> paises = new ArrayList<PaisDTO>();
        for(CatPais pais: paisListEntity) {
            paises.add(UtileriaServiceImpl.mapeaEntityADtoPais(pais));
        }
        return paises;
    }


    public PaisDTO findById(Long id) {
        CatPais paisEntity = paisDAO.recuperarRegistro(id);
        return UtileriaServiceImpl.mapeaEntityADtoPais(paisEntity);
    }

}
