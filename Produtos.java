import java.util.Map;
import java.util.Scanner;
public class Produtos {
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
    public static Map<String, Double> getCatalogo() {
        Map<String, Double> catalogo = Map.of("PAO-DE-QUEIJO", 2.5D, "BOLO", 5.00D,
                "SALGADO", 5.50D, "PUDIM", 8.5D, "BISCOITO", 1.0D, "SUCO",
                8.50D, "REFRIGERANTE", 3.50D, "CAFE", 4.25D, "AGUA",
                2.5D, "VITAMINA", 12.00D);
        return catalogo;
    }

}
