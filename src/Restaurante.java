public class Restaurante {
    //ATRIBUTOS
    private final int num_max_mesas = 20;
    private int num_mesas_atual = 0;
    private String nome = new String();
    private String endereco = new String();
    private Mesa[] mesas = new Mesa[num_max_mesas];
    private Cardapio cardapio = new Cardapio();

    //MÉTODOS

    //gets
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    //sets
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
