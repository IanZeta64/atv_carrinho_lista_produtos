import java.util.*;

public class Atv5_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Produtos produtos = new Produtos();

        HashMap<String, Double> carrinho = new HashMap<>();

        String item, resposta, consumirLinha;
        Integer quantidade = 0;
        boolean flagResposta = true, flagQuantidade = true;
        Double soma = 0.0D;

        Produtos.imprimirCatalogo(Produtos.getCatalogo());

        do {
            item = Produtos.escolherProduto(sc, Produtos.getCatalogo());
            if (carrinho.containsKey(item)) {
                System.out.println("Item ja adicionado ao carrinho. " +
                        "Digite a quantidade a TOTAL ser atualizada:");
            }
            do{
                try {
                    quantidade = Produtos.verificarQuantidade(sc);

                    if (carrinho.containsKey(item)) {
                        carrinho.putIfAbsent(item, (Produtos.getCatalogo().get(item) * quantidade));
                        System.out.println("quantidade adicionada no item do carrinho!");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Erro na entrada de dados!");
                    consumirLinha = sc.nextLine();
                    quantidade = 0;
                }
                flagQuantidade = (quantidade <= 0) ? true : false ;
            }while(flagQuantidade);

            carrinho.put(item, quantidade * Produtos.getCatalogo().get(item));
            consumirLinha = sc.nextLine();
            flagResposta = Produtos.retornarResposta(sc);
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
