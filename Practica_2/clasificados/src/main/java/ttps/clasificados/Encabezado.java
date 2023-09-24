package ttps.clasificados;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encabezado
 */
@WebServlet("/Encabezado")
public class Encabezado extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Encabezado() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SitioClasificado contextoSitio = (SitioClasificado) getServletContext().getAttribute("sitio");
		
		response.setContentType("text/html");
		
		String htmlRes = ("<html><body><nav class='navbar navbar-expand-lg bg-dark border-bottom border-body' data-bs-theme='dark'>\r\n"
				+ "  <div class='container-fluid'>\r\n"
				+ "    <a class='navbar-brand' href='#'>" + contextoSitio.getNombreSitio() + "</a>\r\n"
				+ "    <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarText' aria-controls='navbarText' aria-expanded='false' aria-label='Toggle navigation'>\r\n"
				+ "      <span class='navbar-toggler-icon'></span>\r\n"
				+ "    </button>\r\n"
				+ "    <div class='collapse navbar-collapse' id='navbarText'>\r\n"
				+ "      <ul class='navbar-nav me-auto mb-2 mb-lg-0'>\r\n"
				+ "        <li class='nav-item'>\r\n"
				+ "          <a class='nav-link active' aria-current='page' href='#'>Home</a>\r\n"
				+ "        </li>\r\n"
				+ "      </ul>\r\n"
				+ "      <span class='navbar-text'>\r\n" 
				+ 		contextoSitio.getEmail() + " - " + contextoSitio.getTelefono()
				+ "      </span>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "</nav></body></html>");
		
		response.getWriter().append(htmlRes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
