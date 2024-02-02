package DataStructures;

class Node {
    String nome;
    int id;
    String estado;
    Node prox;

    // Construtor
    public Node(String nome, int id, String estado) {
        this.nome = nome;
        this.id = id;
        this.estado = estado;
        this.prox = null;
    }
}

class Pacientes {
    private Node inicio, fim;

    // Construtor
    Pacientes() {
        inicio = null; // Inicializa sem o nó cabeça fictício
        fim = null;
    }

    void adicionar_paciente(String nome, int id, String estado) {
        if (inicio == null) {
            inicio = new Node(nome, id, estado);
            fim = inicio;
        } else {
            fim.prox = new Node(nome, id, estado);
            fim = fim.prox;
        }
    }

    void remover_pacientes() {
        Node tmp = inicio;
        inicio = inicio.prox;
        tmp.prox = null;
        tmp = null;
    }

    void listar_pacientes() {
        Node atual = inicio;
        while (atual != null) {
            System.out.println(atual.nome + " " +  atual.id + " " + atual.estado);
            atual = atual.prox;
        }
    }

    public static void main(String[] args) {
        Pacientes p = new Pacientes();

        p.adicionar_paciente("Paciente 1" , 1 , "estável");
        p.listar_pacientes();
        System.out.println("________________");
        p.adicionar_paciente("Paciente 2" , 2 , "Crítico");
        p.adicionar_paciente("Paciente 3" , 3 ,  "Recuperando");
        p.listar_pacientes();
        System.out.println("________________");
        System.out.println("Paciente inicial removido");
        p.remover_pacientes();
        System.out.println("________________");
        p.listar_pacientes();
    }
}
