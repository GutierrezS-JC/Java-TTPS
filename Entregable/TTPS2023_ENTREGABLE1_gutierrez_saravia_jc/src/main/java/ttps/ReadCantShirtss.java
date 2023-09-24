package ttps;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ReadCantShirtss
 *
 */
@WebListener
public class ReadCantShirtss implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ReadCantShirtss() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println("ServletContextListener started");
		
		// Se leen parametros de inicializacion de la aplicacion
		String cantidadRemeras = sce.getServletContext().getInitParameter("cantidadRemeras");
		System.out.println("Cantiad de remeras en stock: " + cantidadRemeras);
		
		// Se guardan en el contexto los atributos al contexto de la aplicacion
		ServletContext contexto = sce.getServletContext();
		contexto.setAttribute("cantidadRemeras", cantidadRemeras);

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println("ServletContextListener destroyed");

    }
	
}
