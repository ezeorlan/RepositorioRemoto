package ProyectoLibreriaEzequielMamani;

public class Libro {

  private int idLibro;
  private String titulo;
  private double precio;
  private int stock;

  public Libro(int idLibro, String titulo, double precio, int stock) {
    this.idLibro = idLibro;
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
    precio = precio;
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
    titulo = titulo;
  }

  @Override
  public String toString() {
    return String.format(
        "📘 Título: %-30s | 💲Precio: $%.2f | 📦 Stock: %d" + "\n",
        titulo, precio, stock
    );
  }
}
