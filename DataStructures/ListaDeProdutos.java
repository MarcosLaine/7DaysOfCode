package DataStructures;

class Produto {
    public String nome;
    int codigo;
    float preco;
    int qtde;
    Produto dir, esq;

    public Produto(String nome, int codigo, float preco, int qtde) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.qtde = qtde;
        this.dir = null;
        this.esq = null;
    }
}

public class ListaDeProdutos {
    private Produto inicio, fim;

    ListaDeProdutos() {
        inicio = null;
        fim = null;
    }

    void adicionar_produto(String nome, int codigo, float preco, int qtde) {
        if (inicio == null) {
            inicio = new Produto(nome, codigo, preco, qtde);
            fim = inicio;
        } else {
            Produto novo = new Produto(nome, codigo, preco, qtde);
            fim.dir = novo;
            novo.esq = fim;
            fim = novo;
        }
    }

    void remover_produto(String nome) {
        Produto atual = new Produto(nome, 0, 0, 0);
        atual = inicio;
        if (inicio.nome.equals(nome)) {
            Produto tmp = new Produto(nome, 0, 0, 0);
            tmp.dir = atual.dir;
            atual.dir = tmp;
            inicio = tmp.dir;
            atual = tmp.dir;
            tmp.dir.esq = null;
        } else {
            while (!atual.nome.equals(nome)) {
                atual = atual.dir;
            }
            Produto tmp = new Produto(nome, 0, 0, 0);
            tmp.dir = atual.dir;
            atual.dir = tmp;
            tmp.dir.esq =atual.esq;
            atual.esq = null;
            tmp.dir = null;
            tmp = null;
        }
    }

    void listar_produtos(){
        System.out.println("Lista de produtos:");
        for (Produto p = inicio ; p != null ; p = p.dir)
            System.out.println("nome: " + p.nome+"| Código: "+ p.codigo + "| Valor: " + "R$" + p.preco + "| Quantidade: " + p.qtde);
    }

    void atualizar_qtde(String nome, int qtdeNova){
        Produto atual = new Produto(nome, 0, 0, 0);
        atual = inicio;
        while(!atual.nome.equals(nome))
            atual = atual.dir;
        atual.qtde = qtdeNova;
    }

    public static void main(String[] args) {
        ListaDeProdutos lista = new ListaDeProdutos();
        lista.adicionar_produto("Arroz",123456, 9.99f, 100);
        lista.adicionar_produto("Feijão", 654321, 11.99f, 50);
        lista.listar_produtos();
        lista.remover_produto("Arroz");
        lista.listar_produtos();
        lista.adicionar_produto("Carne", 987654, 109.90f, 25);
        lista.listar_produtos();
        lista.remover_produto("Feijão");
        lista.atualizar_qtde("Carne", 50);
        lista.listar_produtos();
    }
}