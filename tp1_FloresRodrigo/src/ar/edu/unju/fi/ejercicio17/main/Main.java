package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static final Scanner scanner = new Scanner(System.in);
	static final ArrayList<Jugador> jugadores = new ArrayList<>();
	
	public static void main(String[] args) {
		int op;
		
		do {
			mostrarMenu();
			op = seleccionarOpcion();
			switch(op) {
				case 1 : System.out.println("*ANIADIR JUGADOR*");
						altaJugador();
						pausa();
						break;
				case 2 : System.out.println("*MOSTRAR DATOS DE UN JUGADOR*");
						if(jugadores.isEmpty()) {
							System.out.println("No hay jugadores cargados");
						} else {
							mostrarDatosDeUnJugador();
						}
						pausa();
						break;
				case 3 : System.out.println("MOSTRAR JUGADORES ORDENADOS POR APELLIDO");
						if(jugadores.isEmpty()) {
							System.out.println("No hay jugadores cargados");
						} else {
							mostrarJugadoresOrdenados();
						}
						pausa();
						break;
				case 4 : System.out.println("*MODIFICAR JUGADOR INDICANDO NOMBRE Y APELLIDO*");
						if(jugadores.isEmpty()) {
							System.out.println("No hay jugadores cargados");
						} else {
							editarJugador();
						}
						pausa();
						break;
				case 5 : System.out.println("*ELIMINAR JUGADOR INDICANDO NOMBRE Y APELLIDO*");
						if(jugadores.isEmpty()) {
							System.out.println("No hay jugadores cargados");
						} else {
							eliminarJugador();
						}
						pausa();
						break;
				case 6 : System.out.println("*CANTIDAD DE JUGADORES REGISTRADOS*");
						System.out.println("Cantidad de jugadores: "+jugadores.size());
						pausa();
						break;
				case 7 : System.out.println("*CANTIDAD DE JUGADORES DE CIERTA NACIONALIDAD*");
						if(jugadores.isEmpty()) {
							System.out.println("No hay jugadores cargados");
						} else {
							jugadoresNacionalidad();
						}
						pausa();
						break;
				case 8 : System.out.println("*SALIENDO DEL PROGRAMA*");
						pausa();
						break;
				default : System.out.println("Opcion no valida");
						pausa();
			}
		}while(op != 8);
	}
	
	public static void mostrarMenu(){
		System.out.println("""
				Menu de opciones:
				1 - Alta de jugador
				2 - Mostrar datos de jugador
				3 - Mostrar jugadores ordenados por apellido
				4 - Modificar datos de un jugador
				5 - Eliminar un jugador
				6 - Mostrar cantidad total de jugadores
				7 - Mostrar jugadores que pertenecen a una nacionalidad
				8 - Salir
				""");
	}
	
	public static int seleccionarOpcion() {
        int op;

        while (true) {
            try {
                System.out.print("Seleccione una opcion: ");
                op = Byte.parseByte(scanner.nextLine());
                return op;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Solo se permite el ingreso de numeros. Ingrese un numero de la lista");
            }
        }
    }
	
	public static void pausa() {
		System.out.println("Presione enter para continuar");
		scanner.nextLine();
	}
	
	public static void altaJugador() {
        Jugador jugador = new Jugador();
        
        System.out.print("Ingrese el nombre del jugador: ");
        jugador.setNombre(scanner.nextLine());
        
        System.out.print("Ingrese el apellido del jugador: ");
        jugador.setApellido(scanner.nextLine());
        
        LocalDate fechaNacimiento = null;
        while(fechaNacimiento == null) {
        	try {
		        System.out.print("Ingrese fecha de nacimiento del jugador en formato yyyy-mm-dd: ");
		        fechaNacimiento = LocalDate.parse(scanner.nextLine());
        	} catch (DateTimeParseException e) {
        		System.out.println("Formato de fecha no valido");
        	}
        }
        jugador.setFechaNac(fechaNacimiento);
        
        System.out.print("Ingrese la nacionalidad del jugador: ");
        jugador.setNacionalidad(scanner.nextLine());
        
        double estatura = 0.0;
        while(estatura == 0.0) {
        	try {
        		System.out.print("Ingrese la estatura del jugador (solamente numeros, para los decimales utilice ','): ");
        		estatura = scanner.nextDouble();
        		if(estatura <= 0) {
        			throw new NumberFormatException();
        		}
        	} catch (NumberFormatException e) {
        		System.out.println("Ingrese una estatura valida");
        		scanner.nextLine();
        		estatura = 0.0;
        	} catch (InputMismatchException e) {
        		System.out.println("Ingrese solo numeros");
        		scanner.nextLine();
        		estatura = 0.0;
        	}
        }
        jugador.setEstatura(estatura);
        
        double peso = 0.0;
        while(peso == 0.0) {
        	try {
        		System.out.print("Ingrese el peso del jugador (solamente numeros, para los decimales utilice ','): ");
        		peso = scanner.nextDouble();
        		if(peso <= 0) {
        			throw new NumberFormatException();
        		}
        	} catch (NumberFormatException e) {
        		System.out.println("Ingrese un peso valido");
        		scanner.nextLine();
        		peso = 0.0;
        	} catch (InputMismatchException e) {
        		System.out.println("Ingrese solo numeros");
        		scanner.nextLine();
        		peso = 0.0;
        	} 
        }
        jugador.setPeso(peso);
        
        System.out.println("Elija la posicion del jugador: ");
        String[] posiciones = Jugador.getPosiciones();
        for (int i = 0; i < posiciones.length; i++) {
            System.out.println((i + 1) + " - " + posiciones[i]);
        }
        int opcion = 0;
        boolean valido = false;
        
        do {
        	try {
	            System.out.print("Ingrese el numero de la posicion: ");
	            opcion = scanner.nextInt();
	            if (opcion < 1 || opcion > posiciones.length) {
	                System.out.println("Opcion invalida. Elija una opcion valida");
	            } else {
	            	valido = true;
	            }
        	} catch (InputMismatchException e){
        		System.out.println("Ingrese una opcion entre lo mostrado");
        		scanner.nextLine();
        	}
        } while (!valido);

        jugador.setPosicion(posiciones[opcion - 1]);

        
        jugadores.add(jugador);
        
        System.out.println("Jugador aniadido correctamente");
    }
	
	public static void mostrarDatosDeUnJugador() {
		System.out.print("Ingrese nombre del jugador a mostrar: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese apellido del jugador a mostrar: ");
		String apellido = scanner.nextLine();
		
		boolean encontrado = false;
		for(Jugador jugador : jugadores) {
			if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				encontrado = true;
				System.out.println("\n----------Datos del jugador----------");
				System.out.println("Nombre: "+jugador.getNombre());
				System.out.println("Apellido: "+jugador.getApellido());
				System.out.println("Fecha de nacimiento: "+jugador.getFechaNac());
				System.out.println("Nacionalidad: "+jugador.getNacionalidad());
				System.out.println("Estatura: "+jugador.getEstatura());
				System.out.println("Peso: "+jugador.getPeso());
				System.out.println("Edad: "+jugador.calcularEdad());
				System.out.println("Posicion: "+jugador.getPosicion());
				System.out.println("-------------------------------------");
			}
		}
		if(!encontrado) {
			System.out.println("El jugador no fue encontrado");
		}
	}
	
	public static void mostrarJugadoresOrdenados() {
		jugadores.sort(Comparator.comparing(Jugador::getApellido));
		for(Jugador jugador: jugadores) {
			System.out.println("\n----------Datos del jugador----------");
			System.out.println("Nombre: "+jugador.getNombre());
			System.out.println("Apellido: "+jugador.getApellido());
			System.out.println("Fecha de nacimiento: "+jugador.getFechaNac());
			System.out.println("Nacionalidad: "+jugador.getNacionalidad());
			System.out.println("Estatura: "+jugador.getEstatura());
			System.out.println("Peso: "+jugador.getPeso());
			System.out.println("Edad: "+jugador.calcularEdad());
			System.out.println("Posicion: "+jugador.getPosicion());
			System.out.println("-------------------------------------");
		}
	}
	
	public static void editarJugador() {
		boolean encontrado = false;
		System.out.print("Ingrese nombre del jugador a editar: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese apellido del jugador a editar: ");
		String apellido = scanner.nextLine();
		
		for(Jugador jugador : jugadores) {
			if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				encontrado = true;
				System.out.print("Ingrese el nombre del jugador: ");
		        jugador.setNombre(scanner.nextLine());
		        
		        System.out.print("Ingrese el apellido del jugador: ");
		        jugador.setApellido(scanner.nextLine());
		        
		        LocalDate fechaNacimiento = null;
		        while(fechaNacimiento == null) {
		        	try {
				        System.out.print("Ingrese fecha de nacimiento del jugador en formato yyyy-mm-dd: ");
				        fechaNacimiento = LocalDate.parse(scanner.nextLine());
		        	} catch (DateTimeParseException e) {
		        		System.out.println("Formato de fecha no valido");
		        	}
		        }
		        jugador.setFechaNac(fechaNacimiento);
		        
		        System.out.print("Ingrese la nacionalidad del jugador: ");
		        jugador.setNacionalidad(scanner.nextLine());
		        
		        double estatura = 0.0;
		        while(estatura == 0.0) {
		        	try {
		        		System.out.print("Ingrese la estatura del jugador (solamente numeros, para los decimales utilice ','): ");
		        		estatura = scanner.nextDouble();
		        		if(estatura <= 0) {
		        			throw new NumberFormatException();
		        		}
		        	} catch (NumberFormatException e) {
		        		System.out.println("Ingrese una estatura valida");
		        		scanner.nextLine();
		        		estatura = 0.0;
		        	} catch (InputMismatchException e) {
		        		System.out.println("Ingrese solo numeros");
		        		scanner.nextLine();
		        		estatura = 0.0;
		        	}
		        }
		        jugador.setEstatura(estatura);
		        
		        double peso = 0.0;
		        while(peso == 0.0) {
		        	try {
		        		System.out.print("Ingrese el peso del jugador (solamente numeros, para los decimales utilice ','): ");
		        		peso = scanner.nextDouble();
		        		if(peso <= 0) {
		        			throw new NumberFormatException();
		        		}
		        	} catch (NumberFormatException e) {
		        		System.out.println("Ingrese un peso valido");
		        		scanner.nextLine();
		        		peso = 0.0;
		        	} catch (InputMismatchException e) {
		        		System.out.println("Ingrese solo numeros");
		        		scanner.nextLine();
		        		peso = 0.0;
		        	} 
		        }
		        jugador.setPeso(peso);
		        
		        System.out.println("Elija la posicion del jugador: ");
		        String[] posiciones = Jugador.getPosiciones();
		        for (int i = 0; i < posiciones.length; i++) {
		            System.out.println((i + 1) + " - " + posiciones[i]);
		        }
		        int opcion = 0;
		        boolean valido = false;
		        
		        do {
		        	try {
			            System.out.print("Ingrese el numero de la posicion: ");
			            opcion = scanner.nextInt();
			            if (opcion < 1 || opcion > posiciones.length) {
			                System.out.println("Opcion invalida. Elija una opcion valida");
			            } else {
			            	valido = true;
			            }
		        	} catch (InputMismatchException e){
		        		System.out.println("Ingrese una opcion entre lo mostrado");
		        		scanner.nextLine();
		        	}
		        } while (!valido);

		        jugador.setPosicion(posiciones[opcion - 1]);
			}
		}
		if(encontrado) {
			System.out.println("Jugador modificado");
		} else {
			System.out.println("Jugador no encontrado");
		}
	}
	
	public static void eliminarJugador() {
		Iterator<Jugador> iterator = jugadores.iterator();
		Jugador jugador;
		boolean encontrado = false;
		
		System.out.print("Ingrese nombre del jugador a eliminar: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese apellido del jugador a eliminar: ");
		String apellido = scanner.nextLine();
		
		while(iterator.hasNext()) {
			jugador = iterator.next();
			if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				iterator.remove();
				encontrado = true;
			}
		}
		if(encontrado) {
			System.out.println("Jugador eliminado");
		} else {
			System.out.println("Jugador no encontrado");
		}
	}
	
	public static void jugadoresNacionalidad() {
		System.out.print("Ingrese nombre del pais: ");
		String pais = scanner.nextLine();
		
		int contador = 0;
		for(Jugador jugador : jugadores) {
			if(jugador.getNacionalidad().equalsIgnoreCase(pais)) {
				contador++;
			}
		}
		System.out.println("La cantidad de jugadores de "+pais+" es: "+contador);
	}
}
