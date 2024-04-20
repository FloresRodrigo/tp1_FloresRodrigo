package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
	static final Scanner scanner = new Scanner(System.in);
	static final ArrayList<DestinoTuristico> destinos = new ArrayList<>();
	static final ArrayList<Pais> paises = new ArrayList<>();

	public static void main(String[] args) {
		int op;

		paises.add(new Pais(1, "Argentina"));
		paises.add(new Pais(2, "USA"));
		paises.add(new Pais(3, "China"));

		do {
			mostrarMenu();
			op = seleccionarOpcion();
			switch (op) {
			case 1:
				altaDestinoTuristico();
				pausa();
				break;
			case 2:
				mostrarDestinosTuristicos();
				pausa();
				break;
			case 3:
				modificarPaisDestinoTuristico();
				pausa();
				break;
			case 4:
				limpiarDestinosTuristicos();
				pausa();
				break;
			case 5:
				eliminarDestinoTuristico();
				pausa();
				break;
			case 6:
				mostrarDestinosPorPais();
				pausa();
				break;
			case 7:
				mostrarTodosPaises();
				pausa();
				break;
			case 8:
				mostrarDestinosPorPaisSeleccionado();
				pausa();
				break;
			case 9:
				System.out.println("*SALIENDO DEL PROGRAMA*");
				break;
			default:
				System.out.println("Opcion no valida");
				pausa();
			}
		} while (op != 9);
	}

	public static void mostrarMenu() {
		System.out.println("""
				Menu de opciones:
				1 - Alta de destino turistico
				2 - Mostrar todos los destinos turisticos
				3 - Modificar el pais de un destino turistico
				4 - Limpiar la lista de destinos turisticos
				5 - Eliminar un destino turistico
				6 - Mostrar destinos turisticos ordenados por pais
				7 - Mostrar todos los paises
				8 - Mostrar destinos turisticos por pais
				9 - Salir
				""");
	}

	public static int seleccionarOpcion() {
		int op;

		while (true) {
			try {
				System.out.print("Seleccione una opcion: ");
				op = Integer.parseInt(scanner.nextLine());
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

	public static void altaDestinoTuristico() {
		System.out.println("*ALTA DE DESTINO TURISTICO*");
		
		try {
			System.out.print("Ingrese el codigo del destino turistico: ");
			int codigo = Integer.parseInt(scanner.nextLine());

			System.out.print("Ingrese el nombre del destino turistico: ");
			String nombre = scanner.nextLine();

			System.out.print("Ingrese el precio del destino turistico: ");
			double precio = Double.parseDouble(scanner.nextLine());

			int codigoPais = 0;
			do {
				System.out.print("Ingrese el codigo del pais asociado al destino turistico (solamente codigos validos): ");
				codigoPais = Integer.parseInt(scanner.nextLine());
			}while(codigoPais <= 0 || codigoPais > paises.size());
			
			Pais pais = buscarPaisPorCodigo(codigoPais);

			System.out.print("Ingrese la cantidad de dias del destino turistico: ");
			int cantidadDias = Integer.parseInt(scanner.nextLine());

			DestinoTuristico nuevoDestino = new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias);
			destinos.add(nuevoDestino);

			System.out.println("Destino turistico aniadido correctamente");
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Formato de entrada incorrecto. Reingrese los datos nuevamente de forma correcta");
		}
	}

	public static void mostrarDestinosTuristicos() {
		System.out.println("*LISTADO DE DESTINOS TURISTICOS*");
		if (destinos.isEmpty()) {
			System.out.println("No hay destinos turisticos cargados.");
		} else {
			for (DestinoTuristico destino : destinos) {
				System.out.println(destino);
			}
		}
	}

	public static void modificarPaisDestinoTuristico() {
	    System.out.println("*MODIFICAR PAIS DE DESTINO TURISTICO*");
	    if (destinos.isEmpty()) {
	        System.out.println("No hay destinos turisticos cargados");
	    } else {
	        System.out.print("Ingrese el codigo del destino turistico que desea modificar: ");
	        int codigoDestino = Integer.parseInt(scanner.nextLine());
	        DestinoTuristico destino = buscarDestinoPorCodigo(codigoDestino);
	        if (destino == null) {
	            System.out.println("No se encontro ningun destino turistico con ese codigo");
	        } else {
		            int nuevoCodigoPais = 0;
					do {
						System.out.print("Ingrese el nuevo codigo del pais asociado al destino turistico (solamente codigos validos): ");
			            nuevoCodigoPais = Integer.parseInt(scanner.nextLine());
					}while(nuevoCodigoPais <= 0 || nuevoCodigoPais > paises.size());
					
	            Pais nuevoPais = buscarPaisPorCodigo(nuevoCodigoPais);
	            if (nuevoPais == null) {
	                System.out.println("No se encontro ningun pais con ese codigo");
	            } else {
	                destino.setPais(nuevoPais);
	                System.out.println("Pais modificado correctamente");
	            }
	        }
	    }
	}

	public static void limpiarDestinosTuristicos() {
		System.out.println("*LIMPIAR LISTA DE DESTINOS TURISTICOS*");
		destinos.clear();
		System.out.println("Lista de destinos turisticos limpiada.");
	}

	public static void eliminarDestinoTuristico() {
	    System.out.println("*ELIMINAR DESTINO TURISTICO*");
	    if (destinos.isEmpty()) {
	        System.out.println("No hay destinos turisticos cargados");
	    } else {
	        System.out.print("Ingrese el codigo del destino turistico que desea eliminar: ");
	        int codigoDestino = Integer.parseInt(scanner.nextLine());
	        Iterator<DestinoTuristico> iterator = destinos.iterator();
	        boolean encontrado = false;
	        while (iterator.hasNext()) {
	            DestinoTuristico destino = iterator.next();
	            if (destino.getCodigo() == codigoDestino) {
	                iterator.remove();
	                System.out.println("Destino turistico eliminado correctamente");
	                encontrado = true;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("No se encontro ningun destino turistico con ese codigo");
	        }
	    }
	}

	public static void mostrarDestinosPorPais() {
	    System.out.println("*LISTADO DE DESTINOS TURISTICOS ORDENADOS POR PAIS*");
	    if (destinos.isEmpty()) {
	        System.out.println("No hay destinos turisticos cargados");
	    } else {
	        destinos.sort(Comparator.comparing(d -> d.getPais().getNombre()));
	        for (DestinoTuristico destino : destinos) {
	            System.out.println(destino);
	        }
	    }
	}


	public static void mostrarTodosPaises() {
		System.out.println("*LISTADO DE TODOS LOS PAISES*");
		if (paises.isEmpty()) {
			System.out.println("No hay paises cargados");
		} else {
			for (Pais pais : paises) {
				System.out.println(pais);
			}
		}
	}

	public static void mostrarDestinosPorPaisSeleccionado() {
	    System.out.println("*LISTADO DE DESTINOS TURISTICOS POR PAIS SELECCIONADO*");
	    if (paises.isEmpty()) {
	        System.out.println("No hay paises cargados");
	    } else {
	        System.out.print("Ingrese el codigo del pais del cual desea ver los destinos turisticos: ");
	        int codigoPais = Integer.parseInt(scanner.nextLine());
	        Pais pais = buscarPaisPorCodigo(codigoPais);
	        if (pais == null) {
	            System.out.println("No se encontro ningun pais con ese codigo");
	        } else {
	            boolean encontrado = false;
	            for (DestinoTuristico destino : destinos) {
	                if (destino.getPais().getCodigo() == codigoPais) {
	                    System.out.println(destino);
	                    encontrado = true;
	                }
	            }
	            if (!encontrado) {
	                System.out.println("No se encontraron destinos turisticos para el pais seleccionado");
	            }
	        }
	    }
	}

	public static Pais buscarPaisPorCodigo(int codigoPais) {
		for (Pais pais : paises) {
			if (pais.getCodigo() == codigoPais) {
				return pais;
			}
		}
		return null;
	}

	public static DestinoTuristico buscarDestinoPorCodigo(int codigoDestino) {
		for (DestinoTuristico destino : destinos) {
			if (destino.getCodigo() == codigoDestino) {
				return destino;
			}
		}
		return null;
	}

}
