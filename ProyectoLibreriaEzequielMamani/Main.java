package ProyectoLibreriaEzequielMamani;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int opcion;
    System.out.println("Te damos la Bienvenido a la app de compra!");
    ArrayList<Libro> LibrosDB = new ArrayList<>();
    cargarLibrosEjemplo(LibrosDB);
    label:

    while (true) {
      System.out.println("""
          Ingrese el numero equivalente a la opcion:
          0- Salir de la app
          1- Crear Libro
          2- Listar todos los Libros
          3- Buscar Libro por titulo
          """);
      opcion = entrada.nextInt();
      switch (opcion) {
        case 1:
          crearLibro(LibrosDB);
          break;
        case 2:
          mostrarProductos(LibrosDB);
          break;
        case 3:
          buscarLibroPorTitulo(LibrosDB);
          break;
        case 0:
          System.out.println("Gracis por utilizar la app");
          break label;
        default:
          System.out.println("Opcion incorrecta");
      }
    }

  }

  public static void crearLibro(ArrayList<Libro> libros) {

    Scanner entrada = new Scanner(System.in);
    System.out.println("Creando Libro...📖");
    System.out.println("---------------------");
    System.out.println("Ingrese id:");
    int id = entrada.nextInt();
    entrada.nextLine();
    System.out.println("Ingrese Titulo del nuevo Libro: ");
    String nombre = entrada.nextLine();
    System.out.println("Ingresar precio del libro:");
    double precio = entrada.nextDouble();
    System.out.println("Ingrese stock de libro:");
    int cantidadLibros = entrada.nextInt();
    Libro libro = new Libro(id, nombre, precio, cantidadLibros);
    libros.add(libro);
    System.out.println("El Libro fue creado con exito 📚 ");
    pausa();
  }

  public static void mostrarProductos(ArrayList<Libro> libros) {
    System.out.println("📚 =============================== 📚");
    System.out.println("        📖 LISTADO DE LIBROS 📖     ");
    System.out.println("📚 =============================== 📚\n");

    if (libros.isEmpty()) {
      System.out.println("⚠️  El listado está vacío.\n");
    } else {
      for (Libro libro : libros) {
        System.out.printf(libro.toString());
      }
    }

    System.out.println("\n📚 =============================== 📚");
    pausa();
  }

  public static void pausa() {
    Scanner s = new Scanner(System.in);
    System.out.println("Presione ENTER para seguir");
    s.nextLine();
  }

  public static void buscarLibroPorTitulo(ArrayList<Libro> libros) {
    ArrayList<Libro> librosEncontrados = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese palabra para buscar el Libro:");
    String nombreProducto = entrada.nextLine();
    for (Libro libro : libros) {
      if (estaIncluido(libro.getTitulo(), nombreProducto)) {
        librosEncontrados.add(libro);
      }
    }
    mostrarProductos(librosEncontrados);
  }

  public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);
    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }

  public static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }

  public static void cargarLibrosEjemplo(ArrayList<Libro> listaLibros) {

    listaLibros.add(new Libro(1, "Cien años de soledad", 450.0, 10));
    listaLibros.add(new Libro(2, "1984", 320.0, 8));
    listaLibros.add(new Libro(3, "Don Quijote de la Mancha", 500.0, 5));
    listaLibros.add(new Libro(4, "El Principito", 150.0, 20));
    listaLibros.add(new Libro(5, "Crimen y castigo", 380.0, 6));
    listaLibros.add(new Libro(6, "Orgullo y prejuicio", 300.0, 12));
    listaLibros.add(new Libro(7, "Rayuela", 400.0, 4));
    listaLibros.add(new Libro(8, "La Odisea", 270.0, 9));
    listaLibros.add(new Libro(9, "Fahrenheit 451", 290.0, 7));
    listaLibros.add(new Libro(10, "El alquimista", 310.0, 11));
    listaLibros.add(new Libro(11, "La sombra del viento", 420.0, 3));
    listaLibros.add(new Libro(12, "El nombre del viento", 550.0, 5));
    listaLibros.add(new Libro(13, "Los juegos del hambre", 280.0, 13));
    listaLibros.add(new Libro(14, "Harry Potter y la piedra filosofal", 350.0, 15));
    listaLibros.add(new Libro(15, "El señor de los anillos", 600.0, 2));
    listaLibros.add(new Libro(16, "El código Da Vinci", 330.0, 6));
    listaLibros.add(new Libro(17, "Matar a un ruiseñor", 290.0, 7));
    listaLibros.add(new Libro(18, "El diario de Ana Frank", 310.0, 10));
    listaLibros.add(new Libro(19, "La ladrona de libros", 340.0, 8));
    listaLibros.add(new Libro(20, "El Hobbit", 370.0, 9));

  }


}

