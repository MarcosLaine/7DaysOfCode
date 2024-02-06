package DataStructures;

class Livro{
    String nome;
    int paginas;
    Livro baixo;

    //Construtor de Livros
    Livro(String nome, int paginas){
        this.nome = nome;
        this.paginas = paginas;
        this.baixo = null;
    }
}

public class PilhaDeLivros {
    private Livro topo;

    //Construtor da pilha de livros
    PilhaDeLivros(){
        this.topo = null;
    }

    //Função para adicionar livros
    void adicionar_livro(String nome, int paginas){
        Livro novo = new Livro(nome, paginas);
        if (this.topo == null)
            this.topo = novo;
        else{
            novo.baixo = topo;       
            topo = novo;
        }
    }

    //Função para remover livros
    void remover_livro(){
        if (this.topo==null) 
            System.out.println("A pilha está vazia!");
        else {
            Livro tmp = new Livro(null, 0);
            tmp = topo.baixo;
            topo.baixo = null;
            topo = tmp; 
        }
    }

    //Função para mostrar o primeiro livro
    void mostrar_topo(){
        if (this.topo == null)
            System.out.println("A pilha está vazia");
        else    
            System.out.println("O livro no topo é: " + topo.nome+", com "+topo.paginas+" páginas.");
    }

    //Função para mostrar toda a pilha
    void  mostrar_pilha() {
        if (this.topo == null) 
            System.out.println("A pilha está vazia!");
        else {
            Livro atual = topo;
            while(atual != null){
                System.out.println("\nNome do livro: " + atual.nome + " ==== " + " Páginas: " + atual.paginas);
                atual = atual.baixo;
            }
        }
    }

    //Função Main
    public static void main(String[] args) {
        PilhaDeLivros pilha = new PilhaDeLivros();
        pilha.adicionar_livro("GoT 1",  528);
        pilha.adicionar_livro("GoT 2", 555);
        pilha.mostrar_topo();
        pilha.mostrar_pilha();
        pilha.adicionar_livro("GoT 3", 623);
        pilha.mostrar_pilha();
        pilha.mostrar_topo();
        pilha.remover_livro();
        pilha.mostrar_pilha();
        pilha.mostrar_topo();
    }

}
