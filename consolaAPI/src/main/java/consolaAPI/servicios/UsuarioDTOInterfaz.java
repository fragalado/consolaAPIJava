package consolaAPI.servicios;

import java.util.List;

import consolaAPI.dtos.UsuarioDTO;

public interface UsuarioDTOInterfaz {
	
	public List<UsuarioDTO> selectUsuarios();
	
	public UsuarioDTO selectUsuarioPorId();
}
