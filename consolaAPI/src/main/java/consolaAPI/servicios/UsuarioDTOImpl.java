package consolaAPI.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import consolaAPI.dtos.AccesoDTO;
import consolaAPI.dtos.UsuarioDTO;

public class UsuarioDTOImpl implements UsuarioDTOInterfaz {

	@Override
	public List<UsuarioDTO> selectUsuarios() {
		
		// Lista donde guardaremos los usuarios de la base de datos
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		
		try {
			URI uri = new URI("http://localhost:8080/usuario");
			URL urlUsuario = uri.toURL(); // URL urlApi = new URL("http://localhost:8080"); TAMBIEN SE PUEDE

			HttpURLConnection con = (HttpURLConnection) urlUsuario.openConnection();
			con.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			// Variables necesarias para leer un array de JSON
			JSONParser parser = new JSONParser();
			JSONObject jsonObject;
			JSONArray jsonArray;

			String linea;
			while ((linea = br.readLine()) != null) { // Realmente lo devuelve todo en una linea
				jsonArray = (JSONArray) parser.parse(linea);
				for (Object res : jsonArray) {
					jsonObject = (JSONObject) res;

					// Cogemos los valores del json y los metemos en variables
					String dni = jsonObject.get("dni_usuario").toString();
					String nombre = jsonObject.get("nombre_usuario").toString();
					String apellidos = jsonObject.get("apellidos_usuario").toString();
					String tlf = jsonObject.get("tlf_usuario").toString();
					String email = jsonObject.get("email_usuario").toString();
					String clave = jsonObject.get("clave_usuario").toString();
					Boolean estaBloqueado = (Boolean) jsonObject.get("estaBloqueado_usuario");
					Calendar fch_fin = (Calendar) jsonObject.get("fch_fin_bloqueo_usuario");
					Calendar fch_alta = (Calendar) jsonObject.get("fch_alta_usuario");
					Calendar fch_baja = (Calendar) jsonObject.get("fch_baja_usuario");

					JSONObject a = (JSONObject) parser.parse(jsonObject.get("acceso").toString());
					AccesoDTO acceso = new AccesoDTO(a.get("codigo_acceso").toString(),
							a.get("descripcion_acceso").toString());
					
					// Añadimos a la lista usuario un nuevo usuario creado a partir de los valores
					listaUsuarios.add(new UsuarioDTO(dni, nombre, apellidos, tlf, email, clave, estaBloqueado, fch_fin,
							fch_alta, fch_baja, acceso));
				}
			}

			br.close();
			con.disconnect();
			
		} catch (URISyntaxException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuarios]: " + e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuarios]: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuarios]: " + e.getMessage());
		} catch (ParseException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuarios]: " + e.getMessage());
		}
		
		// Devolvemos la lista
		return listaUsuarios;
	}

	@Override
	public UsuarioDTO selectUsuarioPorId() {
		UsuarioDTO usu = null;
		try {
			URI uri = new URI("http://localhost:8080/usuario/1");
			URL urlUsuario = uri.toURL(); // URL urlApi = new URL("http://localhost:8080"); TAMBIEN SE PUEDE

			HttpURLConnection con = (HttpURLConnection) urlUsuario.openConnection();
			con.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			// Variables necesarias para leer un array de JSON
			JSONParser parser = new JSONParser();
			JSONObject jsonObject;

			String linea;
			while ((linea = br.readLine()) != null) { // Realmente lo devuelve todo en una linea
				jsonObject = (JSONObject) parser.parse(linea);
				// Cogemos los valores del json y los metemos en variables
				String dni = jsonObject.get("dni_usuario").toString();
				String nombre = jsonObject.get("nombre_usuario").toString();
				String apellidos = jsonObject.get("apellidos_usuario").toString();
				String tlf = jsonObject.get("tlf_usuario").toString();
				String email = jsonObject.get("email_usuario").toString();
				String clave = jsonObject.get("clave_usuario").toString();
				Boolean estaBloqueado = (Boolean) jsonObject.get("estaBloqueado_usuario");
				Calendar fch_fin = (Calendar) jsonObject.get("fch_fin_bloqueo_usuario");
				Calendar fch_alta = (Calendar) jsonObject.get("fch_alta_usuario");
				Calendar fch_baja = (Calendar) jsonObject.get("fch_baja_usuario");
				
				JSONObject a = (JSONObject) parser.parse(jsonObject.get("acceso").toString());
				AccesoDTO acceso = new AccesoDTO(a.get("codigo_acceso").toString(),
						a.get("descripcion_acceso").toString());
				
				usu = new UsuarioDTO(dni, nombre, apellidos, tlf, email, clave, estaBloqueado, fch_fin,
						fch_alta, fch_baja, acceso);
			}

			br.close();
			con.disconnect();
			
		} catch (URISyntaxException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuariosPorId]: " + e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuariosPorId]: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuariosPorId]: " + e.getMessage());
		} catch (ParseException e) {
			System.err.println("[ERROR-UsuarioDTOImpl-selectUsuariosPorId]: " + e.getMessage());
		}
		
		// Devolvemos el usuario
		return usu;
	}

}
