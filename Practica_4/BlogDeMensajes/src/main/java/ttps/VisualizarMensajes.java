package ttps;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ttps.clasesDAO.MySQLAccess;
/**
 * Servlet implementation class VisualizarMensajes
 */
public class VisualizarMensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarMensajes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String htmlMensajes = "";
		String username = null;
		try {
			Connection conn = MySQLAccess.getDBConnection();
			Statement sent = conn.createStatement();	
			
			username = (String) getServletContext().getAttribute("username");
			
			ResultSet result = sent.executeQuery("SELECT m.*, u.* FROM mensajes m INNER JOIN usuarios u ON (m.usuario_id = u.idusuarios) ORDER BY idmensajes DESC");
			while (result.next()){
				htmlMensajes += "<div class=\"card\" style='width: 50em; margin:auto'>\r\n"
						+ "    <div class=\"card-header\">\r\n"
						+ 	     result.getString("Username")
						+ "    </div>\r\n"
						+ "    <div class=\"card-body\">\r\n"
						+ "      <p class=\"card-text\"> " + result.getString("mensaje") + "</p>\r\n"
						+ "      <blockquote class=\"blockquote mb-0\">\r\n"
						+ "        <footer class=\"blockquote-footer\">" + result.getString("Nombre") + " " + result.getString("Apellido")  + "</footer>\r\n"
						+ "      </blockquote>\r\n"
						+ "    </div>\r\n"
						+ "  </div>";
			}			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String htmlRes = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>Mensajes</title>\r\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<nav class=\"navbar bg-dark border-bottom border-body\" data-bs-theme=\"dark\">\r\n"
				+ "	<div class=\"container-fluid\">\r\n"
				+ "		<a class=\"navbar-brand\" href=\"#\"> TTPS - Java </a>\r\n"
				+ "		<a type=\"button\" href=\"/BlogDeMensajes/index.html\" role=\"button\" class=\"btn btn-outline-danger btn-sm\">Cerrar Sesion </a>"
				+ "	</div>\r\n"
				+ "</nav>";
		htmlRes +="<div class=\"container mt-5 mb-5 \">"
				+ "  <div class='text-center mb-4'>"
				+ "    <h1> Bienvenido " + username + "</h1>"
				+ "	   <p> Hecha un vistazo a los mensajes de los usuarios </p>"
				+ "	   <p> O tambien podes dejar uno :) </p>"
				+ "	   <a class=\"btn btn-primary mt-2\" href=\"/BlogDeMensajes/agregarMensaje.html\" role=\"button\">Agregar Mensaje</a>"
				+ "	 </div>";
		htmlRes += htmlMensajes;
		htmlRes += "</div>"
				+ "</body>";
		
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
