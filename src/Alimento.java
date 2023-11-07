public class Alimento {
    //ATRIBUTOS
    private String nome;
    //private Boolean tipo;
    private double valor;
    private int identificador;

    //MÉTODOS
    Alimento (String Nome, double Valor){
        this.nome = Nome;
        this.valor = Valor;
    }

    Alimento (){}

    //gets
    public String getNome() {
        return nome;
    }
   /* public Boolean getTipo() {
        return tipo;
    }*/
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
    /*public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }*/
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
