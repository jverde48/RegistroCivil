package mx.gob.renapo.registrocivil.util;

public class ConstantesComunes {
	
	/**
	 * Constante para definir el nombre de la vista de datos personales de progenitor uno
	 */
	public static String TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO = "datosPersonalesProgenitorUno.xhtml";
	
	/**
	 * Constante para definir el nombre de la vista de datos personales de progenitor uno
	 */
	public static String TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES = "datosPersonalesAmbosPadres.xhtml";
	
	/**
	 * Constante para definir el nombre del template de la vista de datos de comparecencia
	 */
	public static String TEMPLATE_DATOS_PERSONALES_COMPARECE = "datosPersonalesComparece.xhtml";
	
	/**
	 * Constante para definir el nombre del template de la vista de estadisticos de padre
	 */
	public static String TEMPLATE_ESTADISTICOS_PADRE = "estadisticosPadre.xhtml";
	
	/**
	 * Constante para definir otra comparecencia diferente a padres y abuelos
	 */	
	public static Integer COMPARCENCIA_OTRO = 4;
	
	/**
	 * Constante para definir otro consentimiento diferente a padres
	 */	
	public static Integer CONSENTIMIENTO_OTRO = 4;
	
	/**
	 * Constante para definir el nombre del template de la vista de datos de consentimiento
	 */
	public static String TEMPLATE_DATOS_PERSONALES_CONSENTIMIENTO_CONTRAYENTE_UNO = "datosPersonalesConsentimientoContrayenteUno.xhtml";
	
	/**
	 * Constante para definir el nombre del template de la vista de datos de consentimiento
	 */
	public static String TEMPLATE_DATOS_PERSONALES_CONSENTIMIENTO_CONTRAYENTE_DOS = "datosPersonalesConsentimientoContrayenteDos.xhtml";
	/**
	 * C
	 */

	/**
	 * Constante con el nombre del template de registro normal de nacimientos
	 */
	public static String TEMPLATE_NACIMIENTOS_NORMAL = "registroNormal/registroNacimiento.xhtml";
	
	/**
	 * Constante con el nombre del template de registro historico de nacimientos
	 */
	public static String TEMPLATE_NACIMIENTOS_HISTORICO = "registroHistorico/registroNacimiento.xhtml";
	
	/**
	 * Constante con el nombre del template de registro especial de nacimiento
	 */
	public static String TEMPLATE_NACIMIENTOS_ESPECIAL = "registroEspecial/registroNacimiento.xhtml"; 
	
	/**
	 * contante con el nombre del template de registro normal matrimonio
	 */
	public static String TEMPLATE_MATRIMONIOS_NORMAL = "registroNormal/registroActaMatrimonio.xhtml";
	
	/**
	 * contante con el nombre del template de registro Historico matrimonio
	 */
	public static String TEMPLATE_MATRIMONIOS_HISTORICO = "registroHistorico/registroActaMatrimonio.xhtml";
	
	/**
	 * contante con el nombre del template de registro Especial matrimonio
	 */
	public static String TEMPLATE_MATRIMONIOS_ESPECIAL = "";

    /**
     * Algoritmos de encripcion para genercion de hash cuando se realicen
     * llamadas a ConsultaWS
     */
    public static final String MD2 = "MD2";
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";


     //Codigos de Respuesta para WS.
    /**
     * Indica que no hubo errores y que la ejecucion del metodo fue correcta.
     */
    public static final String NO_ERRORS = "01";

    /**
     * Cuando se busca una persona regresa este codigo de respuesta si no se encontro ninguna coincidencia.
     */
    public static final String NO_EXISTE = "02";

    /**
     * Indica que los datos no son validos.
     * - Curp con menos caracteres.
     * - La cadena no esta bien formada.
     * - Fecha no tiene el formato requerido.
     */
    public static final String DATOS_INVALIDOS = "03";

    /**
     * Indica que el hash generado no es valido.
     */
    public static final String HASH_INVALIDO = "04";
}
