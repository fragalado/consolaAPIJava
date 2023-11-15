package consolaAPI.controladores;

import java.util.ArrayList;
import java.util.List;

import consolaAPI.dtos.AccesoDTO;
import consolaAPI.dtos.UsuarioDTO;
import consolaAPI.servicios.AccesoDTOImpl;
import consolaAPI.servicios.AccesoDTOInterfaz;
import consolaAPI.servicios.UsuarioDTOImpl;
import consolaAPI.servicios.UsuarioDTOInterfaz;

public class Principal {

	public static void main(String[] args) {
		
		// Usuario
		UsuarioDTOInterfaz usuInterfaz = new UsuarioDTOImpl();
		
		// Select Todos
		List<UsuarioDTO> listaUsuarios = usuInterfaz.selectUsuarios();
		for (UsuarioDTO res : listaUsuarios) {
			System.out.println(res.toString());
		}
		
		// Select ID
		System.out.println("\n" + usuInterfaz.selectUsuarioPorId());
		
		// Acceso
		AccesoDTOInterfaz accInterfaz = new AccesoDTOImpl();
		
		// Select Todos
		List<AccesoDTO> listaAccesos = accInterfaz.selectAccesos();
		for (AccesoDTO res : listaAccesos) {
			System.out.println(res.toString());
		}
		
		// Select ID
		System.out.println("\n" + accInterfaz.selectAccesoPorId());
	}

}
