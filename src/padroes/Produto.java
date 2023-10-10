package padroes;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String categoria;
 
    public Produto(int id, String nome, double preco, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }
    
    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Categoria: " + categoria;
    }
}
