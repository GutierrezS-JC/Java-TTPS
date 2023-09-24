

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Premio
 */
public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer numVisitante = 0;
    /**
     * Default constructor. 
     */
    public Premio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String constResponse = "¡Felicitaciones @! eres el visitante número # de nuestro sitio y has sido"
				+ " seleccionado para el gran premio TTPS - Cursada APROBADA";
		numVisitante += 1;
		
		constResponse = constResponse.replace("@", name);
		constResponse = constResponse.replace("#", numVisitante.toString());
		
		String htmlResponse = "<html>";
        htmlResponse += constResponse;      
        htmlResponse += "</html>";
        
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
