package ProyectoLibreriaEzequielMamani;

public class LineaPedido {

  private static int contIDs = 1;
  private int idLineaPedido;
  private Libro libro;
  private int cantidadLibros;

  public LineaPedido(Libro libro,int cantLibros) {
    this.idLineaPedido = contIDs++;
    this.libro=libro;
    cantidadLibros = cantLibros;
  }
public double calcularSubtotal() throws Exception{
    if(libro.getStock()>=cantidadLibros){
      return cantidadLibros *libro.getPrecio();
    }else{
      throw new Exception("Stock insuficiente!");
    }

}

}
