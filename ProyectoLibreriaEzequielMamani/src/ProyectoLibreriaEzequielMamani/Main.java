package ProyectoLibreriaEzequielMamani;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int opcion;
    System.out.println("Te damos la Bienvenido a la app de compra!");
    ArrayList<Libro> LibrosDB = new ArrayList<>();
    ArrayList<Pedido> pedidos = new ArrayList<>();
    cargarLibrosEjemplo(LibrosDB);
    label:

    while (true) {
      System.out.println("""
        =============================================================
        |                        MENÚ PRINCIPAL                     |
        =============================================================
        |  0 - Salir de la aplicación                               |
        |  1 - Crear Libro                                          |
        |  2 - Listar todos los Libros                              |
        |  3 - Buscar Libro por título                              |
        |  4 - Modificar Libro                                      |    
        |  5 - Eliminar Libro                                       |
        =============================================================
        Ingrese el número de la opción:
        """);
      try {
        opcion = entrada.nextInt();

        switch (opcion) {
          case 1:
            crearLibro(LibrosDB);
            limpiarPantalla();
            break;
          case 2:
            mostrarProductos(LibrosDB);
            limpiarPantalla();
            break;
          case 3:
            buscarLibroPorTitulo(LibrosDB);
            limpiarPantalla();
            break;
          case 4:
            modificarLibro(LibrosDB);
            limpiarPantalla();
            break;
          case 5:
            eliminarLibroPorTitulo(LibrosDB);
            limpiarPantalla();
            break;
          case 0:
            System.out.println("Gracis por utilizar la app");
            break label;
          default:
            System.out.println("Opcion incorrecta");
        }
      } catch (RuntimeException e) {
        System.out.println("⚠ Error al ingresar Opcion!");
      }
      finally {
        entrada.nextLine();
        pausa();
      }
    }

  }

  public static void crearLibro(ArrayList<Libro> libros) {

    Scanner entrada = new Scanner(System.in);
    System.out.println("Creando Libro...📖");
    System.out.println("---------------------");

    System.out.println("Ingrese Titulo del nuevo Libro: ");
    String nombre = entrada.nextLine();
    System.out.println("Ingresar precio del libro:");
    double precio = entrada.nextDouble();
    System.out.println("Ingrese stock de libro:");
    int cantidadLibros = entrada.nextInt();
    Libro libro = new Libro(nombre, precio,
        cantidadLibros);
    libros.add(libro);
    System.out.println("✅El Libro fue creado con exito 📚 ");
    pausa();
  }

  public static void mostrarProductos(ArrayList<Libro> libros) {
    System.out.println("📚 =============================== 📚");
    System.out.println("        📖 LISTADO DE LIBROS 📖     ");
    System.out.println("📚 =============================== 📚\n");

    if (libros.isEmpty()) {
      System.out.println("⚠  El listado está vacío.\n");
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
    System.out.println("Ingrese palabra(s) para buscar el Libro:");
    String nombreLibro = entrada.nextLine();
    for (Libro libro : libros) {
      if (estaIncluido(libro.getTitulo(), nombreLibro)) {
        librosEncontrados.add(libro);
      }
    }
    if (librosEncontrados.isEmpty()) {
      System.out.println("❌No se encontraron libros con esa(s) palabras!");
      pausa();
    } else {
      mostrarProductos(librosEncontrados);
    }


  }

  public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String titulo = formatoBusqueda(nombreCompleto);
    String[] palabras = formatoBusqueda(nombreParcial).split("\\s+");

    for (String palabra : palabras) {
      if (!titulo.contains(palabra)) {
        return false; // No se encontró una palabra
      }
    }
    return true;
  }

  public static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }

  public static void cargarLibrosEjemplo(ArrayList<Libro> listaLibros) {

    listaLibros.add(new Libro("Cien años de soledad", 450.0, 10));
    listaLibros.add(new Libro("1984", 320.0, 8));
    listaLibros.add(new Libro("Don Quijote de la Mancha", 500.0, 5));
    listaLibros.add(new Libro("El Principito", 150.0, 20));
    listaLibros.add(new Libro("Crimen y castigo", 380.0, 6));
    listaLibros.add(new Libro("Orgullo y prejuicio", 300.0, 12));
    listaLibros.add(new Libro("Rayuela", 400.0, 4));
    listaLibros.add(new Libro("La Odisea", 270.0, 9));
    listaLibros.add(new Libro("Fahrenheit 451", 290.0, 7));
    listaLibros.add(new Libro("El alquimista", 310.0, 11));
    listaLibros.add(new Libro("La sombra del viento", 420.0, 3));
    listaLibros.add(new Libro("El nombre del viento", 550.0, 5));
    listaLibros.add(new Libro("Los juegos del hambre", 280.0, 13));
    listaLibros.add(new Libro("Harry Potter y la piedra filosofal", 350.0, 15));
    listaLibros.add(new Libro("El señor de los anillos", 600.0, 2));
    listaLibros.add(new Libro("El código Da Vinci", 330.0, 6));
    listaLibros.add(new Libro("Matar a un ruiseñor", 290.0, 7));
    listaLibros.add(new Libro("El diario de Ana Frank", 310.0, 10));
    listaLibros.add(new Libro("La ladrona de libros", 340.0, 8));
    listaLibros.add(new Libro("El Hobbit", 370.0, 9));

  }

  public static void modificarLibro(ArrayList<Libro> libros) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese ID del libro a modificar:");
    Libro libro = buscarLibroPorID(libros);
    if (libro == null) {
      System.out.println("❌No se pudo encontrar el libro, para modificar");
      pausa();
    } else {
      System.out.println("Libro a editar:");
      System.out.println(libro);
      System.out.print("Ingrese el nuevo titulo: ");
      String nuevoTitulo = entrada.nextLine();
      System.out.println("Precio nuevo:");
      double nuevoPrecio = entrada.nextDouble();
      libro.setTitulo(nuevoTitulo);
      libro.setPrecio(nuevoPrecio);

      System.out.println("✅ Libro modificado");
      pausa();
    }
  }

  public static Libro buscarLibroPorID(ArrayList<Libro> libros) {

    Scanner entrada = new Scanner(System.in);
    int busqueda = entrada.nextInt();
    Libro libroEncontrado;
    for (Libro libro : libros) {
      if (libro.getIdLibro()==busqueda) {
        libroEncontrado=libro;
        return libroEncontrado;
      }
    }

    return null;

  }

  public static void limpiarPantalla() {
    for (int i = 0; i < 18
        ; i++) {
      System.out.println();
    }
  }

  public static void eliminarLibroPorTitulo(ArrayList<Libro> libros) {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Ingrese ID del libro a modificar:");
    Libro libro = buscarLibroPorID(libros);
    if (libro ==null) {
      System.out.println("❌No se pudo encontrar el libro, para modificar");
      pausa();
    } else {
      System.out.println("⚠ Libro a eliminar:");
      System.out.println(libro);
      System.out.print("¿Está seguro que desea eliminar el libro? (s/n): ");
      String confirmacion = entrada.nextLine();
      switch (confirmacion) {
        case "s":
          libros.remove(libro);
          System.out.println("✅ Libro eliminado.");
          pausa();
          break;
        case "n":
          System.out.println("No se elimino el libro.");
          pausa();
          break;
        default:
          System.out.println("Opcion incorrecta");
          pausa();
          break;
      }


    }

  }

  //public static void crearPedido(ArrayList<Pedido> pedidos, ArrayList<Libro> libros) {
    //Scanner entrada = new Scanner(System.in);
    //System.out.println("Ingrese nombre de Cliente:");
    //String nomCliente = entrada.nextLine();
    //System.out.println("Ingrese titulo del libro a modificar:");
    //int idLibro = buscarID(libros);
    //if (idLibro == -1) {
     // System.out.println("❌No se pudo encontrar el libro, para modificar");
      //pausa();
    //} else {
      //int posicionLibro = 0;
      //for (int i = 0; i < libros.size(); i++) {
       // if (libros.get(i).getIdLibro() == idLibro) {
         // posicionLibro = i;
       // }

     // }
    //}
  //}
}
