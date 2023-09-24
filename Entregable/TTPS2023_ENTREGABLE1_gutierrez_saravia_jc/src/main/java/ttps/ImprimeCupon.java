package ttps;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

/**
 * Servlet implementation class ImprimeCupon
 */
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimeCupon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cantidadRemeras = (String) getServletContext().getAttribute("cantidadRemeras");
		
		Integer nuevoValor = Integer.valueOf(cantidadRemeras);
		nuevoValor = nuevoValor - 1;

		getServletContext().setAttribute("cantidadRemeras", nuevoValor.toString());
		OutputStream outputStream = response.getOutputStream();
		
		Integer codigoRetiro = ThreadLocalRandom.current().nextInt(1000000, 99999999);
		
		BufferedImage image = new BufferedImage(1800, 1000, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics = image.createGraphics();
		
		BufferedImage img = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/imagenes/cupon3.jpg"));
		
		graphics.drawImage(img, 0, 0, null, null);
		graphics.setBackground(Color.WHITE);
		
		graphics.clearRect(1000, 810, 600, 80);
		graphics.setFont(new Font("TimesRoman", Font.BOLD, 25));
		
		graphics.setColor(Color.WHITE);
		graphics.drawString(request.getParameter("textoPersonalizado"), 500, 700);
		
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("TimesRoman", Font.BOLD, 40));
		graphics.drawString("#" + codigoRetiro.toString(), 1050, 860);

		javax.imageio.ImageIO.write(image, "jpg", outputStream);
	
		outputStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
