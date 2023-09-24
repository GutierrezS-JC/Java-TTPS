package ttps.clasificados;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Menu() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		String rolUsuario = usuario.getRol();
		String htmlResponse;
		if(rolUsuario.equals("Administrador")) {
			htmlResponse = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
					+ "<html>\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
					+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
					+ "		integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\" crossorigin=\"anonymous\">\r\n"
					+ "\r\n"
					+ "	<title>Bienvenido</title>\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "	<div class=\"container mt-4\">\r\n"
					+ "		<h1>Bienvenido administrador " ;
			htmlResponse += usuario.getUsername() + " ";
			htmlResponse += " :)</h1>\r\n"
					+ "		<div class=\"mt-5\">\r\n"
					+ "			<div class=\"row\">\r\n"
					+ "				<div class=\"col-4\">\r\n"
					+ "					<div class=\"card\" style=\"width: 18rem; height: 12em;\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<h5 class=\"card-title\">Actualizar datos</h5>\r\n"
					+ "							<p class=\"card-text\">Actualizar datos de contacto y personales</p>\r\n"
					+ "							<a href=\"#\" class=\"card-link\">Entrar</a>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "				<div class=\"col-4\">\r\n"
					+ "					<div class=\"card\" style=\"width: 18rem; height: 12em;\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<h5 class=\"card-title\">ABM</h5>\r\n"
					+ "							<p class=\"card-text\">Alta, baja y modificacion de Publicaciones</p>\r\n"
					+ "							<a href=\"#\" class=\"card-link\">Entrar</a>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "				<div class=\"col-4\">\r\n"
					+ "					<div class=\"card\" style=\"width: 18rem; height: 12em;\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<h5 class=\"card-title\">Contestar consultas</h5>\r\n"
					+ "							<p class=\"card-text\">Contestar consultas de otros usuarios</p>\r\n"
					+ "							<a href=\"#\" class=\"card-link\">Entrar</a>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "		<a type=\"button\" href=\"/clasificados/login.html\" role=\"button\" class=\"btn btn-primary btn-sm mt-3\">Cerrar\r\n"
					+ "			Sesion</a>\r\n"
					+ "	</div>\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>";
		} else {
			htmlResponse = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
					+ "<html>\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
					+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
					+ "		integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\" crossorigin=\"anonymous\">\r\n"
					+ "\r\n"
					+ "	<title>Bienvenido</title>\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "	<div class=\"container mt-4\">\r\n"
					+ "		<h1>Bienvenido publicador " ;
			htmlResponse += usuario.getUsername() + " ";
			htmlResponse += " :)</h1>\r\n"
					+ "		<div class=\"mt-5\">\r\n"
					+ "			<div class=\"row\">\r\n"
					+ "				<div class=\"col-4\">\r\n"
					+ "					<div class=\"card\" style=\"width: 18rem; height: 12em;\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<h5 class=\"card-title\">Actualizar datos</h5>\r\n"
					+ "							<p class=\"card-text\">Actualizar datos de contacto y personales</p>\r\n"
					+ "							<a href=\"#\" class=\"card-link\">Entrar</a>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "				<div class=\"col-4\">\r\n"
					+ "					<div class=\"card\" style=\"width: 18rem; height: 12em;\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<h5 class=\"card-title\">ABM</h5>\r\n"
					+ "							<p class=\"card-text\">Alta, baja y modificacion de Publicaciones</p>\r\n"
					+ "							<a href=\"#\" class=\"card-link\">Entrar</a>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "				<div class=\"col-4\">\r\n"
					+ "					<div class=\"card\" style=\"width: 18rem; height: 12em;\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<h5 class=\"card-title\">Contestar consultas</h5>\r\n"
					+ "							<p class=\"card-text\">Contestar consultas de otros usuarios</p>\r\n"
					+ "							<a href=\"#\" class=\"card-link\">Entrar</a>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "		<a type=\"button\" href=\"/clasificados/login.html\" role=\"button\" class=\"btn btn-primary btn-sm mt-3\">Cerrar\r\n"
					+ "			Sesion</a>\r\n"
					+ "	</div>\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm\" crossorigin=\"anonymous\"></script>"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>";
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/Encabezado");
		dispatcher.include(request, response);
		
		response.getWriter().append(htmlResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
