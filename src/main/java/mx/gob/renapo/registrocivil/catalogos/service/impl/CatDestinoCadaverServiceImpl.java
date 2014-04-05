package mx.gob.renapo.registrocivil.catalogos.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatDestinoCadaverDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatDestinoCadaverDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatDestinoCadaver;
import mx.gob.renapo.registrocivil.catalogos.service.CatDestinoCadaverService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CatDestinoCadaverServiceImpl implements CatDestinoCadaverService {

    private static Logger logger = Logger.getLogger(CatDestinoCadaverServiceImpl.class);

    @Autowired
    private CatDestinoCadaverDAO destinoCadaverDAO;

	@Override
	public boolean crearDestinoCadaver(String descripcion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarDestinoCadaver(String decripicon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarDestinoCadaver(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CatDestinoCadaverDTO findById(Long id) {
        CatDestinoCadaverDTO destinoCadaverDTO = null;

        try {
            CatDestinoCadaver destinoCadaverEntity = destinoCadaverDAO.recuperarRegistro(id);

            if (destinoCadaverEntity != null) {
                destinoCadaverDTO = new CatDestinoCadaverDTO();
                destinoCadaverDTO.setId(destinoCadaverEntity.getId());
                destinoCadaverDTO.setDescripcion(destinoCadaverEntity.getDescripcion());
            }

        }catch (Exception e) {
          logger.error("Error: " + e);
        }

		return destinoCadaverDTO;
	}

	@Override
	public List<CatDestinoCadaverDTO> findAll() {
		List<CatDestinoCadaverDTO> listaDestinoCadaverDTO = null;

        try {
            List<CatDestinoCadaver> listaDestinoCadaverEntity = destinoCadaverDAO.listarRegistros();

            if (listaDestinoCadaverEntity != null && !listaDestinoCadaverEntity.isEmpty()) {
                listaDestinoCadaverDTO = new ArrayList<CatDestinoCadaverDTO>();

                for (CatDestinoCadaver destinoCadaver : listaDestinoCadaverEntity) {
                    CatDestinoCadaverDTO destinoCadaverDTO = new CatDestinoCadaverDTO();
                    destinoCadaverDTO.setId(destinoCadaver.getId());
                    destinoCadaverDTO.setDescripcion(destinoCadaver.getDescripcion());

                    listaDestinoCadaverDTO.add(destinoCadaverDTO);
                }
            }
        }catch (Exception e) {
            logger.error("Error: " + e);
        }

		return listaDestinoCadaverDTO;
	}



}
