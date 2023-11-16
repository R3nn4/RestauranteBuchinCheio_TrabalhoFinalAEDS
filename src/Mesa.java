import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Mesa {
    //ATRIBUTOS
    private int numeroMesa = 0;
    private Reserva reserva = new Reserva();
    private Cliente[] clientes = new Cliente[4];
    private int num_clientes_atual = 0;
    private final int num_max_clientes = 4;
    private Comanda comanda = new Comanda();
    private boolean ocupada = false;

    //MÉTODOS

    //gets
    public int getNumeroMesa() {
        return numeroMesa;
    }
    public boolean isReserva() {
        return reserva.isReservada();
    }
    public Comanda getComanda() {
        return comanda;
    }
    public void imprimeClientes(){
        for(Cliente i : clientes){
            System.out.println(i.getNome() + " - " + i.getEmail());
        }
    }
    public boolean isOcupada() {
        return ocupada;
    }
    public void adicionaCliente(){
        //Confere se ainda ha espaços disponíveis na mesa;
        if(num_clientes_atual < num_max_clientes) {
            this.num_clientes_atual++;
            Scanner scanner1 = new Scanner(System.in);
            boolean i = false;
            String aux;

            //Confere se o nome ja foi cadastrado;
            do {
                System.out.println("Insira o nome do cliente: ");
                aux = scanner1.nextLine();

                for(Cliente j : clientes){
                    if(Objects.equals(j.getNome(), aux)){
                        System.out.println("\nEste cliente ja foi cadastrado!");
                        break;
                    }else{
                        clientes[num_clientes_atual].setNome(aux);
                        i = true;
                    }
                }
            }while(!i);
            i = false;

            //Confere se o email ja foi cadastrado;
            do {
                System.out.println("Insira o email do cliente: ");
                aux = scanner1.nextLine();

                for(Cliente j : clientes){
                    if(Objects.equals(j.getEmail(), aux)){
                        System.out.println("\nEste cliente ja foi cadastrado!");
                        break;
                    }else{
                        clientes[num_clientes_atual].setEmail(aux);
                        i = true;
                    }
                }
            }while(!i);

        }else{
            System.out.println("\nMesa lotada!");
        }
    }
    public void removeCliente(){
        Scanner scan1 = new Scanner(System.in);
        int aux = 0;
        String aux1 = new String();

        System.out.println("Deseja buscar por (1)nome ou por (2)email?");
        aux = scan1.nextInt();

        if(aux == 1) {
            System.out.println("Insira o nome do cliente que ira sair desta mesa: ");
            aux1 = scan1.nextLine();

            for (int i = 0; i < num_max_clientes; i++) {
                if (Objects.equals(aux1, clientes[i].getNome())) {
                    /*Para retirar um cliente da mesa, o vetor é "realocado" dentro dele mesmo: todas as posições do vetor
                     * que estão à frente do cliente que se quer retirar são copiadas uma casa para atrás. Dessa forma, o array se
                     * reorganiza substituindo as posições anteriores, evitando um "buraco" no meio do vetor e mantendo o funcionamento do código.
                     * O mesmo é feito na classe Comanda.*/
                    System.arraycopy(clientes, i, clientes, (i-1), (num_max_clientes - i));
                    clientes[num_clientes_atual].setNome("");
                    clientes[num_clientes_atual].setEmail("");
                    num_clientes_atual--;
                }
            }
        }
        else if(aux == 2){
            System.out.println("Insira o email do cliente que ira sair desta mesa: ");
            aux1 = scan1.nextLine();

            for (int i = 0; i < num_max_clientes; i++) {
                if (Objects.equals(aux1, clientes[i].getEmail())) {
                    System.arraycopy(clientes, i, clientes, (i-1), (num_max_clientes - i));
                    clientes[num_clientes_atual].setNome("");
                    clientes[num_clientes_atual].setEmail("");
                    num_clientes_atual--;
                }
            }
        }
    }

    //sets
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public void setReserva(Date data, String nome) {
        reserva.setReservada(true);
        reserva.setData(data);
        reserva.setNome(nome);
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
