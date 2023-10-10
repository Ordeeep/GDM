package padroes;

public interface ProdutoFactory {
    Produto criarProduto(int id, String nome, double preco, String categoria);
    class SupermercadoProdutoFactory implements ProdutoFactory {
        public Produto criarProduto(int id, String nome, double preco, String categoria) {
            return new Produto(id, nome, preco, categoria);
        }
    }
}
