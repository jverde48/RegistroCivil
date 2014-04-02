package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatInegiPaisDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiPais;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiPaisService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 1:46 AM
 * Implementacion de service de catalogo de pais de inegi
 */
@Service
@Data
public class CatInegiPaisServiceImpl implements CatInegiPaisService{

    @Autowired
    private CatInegiPaisDAO inegiPaisDAO;


    public List<PaisDTO> findAll() {
        List<CatInegiPais> inegiPaisList = inegiPaisDAO.listarRegistros();
        List<PaisDTO> paisesDTOList = new ArrayList<PaisDTO>();
        for (CatInegiPais inegiPais: inegiPaisList) {
             paisesDTOList.add(UtileriaServiceImpl.mapeaEntityInegiADtoPais(inegiPais));
        }
        return paisesDTOList;
    }


    public PaisDTO findById(Long id) {
        CatInegiPais inegiPais = inegiPaisDAO.recuperarRegistro(id);
        return UtileriaServiceImpl.mapeaEntityInegiADtoPais(inegiPais);
    }


}
