import padroes.*;

public class Main {
    public static void main(String[] args) {
        ProdutoFactory.SupermercadoProdutoFactory factory = new ProdutoFactory.SupermercadoProdutoFactory();
        ProdutoController controller = new ProdutoController(factory);
        controller.executar();
    }
}
