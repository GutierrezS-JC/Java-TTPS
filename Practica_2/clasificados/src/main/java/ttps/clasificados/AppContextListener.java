package ttps.clasificados;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContextListener destroyed");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContextListener started");

		// Se leen parametros de inicializacion de la aplicacion
		String nombreSitio = sce.getServletContext().getInitParameter("nombresitio");
		String emailSitio = sce.getServletContext().getInitParameter("email");
		String telefonoSitio = sce.getServletContext().getInitParameter("telefono");

		// Se guardan en el contexto los atributos al contexto de la aplicacion
		ServletContext contexto = sce.getServletContext();

		SitioClasificado sitioClasificado = new SitioClasificado(nombreSitio, emailSitio, telefonoSitio);
		contexto.setAttribute("sitio", sitioClasificado);
	}

}
