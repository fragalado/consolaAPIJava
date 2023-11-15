package consolaAPI.dtos;

public class AccesoDTO {

	// Atributos

	private long id_acceso;
	private String codigo_acceso;
	private String descripcion_acceso;

	// Constructores

	public AccesoDTO(String codigo_acceso, String descripcion_acceso) {
		super();
		this.codigo_acceso = codigo_acceso;
		this.descripcion_acceso = descripcion_acceso;
	}

	public AccesoDTO() {
		super();
	}

	// Getter y Setter

	public String getCodigo_acceso() {
		return codigo_acceso;
	}

	public void setCodigo_acceso(String codigo_acceso) {
		this.codigo_acceso = codigo_acceso;
	}

	public String getDescripcion_acceso() {
		return descripcion_acceso;
	}

	public void setDescripcion_acceso(String descripcion_acceso) {
		this.descripcion_acceso = descripcion_acceso;
	}

	// toString

	@Override
	public String toString() {
		return "AccesoDTO [codigo_acceso=" + codigo_acceso + ", descripcion_acceso="
				+ descripcion_acceso + "]";
	}

}
