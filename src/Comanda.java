import java.util.Objects;
import java.util.Scanner;
public class Comanda {
    //ATRIBUTOS
    private final int max_alimentos = 100;
    private Alimento[] consumo = new Alimento[max_alimentos];
    private double valor = 0;
    private int num_alimentos = 0;

    //MÉTODOS

    public void adicionaAlimento(Cardapio cardapio){
        //Pega o identificador do alimento e passa para a função
        //inicializa alimento para que ele seja inicializado automaticamente;
        if(num_alimentos < 100) {
            this.num_alimentos++;
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Identificador do Alimento a adicionar: ");
            int aux = scanner1.nextInt();
            this.consumo[num_alimentos].setIdentificador(aux);
            inicializaAlimento(aux, cardapio);
            this.valor +=  consumo[num_alimentos].getValor();
        }

    }
    public int acha_alimento(int identificador){
        int i = 0;
        boolean aux = false;

        for(i = 0; i < num_alimentos; i++){
            if(this.consumo[i].getIdentificador() == identificador){
                aux = true;
                break;
            }
        }

        if(aux == false){
            System.out.println("\nAlimento nao encontrado!");
            return -1;
        }else {
            return i;
        }
    }
    public void listarConsumo(){
        for(Alimento i : consumo){
            System.out.println(i.getNome() + " - " + i.getValor());
        }
        System.out.println("Valor total: " + this.valor);
    }
    public double calcula10porcento (){
        return (this.valor * 0.1);
    }
    public void removeAlimento(){
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Insira o identificador do Alimento que deseja remover: ");
        int aux = scan1.nextInt();

        aux = acha_alimento(aux);

        if(aux >= 0){
            this.valor -= consumo[aux].getValor();
            System.arraycopy(consumo, aux, consumo, (aux-1), (max_alimentos - aux));
            consumo[num_alimentos].setNome("");
            consumo[num_alimentos].setValor(0);
            consumo[num_alimentos].setIdentificador(0);
            num_alimentos--;
        }else{
            System.out.println("\nFalha ao criar alimento!");
        }
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
        }else{
            System.out.println("\nIdentificador invalido!");
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
}
