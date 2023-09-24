package ttps;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMultilenguaje
 */
@WebServlet("/LoginMultilenguaje")
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginMultilenguaje() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String localeLanguage = (String) request.getAttribute("localLanguage");
		
		// Esta linea esta al pepe porque ya la verifique en el filter anterior
		if (localeLanguage == null) localeLanguage = "es";
		
        System.out.println("Soy servlet LoginMultilenguaje y el req viene desde filtro IdentifyLanguage:" + localeLanguage);
        String titulo = (String) request.getAttribute("titulo");
        String labelUsuario = (String) request.getAttribute("labelusuario");
        String labelPassword = (String) request.getAttribute("labelpassword");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<body>");
        out.println("<h1>" + titulo + "</h1>");
        out.println("<form>");
        out.println(labelUsuario);
        out.println("<input type=\"text\" name=\"username\" />");
        out.println(labelPassword);
        out.println("<input type=\"password\" name=\"password\" />");
        out.println("</body>");
        out.close();

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
