package cl.desafiolatam.servicios;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.desafiolatam.modelo.Foto;
import cl.desafiolatam.modelo.Album;
import cl.desafiolatam.modelo.Usuario;

public  class Servicios {
	
//  método para obtener la lista de usuarios desde la API. E imprimir en pantalla los detalles
//  con este formato: "nombre - email".
	public static List<Usuario> getAllUser() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("users");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response users = invocationBuilder.get();
		List<Usuario> usuarios = users.readEntity(new GenericType<List<Usuario>>() {
		});
		return usuarios;
	}
//		método para obtener todos los albums, almacenar en una colección e imprimir solo los
//		pertenecientes al usuario 5.
	public static List<Album> getAllAlbums() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("albums");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response albums = invocationBuilder.get();
		return albums.readEntity(new GenericType<List<Album>>() {
		});
	}
	
//		método para obtener un album de forma individual, enviando el id a través de la ruta.
//		Imprimir en pantalla el detalle de el album 77.
	public static Album getAlbum(String id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("albums").path(id);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response album = invocationBuilder.get();
		return album.readEntity(new GenericType<Album>() {
		});
	}
	
//	 	método para obtener todas las fotos, e imprimir las que en el título contengan "ipsam do" y
//	 	ordenarlas por nombre.
	public static List<Foto> getAllPhoto() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("photos");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response fotos = invocationBuilder.get();
		return fotos.readEntity(new GenericType<List<Foto>>() {
		});
	}


}
