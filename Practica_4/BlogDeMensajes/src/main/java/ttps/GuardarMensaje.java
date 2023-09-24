package ttps;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ttps.clasesDAO.MySQLAccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class GuardarMensaje
 */
public class GuardarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarMensaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String mensaje = request.getParameter("mensajeText");
			Connection conn = MySQLAccess.getDBConnection();
			Integer userId = (Integer) getServletContext().getAttribute("user_id");
			PreparedStatement p_sent = conn.prepareStatement("INSERT INTO mensajes (idmensajes, mensaje, usuario_id)"
					+ "VALUES (?, ?, ?)");
			
			p_sent.clearParameters();
			p_sent.setInt(1, 0);
			p_sent.setString(2, mensaje);
			p_sent.setInt(3, userId);
			p_sent.executeUpdate();
			response.sendRedirect("/BlogDeMensajes/VisualizarMensajes");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
