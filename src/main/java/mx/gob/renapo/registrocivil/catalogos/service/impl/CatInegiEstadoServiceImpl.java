package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatInegiEstadoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiEstadoService;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiEstado;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 2:36 AM
 * Implementacion de service de catalogo de estado de inegi
 */
@Service
@Data
public class CatInegiEstadoServiceImpl implements CatInegiEstadoService {

    @Autowired
    private CatInegiEstadoDAO inegiEstadoDAO;

    @Autowired
    private UtileriaService utileriaService;

    public EstadoDTO findById(Long id) {
        CatInegiEstado inegiEstado = inegiEstadoDAO.recuperarRegistro(id);
        return UtileriaServiceImpl.mapeaEntityInegiADtoEstado(inegiEstado);
    }

    public List<EstadoDTO> findAll() {

        List<CatInegiEstado> inegiEstadoList = inegiEstadoDAO.listarRegistros();
        List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
        for(CatInegiEstado inegiEstado: inegiEstadoList) {
            estadoDTOList.add(UtileriaServiceImpl.mapeaEntityInegiADtoEstado(inegiEstado));
        }

        return estadoDTOList;
    }

	@Override
	public List<EstadoDTO> recupearEstadosPorPais(PaisDTO pais) {
		List<CatInegiEstado> inegiEstadoList = inegiEstadoDAO.
				recuperaEstadoPorPais(utileriaService.recuperarPaisInegi(pais));
        List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
        for(CatInegiEstado inegiEstado: inegiEstadoList) {
            estadoDTOList.add(UtileriaServiceImpl.mapeaEntityInegiADtoEstado(inegiEstado));
        }
        return estadoDTOList;
	}

}
