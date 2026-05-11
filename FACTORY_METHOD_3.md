# Factory Method em Java: Explicação Didática do Exemplo FactoryMethod_3

# Objetivo do exemplo

Esse exemplo mostra uma variação muito comum do padrão Factory Method utilizada em sistemas reais.

Diferente dos exemplos anteriores, aqui a fábrica decide qual objeto criar com base em um parâmetro.

Essa abordagem é extremamente comum em:

* gateways de pagamento
* processadores de notificação
* integração com APIs
* estratégias de autenticação
* drivers de banco de dados
* sistemas de mensageria
* frameworks como Spring

---

# Ideia central

A fábrica recebe uma informação:

```java
int tipoProduto
```

E decide:

```text
qual implementação concreta criar
```

---

# Código completo

```java
package design.patterns.factorymethod;

public class FactoryMethod_3 {

    // Comum ver classe como Factory
    // Produto -> ProdutoFactory
    // Pagar com cartão de crédito, carteira virtual
    // ProcessadorPagamento -> ProcessadorPagamentoFactory

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

    public ProdutoDigital3(Integer prioridade) {
        this.prioridade = prioridade;
    }
}

// Produto Concreto
class ProdutoFisico3 extends ProdutoPadrão3 {

}

// Fábrica de objetos
class Categoria3 {

    private String nome;
    private Integer prioridade;

    // Factory Method
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
```

---

# Estrutura do padrão

| Papel              | Classe                                                |
| ------------------ | ----------------------------------------------------- |
| Produto Abstrato   | `Produto3`                                            |
| Produtos Concretos | `ProdutoPadrão3`, `ProdutoDigital3`, `ProdutoFisico3` |
| Factory            | `Categoria3`                                          |

---

# O que mudou nesse exemplo?

Nos exemplos anteriores:

```text
Cada classe concreta criava um produto específico.
```

Agora:

```text
Uma única fábrica decide qual produto criar.
```

Isso é muito comum no mercado.

---

# 1. Produto Abstrato

```java
interface Produto3 {

}
```

Essa interface representa o contrato dos produtos.

Todas as implementações seguem essa abstração.

O sistema trabalha com:

```java
Produto3
```

E não com classes concretas diretamente.

---

# 2. Produtos Concretos

## Produto padrão

```java
class ProdutoPadrão3 implements Produto3
```

Produto padrão do sistema.

---

## Produto digital

```java
class ProdutoDigital3 extends ProdutoPadrão3
```

Aqui existe herança.

`ProdutoDigital3` especializa `ProdutoPadrão3`.

Além disso:

```java
Integer prioridade;
```

Mostra que produtos concretos podem ter comportamentos ou atributos específicos.

---

## Produto físico

```java
class ProdutoFisico3 extends ProdutoPadrão3
```

Outro tipo concreto.

---

# Hierarquia dos produtos

```text
                 Produto3
                     ▲
                     │
             ProdutoPadrão3
                ▲         ▲
                │         │
     ProdutoDigital3   ProdutoFisico3
```

---

# 3. A fábrica

```java
class Categoria3 {
```

Essa classe centraliza toda criação.

Ela funciona como:

```text
Fábrica de produtos
```

---

# Factory Method

```java
public Produto3 novoProduto(int tipoProduto)
```

Esse método recebe um parâmetro:

```java
tipoProduto
```

E decide qual objeto concreto retornar.

---

# Fluxo da criação

## Quando executamos

```java
Produto3 produto3 = categoria3.novoProduto(1);
```

Fluxo:

```text
main
 ↓
Categoria3.novoProduto(1)
 ↓
case 1
 ↓
new ProdutoPadrão3()
 ↓
Objeto criado
```

---

# Decisão da fábrica

```java
switch (tipoProduto)
```

A fábrica escolhe:

| Tipo | Produto criado  |
| ---- | --------------- |
| 1    | ProdutoPadrão3  |
| 2    | ProdutoDigital3 |
| 3    | ProdutoFisico3  |

---

# O ponto mais importante

O cliente NÃO faz:

```java
new ProdutoDigital3()
```

Quem decide isso é a fábrica.

O cliente apenas informa:

```java
qual tipo deseja
```

---

# Por que isso é importante?

Imagine um sistema de pagamentos.

Sem factory:

```java
if(tipo.equals("PIX")) {
    return new PixProcessor();
}

if(tipo.equals("CARTAO")) {
    return new CartaoProcessor();
}
```

Isso espalha regras pelo sistema.

---

# Com factory

```java
PagamentoProcessor processor = factory.criar(tipo);
```

Toda lógica fica centralizada.

---

# Analogia simples

Imagine uma fábrica de carros.

Você chega e fala:

```text
Quero o modelo 2
```

A fábrica internamente decide:

```text
Modelo SUV
```

ou:

```text
Modelo Sedan
```

Você não monta o carro manualmente.

---

# Esse exemplo é um Simple Factory

Tecnicamente, esse exemplo também lembra muito o padrão:

## Simple Factory

Porque:

* existe uma única fábrica
* ela possui uma lógica interna de decisão
* normalmente usa `if` ou `switch`

---

# Diferença para Factory Method clássico

# Factory Method clássico

```text
Herança decide o produto.
```

Exemplo:

```text
Digital → cria ProdutoDigital
Fisico → cria ProdutoFisico
```

---

# FactoryMethod_3

```text
Parâmetro decide o produto.
```

Exemplo:

```text
tipoProduto = 1 → ProdutoPadrão3
```

---

# Então está errado?

Não.

No mercado os nomes acabam misturando.

Muita gente chama isso de:

* Factory
* Factory Method
* Simple Factory

O importante é entender:

```text
A criação foi encapsulada.
```

---

# Problema desse modelo

Esse trecho:

```java
switch (tipoProduto)
```

pode crescer demais.

Exemplo:

```text
case 1
case 2
case 3
case 50
case 100
```

Isso pode ferir:

# Open/Closed Principle

Porque toda vez que surge um novo produto:

```text
precisa alterar a fábrica
```

---

# Como melhorar?

Uma abordagem mais profissional seria:

* Map
* Strategy
* Registro automático
* Spring BeanFactory
* Enum com comportamento
* Injeção de dependência

---

# Exemplo moderno

```java
Map<TipoProduto, Supplier<Produto3>> produtos;
```

Assim você evita `switch` gigante.

---

# Relação com Spring Framework

O Spring faz algo parecido.

Você pede:

```java
getBean()
```

E internamente ele decide:

* qual implementação criar
* qual classe retornar
* ciclo de vida
* dependências
* proxy

---

# Conceitos utilizados

| Conceito       | Onde aparece                             |
| -------------- | ---------------------------------------- |
| Interface      | `Produto3`                               |
| Herança        | `ProdutoDigital3 extends ProdutoPadrão3` |
| Encapsulamento | criação escondida                        |
| Factory        | `Categoria3`                             |
| Polimorfismo   | retorno `Produto3`                       |
| Switch Factory | decisão por parâmetro                    |
| SOLID          | parcialmente aplicado                    |

---

# Visualização mental

```text
                   Categoria3
                        │
                        │ tipoProduto
                        ▼
                ┌─────────────────┐
                │     switch      │
                └─────────────────┘
                   │      │      │
                   ▼      ▼      ▼
          ProdutoPadrão3
          ProdutoDigital3
          ProdutoFisico3
```

---

# Resumo final

Esse exemplo mostra:

* fábrica centralizada
* criação baseada em parâmetro
* encapsulamento de objetos
* desacoplamento parcial
* uso de abstração
* polimorfismo
* herança

Também mostra uma transição importante entre:

* Factory Method
* Simple Factory
* fábricas modernas usadas em frameworks

É um padrão extremamente comum em aplicações corporativas.
