package ttps;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroStockRemeras
 */
public class FiltroStockRemeras extends HttpFilter implements Filter {
	private FilterConfig config;
	private ServletContext context;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroStockRemeras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String cantidadRemeras = (String) request.getServletContext().getAttribute("cantidadRemeras");
		Integer valorActual = Integer.valueOf(cantidadRemeras);
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		if(valorActual <= 0) {
			httpServletResponse.sendRedirect("error.html");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
		this.context = fConfig.getServletContext();
		this.context.log("FiltroStockRemeras initialized");
		System.out.println("FiltroStockRemeras initialized");
	}

}
