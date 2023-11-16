import java.util.Date;

public class Reserva {
    //ATRIBUTOS
    private boolean reservada = false;
    private Date data = new Date();
    private String nome = new String();

    //METODOS

    //gets
    public boolean isReservada() {
        return reservada;
    }
    public Date getData() {
        return data;
    }
    public String getNome() {
        return nome;
    }

    //sets
    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
