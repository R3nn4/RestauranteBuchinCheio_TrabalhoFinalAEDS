import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scan1 = new Scanner(System.in);
        int comando;

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

            int aux = 0;
            double aux1 = 0;

            switch(comando){
                //Comandas
                case 0:
                    break;
                case 1: /* Adiciona alimento */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = scan1.nextInt();
                    restaurante.mesas[aux].comanda.adicionaAlimento(restaurante.cardapio);

                    break;
                case 2: /* Remove alimento */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = scan1.nextInt();
                    restaurante.mesas[aux].comanda.removeAlimento();

                    break;
                case 3: /* Lista consumo */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = scan1.nextInt();
                    restaurante.mesas[aux].comanda.listarConsumo();

                    break;
                case 4: /* Divide conta */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = scan1.nextInt();
                    aux1 = restaurante.mesas[aux].comanda.divideConta(restaurante.mesas[aux].getNum_clientes_atual());

                    System.out.println("\nCada cliente da mesa deve pagar: R$" + aux1);

                    break;
                case 5: /* Calcula 10% */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = scan1.nextInt();
                    aux1 = restaurante.mesas[aux].comanda.calcula10porcento();

                    System.out.println("O valor da taxa de 10% eh: R$" + aux1);

                    break;
                //Mesas
                case 6: /* Adiciona cliente */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = scan1.nextInt();
                    restaurante.mesas[aux].adicionaCliente();

                    break;
                case 7: /* Remove cliente */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = scan1.nextInt();
                    restaurante.mesas[aux].removeCliente();

                    break;
                case 8: /* Imprime clientes */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = scan1.nextInt();
                    restaurante.mesas[aux].imprimeClientes();

                    break;
                case 9: /* Faz reserva */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = scan1.nextInt();

                    if(!restaurante.mesas[aux].isReserva()) {
                        restaurante.mesas[aux].setReserva();
                    }else{
                        System.out.println("Esta mesa ja foi reservada!");
                    }

                    break;
                case 10: /* Imprime reserva */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = scan1.nextInt();

                    if(!restaurante.mesas[aux].isReserva()) {
                        restaurante.mesas[aux].imprimeReserva();
                    }else{
                        System.out.println("Esta mesa ja foi reservada!");
                    }

                    break;
                //Cardapio
                case 11: /* Imprime cardapio */
                    restaurante.cardapio.imprimeCardapio();
                    break;
                case 12: /* Cadastra novo alimento */
                    String aux2 = new String();

                    System.out.println("Insira o nome do novo alimento: ");
                    aux2 = scan1.nextLine();
                    System.out.println("Agora insira o preco: ");
                    aux1 = scan1.nextDouble();

                    restaurante.cardapio.adicionaAlimento(aux2, aux1);

                    System.out.println();
                    break;
                //Restaurante
                case 13: /* Imprime restaurante */
                    System.out.println("Nome: " + restaurante.getNome());
                    System.out.println("Endereco: " + restaurante.getEndereco());
                    break;
            }

        }while(comando != 0);
    }
}