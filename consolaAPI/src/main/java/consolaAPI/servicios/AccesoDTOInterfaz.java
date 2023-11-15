package consolaAPI.servicios;

import java.util.List;

import consolaAPI.dtos.AccesoDTO;

public interface AccesoDTOInterfaz {

	public List<AccesoDTO> selectAccesos();
	
	public AccesoDTO selectAccesoPorId();
}
