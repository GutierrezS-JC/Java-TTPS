package ttps;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class IdentifyLanguage
 */
@WebFilter("/IdentifyLanguage")
public class IdentifyLanguage extends HttpFilter implements Filter {
	private FilterConfig config;
	private ServletContext context;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public IdentifyLanguage() {
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
//        Locale locale = request.getLocale();
//        String localeLanguage = locale.getLanguage();
        
		// Comentando (o no) este parametro de request puedo testeas si viene en ingles o no
//		request.setAttribute("localLanguage", "en");
		
		String localeLanguage = (String) request.getAttribute("localLanguage");
        System.out.println("Soy filtro IdentifyLanguage y el req viene desde filtro FiltroLenguage: " + localeLanguage);
        
        // Leer archivo de propiedades
//        PrintWriter out = response.getWriter();
		ResourceBundle rb = (localeLanguage == "en") ? (ResourceBundle.getBundle("textos_en"))
				: (ResourceBundle.getBundle("textos_es"));
        
        Enumeration<String> claves = rb.getKeys();
        while (claves.hasMoreElements()) {
        	String clave = (String) claves.nextElement();
//        	out.println(clave+" = "+rb.getString(clave));
//        	System.out.println(clave + " = " + rb.getString(clave));
        	request.setAttribute(clave, rb.getString(clave));
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
		this.context.log("IdentifyLanguage initialized");
	}

}
