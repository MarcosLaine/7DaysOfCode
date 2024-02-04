package DataStructures;

class Pedido{
    public String nome;
    int numero;
    Pedido prox;

    public Pedido(String nome,int numero){
        this.nome = nome;
        this.numero = numero;
        this.prox = null;
    }
}

public class ListaDePedidos{
    private Pedido inicio;

    ListaDePedidos(){
        this.inicio = null;
    }

    void adicionarPedido(String nome, int numero) {
        Pedido novoPedido = new Pedido(nome, numero);
        novoPedido.prox = inicio;
        inicio = novoPedido;
    }

    void removerPedido() {
        if (inicio == null) {
            System.out.println("A lista está vazia");
        } else {
            inicio = inicio.prox;
        }
    }

    void listarPedidos() {
        Pedido atual = inicio;
        while (atual != null) {
            System.out.println("Nome: " + atual.nome);
            System.out.println("Numero: " + atual.numero);
            atual = atual.prox;
        }
    }

   public static void main(String[] args) {
    ListaDePedidos pedidos = new ListaDePedidos();

    pedidos.adicionarPedido("Macarrão", 1);
    pedidos.adicionarPedido("Salada", 2);
    pedidos.listarPedidos();
    pedidos.adicionarPedido("Canellone", 3);
    pedidos.listarPedidos();
    pedidos.removerPedido();
    pedidos.listarPedidos();
   }
}