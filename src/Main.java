// Programa para leer los datos de un fichero, guardarlos en un arraylist, y despues mostrarlos en pantalla.

// Se importan las librerias necesarias
import java.util.*;
import java.io.*;

public class Main {

public static void main (String args[]) throws IOException{	

		Scanner sc = new Scanner(System.in);
		
		// Se crea el arraylist donde se guardaran los distribuidores
		ArrayList <Distribuidor> distribuidores = new ArrayList <Distribuidor>();
		
		try {

			// Se crean los objetos necesarios para leer el fichero.
 			File archivo = new File("/home/zubiri/proyectosjava/java2_Almacen/src/distribuidores.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader bf = new BufferedReader(fr);
			String linea = bf.readLine();	
	       
	       	// Por cada linea leida, hara lo siguiente.
	        while(linea!=null) {

	        	// Separa la linea en partes (3); teniendo "/ " como patron.
	        	String [] lineaPartida = linea.split("/ ");

	        	// Las partes obtenidas de la linea, las vuelve a dividir en partes, con "," como patron.
	       	 	String [] parte1 = lineaPartida[0].split(",");
	       		String [] parte2 = lineaPartida[1].split(",");
	       		String [] parte3 = lineaPartida[2].split(",");
	        	
	        	// Se crean los objetos necesarios para despues asignarles los valores.
	       		Distribuidor distribuidor = new Distribuidor();
	       		Direccion direccion = new Direccion();
	       		Contacto contacto = new Contacto();

	       		// Al objeto direccion se le asignan los valores obtenidos desde el fichero.
	       		direccion.setCalle(parte2[0]);
	       		direccion.setNumero(Integer.parseInt(parte2[1]));
	       		direccion.setPiso(parte2[2]);
	       		direccion.setCiudad(parte2[3]);
	     		direccion.setProvincia(parte2[4]);
	       		direccion.setCodigoPostal(Integer.parseInt(parte2[5]));

	       		// Al objeto contacto se le asignan los valores obtenidos desde el fichero.
	       		contacto.setNombre(parte3[0]);
	       		contacto.setApellidos(parte3[1]);
	       		contacto.setTelefono(parte3[2]);
	      		contacto.setEdad(Integer.parseInt(parte3[3]));

	      		// Al objeto distribuidor se le asignan los valores obtenidos desde el fichero.
	       		distribuidor.setNombre(parte1[0]);
	       		distribuidor.setCif(parte1[1]);
	       		distribuidor.setDireccion(direccion);
	       		distribuidor.setPersonaContacto(contacto);

	       		// Añade 'distribuidor' al arraylist 'distribuidores'.       		       		
	       		distribuidores.add(distribuidor);

	       		// Lee otra linea del fichero.
	       		linea = bf.readLine();

	        }

	        // Ahora se mostraran en pantalla los datos guardados dentro del arraylist
	        for (int i=0; i<distribuidores.size(); i++) {
	        	System.out.println("\n//// Distribuidor " + (i+1));

	        	// Datos del distribuidor
	        	System.out.println("- Nombre: " + distribuidores.get(i).getNombre());
	        	System.out.println("- CIF: " + distribuidores.get(i).getCif());

	        	// Datos de la direccion
	        	System.out.println("- Direccion:");
	        	System.out.println("   - Calle: " + distribuidores.get(i).getDireccion().getCalle());
	        	System.out.println("   - Numero: " + distribuidores.get(i).getDireccion().getNumero());
	        	System.out.println("   - Piso: " + distribuidores.get(i).getDireccion().getPiso());
	        	System.out.println("   - Ciudad: " + distribuidores.get(i).getDireccion().getCiudad());
	        	System.out.println("   - Provincia: " + distribuidores.get(i).getDireccion().getProvincia());
	        	System.out.println("   - Codigo Postal: " + distribuidores.get(i).getDireccion().getCodigoPostal());

	        	// Datos de PersonaContacto
	        	System.out.println("- Persona de Contacto:");
	        	System.out.println("   - Nombre: " + distribuidores.get(i).getPersonaContacto().getNombre());
	        	System.out.println("   - Apellidos: " + distribuidores.get(i).getPersonaContacto().getApellidos());
	        	System.out.println("   - Telefono: " + distribuidores.get(i).getPersonaContacto().getTelefono());
	        	System.out.println("   - Edad: " + distribuidores.get(i).getPersonaContacto().getEdad());

	        }

	    }

	    // Si se produce algun error, se mostrara en pantalla.
	    catch(Exception error){
	    	System.out.println("Error: "+ error);
	    }
	}
}