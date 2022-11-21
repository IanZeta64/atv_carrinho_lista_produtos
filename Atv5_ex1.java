import java.util.*;

public class Atv5_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrinho cr = new Carrinho();

        HashMap<String, Double> pedido = new HashMap<>();

        String item, consumirLinha;
        Integer quantidade = 0;
        boolean flagResposta = true, flagQuantidade = true;
        Double soma = 0.0D;

        cr.imprimirCatalogo(cr.getCatalogo());

        do {
            item = cr.escolherProduto(sc, cr.getCatalogo());
            if (pedido.containsKey(item)) {
                System.out.println("Item ja adicionado ao carrinho. " +
                        "Digite a quantidade a TOTAL ser atualizada:");
            }
            do {
                try {
                    quantidade = cr.verificarQuantidade(sc);

                    if (pedido.containsKey(item)) {
                        pedido.putIfAbsent(item, (cr.getCatalogo().get(item) * quantidade));
                        System.out.println("quantidade adicionada no item do carrinho!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro na entrada de dados!");
                    consumirLinha = sc.nextLine();
                    quantidade = 0;
                }
                flagQuantidade = (quantidade <= 0) ? true : false;
            } while (flagQuantidade);

            pedido.put(item, quantidade * cr.getCatalogo().get(item));
            consumirLinha = sc.nextLine();
            flagResposta = cr.retornarResposta(sc);
        } while (flagResposta);

        System.out.println("ITENS NO CARRINHO:");
        pedido.entrySet().forEach(a -> System.out.println(a.getKey() + " = R$" + a.getValue()));
        System.out.println("\nVALOR FINAL:");

        soma = somarCarrinho(pedido);
        System.out.printf("R$ %.2f.", soma);
        sc.close();

    }

    public static Double somarCarrinho(HashMap<String, Double> carrinho) {
        Double soma = 0.0D;
        for (Double valores : carrinho.values()) {
            soma += valores;
        }
        return soma;
    }
}
