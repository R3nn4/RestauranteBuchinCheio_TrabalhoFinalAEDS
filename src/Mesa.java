import java.util.Objects;
import java.util.Scanner;

public class Mesa {
    //ATRIBUTOS
    private int numeroMesa;
    private String data; //???
    private boolean reserva;
    private Cliente[] clientes = new Cliente[4];
    private int num_clientes_atual = 0;
    private final int num_max_clientes = 4;
    private Comanda comanda = new Comanda();

    //MÉTODOS

    //gets
    public int getNumeroMesa() {
        return numeroMesa;
    }
    public boolean isReserva() {
        return reserva;
    }
    public Comanda getComanda() {
        return comanda;
    }
    public void imprimeClientes(){
        for(Cliente i : clientes){
            System.out.println(i.getNome() + " - " + i.getEmail());
        }
    }
    //sets
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
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
        // fazer depois
    }
}
