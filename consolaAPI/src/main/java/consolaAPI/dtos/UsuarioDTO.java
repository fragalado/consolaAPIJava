package consolaAPI.dtos;

import java.util.Calendar;


public class UsuarioDTO {
	// Atributos
	
	private long id_usuario;
	private String dni_usuario;
	private String nombre_usuario;
	private String apellidos_usuario;
	private String tlf_usuario;
	private String email_usuario;
	private String clave_usuario;
	private boolean establoqueado_usuario;
	private Calendar fch_fin_bloqueo_usuario;
	private Calendar fch_alta_usuario;
	private Calendar fch_baja_usuario;
	AccesoDTO acceso;
	
	// Constructores
	
	public UsuarioDTO(String dni_usuario, String nombre_usuario, String apellidos_usuario, String tlf_usuario,
			String email_usuario, String clave_usuario, boolean establoqueado_usuario, Calendar fch_fin_bloqueo_usuario,
			Calendar fch_alta_usuario, Calendar fch_baja_usuario, AccesoDTO acceso) {
		super();
		this.dni_usuario = dni_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellidos_usuario = apellidos_usuario;
		this.tlf_usuario = tlf_usuario;
		this.email_usuario = email_usuario;
		this.clave_usuario = clave_usuario;
		this.establoqueado_usuario = establoqueado_usuario;
		this.fch_fin_bloqueo_usuario = fch_fin_bloqueo_usuario;
		this.fch_alta_usuario = fch_alta_usuario;
		this.fch_baja_usuario = fch_baja_usuario;
		this.acceso = acceso;
	}
	
	public UsuarioDTO() {
		super();
	}
	
	// Getter y Setter
	
	public String getDni_usuario() {
		return dni_usuario;
	}
	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getApellidos_usuario() {
		return apellidos_usuario;
	}
	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}
	public String getTlf_usuario() {
		return tlf_usuario;
	}
	public void setTlf_usuario(String tlf_usuario) {
		this.tlf_usuario = tlf_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getClave_usuario() {
		return clave_usuario;
	}
	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}
	public boolean isEstabloqueado_usuario() {
		return establoqueado_usuario;
	}
	public void setEstabloqueado_usuario(boolean establoqueado_usuario) {
		this.establoqueado_usuario = establoqueado_usuario;
	}
	public Calendar getFch_fin_bloqueo_usuario() {
		return fch_fin_bloqueo_usuario;
	}
	public void setFch_fin_bloqueo_usuario(Calendar fch_fin_bloqueo_usuario) {
		this.fch_fin_bloqueo_usuario = fch_fin_bloqueo_usuario;
	}
	public Calendar getFch_alta_usuario() {
		return fch_alta_usuario;
	}
	public void setFch_alta_usuario(Calendar fch_alta_usuario) {
		this.fch_alta_usuario = fch_alta_usuario;
	}
	public Calendar getFch_baja_usuario() {
		return fch_baja_usuario;
	}
	public void setFch_baja_usuario(Calendar fch_baja_usuario) {
		this.fch_baja_usuario = fch_baja_usuario;
	}
	public AccesoDTO getAcceso() {
		return acceso;
	}
	public void setAcceso(AccesoDTO acceso) {
		this.acceso = acceso;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "UsuarioDTO [dni_usuario=" + dni_usuario + ", nombre_usuario="
				+ nombre_usuario + ", apellidos_usuario=" + apellidos_usuario + ", tlf_usuario=" + tlf_usuario
				+ ", email_usuario=" + email_usuario + ", clave_usuario=" + clave_usuario + ", establoqueado_usuario="
				+ establoqueado_usuario + ", fch_fin_bloqueo_usuario=" + fch_fin_bloqueo_usuario + ", fch_alta_usuario="
				+ fch_alta_usuario + ", fch_baja_usuario=" + fch_baja_usuario + ", acceso=" + acceso + "]";
	}
	
}
