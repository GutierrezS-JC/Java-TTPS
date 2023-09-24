package ttps.clasificados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	/**
	 * Default constructor.
	 */
	public Login() {

		Usuario user1 = new Usuario("Manaos", "123manaos321", "Publicador");
		Usuario user2 = new Usuario("Pepe", "123pepe321", "Administrador");
		Usuario user3 = new Usuario("Gatubi", "123gatubi321", "Publicador");

		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
		listaUsuarios.add(user3);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Usuario usuario = this.listaUsuarios.stream().filter(u -> u.verificarUsuario(username, password)).findFirst()
				.orElse(null);

		if (usuario == null) {
			response.sendRedirect("unauthorized.html");
		}
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menu");
			if (dispatcher != null) {
				request.setAttribute("usuario", usuario);
				dispatcher.forward(request, response);
			}
		}
//		doGet(request, response);
	}

}
