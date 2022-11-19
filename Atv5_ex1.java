import java.util.*;

public class Atv5_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produtos produtos = new Produtos();

        Map<String, Double> catalogo = produtos.getCatalogo();
        HashMap<String, Double> carrinho = new HashMap<>();

        String item, resposta, consumirLinha;
        Integer quantidade = 0;
        boolean flagResposta = true, flagQuantidade = true;
        Double soma = 0.0D;

        produtos.imprimirCatalogo(catalogo);

        do {
            item = produtos.escolherProduto(sc, catalogo);
            if (carrinho.containsKey(item)) {
                System.out.println("Item ja adicionado ao carrinho. " +
                        "Digite a quantidade a TOTAL ser atualizada:");
            }
            do{
                try {
                    quantidade = produtos.verificarQuantidade(sc);

                    if (carrinho.containsKey(item)) {
                        carrinho.putIfAbsent(item, (catalogo.get(item) * quantidade));
                        System.out.println("quantidade adicionada no item do carrinho!");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Erro na entrada de dados!");
                    consumirLinha = sc.nextLine();
                    quantidade = 0;
                }
                flagQuantidade = (quantidade <= 0) ? true : false ;
            }while(flagQuantidade);

            carrinho.put(item, quantidade * catalogo.get(item));
            consumirLinha = sc.nextLine();
            flagResposta = produtos.retornarResposta(sc);
        } while (flagResposta);

        System.out.println("ITENS NO CARRINHO:");
        carrinho.entrySet().forEach(a -> System.out.println(a.getKey() + " = R$" + a.getValue()));
        System.out.println("\nVALOR FINAL:");

        for (Double valores: carrinho.values()) {
            soma += valores;
        }
        System.out.printf("R$ %.2f.", soma);
        sc.close();
    }
}
