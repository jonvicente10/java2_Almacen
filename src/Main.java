// Programa para leer los datos de un fichero, guardarlos en un arraylist, y despues mostrarlos en pantalla.

// Importar librerias
import java.util.*;
import java.io.*;

public class Main {

	public static void main (String args[]) throws IOException {	

		////////////////////////////////////////////////
	    //// GUARDAR DATOS DEL FICHERO EN ARRAYLIST ////
	    ////////// Y MOSTRARLOS EN PANTALLA ////////////
	    ////////////////////////////////////////////////

		try {

 			File archivo = new File("/home/zubiri/proyectosjava/java2_Almacen/src/distribuidores.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader bf = new BufferedReader(fr);
			String linea = bf.readLine();

			Scanner sc = new Scanner(System.in);
			ArrayList <Distribuidor> distribuidores = new ArrayList <Distribuidor>();
	       
	        // 1.- Leer los datos y guardarlos en el arraylist
	        while(linea!=null) {

	        	// Separar la linea leida en partes (3); teniendo "/ " como patron.
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


	        // Salto de linea vistoso
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");


	        // 2.- Mostrar los datos del arraylist
	        System.out.println("\nA continuacion se muestran los datos de los distribuidores:");
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


			///////////////////////////////////////////////////////////
		    //// SOLICITAR MANZANAS, LECHE Y LECHUGAS Y ASIGNARLES ////
		    /////////  LOS DATOS DEL DISTRIBUIDOR INTRODUCIDO /////////
		    ///////////////////////////////////////////////////////////

			ArrayList <Manzana> manzanas = new ArrayList <Manzana>();
			ArrayList <Lechuga> lechugas = new ArrayList <Lechuga>();
			ArrayList <Leche> leches = new ArrayList <Leche>();


	        // Solicitud de manzanas
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\nIntroduce los datos de MANZANA(S):");
	        for (int i=0; i<2; i++) {
	        	Manzana manzana = new Manzana();
		        System.out.println("\n/// Manzana " + (i+1) + " :");
		        System.out.print("Tipo de manzana: ");
				manzana.setTipoManzana(sc.next());
		        System.out.print("Procedencia: ");
				manzana.setProcedencia(sc.next());
		        System.out.print("Color: ");
				manzana.setColor(sc.next());
		        System.out.print("Precio (Euros/kilo): ");
				manzana.setEurosKilo(sc.nextDouble());
		        System.out.print("Distribuidor: ");
				String distribuidorManzana = sc.next();

				int realizado = 0;

				while (realizado == 0) {
					for (int j=0; j<distribuidores.size(); j++) {
		        		if (distribuidorManzana.equalsIgnoreCase(distribuidores.get(j).getNombre())) {
		        			manzana.setDistribuidor(distribuidores.get(j));
			       	 		realizado = 1;
			       	 	}
					}
					if (realizado == 0) {
				       	System.out.print("El proveedor que ha introducido, no existe en la base de datos. Introduzca uno valido: ");
				       	distribuidorManzana = sc.next();
					}
				}
				manzanas.add(manzana);
	        } 

	        // Solicitud de lechugas
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\nIntroduce los datos de LECHUGA(S):");
	        for (int i=0; i<1; i++) {
	        	Lechuga lechuga = new Lechuga();
		        System.out.println("\n/// Lechuga " + (i+1) + " :");
		        System.out.print("Tipo de lechuga: ");
				lechuga.setTipoLechuga(sc.next());
		        System.out.print("Procedencia: ");
				lechuga.setProcedencia(sc.next());
		        System.out.print("Color: ");
				lechuga.setColor(sc.next());
		        System.out.print("Precio (Euros/unidad): ");
				lechuga.setEurosUnidad(sc.nextDouble());
		        System.out.print("Distribuidor: ");
				String distribuidorLechuga = sc.next();

				int realizado = 0;

				while (realizado == 0) {
					for (int j=0; j<distribuidores.size(); j++) {
		        		if (distribuidorLechuga.equalsIgnoreCase(distribuidores.get(j).getNombre())) {
		        			lechuga.setDistribuidor(distribuidores.get(j));
			       	 		realizado = 1;
			       	 	}
					}
					if (realizado == 0) {
				       	System.out.print("El proveedor que ha introducido, no existe en la base de datos. Introduzca uno valido: ");
				       	distribuidorLechuga = sc.next();
					}
				}
				lechugas.add(lechuga);
	        }

	        // Solicitud de leche
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\nIntroduce los datos de LECHE(S):");
	        for (int i=0; i<2; i++) {
	        	Leche leche = new Leche();
		        System.out.println("\n/// Leche " + (i+1) + " :");
		        System.out.print("Tipo de leche: ");
				leche.setTipoLeche(sc.next());
		        System.out.print("Procedencia: ");
				leche.setProcedencia(sc.next());
		        System.out.print("Precio (Euros/litro): ");
				leche.setEurosLitro(sc.nextDouble());
		        System.out.print("Distribuidor: ");
				String distribuidorLeche = sc.next();

				int realizado = 0;

				while (realizado == 0) {
					for (int j=0; j<distribuidores.size(); j++) {
		        		if (distribuidorLeche.equalsIgnoreCase(distribuidores.get(j).getNombre())) {
		        			leche.setDistribuidor(distribuidores.get(j));
			       	 		realizado = 1;
			       	 	}
					}
					if (realizado == 0) {
						System.out.print("El proveedor que ha introducido, no existe en la base de datos. Introduzca uno valido: ");
				    	distribuidorLeche = sc.next();
					}
				}
				leches.add(leche);
	        }


			/////////////////////////////////////////////////////////
		    //// RECOJER LOS DATOS INTRODUCIDOS DE LOS PRODUCTOS ////
		   	/////////////// Y MOSTRARLOS EN PANTALLA ////////////////
		    /////////////////////////////////////////////////////////


	        // Mostrar datos de las manzanas
	        for (int i=0; i<manzanas.size(); i++) {
	        	System.out.println("\n- Manzana " + (i+1) + " :");
	        	System.out.println("   - Tipo de Manzana: " + manzanas.get(i).getTipoManzana());
	        	System.out.println("   - Procedencia: " + manzanas.get(i).getProcedencia());
	        	System.out.println("   - Color: " + manzanas.get(i).getColor());
	        	System.out.println("   - Precio (Euros/kilo): " + manzanas.get(i).getEurosKilo());
	        	System.out.println("   - Distribuidor:");
	        	System.out.println("       - Nombre: " + manzanas.get(i).getDistribuidor().getNombre());
	        	System.out.println("       - CIF: " + manzanas.get(i).getDistribuidor().getCif());
	        	System.out.println("       - Direccion: ");
	        	System.out.println("           - Calle: " + manzanas.get(i).getDistribuidor().getDireccion().getCalle());
	        	System.out.println("           - Numero: " + manzanas.get(i).getDistribuidor().getDireccion().getNumero());
	        	System.out.println("           - Piso: " + manzanas.get(i).getDistribuidor().getDireccion().getPiso());
	        	System.out.println("           - Ciudad: " + manzanas.get(i).getDistribuidor().getDireccion().getCiudad());
	        	System.out.println("           - Provincia: " + manzanas.get(i).getDistribuidor().getDireccion().getProvincia());
	        	System.out.println("           - Codigo Postal: " + manzanas.get(i).getDistribuidor().getDireccion().getCodigoPostal());
	        	System.out.println("       - Contacto:");
	        	System.out.println("           - Nombre: " + manzanas.get(i).getDistribuidor().getPersonaContacto().getNombre());
	        	System.out.println("           - Apellidos: " + manzanas.get(i).getDistribuidor().getPersonaContacto().getApellidos());
	        	System.out.println("           - Telefono: " + manzanas.get(i).getDistribuidor().getPersonaContacto().getTelefono());
	        	System.out.println("           - Edad: " + manzanas.get(i).getDistribuidor().getPersonaContacto().getEdad());
	        }

	        // Mostrar datos de las lechugas
	        for (int i=0; i<lechugas.size(); i++) {
	        	System.out.println("\n- Lechuga " + (i+1) + " :");
	        	System.out.println("   - Tipo de Lechuga: " + lechugas.get(i).getTipoLechuga());
	        	System.out.println("   - Procedencia: " + lechugas.get(i).getProcedencia());
	        	System.out.println("   - Color: " + lechugas.get(i).getColor());
	        	System.out.println("   - Precio (Euros/kilo): " + lechugas.get(i).getEurosUnidad());
	        	System.out.println("   - Distribuidor:");
	        	System.out.println("       - Nombre: " + lechugas.get(i).getDistribuidor().getNombre());
	        	System.out.println("       - CIF: " + lechugas.get(i).getDistribuidor().getCif());
	        	System.out.println("       - Direccion: ");
	        	System.out.println("           - Calle: " + lechugas.get(i).getDistribuidor().getDireccion().getCalle());
	        	System.out.println("           - Numero: " + lechugas.get(i).getDistribuidor().getDireccion().getNumero());
	        	System.out.println("           - Piso: " + lechugas.get(i).getDistribuidor().getDireccion().getPiso());
	        	System.out.println("           - Ciudad: " + lechugas.get(i).getDistribuidor().getDireccion().getCiudad());
	        	System.out.println("           - Provincia: " + lechugas.get(i).getDistribuidor().getDireccion().getProvincia());
	        	System.out.println("           - Codigo Postal: " + lechugas.get(i).getDistribuidor().getDireccion().getCodigoPostal());
	        	System.out.println("       - Contacto:");
	        	System.out.println("           - Nombre: " + lechugas.get(i).getDistribuidor().getPersonaContacto().getNombre());
	        	System.out.println("           - Apellidos: " + lechugas.get(i).getDistribuidor().getPersonaContacto().getApellidos());
	        	System.out.println("           - Telefono: " + lechugas.get(i).getDistribuidor().getPersonaContacto().getTelefono());
	        	System.out.println("           - Edad: " + lechugas.get(i).getDistribuidor().getPersonaContacto().getEdad());
	        }
	    }

	    // Si se produce algun error, se mostrara en pantalla.
	    catch(Exception error){
	    	System.out.println("Error: "+ error);
	    }

	}
}