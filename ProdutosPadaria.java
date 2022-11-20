import java.util.Map;

public enum ProdutosPadaria {
    PAO_DE_QUEIJO("PAO-DE-QUEIJO", 2.5D), BOLO("BOLO", 5.00D),
    SALGADO("SALGADO", 5.50D), PUDIM("PUDIM", 8.5D),
    BISCOITO("BISCOITO", 1.0D), SUCO("SUCO", 8.50D),
    REFRIGERANTE("REFRIGERANTE", 3.50D),CAFE("CAFE", 4.25D),
    AGUA("AGUA", 2.5D), VITAMINA("VITAMINA", 12.00D);

    private final String item;
    private final Double preco;
    ProdutosPadaria(String item, Double preco) {
        this.item = item;
        this.preco = preco;
    }
    public Double getPreco() {
        return preco;
    }
    public String getitem() {return item;
    }

}
