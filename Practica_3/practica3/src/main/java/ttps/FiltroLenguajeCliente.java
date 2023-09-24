package ttps;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroLenguajeCliente
 */
@WebFilter("/FiltroLenguajeCliente")
public class FiltroLenguajeCliente extends HttpFilter implements Filter {
	private FilterConfig config;
	private ServletContext context;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLenguajeCliente() {
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
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// Agarramos la informacion sobre Locale y averiguamos el lenguaje
		Locale locale = request.getLocale();
        String localeLanguage = locale.getLanguage();
		
        request.setAttribute("localLanguage", localeLanguage);
        
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
		this.context.log("FiltroLenguajeCliente initialized");
	}

}
