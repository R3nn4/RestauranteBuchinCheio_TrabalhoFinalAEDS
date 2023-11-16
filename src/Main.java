import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scan1 = new Scanner(System.in);
        int comando = -1;

        System.out.println("\n- Seja bem vindo ao SOFTWARE PARA RESTAURANTES EFEMEROS! -");
        System.out.println("Aqui, os restaurante so duram enquanto o programa estiver aberto, " +
                "entao tenha certeza de ter concluido tudo antes de encerra-lo para que voce " +
                "nao tenha que fazer tudo de novo! :D\n");

        //Pega infos do Restaurante.
        System.out.println("Primeiramente, insira o nome do seu Restaurante: ");
        restaurante.setNome(scan1.nextLine());
        System.out.println("Agora, o endereco onde ele fica: ");
        restaurante.setEndereco(scan1.nextLine());

        do {
            System.out.println("\n\n- Restaurante " + restaurante.getNome() + " - ");
            System.out.println("""
                    Comandas
                    \t(1) Cadastrar novo Alimento em uma Comanda;\s
                    \t(2) Remover Alimento de uma Comanda;\s
                    \t(3) Listar consumo da Comanda;\s
                    \t(4) Dividir a conta da Comanda;\s
                    \t(5) Calcular 10% da Comanda;\s
                    
                    Mesas
                    \t(6) Adicionar Cliente a Mesa;\s
                    \t(7) Remover Cliente da Mesa;\s
                    \t(8) Imprimir Clientes da Mesa;\s
                    \t(9) Reservar uma Mesa;\s
                    \t(10) Imprimir dados de uma Reserva;\s
                    
                    Cardapio
                    \t(11) Imprimir Cardapio;\s
                    \t(12) Inserir novo Alimento no Cardapio;\s
                    
                    Restaurante
                    \t(13) Imprime infos do Restaurante;\s
                    """);
            comando = scan1.nextInt();

        }while(comando != 0);
    }
}