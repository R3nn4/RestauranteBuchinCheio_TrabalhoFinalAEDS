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
    public Comanda comanda = new Comanda();
    private boolean ocupada = false;

    //MÉTODOS

    public int encontraCliente(int opcao, String identificador){
        int i = 0;
        boolean aux = false;

        if(opcao == 1) {
            for (i = 0; i < num_clientes_atual; i++) {
                if (Objects.equals(this.clientes[i].getNome(), identificador)) {
                    aux = true;
                    break;
                }
            }
        }
        else if (opcao == 2){
            for (i = 0; i < num_clientes_atual; i++) {
                if (Objects.equals(this.clientes[i].getEmail(), identificador)) {
                    aux = true;
                    break;
                }
            }
        }
        if(aux == false){
            System.out.println("\nCliente nao encontrado!");
            return -1;
        }else {
            return i;
        }
    }
    public void adicionaCliente(){
        //Confere se ainda ha espaços disponíveis na mesa;
        if(num_clientes_atual < num_max_clientes) {
            this.num_clientes_atual++;
            Scanner scanner1 = new Scanner(System.in);
            boolean i = false;
            String aux;
            this.ocupada = true;

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

        if(num_clientes_atual == 0){
            System.out.println("\nNao ha clientes nesta mesa!");
            this.ocupada = false;
        }else {

            System.out.println("Deseja buscar por (1)nome ou por (2)email?");
            aux = scan1.nextInt();

            if (aux == 1) {
                System.out.println("Insira o nome do cliente que ira sair desta mesa: ");
                aux1 = scan1.nextLine();
                aux = encontraCliente(aux, aux1);

                /*Para retirar um cliente da mesa, o vetor é "realocado" dentro dele mesmo: todas as posições do vetor
                 * que estão à frente do cliente que se quer retirar são copiadas uma casa para atrás. Dessa forma, o array se
                 * reorganiza substituindo as posições anteriores, evitando um "buraco" no meio do vetor e mantendo o funcionamento do código.
                 * O mesmo é feito na classe Comanda.*/
                if (aux >= 0) {
                    System.arraycopy(clientes, aux, clientes, (aux - 1), (num_max_clientes - aux));
                    clientes[num_clientes_atual].setNome("");
                    clientes[num_clientes_atual].setEmail("");
                    num_clientes_atual--;
                } else {
                    System.out.println("\nFalha ao remover cliente!");
                }
            } else if (aux == 2) {
                System.out.println("Insira o email do cliente que ira sair desta mesa: ");
                aux1 = scan1.nextLine();
                aux = encontraCliente(aux, aux1);

                if (aux >= 0) {
                    System.arraycopy(clientes, aux, clientes, (aux - 1), (num_max_clientes - aux));
                    clientes[num_clientes_atual].setNome("");
                    clientes[num_clientes_atual].setEmail("");
                    num_clientes_atual--;
                } else {
                    System.out.println("Falha ao remover cliente!");
                }
            }

            if(num_clientes_atual == 0){
                this.ocupada = false;
            }
        }
    }
    public void imprimeClientes(){
        if(isOcupada()) {
            for (Cliente i : clientes) {
                System.out.println(i.getNome() + " - " + i.getEmail());
            }
        }else{
            System.out.println("\nNao ha clientes nesta mesa!");
        }
    }
    public void imprimeReserva(){
        System.out.println("Nome: " + this.reserva.getNome());
        System.out.println("Data: " + this.reserva.getData());
    }

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
    public boolean isOcupada() {
        return ocupada;
    }
    public int getNum_clientes_atual() {
        return num_clientes_atual;
    }

    //sets
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public void setReserva() {
        Scanner scan1 = new Scanner(System.in);
        Date aux = new Date();

        System.out.println("Insira o nome a partir do qual sera feita a reserva: ");
        reserva.setNome(scan1.nextLine());

        System.out.println("Insira a data da sua reserva: ");
        System.out.println("Mes: ");
        aux.setMonth(scan1.nextInt());
        System.out.println("Dia: ");
        aux.setDate(scan1.nextInt());
        System.out.println("Horario (Horas e minutos, separados por espaco): ");
        aux.setHours(scan1.nextInt());
        aux.setMinutes(scan1.nextInt());

        reserva.setData(aux);
        reserva.setReservada(true);
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
