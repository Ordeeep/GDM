package padroes;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();


    public void criarProduto(int id, String nome, double preco, String categoria) {
        Produto novoProduto = new Produto(id, nome, preco, categoria);
        produtos.add(novoProduto);
    }

    public Produto encontrarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void alterarProduto(int id, String novoNome, double novoPreco, String novaCategoria) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setNome(novoNome);
                produto.setPreco(novoPreco);
                produto.setCategoria(novaCategoria);
                return;
            }
        }
    }

    public void deletarProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    //Metodo para listar todos os produtos cadastrados 
    public List<Produto> listarProdutos() {
        return produtos;
    }
}
