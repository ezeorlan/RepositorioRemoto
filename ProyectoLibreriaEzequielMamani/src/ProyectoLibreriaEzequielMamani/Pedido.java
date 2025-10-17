package ProyectoLibreriaEzequielMamani;

import java.util.ArrayList;

public class Pedido {

  private static int contadorDeiD = 1;
  private int idPedido;
  private String nombreCliente;
  ArrayList<LineaPedido> pedidos;

  public Pedido(String nombreCliente) {
    this.idPedido = contadorDeiD++;
    this.nombreCliente = nombreCliente;
    this.pedidos = new ArrayList<>();
  }
}
