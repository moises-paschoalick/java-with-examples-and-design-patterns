# Código completo

```java
public class FactoryMethod_2 {

    // Criador Concreto
    // Produto Abstrato
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

class ProdutoDigital2 implements Produto2 {

    public ProdutoDigital2(){
        System.out.println("Produto Digital2 foi criado");
    }
}

class ProdutoFisico2 implements Produto2 {

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

// Categoria especializada
class CategoriaDigital extends Categoria2 {

    @Override
    public Produto2 novoProduto() {
        System.out.println("Criando Produto Digital 2");
        return new ProdutoDigital2();
    }
}
```

---

# Estrutura do padrão

O Factory Method possui algumas peças principais.

| Papel | Classe |
|---|---|
| Produto Abstrato | `Produto2` |
| Produtos Concretos | `ProdutoFisico2`, `ProdutoDigital2` |
| Criador | `Categoria2` |
| Criador Especializado | `CategoriaDigital` |

---

# 1. Produto Abstrato

```java
interface Produto2 {
}
```

Essa interface representa o contrato dos produtos.

Ela diz:

> Todo produto do sistema deve implementar `Produto2`.

Isso permite trabalhar com abstração.

O código cliente não precisa conhecer:

- `ProdutoFisico2`
- `ProdutoDigital2`

Ele conhece apenas:

```java
Produto2
```

---

# 2. Produtos Concretos

## Produto físico

```java
class ProdutoFisico2 implements Produto2 {
```

## Produto digital

```java
class ProdutoDigital2 implements Produto2 {
```

Essas classes representam os objetos reais que serão criados.

Cada uma possui seu comportamento específico.

---

# 3. Classe Criadora

```java
class Categoria2 {
```

Essa classe contém o Factory Method:

```java
public Produto2 novoProduto()
```

Esse método é responsável por criar o objeto.

---

# Fluxo da criação

Quando executamos:

```java
Categoria2 categoria2 = new Categoria2();
Produto2 produto2 = categoria2.novoProduto();
```

o fluxo acontece assim:

```text
main
 ↓
Categoria2.novoProduto()
 ↓
new ProdutoFisico2()
 ↓
Objeto criado
```

Saída no console:

```text
Criando Produto Fisico 2
Produto Físico 2 foi criado
```

---

# 4. Especialização com herança

Agora temos:

```java
class CategoriaDigital extends Categoria2
```

Ela herda de `Categoria2`.

Mas sobrescreve:

```java
public Produto2 novoProduto()
```

Isso altera o comportamento da criação.

---

# Fluxo da categoria digital

```java
CategoriaDigital categoriaDigital = new CategoriaDigital();
Produto2 produto3 = categoriaDigital.novoProduto();
```

Fluxo:

```text
main
 ↓
CategoriaDigital.novoProduto()
 ↓
new ProdutoDigital2()
 ↓
Objeto criado
```

Saída:

```text
Criando Produto Digital 2
Produto Digital2 foi criado
```

---

# O ponto mais importante

O código cliente NÃO sabe qual classe concreta será criada.

Ele trabalha apenas com:

```java
Produto2
```

Isso reduz acoplamento.

---

# Sem Factory Method

O código normalmente ficaria assim:

```java
if(tipo.equals("digital")) {
    return new ProdutoDigital2();
}

if(tipo.equals("fisico")) {
    return new ProdutoFisico2();
}
```

Problemas:

- muito `if`
- código difícil de manter
- difícil de expandir
- alto acoplamento

---

# Com Factory Method

Cada classe sabe criar seu próprio produto.

Isso organiza o sistema.

---

# Benefícios

## Desacoplamento

O cliente não conhece implementações concretas.

---

## Extensibilidade

Podemos adicionar novas categorias sem alterar código existente.

Exemplo:

```java
class CategoriaPremium extends Categoria2 {

    @Override
    public Produto2 novoProduto() {
        return new ProdutoPremium();
    }
}
```

---

## Organização

A lógica de criação fica centralizada.

---

## Polimorfismo

O sistema trabalha com abstrações.

---

# Conceitos utilizados nesse exemplo

Esse código usa vários conceitos importantes do Java:

| Conceito | Onde aparece |
|---|---|
| Interface | `Produto2` |
| Herança | `CategoriaDigital extends Categoria2` |
| Polimorfismo | `Produto2 produto2` |
| Sobrescrita | `@Override` |
| Encapsulamento | criação escondida no método |
| Factory Method | `novoProduto()` |

---

# Diagrama mental

```text
                Produto2
                   ▲
        ┌──────────┴──────────┐
        │                     │
ProdutoFisico2       ProdutoDigital2



                Categoria2
                     ▲
                     │
            CategoriaDigital
```

---

# Analogia simples

Imagine uma cafeteria.

Você pede:

```text
"Quero um café"
```

Você não prepara o café manualmente.

A cafeteria:

- escolhe ingredientes
- prepara
- monta
- entrega pronto

Ela funciona como uma fábrica.

---

# Relação com Spring Framework

O Spring usa muito esse conceito.

Exemplos:

- BeanFactory
- FactoryBean
- LoggerFactory
- EntityManagerFactory

Você apenas pede o objeto:

```java
getBean()
```

e o framework decide:

- qual implementação criar
- singleton ou prototype
- dependências
- proxy
- cache

---

# Princípio SOLID utilizado

O Factory Method ajuda no:

## Open/Closed Principle

> Aberto para extensão.
> Fechado para modificação.

Você adiciona novas implementações sem alterar código já existente.

---

# Resumo final

O Factory Method:

- encapsula criação de objetos
- reduz acoplamento
- melhora organização
- facilita manutenção
- facilita crescimento do sistema
- usa polimorfismo e herança
- evita `if/else` gigantes

É um dos padrões mais importantes da programação orientada a objetos.
