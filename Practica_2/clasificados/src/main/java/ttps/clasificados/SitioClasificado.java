package ttps.clasificados;

public class SitioClasificado {
	private String nombreSitio;
	private String email;
	private String telefono;

	public SitioClasificado(String nombreSitio, String email, String telefono) {
		super();
		this.nombreSitio = nombreSitio;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombreSitio() {
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
