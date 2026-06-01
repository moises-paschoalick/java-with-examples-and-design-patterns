package design.patterns.factoryMethod;

public class FactoryMethod_2 {
    // Criador Concreto  (classe que cria um objeto, criar a instância)
    // Produto Abstrado (objeto que está sendo criado)
    // Produto Concreto

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Categoria2 categoria2 = new Categoria2();
        Produto2 produto2 = categoria2.novoProduto();

        CategoriaDigital categoriaDigital = new CategoriaDigital();
        Produto2 produto3 = categoriaDigital.novoProduto();
    }
}

interface Produto2 {
}

class ProdutoDigital2 implements  Produto2 {
    public ProdutoDigital2(){
        System.out.println("Produto Digital2 foi criado");
    }
}

class ProdutoFisico2 implements  Produto2 {

    public ProdutoFisico2(){
        System.out.println("Produto Físico 2 foi criado");
    }
}

class Categoria2 {
    private String nome;
    private Integer prioridade;

    // Factory Method
    public Produto2 novoProduto() {
        System.out.println("Criando Produto Fisico 2");
        return new ProdutoFisico2();
    }
}

// Categoria mais especializada
class CategoriaDigital extends Categoria2 {
    public Produto2 novoProduto() {
        System.out.println("Criando Produto Digital 2");
        return new ProdutoDigital2();
    }
}

