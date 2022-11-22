import java.util.*;

public class Atv5_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrinho cr = new Carrinho();

        HashMap<String, Double> pedido = new HashMap<>();

        String item;
        Integer quantidade;
        boolean flagResposta, flagQuantidade;
        Double soma;

        cr.imprimirCatalogo(cr.getCatalogo());

        do {
            item = cr.escolherProduto(sc, cr.getCatalogo(), pedido);
            do {
                try {
                    quantidade = cr.verificarQuantidade(sc, pedido, item);
                } catch (InputMismatchException e) {
                    System.out.println("Erro na entrada de dados!");
                    sc.nextLine();
                    quantidade = 0;
                }
                flagQuantidade = (quantidade <= 0) ? true : false;
            } while (flagQuantidade);

            pedido.put(item, quantidade * cr.getCatalogo().get(item));
            sc.nextLine();

            flagResposta = cr.retornarResposta(sc);
        } while (flagResposta);
        soma = cr.somarCarrinho(pedido);

        System.out.println("===================================");
        System.out.println("ITENS NO CARRINHO:");
        pedido.entrySet().forEach(a -> System.out.println(a.getKey() + " = R$" + a.getValue()));
        System.out.println("===================================");
        System.out.println("VALOR FINAL:");
        System.out.printf("R$ %.2f.%n", soma);
        System.out.println("===================================");
        sc.close();
    }
}
