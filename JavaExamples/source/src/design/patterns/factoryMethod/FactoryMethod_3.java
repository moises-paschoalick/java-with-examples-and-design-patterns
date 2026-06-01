package design.patterns.factoryMethod;

public class FactoryMethod_3 {

    // Comum ver classe como Factoy
    // Produto -> ProdutoFactory
    // Pagar com cartão de crédito, carteira virtual
    // ProcessadorPagamento -> ProcessadorPagamentoFactory (pega a instância que precisa)


    // Criador concreto com parâmetro
    // Produto Abstrato
    // Produto Concreto

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Categoria3 categoria3 = new Categoria3();
        Produto3 produto3 = categoria3.novoProduto(1);
    }
}

// Produto Abstrato
interface Produto3 {

}

// Produto Concreto
class ProdutoPadrão3 implements Produto3 {

}

// Produto Concreto
class ProdutoDigital3 extends ProdutoPadrão3 {
    Integer prioridade;
    // Poderia passsar a prioridade como argumento
    public ProdutoDigital3(Integer prioridade) {
        this.prioridade = prioridade;
    }

}

// Produto Concreto
class ProdutoFisico3 extends ProdutoPadrão3 {

}

// Criador concreto com parâmetro
// É a criadora, fábrica de produtos

// Comum ver ProdutoFactory
class Categoria3 {

    private String nome;
    private Integer prioridade;

    // ...
    //Fábrica de objetos
    public Produto3 novoProduto(int tipoProduto) {
        switch (tipoProduto) {
            case 1:
                return new ProdutoPadrão3();
            case 2:
                return new ProdutoDigital3(prioridade);
            case 3:
                return new ProdutoFisico3();
            default:
                throw new IllegalArgumentException();
        }
    }


}