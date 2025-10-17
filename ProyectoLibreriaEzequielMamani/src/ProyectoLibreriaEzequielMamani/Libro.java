package ProyectoLibreriaEzequielMamani;

public class Libro {

  private static int contIDs = 1;
  private int idLibro;
  private String titulo;
  private double precio;
  private int stock;

  public Libro(String titulo, double precio, int stock) {
    this.idLibro = contIDs++;
    this.titulo = titulo;
    this.precio = precio;
    this.stock = stock;
  }

  public int getIdLibro() {
    return idLibro;
  }

  public void setIdLibro(int idLibro) {
    this.idLibro = idLibro;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  @Override
  public String toString() {
    return String.format(
        "📘ID: %d    |Título: %-30s | 💲Precio: $%.2f | 📦 Stock: %d" + "\n",
        idLibro, titulo, precio, stock
    );
  }
}
