# Factory Method em Java: Explicação Didática do Exemplo FactoryMethod_1

Esse exemplo está ainda mais próximo da implementação clássica do padrão **Factory Method** descrito pelo GoF (Gang of Four).

A principal diferença entre o `FactoryMethod_1` e o `FactoryMethod_2` é a forma como o criador é estruturado.

No `FactoryMethod_1`:

* você usa interfaces para o criador (`Categoria`)
* cada implementação concreta cria um produto específico
* existe desacoplamento total

No `FactoryMethod_2`:

* você utilizava herança (`CategoriaDigital extends Categoria2`)
* havia uma implementação base reutilizável

---

# Código completo

```java
package design.patterns.factorymethod;

public class FactoryMethod_1 {

    // Criador Abstrato
    // Produto Abstrato

    // Criador Concreto
    // Produto Concreto

    //Tem duas classes que seguem o mesmo conceito de hierarquias
    // Produto (Digital e Físico) e Categoria (Digital e Fisico)

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Categoria categoria = new Digital();
        Produto produto = categoria.novoProduto();

        Categoria fisico  = new Fisico();
        Produto produtoFisico = fisico.novoProduto();
    }
}

// Produto Abstrato
interface Produto {
}

class ProdutoDigital implements Produto {

    public ProdutoDigital() {
        System.out.println("Produto Digital Criado");
    }
}

class ProdutoFisico implements Produto {

    public ProdutoFisico() {
        System.out.println("Produto Físico Criado");
    }
}

// Criador Abstrato
interface Categoria {

    // Factory Method
    Produto novoProduto();
}

// Criador Concreto
class Digital implements Categoria {

   @Override
   public Produto novoProduto() {
       System.out.println("Criando produto Digital...");
       return new ProdutoDigital();
   }
}

// Criador Concreto
class Fisico implements Categoria {

    @Override
    public Produto novoProduto() {
        System.out.println("Criando produto Físico...");
        return new ProdutoFisico();
    }
}
```

---

# Visão geral da estrutura

Você possui duas hierarquias paralelas.

## Hierarquia de Produtos

```text
Produto
   ▲
   ├── ProdutoDigital
   └── ProdutoFisico
```

---

## Hierarquia de Criadores

```text
Categoria
   ▲
   ├── Digital
   └── Fisico
```

---

# O conceito central

Cada categoria sabe criar seu próprio produto.

Essa é a essência do Factory Method.

---

# 1. Produto Abstrato

```java
interface Produto {
}
```

Representa o contrato dos produtos.

O sistema trabalha com abstração:

```java
Produto produto
```

E não com implementações concretas:

```java
ProdutoDigital produto
```

---

# 2. Produtos Concretos

## ProdutoDigital

```java
class ProdutoDigital implements Produto
```

## ProdutoFisico

```java
class ProdutoFisico implements Produto
```

Esses são os objetos reais criados pela fábrica.

Cada classe representa uma implementação concreta.

---

# 3. Criador Abstrato

```java
interface Categoria {
    Produto novoProduto();
}
```

Essa é a parte mais importante do padrão.

Aqui você define o Factory Method:

```java
Produto novoProduto();
```

Você está dizendo:

> Toda categoria deve saber criar um produto.

Mas a interface não sabe qual produto será criado.

Isso fica para as implementações concretas.

---

# 4. Criadores Concretos

## Digital

```java
class Digital implements Categoria
```

Implementação:

```java
public Produto novoProduto() {
    return new ProdutoDigital();
}
```

---

## Fisico

```java
class Fisico implements Categoria
```

Implementação:

```java
public Produto novoProduto() {
    return new ProdutoFisico();
}
```

Cada classe concreta decide qual produto criar.

---

# Fluxo completo da execução

## Parte 1

```java
Categoria categoria = new Digital();
Produto produto = categoria.novoProduto();
```

Fluxo:

```text
main
 ↓
Digital.novoProduto()
 ↓
new ProdutoDigital()
 ↓
Produto criado
```

Saída:

```text
Criando produto Digital...
Produto Digital Criado
```

---

## Parte 2

```java
Categoria fisico = new Fisico();
Produto produtoFisico = fisico.novoProduto();
```

Fluxo:

```text
main
 ↓
Fisico.novoProduto()
 ↓
new ProdutoFisico()
 ↓
Produto criado
```

Saída:

```text
Criando produto Físico...
Produto Físico Criado
```

---

# O detalhe mais importante

Veja isso:

```java
Categoria categoria = new Digital();
```

A variável é:

```java
Categoria
```

Mas o objeto real é:

```java
Digital
```

Isso é polimorfismo.

---

# Outro ponto importante

O `main` não faz:

```java
new ProdutoDigital()
```

Quem cria o produto é a categoria.

Isso desacopla:

* criação
* utilização

---

# O padrão acontecendo na prática

O Factory Method é exatamente isso:

```text
Classe concreta decide qual objeto concreto criar.
```

---

# Diferença entre FactoryMethod_1 e FactoryMethod_2

# FactoryMethod_1

## Estrutura

```text
Interface → Implementações
```

Exemplo:

```text
Categoria
   ├── Digital
   └── Fisico
```

### Características

* mais desacoplado
* mais próximo do GoF
* mais flexível
* mais orientado a contratos

---

# FactoryMethod_2

## Estrutura

```text
Classe Base → Herança
```

Exemplo:

```text
Categoria2
    └── CategoriaDigital
```

### Características

* reaproveita comportamento
* usa herança
* mais simples para exemplos pequenos

---

# Qual é mais usado profissionalmente?

Normalmente:

## Interfaces + composição

como no `FactoryMethod_1`.

Porque reduz acoplamento.

Muito comum em:

* Spring
* Clean Architecture
* Hexagonal Architecture
* Microsserviços

---

# Analogia simples

Imagine aplicativos de entrega.

## Interface

```text
Entrega
```

## Implementações

```text
Moto
Bicicleta
Drone
```

Cada tipo de entrega sabe criar seu veículo.

O cliente apenas pede:

```text
"Faça uma entrega"
```

e a implementação decide como.

---

# O que esse exemplo ensina

Você praticou:

| Conceito       | Onde                                  |
| -------------- | ------------------------------------- |
| Interface      | `Produto` e `Categoria`               |
| Polimorfismo   | `Categoria categoria = new Digital()` |
| Factory Method | `novoProduto()`                       |
| Desacoplamento | cliente não conhece implementação     |
| Encapsulamento | criação escondida                     |
| SOLID          | Open/Closed + Dependency Inversion    |

---

# Relação com Spring Framework

Isso lembra muito:

```java
BeanFactory
```

ou:

```java
ApplicationContext
```

Você pede:

```java
getBean()
```

e o Spring decide:

* qual implementação criar
* ciclo de vida
* dependências
* proxy

---

# Visualização mental final

```text
                Produto
                   ▲
         ┌─────────┴─────────┐
         │                   │
 ProdutoDigital      ProdutoFisico



               Categoria
                   ▲
         ┌─────────┴─────────┐
         │                   │
        Digital            Fisico
```

Cada categoria cria seu próprio produto.

Esse é o coração do Factory Method.

---

# Resumo final

O padrão Factory Method:

* encapsula criação de objetos
* reduz acoplamento
* melhora extensibilidade
* facilita manutenção
* utiliza polimorfismo
* trabalha com abstrações
* evita `if/else` gigantes
* segue princípios SOLID

É um dos padrões mais importantes da programação orientada a objetos e aparece frequentemente em frameworks como Spring.

