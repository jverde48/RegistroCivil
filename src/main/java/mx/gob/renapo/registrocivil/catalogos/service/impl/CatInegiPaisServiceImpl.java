package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatInegiPaisDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiPais;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiPaisService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(CatInegiPaisServiceImpl.class);

    @Autowired
    private CatInegiPaisDAO inegiPaisDAO;


    public List<PaisDTO> findAll() {
        List<PaisDTO> paisesDTOList = new ArrayList<PaisDTO>();
        try {
            List<CatInegiPais> inegiPaisList = inegiPaisDAO.listarRegistros();

            for (CatInegiPais inegiPais: inegiPaisList) {
                paisesDTOList.add(UtileriaServiceImpl.mapeaEntityInegiADtoPais(inegiPais));
            }
        }catch (Exception e) {
          logger.error("Error: " + e);
        }
        return paisesDTOList;
    }


    public PaisDTO findById(Long id) {
        CatInegiPais inegiPais = null;
        try {
            inegiPais = inegiPaisDAO.recuperarRegistro(id);
        }catch (Exception e) {
          logger.error("Error: " + e);
        }
        return UtileriaServiceImpl.mapeaEntityInegiADtoPais(inegiPais);
    }


}
