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
    public Comanda comandaComidas = new Comanda(0);
    public Comanda comandaBebidas = new Comanda(1);
    private boolean ocupada = false;

    //MÉTODOS

    public void adicionaCliente(){
        //Confere se ainda ha espaços disponíveis na mesa;
        if(num_clientes_atual < num_max_clientes) {
            clientes[num_clientes_atual] = new Cliente();
            Scanner scanner1 = new Scanner(System.in);
            boolean i = false;
            String aux;
            this.ocupada = true;

            //Confere se o nome ja foi cadastrado;
            do {
                System.out.println("Insira o nome do cliente: ");
                aux = scanner1.nextLine();

                for(int j = 0; j <= num_clientes_atual; j++){
                    if(Objects.equals(clientes[j].getNome(), aux)){
                        System.out.println("\nEste cliente ja foi cadastrado!");
                        break;
                    }else{
                        clientes[num_clientes_atual].setNome(aux);
                        i = true;
                        break;
                    }
                }
            }while(!i);
            i = false;

            //Confere se o email ja foi cadastrado;
            do {
                System.out.println("Insira o email do cliente: ");
                aux = scanner1.nextLine();

                for(int j = 0; j <= num_clientes_atual; j++){
                    if(Objects.equals(clientes[j].getEmail(), aux)){
                        System.out.println("\nEste cliente ja foi cadastrado!");
                        break;
                    }else{
                        clientes[num_clientes_atual].setEmail(aux);
                        i = true;
                        break;
                    }
                }
            }while(!i);
            this.num_clientes_atual++;
        }
        else{
            System.out.println("\nMesa lotada!");
        }
    }

    public void imprimeClientes(){
        if(isOcupada()) {
            for (int i = 0; i < num_clientes_atual; i++) {
                System.out.println(clientes[i].getNome() + " - " + clientes[i].getEmail());
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
    public Comanda getComandaComidas() {
        return comandaComidas;
    }
    public Comanda getComandaBebidas() {return comandaBebidas; }
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
    public void setComandaComidas(Comanda comandaComidas) {
        this.comandaComidas = comandaComidas;
    }
    public void setComandaBebidas(Comanda comandaBebidas) {
        this.comandaBebidas = comandaBebidas;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
