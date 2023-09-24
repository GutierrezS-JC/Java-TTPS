package ttps.clasificados;

public class Usuario {
	private String username;
	private String password;
	private String rol;
	
	public Usuario(String username, String password, String rol) {
		super();
		this.username = username;
		this.password = password;
		this.rol = rol;
	}
	
	public Usuario() {
		
	}
	
	public Boolean verificarUsuario(String username, String password) {
		
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		}
		
		return false;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}
