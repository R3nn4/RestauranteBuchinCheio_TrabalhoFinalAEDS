public class Cardapio {
    //ATRIBUTOS
    private final int max_alimentos = 100;
    public Alimento[] cardapio = new Alimento[max_alimentos];
    private int num_alimentos_atual = 0;
    private int tipo = 0;
    /*O tipo na classe Cardapio serve meramente pra diferenciar as
    inicializações padrão dos diferentes tipos. Cardapio de comidas
    inicializa com comidas, cardapio de bebidas, com bebidas;*/

    //MÉTODOS
    Cardapio(int tipo){
        this.tipo = tipo;
        inicializaCardapio(this.tipo);
    }
    private void criaPosicaoCardapio(int Posicao, String Nome, double Valor){
        cardapio[Posicao] = new Alimento();
        if(Posicao >= num_alimentos_atual) {
            cardapio[Posicao].setNome(Nome);
            cardapio[Posicao].setValor(Valor);
            cardapio[Posicao].setIdentificador(Posicao);
            num_alimentos_atual++;
        }else{
            System.out.println("\nPosicao invalida!");
        }
    }
    void adicionaAlimento(String Nome, double Valor){
        /*As funções adicionaAlimento e criaPosicaoCardapio foram separadas
        com o intuito de organização do código e praticidade;*/
        if(num_alimentos_atual < 100){
            criaPosicaoCardapio(this.num_alimentos_atual, Nome, Valor);
        }else{
            System.out.println("\nNumero maximo de alimentos atingido!");
        }
    }

    void imprimeCardapio(){
        for(int j = 0; j < num_alimentos_atual; j++){
            System.out.println(cardapio[j].getIdentificador() + " - " + cardapio[j].getNome() + " - R$ " + cardapio[j].getValor());
        }
    }

    private void inicializaCardapio(int tipo){
        if(tipo == 0) {
            criaPosicaoCardapio(0, "Salada Normal", 12.00);
            criaPosicaoCardapio(1, "Salada Caesar", 16.00);
            criaPosicaoCardapio(2, "Salada Primavera", 20.00);
            criaPosicaoCardapio(3, "Strogonoff", 40.00);
            criaPosicaoCardapio(4, "Omelete", 30.00);
            criaPosicaoCardapio(5, "Cozido de cogumelos", 35.00);
            criaPosicaoCardapio(6, "Manteiga na Manteiga", 25.00);
            criaPosicaoCardapio(7, "Peixe frito", 16.00);
            criaPosicaoCardapio(8, "Pizza (tamanho unico)", 40.00);
            criaPosicaoCardapio(9, "Sanduiche", 24.00);
            criaPosicaoCardapio(10, "Pudim de leite", 7.00);
            criaPosicaoCardapio(11, "Torta de limao", 10.00);
            criaPosicaoCardapio(12, "Petit Gateau", 9.00);
        }
        else if (tipo == 1){
            criaPosicaoCardapio(0, "Agua Mineral", 4.00);
            criaPosicaoCardapio(1, "Suco de Fruta", 6.00);
            criaPosicaoCardapio(2, "Refrigerante", 6.00);
            criaPosicaoCardapio(3, "Milk Shake", 10.00);
            criaPosicaoCardapio(4, "Vitamina de fruta", 8.00);
        }
    }
    public int getNum_alimentos_atual() {
        return num_alimentos_atual;
    }
}
