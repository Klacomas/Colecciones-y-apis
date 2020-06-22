package cl.desafiolatam.modelo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.List;

import cl.desafiolatam.modelo.Album;
import cl.desafiolatam.modelo.Foto;
import cl.desafiolatam.servicios.Servicios;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	//Obtiene listas
		List<Usuario> lstUsuarios=Servicios.getAllUser();
		List<Album> lstAlbum = Servicios.getAllAlbums();
		List<Foto> lstFotos = Servicios.getAllPhoto();

		titulo("**Imprime Usuario - Correo***");
		lstUsuarios.forEach(user -> System.out.println(user.getName()+" -"+user.getEmail()));
    	System.out.println(" ");
    	
      	titulo("Imprime Album usuario [5]");
      	lstAlbum.stream().filter(a -> a.getUserId().equals("5"))
      		.forEach(m -> System.out.println(m.getId()+" - "+m.getUserId()+" -"+m.getTitle()));
    	System.out.println(" ");

    	titulo("******album 77******");
    	System.out.println(Servicios.getAlbum("77").toString());
		System.out.println(" ");
		
		titulo("*****titulos*****");
				lstFotos.stream().filter(p -> p.getTitle().contains("ipsam do"))
				.sorted(Comparator.comparing(Foto::getTitle)).forEach(p -> System.out.println(p.getTitle()));
		System.out.println(" ");
		
		titulo("*2 usuarios y sus albums*");
		Stream<Usuario> streamUsuarios = lstUsuarios.stream().filter(user -> Integer.valueOf(user.getId()) < 3);

		streamUsuarios.forEach(usuario -> lstAlbum.stream().filter(alb -> alb.getUserId().equals(usuario.getId())).
				forEach(alb -> System.out.println(alb.toString())));

		
		titulo("***USUARIOS Y ALBUMS***");

		Map<String, Set<String>> usersAlbum = new HashMap<>();
		lstUsuarios.stream().forEach(user -> {
			Set<String> albums = new HashSet<>();
			lstAlbum.stream().filter(alb -> Integer.valueOf(alb.getUserId()) < 4)
					.filter(album -> album.getUserId().equals(user.getId())).forEach(album -> {
						albums.add(album.getTitle());
						usersAlbum.put(user.getId(), albums);
					});
		});
		usersAlbum.forEach((k, v) -> System.out.println("usuario: " + k + " - titulos" + v));

    }

	public static void titulo(String strTitulo) {
		System.out.println("*****************************");
		System.out.println(strTitulo);
		System.out.println("*****************************");
	}   
    
}
    	
