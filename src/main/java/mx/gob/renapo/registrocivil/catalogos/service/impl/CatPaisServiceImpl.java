package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatPaisDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.catalogos.service.CatPaisService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(CatPaisServiceImpl.class);

    @Autowired
    private UtileriaServiceImpl utileriaService;

    @Autowired
    private CatPaisDAO paisDAO;

    public List<PaisDTO> findAll() {

        List<PaisDTO> paises = new ArrayList<PaisDTO>();
        try {
            List<CatPais> paisListEntity = paisDAO.listarRegistros();
            for(CatPais pais: paisListEntity) {
                paises.add(utileriaService.mapeaEntityADtoPais(pais));
            }
        }catch (Exception e) {

        }

        return paises;
    }


    public PaisDTO findById(Long id) {
        CatPais paisEntity = null;

        try {
            paisEntity = paisDAO.recuperarRegistro(id);
        }catch (Exception e) {
         logger.error("Error: " + e);
        }
        return utileriaService.mapeaEntityADtoPais(paisEntity);
    }

    public PaisDTO findMexico() {
        CatPais paisEntity = null;

        try {
            paisEntity = paisDAO.findMexico();
        } catch (Exception e) {
            logger.info("Error: " + e);
        }

        return utileriaService.mapeaEntityADtoPais(paisEntity);
    }

}
