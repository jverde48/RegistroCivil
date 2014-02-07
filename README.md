RC Web - RENAPO
===

Sistema de Registro Civil para RENAPO
---

---

### Tecnología
* Java 6
* JSF 2.2.5
* Primefaces 4.0
* Hibernate 3.x
* Spring Framework 3.x
* Twitter Bootstrap

### Equipo

**Líder de Proyecto:**

* Javier Alberto Ramírez Hernández - <aramirez@sintelti.com.mx>

**Análisis**

* Sandra del Río - <sandyjav@hotmail.com>
* Alejandro Díaz Solís - <adsolis@sintelti.com.mx>

**Desarrollo**

* Armando Verde - <jverde@sintelti.com.mx>
* Gerardo Balderas - <jbalderas@sintelti.com.mx>
* Abel Molina - <amolina@sintelti.com.mx>
* Estela Velázquez - <evelazquez@sintelti.com.mx>
* Melyna Hermida - <mhermida@sintelti.com.mx>
* Janet Ramírez - <jrnoyola@sintelti.com.mx>
* José Ángel Hernández <jhgonzalez@sintelti.com.mx>

### Documentación del Proyecto

//TODO

### Configuración del proyecto
1. Si es la primera vez que usas Git:
    1. Realizar el siguiente ritual de iniciación: [http://try.github.io/](http://try.github.io/)
    2. Seguir los pasos descritos [aquí](https://help.github.com/articles/set-up-git#platform-windows) y [aquí](https://help.github.com/articles/generating-ssh-keys#platform-windows) (en ese orden).
2. Clonar el repositorio con el siguiente comando (**poner especial atención en que la URL sea HTTPS**):
    * git clone https://github.com/SintelTI/RegistroCivil.git
3. El proyecto se construye con [Gradle](http://www.gradle.org), que es como Maven mejorado. Gradle es una herramienta que compila y construye el proyecto, además de descargar automágicamente las dependencias que tenga (jar). Adicionalmente Gradle está configurado para descargar automáticamente un servidor Jetty y levantar la aplicación dentro de él, sin que tengamos que hacerlo nosotros. La primera vez que lo hagamos tardará en hacerlo ya que Gradle [tiene que descargarse a si mismo](http://www.javamexico.org/blogs/domix/usar_gradle_wrapper_para_evitar_instalar_gradle) y después descargar todas las dependencias del proyecto.
    1. En la línea de comandos ejecutar el comando:
        * ``gradle.bat``
    2. Dependiendo del IDE que vayan a utilizar (Eclipse o Intellij IDEA), ejecutar el siguiente comando que creará los archivos de configuración para el IDE elegido (uno u otro, no ambos). Una vez creados los archivos de configuración ya podrán importar el proyecto fácilmente en su IDE elegido:
        * ``gradle.bat eclipse``
        * ``gradle.bat idea``
    3. Levantar el proyecto por primera vez con el comando:
        * ``gradle.bat jettyRun``
    4. Verificar que levantó correctamente accediendo a: [http://localhost:8080/RegistroCivil](http://localhost:8080/RegistroCivil)
    5. Adicionalmente también pueden configurarlo para que puedan levantarlo desde su IDE.

### Integración Continua

//TODO

### Inspección Continua

//TODO


---
SintelTI.mx, 2014.
