package design.patterns.factorymethod;

public class FactoryMethod_1 {

    // Criador Abstrato
    // Produto Abstrato

    // Criador Concreto
    // Produto Concreto


    //Tem duas classes que seguem o mesmo conceito de hierarquias
    // Produto (Digital e Físico) e Categoria (Digital e Fisico)
    //

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Categoria categoria = new Digital();
        Produto produto = categoria.novoProduto();

        Categoria fisico  = new Fisico();
        Produto produtoFisico = fisico.novoProduto();
    }
}
// Produto Abstrato
// poderia ser abstract class Produto {}
interface Produto {
}

class ProdutoDigital implements Produto {

    public ProdutoDigital() {
        System.out.println("Produto Digital Criado");
    }
}

class ProdutoFisico implements  Produto {
    public ProdutoFisico() {
        System.out.println("Produto Físico Criado");
    }
}

// Criador Abstrato
// Uma interface é como se fosse uma classe totalmente abstrata
interface Categoria {
    // Factory Method na forma mais padrão (Raíz)
    Produto novoProduto();
}

// Criador Concreto
class Digital implements Categoria {

   @Override
   public Produto novoProduto() {
       // ...
       System.out.println("Criando produto Digital...");
       return new ProdutoDigital();
   }
}

// Criador Concreto
class Fisico implements Categoria {

    @Override
    public Produto novoProduto() {
        // ...
        System.out.println("Criando produto Físico...");
        return new ProdutoFisico();
    }
}

