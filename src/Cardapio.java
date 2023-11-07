public class Cardapio {
    //ATRIBUTOS
    private final int max_alimentos = 100;
    public Alimento[] cardapio = new Alimento[max_alimentos];
    private int num_alimentos_atual = 0;

    //MÉTODOS
    Cardapio(){
        inicializaCardapio();
    }
    private void criaPosicaoCardapio(int Posicao, String Nome, double Valor){
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
        if(num_alimentos_atual < 100){
            criaPosicaoCardapio(this.num_alimentos_atual, Nome, Valor);
        }else{
            System.out.println("\nNumero maximo de alimentos atingido!");
        }
    }
    private void inicializaCardapio(){
        criaPosicaoCardapio(0,"Agua Mineral", 4.00);
        criaPosicaoCardapio(1,"Suco de Fruta", 6.00);
        criaPosicaoCardapio(2,"Refrigerante", 6.00);
        criaPosicaoCardapio(3,"Salada Normal", 12.00);
        criaPosicaoCardapio(4,"Salada Caesar", 16.00);
        criaPosicaoCardapio(5,"Salada Primavera", 20.00);
        criaPosicaoCardapio(6,"Strogonoff", 40.00);
        criaPosicaoCardapio(7,"Omelete", 30.00);
        criaPosicaoCardapio(8,"Cozido de cogumelos", 35.00);
        criaPosicaoCardapio(9,"Manteiga na Manteiga", 25.00);
        criaPosicaoCardapio(10,"Peixe frito", 16.00);
        criaPosicaoCardapio(11,"Pizza (tamanho unico)", 40.00);
        criaPosicaoCardapio(12,"Sanduiche", 24.00);
        criaPosicaoCardapio(13,"Pudim de leite", 7.00);
        criaPosicaoCardapio(14,"Torta de limao", 10.00);
        criaPosicaoCardapio(15,"Petit Gateau", 9.00);
    }
    public int getNum_alimentos_atual() {
        return num_alimentos_atual;
    }
}
