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
	public static Integer COMPARCENCIA_OTRO = 5;

    /**
     * Constante par definir otra comparecencia
     */
    public static Integer COMPARENCIA_INDETERMINADO = 0;
	
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

    /**Constante par adefinir el nombre del tempalte de la vista de datos de consentimiento de reconocimiento
     *
     */
    public static String TEMPLATE_DATOS_PERSONALES_COSENTIMIENTO_RECONOCIMIENTO_OTRO = "datosOtros.xhtml";


    /**
     * Redireccionamiento despues de Login
     */
    public static String INDEX = "/index.xhtml";

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
     * Redireccionamiento para vista de Detalle de Matrimonio
     */
    public static String DETALLE_MATRIMONIO = "/pages/actos/matrimonio/acta/detalleRegistroMatrimonio/detalleRegistroMatrimonio.xhtml";

    /**
     * Redireccion a consulta para eleiminacion o cancelacion.
     */
    public static String CONSULTA_MATRIMONIO ="/pages/actos/matrimonio/acta/consultaRegistroMatrimonio/consultaRegistroMatrimonio.xhtml";

    /**
     * Redireccion a consulta para eleiminacion o cancelacion.
     */
    public static String CONSULTA_DEFUNCION ="/pages/actos/defuncion/acta/consultaRegistroDefuncion/consultaRegistroDefuncion.xhtml";

    /**
     * Redireccionamiento para vista de Detalle de Nacimiento
     */
    public static String DETALLE_NACIMIENTO = "/pages/actos/nacimiento/acta/detalleRegistroNacimiento/detalleRegistroNacimiento.xhtml";

    /**
     * Redireccionamiento para vista de Detalle de Defuncion
     */
    public static String DETALLE_DEFUNCION = "/pages/actos/defuncion/acta/detalleRegistroDefuncion/detalleDefuncion.xhtml";

    /**
     * Redireccionamiento para vista de Detalle de Adopcion
     */
    public static String DETALLE_ADOPCION = "/pages/actos/adopcion/acta/simple/detalleRegistroAdopcion/detalleRegistroAdopcion.xhtml";
    /**
     * Redireccionamiento para vista de Detalle de Reconocimiento
     */
    public static String DETALLE_RECONOCIMIENTO = "/pages/actos/reconocimiento/acta/detalleRegistroReconocimiento/detalleReconocimiento.xhtml";

    /**
     * Redireccionamiento para vista de Consulta de Reconocimiento
     */
    public static String CONSULTA_RECONOCIMIENTO = "/pages/actos/reconocimiento/acta/consultaRegistroReconocimiento/consultaRegistroReconocimiento.xhtml";

    /**
     * Redireccionamiento para vista de Detalle de Divorcio
     */
    public static String DETALLE_DIVORCIO = "/pages/actos/divorcio/acta/detalleRegistroDivorcio/detalleRegistroDivorcio.xhtml";
    
    /**
     * Redireccionamiento para vista de Consulta de Divorcio
     */
    public static String CONSULTA_DIVORCIO = "/pages/actos/divorcio/acta/consultaRegistroDivorcio/consultaRegistroDivorcio.xhtml";

    /**
     * Redireccionamiento para vista de Registro Normal de Divorcio
     */
    public static String REGISTRO_NORMAL_DIVORCIO = "/pages/actos/divorcio/acta/registroNormal/registroDivorcio.xhtml";
    /**
	 * constante con el nombre del template de registro del Testigo Uno de Divorcio
	 */
	public static String DIVORCIO_TESTIGO_UNO = "/pages/actos/divorcio/acta/registroNormal/datosTestigoDivorciadoUno.xhtml";
	
	/**
	 * constante con el nombre del template de registro del Testigo Dos de Divorcio
	 */
	public static String DIVORCIO_TESTIGO_DOS = "/pages/actos/divorcio/acta/registroNormal/datosTestigoDivorciadoDos.xhtml";
	
	/**
	 * constante con el nombre del template de registro del Testigo Uno de Divorcio
	 */
	public static String DIVORCIO_ESPECIAL_TESTIGO_UNO = "/pages/actos/divorcio/acta/registroEspecial/datosTestigoDivorciadoUno.xhtml";
	
	/**
	 * constante con el nombre del template de registro del Testigo Dos de Divorcio
	 */
	public static String DIVORCIO_ESPECIAL_TESTIGO_DOS = "/pages/actos/divorcio/acta/registroEspecial/datosTestigoDivorciadoDos.xhtml";
	
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
    
    /**
     * Indica el nombre de Mexico
     */
    public static final String MEXICO = "Mexico";

    /**
     * Indica el nombre de comparecencia de Otro
     */
    public static final String COMPARECE_OTRO = "OTRO";

    /**
     * Indica el nombre de comparecencia de Indeterminado
     */
    public static final String COMPARECE_INDETERMINADO = "Indeterminado";

    /**
     * Indica el tipo de operacion, si se trata de un registro dentro del pais
     */
    public static final Integer TIPO_OPERACION_NACIONAL = 1;

    /**
     * Indica el tipo de operacion del acto, si se trata de una inscripcion
     */
    public static final Integer TIPO_OPERACION_INSCRIPCION = 2;
    
    /**
     * Indica el tipo de divorcio Administrativo
     */
    public static final String TIPO_DIVORCIO_ADMINISTRATIVO = "ADMINISTRATIVO";
    
    /**
     * Indica el tipo de divorcio Judicial
     */
    public static final String TIPO_DIVORCIO_JUDICIAL = "JUDICIAL";
    
    /**
     * Indica el tipo de divorcio Indeterminado
     */
    public static final String TIPO_DIVORCIO_INDETERMINADO = "INDETERMINADO";

    /**
     * Indica que el registro fue exitoso
     */
    public static final Integer CODIGO_EXITOSO = 0;

    /**
     * Indica que se genero al realizar el registro
     */
    public static final Integer CODIGO_ERROR = 1;
}
