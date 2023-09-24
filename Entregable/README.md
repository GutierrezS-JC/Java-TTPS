# Entregable 1
### Integración de tecnologías JEE

Se aproxima el **Festival Capital** en nuestra ciudad y usted ha sido contratado para implementar una aplicacion web que permita participar de una promocion que regala camisetas personalizadas de las diferentes bandas que asistiran. Las camisetas podran ser retiradas el dia del evento en el mismo Hipódromo de La Plata visitando el stand del *sponsor* oficial **TTPS2023**.

Para ello realice lo siguiente:

1) Cree un proyecto web dinámico llamado **TTPS2023_ENTREGABLE_suApellido**. Al momento de crearlo, elija la **version 5 o superior y Tomcat 10** para que el mismo sea compatible con el servidor donde será desplegado. Una vez creado, conviértalo en un proyecto Maven.

2) Se desea regalar una cantidad de remeras con estampas del recital. Para ello, implemente un **listener** que lea la cantidad de remeras a regalar de un **parametro de inicialización** de la aplicación. Guarde en el contexto un contador para decrementar cada vez que se regala una remera.

3) Genere una página **index.html** con un texto personalizado para imprimir en la remera.

4) Implemente un servlet llamado **ImprimeCupon** que devuelva una imagen dinámica dada con los siguientes ítems:
    - La imagen de la remera del evento (es un archivo remera.jpg que reside en el servidor)
    - El texto personalizado ingresado por el usuario
    - Un código de retiro generado aleatoriamente. Por ej: ThreadLocalRandom.current().nextInt(1000000, 99999999)

**Nota:** Utilice la clase **ImageIO** para leer un archivo JPG y generar una salida JPG escribiendo directamente en la respuesta del Servlet la clase **java.awt.image.BufferedImage** para usar su **Graphics (java.awt.Graphics2D)** y dibujar sobre la imagen a devolver.

5) Implemente un filtro llamado **FiltroStockRemeras** que chequee si aún hay remeras del festival. Si no hay más remeras, redireccionar a una página que indique "No hay más remeras para regalar" y contenga un link para volver a la página principal.

6) **Exporte** su proyecto como **archivo .ZIP** (Verifiquer que contenga los fuentes) y súbalo a **cátedras**  

7) **Exporte** su proyecto como un **archivo .WAR**, súbalo al servidor TOMCAT de la cátedra y verifique que funcione correctamente (Usar los datoss de acceso provistos el dia del entregable)


## Resultado

<img src="https://github.com/GutierrezS-JC/Java-TTPS/blob/main/Entregable/Entregable.gif">
