package ttps;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ttps.clasesDAO.MySQLAccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Connection conn = MySQLAccess.getDBConnection();
			PreparedStatement p_sent = conn.prepareStatement("SELECT idusuarios, username FROM usuarios where username=?"
					+ "AND password=?");
			
			p_sent.clearParameters();
			p_sent.setString(1, username);
			p_sent.setString(2, password);
			
			ResultSet result = p_sent.executeQuery();
			
			if(!result.isBeforeFirst()) {
				response.sendRedirect("index.html");
			}
			else {
				while(result.next()) {
					getServletContext().setAttribute("user_id", result.getInt("idusuarios"));
					getServletContext().setAttribute("username", result.getString("username"));
				}
				response.sendRedirect("/BlogDeMensajes/VisualizarMensajes");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
