package padroes;

import java.util.List;
import java.util.Scanner;

public class ProdutoController {
    private ProdutoRepository repository;
    private Scanner scanner;

    public ProdutoController(ProdutoFactory.SupermercadoProdutoFactory factory) {
        this.repository = new ProdutoRepository();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        //Esse metodo serve para exibir a interface de texto pro usuario o switch sendo as escolhas dele
        int escolha;
        do {
            exibirMenu();
            escolha = scanner.nextInt();
            scanner.nextLine(); 
            switch (escolha) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    editarProduto();
                    break;
                case 3:
                    deletarProduto();
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    break;
            }
        } while (escolha != 0);
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("Seja bem-vindo ao Sistema GDM - Gerenciamento de mercadorias");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Editar Produto");
        System.out.println("3 - Deletar Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("0 - Fechar o Programa");
        System.out.print("Digite o comando: ");
    }

    private void adicionarProduto() {
        
        System.out.println("Digite o ID do produto:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Digite a categoria do produto:");
        String categoria = scanner.nextLine();

        repository.criarProduto(id, nome, preco, categoria);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void editarProduto() {
        System.out.println("Digite o ID do produto que deseja editar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produtoExistente = repository.encontrarProdutoPorId(id);
        if (produtoExistente == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do produto:");
        String novoNome = scanner.nextLine();

        System.out.println("Digite o novo preço do produto:");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Digite a nova categoria do produto:");
        String novaCategoria = scanner.nextLine();

        repository.alterarProduto(id, novoNome, novoPreco, novaCategoria);
        System.out.println("Produto editado com sucesso!");
    }

    private void deletarProduto() {
        System.out.println("Digite o ID do produto que deseja deletar:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Produto produtoExistente = repository.encontrarProdutoPorId(id);
        if (produtoExistente == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        repository.deletarProduto(id);
        System.out.println("Produto deletado com sucesso!");
    }

    private void listarProdutos() {
        List<Produto> produtos = repository.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}
