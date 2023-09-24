package ttps;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.util.Date;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
@WebFilter("/FiltroLogDeAccesos")
public class FiltroLogDeAccesos extends HttpFilter implements Filter {
	private FilterConfig config;
	private ServletContext context;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FiltroLogDeAccesos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String ipAddress = request.getRemoteAddr();
		Date date = new Date();

		// Request Line
		String method = req.getMethod();
		String resource = req.getRequestURI();
		String protocolVersion = req.getProtocol();
		String userAgent = req.getHeader("User-Agent");

		this.context.log(
				ipAddress + " [" + date + "] " + "\"" + method + " " + resource + " " + protocolVersion + "\"" + userAgent);

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
		this.context.log("FiltroLogDeAccesos initialized");
	}

}
