# Factory Method em Java: Explicação Didática
Também é conhecido como: Virtual Constructor

Tipo: Criacional

## Objetivo do padrão Factory Method

O padrão de projeto **Factory Method** serve para:

- encapsular a criação de objetos
- desacoplar quem usa do objeto concreto
- facilitar extensão do sistema
- evitar `if/else` gigantes para criar objetos

A ideia principal é:

> Uma classe fica responsável por criar os objetos.

Em vez do código cliente usar:

```java
new ProdutoFisico2()
```

ou

```java
new ProdutoDigital2()
```

ele apenas pede:

```java
novoProduto()
```

e a classe decide qual objeto criar.

---
[Exemplo FactoryMehtod_1](FACTORY_METHOD_1.md)

[Exemplo FactoryMehtod_2](FACTORY_METHOD_2.md)

[Exemplo FactoryMehtod_3](FACTORY_METHOD_3.md)

[Exemplo FactoryMehtod_4](FACTORY_METHOD_4.md)

