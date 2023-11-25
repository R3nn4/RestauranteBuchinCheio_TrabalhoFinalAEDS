public class Alimento {
    //ATRIBUTOS
    private String nome;
    private double valor;
    private int identificador;

    //MÉTODOS
    Alimento (String Nome, double Valor, int Tipo){
        this.nome = Nome;
        this.valor = Valor;
    }
    Alimento (){}

    //gets
    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }
    public int getIdentificador() {
        return identificador;
    }

    //sets
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

}
