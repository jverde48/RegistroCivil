package mx.gob.renapo.registrocivil.showcase.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import mx.gob.renapo.registrocivil.showcase.dto.AutomovilDto;

@ManagedBean(name = "loadInformationBean")
@RequestScoped
public class LoadInformation {
    private static Logger log = Logger.getLogger(LoadInformation.class);
    /*
     * Aleatorios para obtener marca modelo y color del automovil a crear.
     */
    private Random aleatorioModeloMarca = new Random();
    private Random aleatorioColor = new Random();    
    private List<AutomovilDto> listaAutomoviles;
    
    /*
     * Contienen la informacion a obtener para crear un nuevo auto.
     */
    public static final Integer[] ARRAY_MODELO = {2002, 2012, 2009, 2014, 2000, 1999, 2002, 2005, 2007, 2008};
    public static final String[] ARRAY_MARCA = {"VolskWagen", "Nissan", "Chevrolet", "Toyota", "Ford", "BMW", "Renault", "Chrysler", "Mercedes", "Seat"};
    public static final String[] ARRAY_COLOR = {"Plata", "Vino", "Negro", "Gris", "Azul", "Amarillo"};
    
    /*
     * Nos sirve para llenar la informacion de la listaAtomoviles cuando 
     * se cree el bean loadIformationBean, este llenara la 
     * lista de informacion para ser utlizada.
     */
    @PostConstruct
    public void loadInformation() {
        listaAutomoviles = getAutomoviles();
    }

    public List<AutomovilDto> getListaAutomoviles() {
        return listaAutomoviles;
    }

    public void setListaAutomoviles(List<AutomovilDto> listaAutomoviles) {
        this.listaAutomoviles = listaAutomoviles;
    }
    
    /*
     * Este metodo en la implentacion del proyecto de debe cambiar 
     * para obtener los datos de la BD
     */
    private List<AutomovilDto> getAutomoviles(){
        log.info("Entra al metodo");
        AutomovilDto automovil;
        List<AutomovilDto> listAutomoviles = new ArrayList<AutomovilDto>();
        
        for(int i = 1; i <= 20; i++) {
            automovil = new AutomovilDto();
            automovil.setId(i);
            
            //Se llena la informacion del automovil con la definida en los arreglos
            automovil.setMarca(ARRAY_MARCA[aleatorioModeloMarca.nextInt(ARRAY_MARCA.length)]);
            automovil.setModelo(ARRAY_MODELO[aleatorioModeloMarca.nextInt(ARRAY_MODELO.length)]);
            automovil.setColor(ARRAY_COLOR[aleatorioColor.nextInt(ARRAY_COLOR.length)]);
            
            listAutomoviles.add(automovil);
        }
        
        return listAutomoviles;
    }
    
    
}
