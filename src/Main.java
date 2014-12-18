// Programa para leer los datos de un fichero, guardarlos en un arraylist, y despues mostrarlos en pantalla.

// Importar librerias
import java.util.*;
import java.io.*;

public class Main {

	public static void main (String args[]) throws IOException {	

		Scanner sc = new Scanner(System.in);
		ArrayList <Distribuidor> distribuidores = new ArrayList <Distribuidor>();
		ArrayList <Manzana> manzanasCesta = new ArrayList <Manzana>();
		ArrayList <Lechuga> lechugasCesta = new ArrayList <Lechuga>();
		ArrayList <Leche> lechesCesta = new ArrayList <Leche>();

		ArrayList <Manzana> manzanasIntro = new ArrayList <Manzana>();
		ArrayList <Lechuga> lechugasIntro = new ArrayList <Lechuga>();
		ArrayList <Leche> lechesIntro = new ArrayList <Leche>();


		////////////////////////////////////////////////
	    //// GUARDAR DATOS DEL FICHERO EN ARRAYLIST ////
	    ////////// Y MOSTRARLOS EN PANTALLA ////////////
	    ////////////////////////////////////////////////

		try {

 			File archivo = new File("/home/zubiri/proyectosjava/java2_Almacen/src/distribuidores.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader bf = new BufferedReader(fr);
			String linea = bf.readLine();
	       
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


	        // Solicitud de manzanas
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\nIntroduzca los datos de MANZANA(S):");
	        for (int i=0; i<2; i++) {
	        	Manzana manzana = new Manzana();
		        System.out.println("\n/// Manzana " + (i+1) + ":");
		        System.out.print("Tipo de manzana: ");
				manzana.setTipoManzana(sc.next());
		        System.out.print("Procedencia: ");
				manzana.setProcedencia(sc.next());
		        System.out.print("Color: ");
				manzana.setColor(sc.next());
		        System.out.print("Precio (Euros/kilo): ");
				manzana.setEurosKilo(sc.nextDouble());
		        System.out.print("Codigo de Barras: ");
				manzana.setCodigoBarras(sc.next());
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
				       	System.out.print("El proveedor que ha introducido, no existe. Introduzca uno valido: ");
				       	distribuidorManzana = sc.next();
					}
				}
				manzanasIntro.add(manzana);
	        } 

	        // Solicitud de lechugas
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\nIntroduzca los datos de LECHUGA(S):");
	        for (int i=0; i<1; i++) {
	        	Lechuga lechuga = new Lechuga();
		        System.out.println("\n/// Lechuga " + (i+1) + ":");
		        System.out.print("Tipo de lechuga: ");
				lechuga.setTipoLechuga(sc.next());
		        System.out.print("Procedencia: ");
				lechuga.setProcedencia(sc.next());
		        System.out.print("Color: ");
				lechuga.setColor(sc.next());
		        System.out.print("Precio (Euros/unidad): ");
				lechuga.setEurosUnidad(sc.nextDouble());
		        System.out.print("Codigo de Barras: ");
				lechuga.setCodigoBarras(sc.next());
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
				       	System.out.print("El proveedor que ha introducido, no existe. Introduzca uno valido: ");
				       	distribuidorLechuga = sc.next();
					}
				}
				lechugasIntro.add(lechuga);
	        }

	        // Solicitud de leche
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\nIntroduzca los datos de LECHE(S):");
	        for (int i=0; i<2; i++) {
	        	Leche leche = new Leche();
		        System.out.println("\n/// Leche " + (i+1) + ":");
		        System.out.print("Tipo de leche: ");
				leche.setTipoLeche(sc.next());
		        System.out.print("Procedencia: ");
				leche.setProcedencia(sc.next());
		        System.out.print("Precio (Euros/litro): ");
				leche.setEurosLitro(sc.nextDouble());
		        System.out.print("Codigo de Barras: ");
				leche.setCodigoBarras(sc.next());
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
						System.out.print("El proveedor que ha introducido, no existe. Introduzca uno valido: ");
				    	distribuidorLeche = sc.next();
					}
				}
				lechesIntro.add(leche);
	        }


			/////////////////////////////////////////////////////////
		    //// RECOJER LOS DATOS INTRODUCIDOS DE LOS PRODUCTOS ////
		   	/////////////// Y MOSTRARLOS EN PANTALLA ////////////////
		    /////////////////////////////////////////////////////////


	        // Mostrar datos de las manzanas
	        for (int i=0; i<manzanasIntro.size(); i++) {
	        	System.out.println("\n- Manzana " + (i+1) + ":");
	        	System.out.println("   - Tipo de Manzana: " + manzanasIntro.get(i).getTipoManzana());
	        	System.out.println("   - Procedencia: " + manzanasIntro.get(i).getProcedencia());
	        	System.out.println("   - Color: " + manzanasIntro.get(i).getColor());
	        	System.out.println("   - Precio (Euros/Kilo): " + manzanasIntro.get(i).getEurosKilo());
	        	System.out.println("   - Codigo de Barras: " + manzanasIntro.get(i).getCodigoBarras());
	        	System.out.println("   - Distribuidor:");
	        	System.out.println("       - Nombre: " + manzanasIntro.get(i).getDistribuidor().getNombre());
	        	System.out.println("       - CIF: " + manzanasIntro.get(i).getDistribuidor().getCif());
	        	System.out.println("       - Direccion: ");
	        	System.out.println("           - Calle: " + manzanasIntro.get(i).getDistribuidor().getDireccion().getCalle());
	        	System.out.println("           - Numero: " + manzanasIntro.get(i).getDistribuidor().getDireccion().getNumero());
	        	System.out.println("           - Piso: " + manzanasIntro.get(i).getDistribuidor().getDireccion().getPiso());
	        	System.out.println("           - Ciudad: " + manzanasIntro.get(i).getDistribuidor().getDireccion().getCiudad());
	        	System.out.println("           - Provincia: " + manzanasIntro.get(i).getDistribuidor().getDireccion().getProvincia());
	        	System.out.println("           - Codigo Postal: " + manzanasIntro.get(i).getDistribuidor().getDireccion().getCodigoPostal());
	        	System.out.println("       - Contacto:");
	        	System.out.println("           - Nombre: " + manzanasIntro.get(i).getDistribuidor().getPersonaContacto().getNombre());
	        	System.out.println("           - Apellidos: " + manzanasIntro.get(i).getDistribuidor().getPersonaContacto().getApellidos());
	        	System.out.println("           - Telefono: " + manzanasIntro.get(i).getDistribuidor().getPersonaContacto().getTelefono());
	        	System.out.println("           - Edad: " + manzanasIntro.get(i).getDistribuidor().getPersonaContacto().getEdad());
	        }

	        // Mostrar datos de las lechugas
	        for (int i=0; i<lechugasIntro.size(); i++) {
	        	System.out.println("\n- Lechuga " + (i+1) + ":");
	        	System.out.println("   - Tipo de Lechuga: " + lechugasIntro.get(i).getTipoLechuga());
	        	System.out.println("   - Procedencia: " + lechugasIntro.get(i).getProcedencia());
	        	System.out.println("   - Color: " + lechugasIntro.get(i).getColor());
	        	System.out.println("   - Precio (Euros/Unidad): " + lechugasIntro.get(i).getEurosUnidad());
	        	System.out.println("   - Codigo de Barras: " + lechugasIntro.get(i).getCodigoBarras());
	        	System.out.println("   - Distribuidor:");
	        	System.out.println("       - Nombre: " + lechugasIntro.get(i).getDistribuidor().getNombre());
	        	System.out.println("       - CIF: " + lechugasIntro.get(i).getDistribuidor().getCif());
	        	System.out.println("       - Direccion: ");
	        	System.out.println("           - Calle: " + lechugasIntro.get(i).getDistribuidor().getDireccion().getCalle());
	        	System.out.println("           - Numero: " + lechugasIntro.get(i).getDistribuidor().getDireccion().getNumero());
	        	System.out.println("           - Piso: " + lechugasIntro.get(i).getDistribuidor().getDireccion().getPiso());
	        	System.out.println("           - Ciudad: " + lechugasIntro.get(i).getDistribuidor().getDireccion().getCiudad());
	        	System.out.println("           - Provincia: " + lechugasIntro.get(i).getDistribuidor().getDireccion().getProvincia());
	        	System.out.println("           - Codigo Postal: " + lechugasIntro.get(i).getDistribuidor().getDireccion().getCodigoPostal());
	        	System.out.println("       - Contacto:");
	        	System.out.println("           - Nombre: " + lechugasIntro.get(i).getDistribuidor().getPersonaContacto().getNombre());
	        	System.out.println("           - Apellidos: " + lechugasIntro.get(i).getDistribuidor().getPersonaContacto().getApellidos());
	        	System.out.println("           - Telefono: " + lechugasIntro.get(i).getDistribuidor().getPersonaContacto().getTelefono());
	        	System.out.println("           - Edad: " + lechugasIntro.get(i).getDistribuidor().getPersonaContacto().getEdad());
	        }
	    }

	    // Si se produce algun error, se mostrara en pantalla.
	    catch(Exception error){
	    	System.out.println("Error: "+ error);
	    }


		ArrayList <Cliente> clientes = new ArrayList <Cliente>();
		
		////////////////////////////////////////////////
	    //// GUARDAR DATOS DEL FICHERO EN ARRAYLIST ////
	    ////////// Y MOSTRARLOS EN PANTALLA ////////////
	    ////////////////////////////////////////////////

		try {

 			File archivo = new File("/home/zubiri/proyectosjava/java2_Almacen/src/clientes.txt");
			FileReader fr2 = new FileReader (archivo);
			BufferedReader bf2 = new BufferedReader(fr2);
			String linea = bf2.readLine();
	       
	        // 1.- Leer los datos y guardarlos en el arraylist
	        while(linea!=null) {

	        	// Separar la linea leida en partes (2); teniendo "/ " como patron.
	        	String [] lineaPartida = linea.split("/ ");

	        	// Las partes obtenidas de la linea, las vuelve a dividir en partes, con "," como patron.
	       	 	String [] parte1 = lineaPartida[0].split(",");
	       		String [] parte2 = lineaPartida[1].split(",");
	        	
	        	// Se crean los objetos necesarios para despues asignarles los valores.
	       		Cliente cliente = new Cliente();
	       		Direccion direccion = new Direccion();

	       		// Al objeto direccion se le asignan los valores obtenidos desde el fichero.
	       		direccion.setCalle(parte2[0]);
	       		direccion.setNumero(Integer.parseInt(parte2[1]));
	       		direccion.setPiso(parte2[2]);
	       		direccion.setCiudad(parte2[3]);
	     		direccion.setProvincia(parte2[4]);
	       		direccion.setCodigoPostal(Integer.parseInt(parte2[5]));

	      		// Al objeto cliente se le asignan los valores obtenidos desde el fichero.
	       		cliente.setNombre(parte1[0]);
	       		cliente.setApellidos(parte1[1]);
	       		cliente.setDni(parte1[2]);
	       		cliente.setNumSocio(Integer.parseInt(parte1[3]));
	       		cliente.setDto(Double.parseDouble(parte1[4]));
	       		cliente.setDireccion(direccion);

	       		// Añade 'cliente' al arraylist 'clientes'.       		       		
	       		clientes.add(cliente);

	       		// Lee otra linea del fichero.
	       		linea = bf2.readLine();
	        }

	        // Salto de linea vistoso
	        System.out.println("\n///////////////////////////////////////");
	        System.out.println("\n///////////////////////////////////////");


	        // 2.- Mostrar los datos del arraylist
	        System.out.println("\nA continuacion se muestran los datos de los clientes:");
	        for (int i=0; i<clientes.size(); i++) {
	        	System.out.println("\n//// Cliente " + (i+1));

	        	// Datos del cliente
	        	System.out.println("- Nombre: " + clientes.get(i).getNombre());
	        	System.out.println("- Apellidos: " + clientes.get(i).getApellidos());
	        	System.out.println("- DNI: " + clientes.get(i).getDni());
	        	System.out.println("- Numero de socio: " + clientes.get(i).getNumSocio());
	        	System.out.println("- Descuento: " + clientes.get(i).getDto());

	        	// Datos de la direccion
	        	System.out.println("- Direccion:");
	        	System.out.println("   - Calle: " + clientes.get(i).getDireccion().getCalle());
	        	System.out.println("   - Numero: " + clientes.get(i).getDireccion().getNumero());
	        	System.out.println("   - Piso: " + clientes.get(i).getDireccion().getPiso());
	        	System.out.println("   - Ciudad: " + clientes.get(i).getDireccion().getCiudad());
	        	System.out.println("   - Provincia: " + clientes.get(i).getDireccion().getProvincia());
	        	System.out.println("   - Codigo Postal: " + clientes.get(i).getDireccion().getCodigoPostal());
	        }
	    }

	    // Si se produce algun error, se mostrara en pantalla.
	    catch(Exception error){
	    	System.out.println("Error: "+ error);
	    }


		
		////////////////////////////////////////////////
	    //////// INTRODUCIR PRODUCTOS A LA CESTA ///////
	    //////////// Y CALCULAR EL IMPORTE /////////////
	    ////////////////////////////////////////////////

	    // Salto de linea vistoso
	    System.out.println("\n///////////////////////////////////////");
	    System.out.println("\n///////////////////////////////////////");

	    System.out.println("\nCreando cesta de la compra... ");
	    Cesta cesta = new Cesta();

		System.out.print("\nElige el DNI del cliente:\n");
		for (int i=0; i<clientes.size(); i++) {
			System.out.println(clientes.get(i).getDni());
		}
	    System.out.print("\nIntroduzca el DNI del cliente: ");
	    String dniIntro = sc.next();

	    int realizado = 0;

		while (realizado == 0) {
			for (int i=0; i<clientes.size(); i++) {
			    if (dniIntro.equalsIgnoreCase(clientes.get(i).getDni())) {
			        cesta.setCliente(clientes.get(i));
				    realizado = 1;
				}
			}
			if (realizado == 0) {
				System.out.print("\nEl DNI que ha introducido, no existe. Introduzca uno valido: ");
				dniIntro = sc.next();
			}
		}

	    int salir = 0;

	    while (salir == 0) {
	    	System.out.print("\nIntroduzca el codigo de barras del producto (Para salir introduzca '0'): ");
		    String codigoBarrasIntro = sc.next();
		   	realizado = 0;
	    	switch (codigoBarrasIntro) {

                case "0": 
		    		salir = 1;
		    		realizado = 1;
                	break;

                default: 
					while (realizado == 0) {
						for (int i=0; i<manzanasIntro.size(); i++) {
				        	if (codigoBarrasIntro.equalsIgnoreCase(manzanasIntro.get(i).getCodigoBarras())) {
				        		manzanasCesta.add(manzanasIntro.get(i));
					       		realizado = 1;
					       	}
						}
						for (int i=0; i<lechugasIntro.size(); i++) {
				        	if (codigoBarrasIntro.equalsIgnoreCase(lechugasIntro.get(i).getCodigoBarras())) {
				        		lechugasCesta.add(lechugasIntro.get(i));
					       		realizado = 1;
					       	}
						}
						for (int i=0; i<lechesIntro.size(); i++) {
				        	if (codigoBarrasIntro.equalsIgnoreCase(lechesIntro.get(i).getCodigoBarras())) {
				        		lechesCesta.add(lechesIntro.get(i));
					       		realizado = 1;
					       	}
						}
						if (realizado == 0) {
							System.out.print("\nEl codigo que ha introducido, no existe. Introduzca uno valido: ");
						   	codigoBarrasIntro = sc.next();
						}
					}
                    break;
	    	}
	    }
	  

	    cesta.setManzanas(manzanasCesta);
	    cesta.setLeches(lechesCesta);
	    cesta.setLechugas(lechugasCesta);
	    cesta.setImporte();

	    // Datos de la compra
	    System.out.println("\nDATOS DE LA COMPRA");

	    // Datos del cliente
	    System.out.println("\n- Datos del cliente:");
	    System.out.println("-    Nombre: " + cesta.getCliente().getNombre());
	    System.out.println("-    Apellidos: " + cesta.getCliente().getApellidos());
	    System.out.println("-    DNI: " + cesta.getCliente().getDni());
	    System.out.println("-    Numero de socio: " + cesta.getCliente().getNumSocio());
	    System.out.println("-    Descuento: " + cesta.getCliente().getDto());
	    System.out.println("-    Direccion:");
	    System.out.println("      - Calle: " + cesta.getCliente().getDireccion().getCalle());
	    System.out.println("      - Numero: " + cesta.getCliente().getDireccion().getNumero());
	    System.out.println("      - Piso: " + cesta.getCliente().getDireccion().getPiso());
	    System.out.println("      - Ciudad: " + cesta.getCliente().getDireccion().getCiudad());
	    System.out.println("      - Provincia: " + cesta.getCliente().getDireccion().getProvincia());
	    System.out.println("      - Codigo Postal: " + cesta.getCliente().getDireccion().getCodigoPostal());

	    // Datos de la cesta
	    System.out.println("\n- Productos de la cesta:");

	    for (int i=0; i<cesta.getManzanas().size(); i++) {
	    	System.out.println("-    Manzana " + (i+1) + ":");
	        System.out.println("      - Tipo de Manzana: " + cesta.getManzanas().get(i).getTipoManzana());	        	
	        System.out.println("      - Procedencia: " + cesta.getManzanas().get(i).getProcedencia());
	        System.out.println("      - Color: " + cesta.getManzanas().get(i).getColor());
	        System.out.println("      - Precio (Euros/kilo): " + cesta.getManzanas().get(i).getEurosKilo());
	        System.out.println("      - Codigo de Barras: " + cesta.getManzanas().get(i).getCodigoBarras());
	    }

	    for (int i=0; i<cesta.getLechugas().size(); i++) {
	    	System.out.println("-    Lechuga " + (i+1) + ":");
	        System.out.println("      - Tipo de Lechuga: " + cesta.getLechugas().get(i).getTipoLechuga());	        	
	        System.out.println("      - Procedencia: " + cesta.getLechugas().get(i).getProcedencia());
	        System.out.println("      - Color: " + cesta.getLechugas().get(i).getColor());
	        System.out.println("      - Precio (Euros/Unidad): " + cesta.getLechugas().get(i).getEurosUnidad());
	        System.out.println("      - Codigo de Barras: " + cesta.getLechugas().get(i).getCodigoBarras());
	    }

	    for (int i=0; i<cesta.getLeches().size(); i++) {
	    	System.out.println("-    Leche " + (i+1) + ":");
	        System.out.println("      - Tipo de Leche: " + cesta.getLeches().get(i).getTipoLeche());	        	
	        System.out.println("      - Procedencia: " + cesta.getLeches().get(i).getProcedencia());
	        System.out.println("      - Precio (Euros/Litro): " + cesta.getLeches().get(i).getEurosLitro());
	        System.out.println("      - Codigo de Barras: " + cesta.getLeches().get(i).getCodigoBarras());
	    }

	    // Importe de la cesta
		System.out.println("\nIMPORTE: " + cesta.getImporte() + "\n");

	}
}