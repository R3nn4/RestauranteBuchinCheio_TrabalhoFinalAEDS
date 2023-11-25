/*Trabalho Final de AEDS - Segundo Ano
* João Renna Wykrota Tostes - Mario Ramos
* Turma 203 - Prof. Virgínia Mota */

import java.util.Scanner;

public class TesteRestaurante {
    public static int pega_aux(int max){
        int aux;
        Scanner scan1 = new Scanner(System.in);
        do {
            aux = scan1.nextInt();
            if(aux > max || aux < 0){
                System.out.println("\nMesa invalida! Tente novamente:");
            }
        }while(aux > max || aux < 0);
        return aux;
    }
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
                    \t(2) Listar consumo geral de uma Mesa;\s
                    \t(3) Listar consumo de comida de uma Mesa;\s
                    \t(4) Listar consumo de bebida de uma Mesa;\s
                    \t(5) Dividir a conta da Mesa;\s
                    \t(6) Calcular 10% da conta da Mesa;\s
                    
                    Mesas
                    \t(7) Adicionar Cliente a Mesa;\s
                    \t(8) Imprimir Clientes da Mesa;\s
                    \t(9) Reservar uma Mesa;\s
                    \t(10) Imprimir dados de uma Reserva;\s
                    
                    Cardapio
                    \t(11) Imprimir Cardapio de comida;\s
                    \t(12) Imprimir Cardapio de bebida;\s
                    \t(13) Inserir novo Alimento em um Cardapio;\s
                    
                    Restaurante
                    \t(14) Imprime infos do Restaurante;\s
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
                    aux = pega_aux(restaurante.getNum_max_mesas());
                    int tipo = 0;

                    if(restaurante.mesas[aux].isOcupada() == true) {
                        System.out.println("Este Alimento eh (0)comida ou (1)bebida?");
                        tipo = pega_aux(2);

                        if(tipo == 0) {
                            restaurante.mesas[aux].comandaComidas.adicionaAlimento(restaurante.cardapioComidas);
                        }else if (tipo == 1){
                            restaurante.mesas[aux].comandaBebidas.adicionaAlimento(restaurante.cardapioBebidas);
                        }
                    }
                    else{
                        System.out.println("\nEsta mesa ainda nao tem clientes!");
                    }

                    break;
                case 2: /* Lista consumo geral*/
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());

                    System.out.println("Comidas:");
                    restaurante.mesas[aux].comandaComidas.listarConsumo();
                    System.out.println();
                    System.out.println("Bebidas:");
                    restaurante.mesas[aux].comandaBebidas.listarConsumo();
                    System.out.println("Valor total da mesa: R$ " + (restaurante.mesas[aux].comandaComidas.getValor() + restaurante.mesas[aux].comandaBebidas.getValor()));

                    break;
                case 3: /* Lista consumo comida*/
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());

                    restaurante.mesas[aux].comandaComidas.listarConsumo();
                    break;
                case 4: /* Lista consumo bebida*/
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());

                    restaurante.mesas[aux].comandaBebidas.listarConsumo();
                    break;
                //Mesas
                case 5: /* Divide conta */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());
                    aux1 = restaurante.mesas[aux].comandaComidas.divideConta(restaurante.mesas[aux].getNum_clientes_atual());
                    aux1 += restaurante.mesas[aux].comandaBebidas.divideConta(restaurante.mesas[aux].getNum_clientes_atual());

                    System.out.printf("\nCada cliente da mesa deve pagar: R$ %.2f \n", aux1);

                    break;
                case 6: /* Calcula 10% */
                    System.out.println("Insira o numero da mesa correspondente a comanda: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());
                    aux1 = restaurante.mesas[aux].comandaComidas.calcula10porcento();
                    aux1 += restaurante.mesas[aux].comandaBebidas.calcula10porcento();

                    System.out.printf("O valor da taxa de 10 porcento eh: R$ %.2f \n", aux1);

                    break;
                case 7: /* Adiciona cliente */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());
                    restaurante.mesas[aux].adicionaCliente();

                    break;
                case 8: /* Imprime clientes */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());
                    restaurante.mesas[aux].imprimeClientes();

                    break;
                case 9: /* Faz reserva */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());

                    if(!restaurante.mesas[aux].isReserva()) {
                        restaurante.mesas[aux].setReserva();
                    }else{
                        System.out.println("Esta mesa ja foi reservada!");
                    }

                    break;
                case 10: /* Imprime reserva */
                    System.out.println("Insira o numero da mesa correspondente: ");
                    aux = pega_aux(restaurante.getNum_max_mesas());

                    if(restaurante.mesas[aux].isReserva()) {
                        restaurante.mesas[aux].imprimeReserva();
                    }else{
                        System.out.println("Esta mesa ainda nao foi reservada!");
                    }

                    break;
                case 11: /* Imprime cardapio de comida*/
                    restaurante.cardapioComidas.imprimeCardapio();
                    break;
                case 12:
                    restaurante.cardapioBebidas.imprimeCardapio();
                    break;
                case 13: /* Cadastra novo alimento */
                    String aux2 = new String();

                    System.out.println("Em qual cardapio voce deseja inserir um novo Alimento?");
                    System.out.println("(0)Cardapio de Comidas - (1)Cardapio de Bebidas");

                    aux = pega_aux(2);

                    if(aux == 0) {
                        System.out.println("Insira o nome do novo alimento: ");
                        aux2 = scan1.nextLine();
                        aux2 = scan1.nextLine();
                        System.out.println("Agora insira o preco: ");
                        aux1 = scan1.nextDouble();

                        restaurante.cardapioComidas.adicionaAlimento(aux2, aux1);
                    }
                    else if(aux == 1){
                        System.out.println("Insira o nome do novo alimento: ");
                        aux2 = scan1.nextLine();
                        aux2 = scan1.nextLine();
                        System.out.println("Agora insira o preco: ");
                        aux1 = scan1.nextDouble();

                        restaurante.cardapioBebidas.adicionaAlimento(aux2, aux1);
                    }
                    System.out.println();
                    break;
                case 14: /* Imprime restaurante */
                    System.out.println("Nome: " + restaurante.getNome());
                    System.out.println("Endereco: " + restaurante.getEndereco());
                    break;
            }

        }while(comando != 0);
    }
}