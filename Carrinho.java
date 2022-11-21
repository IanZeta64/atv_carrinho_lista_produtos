import java.util.Map;
import java.util.Scanner;
public class Carrinho {

    public static boolean retornarResposta(Scanner sc) {
        boolean flagResposta = true, flagInterno = true;
        String resposta;
        do {
            System.out.println("Deseja adicionar mais algum produto(S/N)?");
            resposta = sc.nextLine().toUpperCase().trim().replace(" ", "");
            if (resposta.equals("S") || resposta.equals("N")) {
                flagResposta = (resposta.equals("S")) ? true : false;
                flagInterno = false;
            } else {
                System.out.println("Resposta invalida.");
                flagInterno = true;
            }
        }while(flagInterno);
        return flagResposta;
    }
    public static Integer verificarQuantidade(Scanner sc) {
        Integer quantidade;
        boolean flag;
        do {
            System.out.println("Digite a quantidade do produto desejado:");
            quantidade = sc.nextInt();
            flag = (quantidade > 0) ? true : false;
            if(!flag){
                System.out.println("Digite um valor valido.");
            }
        }while (!flag);
        return quantidade;
    }
    public static String escolherProduto(Scanner sc, Map<String, Double> catalogo) {
        boolean flag;
        String item;
        do {
            System.out.println("Digite o produto desejado:");
            item = sc.nextLine().toUpperCase().trim().replace(" ","");
            flag = (catalogo.containsKey(item)) ? true : false;
            if(!flag){
                System.out.println("Digite um item valido do menu.");
            }
        }while (!flag);
        return item;
    }
    public static void imprimirCatalogo(Map<String, Double> catalogo) {
        System.out.println("======BEM-VINDO AO CAFE JAVA!====== \n"
                + "\nESCOLHA O PRODUTO DESEJADO DO MENU: \n");
        catalogo.entrySet().forEach(a -> System.out.printf( "%s -> R$ %.2f %n", a.getKey(), a.getValue() ) );
        System.out.println("\n=================================== \n");
    }
    private static final Map<String, Double> catalogo() {
        Map<String, Double> CATALOGO = Map.of(
                ProdutosPadaria.PAO_DE_QUEIJO.getitem(), ProdutosPadaria.PAO_DE_QUEIJO.getPreco(),
                ProdutosPadaria.BOLO.getitem(), ProdutosPadaria.BOLO.getPreco(),
                ProdutosPadaria.SALGADO.getitem(), ProdutosPadaria.SALGADO.getPreco(),
                ProdutosPadaria.PUDIM.getitem(), ProdutosPadaria.PUDIM.getPreco(),
                ProdutosPadaria.BISCOITO.getitem(), ProdutosPadaria.BISCOITO.getPreco(),
                ProdutosPadaria.SUCO.getitem(), ProdutosPadaria.SUCO.getPreco(),
                ProdutosPadaria.REFRIGERANTE.getitem(), ProdutosPadaria.REFRIGERANTE.getPreco(),
                ProdutosPadaria.CAFE.getitem(), ProdutosPadaria.CAFE.getPreco(),
                ProdutosPadaria.AGUA.getitem(), ProdutosPadaria.AGUA.getPreco(),
                ProdutosPadaria.VITAMINA.getitem(), ProdutosPadaria.VITAMINA.getPreco());
        return CATALOGO;
            }
            public static final Map<String, Double> getCatalogo(){
                return catalogo();
            }
}