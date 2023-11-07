import java.util.Scanner;
public class Comanda {
    //ATRIBUTOS
    private final int max_alimentos = 100;
    private Alimento[] consumo = new Alimento[max_alimentos];
    private double valor;
    private int num_alimentos = 0;

    //MÉTODOS

    public int acha_alimento(int identificador){
        int i = 0;
        int j = -1;
        do{
            i++;
            j = this.consumo[i].getIdentificador();
        }while(j != identificador);
        return i;
    }
    public void listarConsumo(){
        for(Alimento i : consumo){
            System.out.println(i.getNome() + " - " + i.getValor());
        }
    }
    public double calcula10porcento (){
        return (this.valor * 0.1);
    }
    public double divideConta(int num_pessoas){
        return (this.valor / num_pessoas);
    }
    public void inicializaAlimento (int identificador, Cardapio cardapio){
        /*É passado o cardápio do restaurante, que tem disponíveis todos os pratos e bebidas
        ordenados de acordo com seu identificador. Assim, o identificador serve como localizador
        do alimento no cardápio e pode-se atribuir seu nome e valor de forma automática.*/

        //Checa se o identificador eh valido e atribui os dados.
        if(identificador>=0 && identificador<=cardapio.getNum_alimentos_atual()) {
            //Nome e valor do alimento alocado no cardapio na posicao do identificador passado são
            //atribuídos ao nome e valor no alimento na última posicao do consumo da comanda.
            consumo[num_alimentos].setNome(cardapio.cardapio[identificador].getNome());
            consumo[num_alimentos].setValor(cardapio.cardapio[identificador].getValor());
        }
    }

    //gets
    public Alimento get_alimento(int posicao){
        return this.consumo[posicao];
    }
    public double getValor() {
        return valor;
    }
    public double getNumAlimentos(){ return num_alimentos; }
    //sets
    public void adicionaAlimento(Cardapio cardapio){
        //Pega o identificador do alimento e passa para a função
        //inicializa alimento para que ele seja inicializado automaticamente;
        if(num_alimentos < 100) {
            this.num_alimentos++;
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Identificador: ");
            int aux = scanner1.nextInt();
            this.consumo[num_alimentos].setIdentificador(aux);
            inicializaAlimento(aux, cardapio);
        }

    }
}
