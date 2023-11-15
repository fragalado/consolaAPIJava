package consolaAPI.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import consolaAPI.dtos.AccesoDTO;

public class AccesoDTOImpl implements AccesoDTOInterfaz {

	@Override
	public List<AccesoDTO> selectAccesos() {
		// Lista donde guardaremos los accesos de la base de datos
				List<AccesoDTO> listaAccesos = new ArrayList<AccesoDTO>();
				
				try {
					URI uri = new URI("http://localhost:8080/acceso");
					URL urlAcceso = uri.toURL(); // URL urlApi = new URL("http://localhost:8080"); TAMBIEN SE PUEDE

					HttpURLConnection con = (HttpURLConnection) urlAcceso.openConnection();
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
							String descripcion = jsonObject.get("descripcion_acceso").toString();
							String codigo = jsonObject.get("codigo_acceso").toString();
							
							// Añadimos a la lista usuario un nuevo usuario creado a partir de los valores
							listaAccesos.add(new AccesoDTO(codigo, descripcion));
						}
					}

					br.close();
					con.disconnect();
					
				} catch (URISyntaxException e) {
					System.err.println("[ERROR-AccesoDTOImpl-selectAccesos]: " + e.getMessage());
				} catch (MalformedURLException e) {
					System.err.println("[ERROR-AccesoDTOImpl-selectAccesos]: " + e.getMessage());
				} catch (IOException e) {
					System.err.println("[ERROR-AccesoDTOImpl-selectAccesos]: " + e.getMessage());
				} catch (ParseException e) {
					System.err.println("[ERROR-AccesoDTOImpl-selectAccesos]: " + e.getMessage());
				}
				
				// Devolvemos la lista
				return listaAccesos;
	}

	@Override
	public AccesoDTO selectAccesoPorId() {
		AccesoDTO acc = null;
		try {
			URI uri = new URI("http://localhost:8080/acceso/1");
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
				String descripcion = jsonObject.get("descripcion_acceso").toString();
				String codigo = jsonObject.get("codigo_acceso").toString();
				
				acc = new AccesoDTO(codigo, descripcion);
			}

			br.close();
			con.disconnect();
			
		} catch (URISyntaxException e) {
			System.err.println("[ERROR-AccesoDTOImpl-selectAccesosPorId]: " + e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println("[ERROR-AccesoDTOImpl-selectAccesosPorId]: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("[ERROR-AccesoDTOImpl-selectAccesosPorId]: " + e.getMessage());
		} catch (ParseException e) {
			System.err.println("[ERROR-AccesoDTOImpl-selectAccesosPorId]: " + e.getMessage());
		}
		
		// Devolvemos el acceso
		return acc;
	}

}
