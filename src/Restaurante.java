public class Restaurante {
    //ATRIBUTOS
    private final int num_max_mesas = 100;
    private int num_mesas_atual = 0;
    private String nome = new String();
    private String endereco = new String();
    public Mesa[] mesas = new Mesa[num_max_mesas];
    public Cardapio cardapio = new Cardapio();

    //MÉTODOS

    Restaurante(){
        inicializaMesas();
    }

    public void inicializaMesas(){
        for(int i = 0; i < num_max_mesas; i++){
            this.mesas[i] = new Mesa();
            this.mesas[i].setNumeroMesa(i);
        }
    }

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
