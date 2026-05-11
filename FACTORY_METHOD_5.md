# Factory Method em Java: Explicação Didática do Exemplo Logistics

# Objetivo do exemplo

Esse exemplo representa o modelo clássico do padrão Factory Method descrito pelo GoF (Gang of Four).

É provavelmente o exemplo mais famoso desse padrão.

Ele mostra um problema real:

```text
Como criar objetos diferentes sem acoplar o sistema às implementações concretas?
```

---

# O cenário do problema

Imagine um sistema de logística.

Inicialmente o sistema trabalha apenas com:

```text
Truck
```

Tudo funciona bem.

Mas depois surge uma nova necessidade:

```text
transporte marítimo
```

Agora o sistema precisa suportar:

```text
Ship
```

---

# Problema sem Factory Method

Sem Factory Method o código normalmente fica assim:

```java
if(type.equals("road")) {
    Truck truck = new Truck();
    truck.deliver();
}

if(type.equals("sea")) {
    Ship ship = new Ship();
    ship.deliver();
}
```

---

# Problemas dessa abordagem

Esse modelo gera:

* alto acoplamento
* excesso de `if/else`
* dificuldade de manutenção
* crescimento descontrolado
* dificuldade para adicionar novos transportes

Imagine adicionar:

* Airplane
* Drone
* Train
* Motorcycle

O código começa a crescer rapidamente.

---

# Solução com Factory Method

O Factory Method sugere:

```text
Mover a criação dos objetos para subclasses especializadas.
```

Agora:

* o cliente não conhece os produtos concretos
* subclasses decidem qual produto criar
* o sistema trabalha com abstrações

---

# Estrutura do padrão

O padrão possui duas hierarquias.

---

# Hierarquia dos Produtos

```text
               Transport
                   ▲
         ┌─────────┴─────────┐
         │                   │
       Truck               Ship
```

---

# Hierarquia dos Criadores

```text
                Logistics
                    ▲
          ┌─────────┴─────────┐
          │                   │
     RoadLogistics      SeaLogistics
```

---

# Código completo

```java
public class FactoryMethodExample {

    public static void main(String[] args) {

        Logistics logistics;

        logistics = new RoadLogistics();
        logistics.planDelivery();

        logistics = new SeaLogistics();
        logistics.planDelivery();
    }
}
```

---

# Produto Abstrato

```java
interface Transport {
    void deliver();
}
```

Representa o contrato dos produtos.

Todo transporte deve possuir:

```java
void deliver();
```

---

# Produtos Concretos

## Truck

```java
class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivering by land using truck");
    }
}
```

Entrega por terra.

---

## Ship

```java
class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivering by sea using ship");
    }
}
```

Entrega por mar.

---

# Criador Abstrato

```java
abstract class Logistics {
```

Essa é a parte mais importante do padrão.

---

# Factory Method

```java
public abstract Transport createTransport();
```

Esse método define:

```text
Toda subclasse deve decidir qual transporte criar.
```

---

# Método de negócio

```java
public void planDelivery() {

    Transport transport = createTransport();
    transport.deliver();
}
```

Aqui está o detalhe mais sofisticado do padrão.

A classe abstrata possui:

* comportamento real
* lógica de negócio
* fluxo principal

Mas delega:

```text
a criação do objeto
```

para subclasses.

---

# O detalhe MAIS importante

Veja isso:

```java
Transport transport = createTransport();
```

A classe `Logistics` trabalha apenas com:

```java
Transport
```

Ela NÃO conhece:

* Truck
* Ship

Isso reduz acoplamento.

---

# Criadores Concretos

## RoadLogistics

```java
class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
```

Essa subclasse decide criar:

```text
Truck
```

---

## SeaLogistics

```java
class SeaLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
```

Essa subclasse decide criar:

```text
Ship
```

---

# Fluxo completo da execução

# RoadLogistics

```text
main
 ↓
RoadLogistics.planDelivery()
 ↓
createTransport()
 ↓
new Truck()
 ↓
deliver()
```

---

# SeaLogistics

```text
main
 ↓
SeaLogistics.planDelivery()
 ↓
createTransport()
 ↓
new Ship()
 ↓
deliver()
```

---

# O cliente não conhece os concretos

O cliente trabalha apenas com:

```java
Transport
```

E não com:

```java
Truck
Ship
```

Esse é o verdadeiro benefício do padrão.

---

# Dúvida comum

Muita gente pensa:

```text
“Mas ainda existe new RoadLogistics()”
```

Sim.

Porque alguém ainda precisa decidir:

```text
qual estratégia de logística usar
```

O Factory Method NÃO elimina o `new`.

Ele elimina:

```text
acoplamento com produtos concretos
```

---

# Antes do Factory Method

Cliente dependia diretamente de:

```text
Truck
Ship
```

---

# Depois do Factory Method

Cliente depende apenas de:

```text
Transport
Logistics
```

Muito mais flexível.

---

# O que acontece quando o sistema cresce?

Agora adicionar novos transportes fica fácil.

Exemplo:

```text
Airplane
Drone
Train
```

Você cria:

* novo produto
* nova logística

Sem alterar código antigo.

---

# SOLID aplicado

# Open/Closed Principle

```text
Aberto para extensão
Fechado para modificação
```

Você adiciona novas implementações sem alterar classes existentes.

---

# Dependency Inversion Principle

O sistema depende de:

```java
Transport
```

E não de:

```java
Truck
Ship
```

---

# Polimorfismo na criação

O Factory Method cria:

```text
polimorfismo na criação de objetos
```

Isso é extremamente poderoso.

---

# Virtual Constructor

Factory Method também é conhecido como:

## Virtual Constructor

Porque:

```java
createTransport()
```

funciona como um construtor indireto.

Mas quem decide o objeto real:

```text
é a subclasse
```

---

# Comparação importante

# Sem Factory Method

```java
if(type.equals("road")) {
    return new Truck();
}
```

---

# Com Factory Method

```java
class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
```

A responsabilidade fica encapsulada.

---

# Analogia simples

Imagine um aplicativo de entrega.

O cliente apenas solicita:

```text
"Entregar encomenda"
```

Mas o sistema decide:

* caminhão
* navio
* drone
* avião

O cliente não conhece a implementação concreta.

---

# Relação com Spring Framework

Isso aparece muito no Spring.

Exemplo:

```java
ApplicationContext.getBean()
```

Você não faz:

```java
new MeuService()
```

O framework decide:

* qual implementação criar
* dependências
* proxy
* ciclo de vida

---

# Conceitos utilizados

| Conceito            | Onde aparece                    |
| ------------------- | ------------------------------- |
| Produto Abstrato    | `Transport`                     |
| Produtos Concretos  | `Truck`, `Ship`                 |
| Criador Abstrato    | `Logistics`                     |
| Factory Method      | `createTransport()`             |
| Criadores Concretos | `RoadLogistics`, `SeaLogistics` |
| Polimorfismo        | `Transport transport`           |
| Desacoplamento      | cliente não conhece concretos   |
| Herança             | subclasses alteram criação      |
| SOLID               | Open/Closed + DIP               |

---

# Visualização mental final

```text
                Transport
                    ▲
          ┌─────────┴─────────┐
          │                   │
        Truck               Ship



                Logistics
                    ▲
          ┌─────────┴─────────┐
          │                   │
     RoadLogistics      SeaLogistics
```

---

# A frase que define Factory Method

```text
A subclasse decide qual produto concreto será criado.
```

---

# Resumo final

Esse exemplo mostra:

* abstração
* desacoplamento
* encapsulamento da criação
* polimorfismo
* herança
* SOLID
* extensibilidade
* virtual constructor

É um dos exemplos mais importantes da programação orientada a objetos e representa a implementação clássica do padrão Factory Method.
