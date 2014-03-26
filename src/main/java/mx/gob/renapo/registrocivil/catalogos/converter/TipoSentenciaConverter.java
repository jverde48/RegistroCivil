package mx.gob.renapo.registrocivil.catalogos.converter;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoSentenciaDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoSentenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 24/03/14
 * Time: 03:32
 * To change this template use File | Settings | File Templates.
 */
//@FacesConverter(value = "tipoSentenciaConverter", forClass = CatTipoSentenciaDTO.class)
@ManagedBean(name = "tipoSentenciaConverter")
@Data
@Component
public class TipoSentenciaConverter implements Converter {

    @Autowired
    private CatTipoSentenciaService tipoSentenciaService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatTipoSentenciaDTO) || ((CatTipoSentenciaDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatTipoSentenciaDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatTipoSentenciaDTO tipoSentencia = tipoSentenciaService.findById(Long.valueOf(value));

        if (tipoSentencia == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return tipoSentencia;
    }
}
