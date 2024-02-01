package DataStructures;

class ListaDeCompras{
    private String[] itens;
    private int[] quantidades;
    private int tamanho;
    private final int capacidadeMaxima;

    public ListaDeCompras(int capacidade) {
        capacidadeMaxima = capacidade;
        itens = new String[capacidadeMaxima];
        quantidades = new int[capacidadeMaxima];
        tamanho = 0;
    }

    public void adicionarItem(String item, int quantidade) {
        if (tamanho < capacidadeMaxima) {
            itens[tamanho] = item;
            quantidades[tamanho] = quantidade;
            tamanho++;
        }
    }

    public void removerItem(String item) {
        for (int i = 0; i < tamanho; i++) {
            if (itens[i].equals(item)) {
                for (int j = i; j < tamanho - 1; j++) {
                    itens[j] = itens[j + 1];
                    quantidades[j] = quantidades[j + 1];
                }
                tamanho--;
                return;
            }
        }
    }

    public void listar_itens(){
        System.out.println("Itens da lista de compras:");
        for(int i = 0; i < tamanho; i++){
            System.out.println(itens[i] + " - " + quantidades[i]);
        }
    }

    public static void main(String[] args) {
        // Criando uma lista de compras com capacidade máxima de 5 itens
        ListaDeCompras lista = new ListaDeCompras(5);
        
        lista.adicionarItem("maçã", 5);
        lista.adicionarItem("banana", 3);
        lista.listar_itens();
        lista.removerItem("banana");
        lista.listar_itens();
    }
}