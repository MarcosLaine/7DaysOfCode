package DataStructures;

class Jogador {
    public String nome;
    public int pontos;
    Jogador prox;

    Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.prox = null;
    }
}

class Lista {
    public Jogador inicio, fim;

    Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirInicio(String nome, int pontos) {
        Jogador novaJogador = new Jogador(nome, pontos);
        if (inicio == null) {
            inicio = novaJogador;
            fim = novaJogador;
        } else {
            novaJogador.prox = inicio;
            inicio = novaJogador;
        }
    }

    public void inserirFim(String nome, int pontos) {
        Jogador novoJogador = new Jogador(nome, pontos);
        if (fim != null) {
            fim.prox = novoJogador;
            fim = novoJogador;
        } else {
            inicio = novoJogador;
            fim = novoJogador;
        }
    }

    public void mostrar() {
        Jogador atual = inicio;
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + ", Pontos: " + atual.pontos);
            atual = atual.prox;
        }
    }
}

public class HashJogadores {
    Lista tabela[];
    int tamanho;

    public HashJogadores(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Lista[tamanho];
        for (int i = 0; i < tamanho; i++)
            tabela[i] = new Lista();
    }

    int hash(int chave) {
        return chave % tamanho;
    }

    void inserir(String nome, int pontos, int chave) {
        tabela[hash(chave)].inserirFim(nome, pontos); // Inserção no fim
    }

    void atualizarPontos(String nome, int novaPontuacao, int chave) {
        Jogador atual = tabela[hash(chave)].inicio;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                atual.pontos = novaPontuacao;
                return; // Sai do método após encontrar e atualizar
            }
            atual = atual.prox;
        }
        System.out.println("Jogador não encontrado");
    }

    void remover(String nome, int chave) {
        int indice = hash(chave);
        Jogador atual = tabela[indice].inicio;
        Jogador anterior = null;
        while (atual != null && !atual.nome.equals(nome)) {
            anterior = atual;
            atual = atual.prox;
        }
        if (atual == null) {
            System.out.println("Jogador não encontrado");
            return;
        }
        if (anterior == null) {
            // Removendo o primeiro jogador
            tabela[indice].inicio = atual.prox;
            if (tabela[indice].inicio == null) {
                tabela[indice].fim = null; // Se a lista ficou vazia
            }
        } else {
            anterior.prox = atual.prox;
            if (anterior.prox == null) {
                tabela[indice].fim = anterior; // Atualiza o fim se necessário
            }
        }
    }

    void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Lista " + i + ":");
            tabela[i].mostrar();
        }
    }

    public static void main(String[] args) {
        HashJogadores tabela = new HashJogadores(5);

        tabela.inserir("joao", 10, 5);
        tabela.inserir("maria", 8, 3);
        tabela.inserir("luis", 9, 4);
        tabela.inserir("Marcos", 15, 5);
        tabela.inserir("Joana", 7, 2);

        System.out.println("Tabela antes da remoção:");
        tabela.imprimir();

        tabela.remover("joao", 5);
        System.out.println("Tabela depois da remoção:");
        tabela.imprimir();

        System.out.println("atualizar pontos de maria: ");
        tabela.atualizarPontos("maria", 12, 3);
        System.out.println("Tabela após atualização dos pontos de maria");
        tabela.imprimir();
    }
}
