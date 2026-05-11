# Factory Method em Java — Explicação Didática do Exemplo FactoryMethod_4

# Objetivo do exemplo

Esse exemplo mostra algo muito importante:

> O padrão Factory Method está presente dentro da própria API do Java.

Ou seja:

```text
Você já usa Factory Method todos os dias.
```

Mesmo sem perceber.

---

# Código completo

```java
package design.patterns.factorymethod;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public class FactoryMethod_4 {

    // Torna flexível a criação de objetos com Factory Methods
    // Virtual constructor

    public static void main(String[] args) {

        // Static Factory Methods

        Calendar.getInstance();
        NumberFormat.getInstance();
        Stream.of(1, 2, 3, 4);
        List.of(1, 2, 3, 4);
        Integer valueOf = Integer.valueOf("1234");
    }
}
```

---

# O que esse exemplo quer ensinar?

O Java utiliza fortemente:

## Static Factory Methods

Ou seja:

```text
Métodos estáticos que criam objetos.
```

Exemplo:

```java
Calendar.getInstance()
```

Em vez de:

```java
new Calendar()
```

---

# O conceito principal

Factory Method não significa apenas:

```text
Classe Factory separada.
```

Muitas vezes o Factory Method é:

```text
um método estático
```

que decide qual implementação concreta retornar.

---

# 1. Calendar.getInstance()

```java
Calendar.getInstance();
```

Esse é um dos exemplos mais clássicos.

---

# Calendar é abstrata

```java
public abstract class Calendar
```

Logo:

```java
new Calendar()
```

não funciona.

---

# Então quem cria o objeto?

O método:

```java
Calendar.getInstance()
```

---

# O Factory Method escondido

Internamente o Java decide:

```text
GregorianCalendar
```

ou outra implementação dependendo:

* sistema operacional
* localidade
* timezone
* configurações internas

---

# O cliente não sabe disso

Você faz apenas:

```java
Calendar calendar = Calendar.getInstance();
```

E recebe:

```text
alguma implementação concreta
```

Isso é Factory Method.

---

# Fluxo mental

```text
Calendar.getInstance()
          ↓
Java decide implementação
          ↓
new GregorianCalendar()
          ↓
retorna Calendar
```

---

# 2. NumberFormat.getInstance()

```java
NumberFormat.getInstance();
```

Mesmo conceito.

`NumberFormat` também é abstrata.

---

# O Java decide a implementação

Dependendo da localidade:

```text
Brasil → 1.000,50
Estados Unidos → 1,000.50
```

Internamente pode retornar:

```text
DecimalFormat
```

ou outras implementações.

---

# O cliente não conhece a implementação

Ele trabalha apenas com:

```java
NumberFormat
```

Isso reduz acoplamento.

---

# 3. Stream.of()

```java
Stream.of(1, 2, 3, 4);
```

Aqui temos um Factory Method estático.

O método:

```java
of()
```

cria uma implementação concreta de `Stream`.

---

# O detalhe importante

Você NÃO faz:

```java
new Stream()
```

Na verdade:

```text
nem conseguiria
```

Porque:

```java
Stream é interface
```

---

# O Factory Method resolve isso

```java
Stream.of(...)
```

cria a implementação correta internamente.

---

# 4. List.of()

```java
List.of(1, 2, 3, 4);
```

Outro exemplo moderno do Java.

---

# Antes do Java 9

Você fazia:

```java
new ArrayList<>()
```

---

# Agora

Você pode fazer:

```java
List.of(...)
```

O Java decide:

* implementação interna
* otimizações
* imutabilidade
* tamanho ideal

---

# Isso é poderoso

O Java pode trocar implementações internas:

```text
sem quebrar seu código
```

---

# 5. Integer.valueOf()

```java
Integer.valueOf("1234")
```

Outro exemplo extremamente importante.

---

# Por que não usar new?

Poderia existir:

```java
new Integer("1234")
```

Mas:

```text
o Java prefere factory methods
```

---

# Vantagem importante

O Java pode:

* reutilizar objetos
* fazer cache
* otimizar memória

---

# Exemplo real

```java
Integer a = Integer.valueOf(100);
Integer b = Integer.valueOf(100);
```

Internamente o Java pode reutilizar a mesma instância.

---

# Isso seria impossível com new

```java
new Integer(100)
```

sempre criaria um objeto novo.

---

# Static Factory Method

Todos esses exemplos usam:

## Static Factory Method

Ou seja:

```text
Método estático responsável por criar objetos.
```

---

# Diferença para constructor

# Constructor

```java
new Produto()
```

---

# Factory Method

```java
Produto.of()
Produto.getInstance()
Produto.valueOf()
```

---

# Por que isso é melhor?

Factory Methods permitem:

* esconder implementação
* retornar subclasses
* reutilizar objetos
* cache
* lazy loading
* singleton
* flexibilidade
* melhor legibilidade

---

# Virtual Constructor

Você comentou:

```java
// Virtual constructor
```

Esse termo significa:

```text
Método que se comporta como construtor.
```

Mas:

```text
sem usar new diretamente.
```

---

# Exemplo visual

## Constructor

```java
new ArrayList<>()
```

---

## Virtual Constructor

```java
List.of()
```

A criação continua acontecendo.

Mas escondida.

---

# Isso aparece muito no Spring

Exemplo:

```java
BeanFactory.getBean()
```

Você não cria:

```java
new MeuService()
```

O framework cria.

---

# Outro exemplo famoso

```java
LoggerFactory.getLogger()
```

Muito comum no SLF4J.

---

# Analogia simples

Imagine pedir um carro por aplicativo.

Você faz:

```text
Uber.getCar()
```

Você não sabe:

* qual motorista virá
* qual carro será usado
* qual rota será escolhida

O sistema decide.

Isso é Factory Method.

---

# Conceitos utilizados

| Conceito       | Onde aparece                         |
| -------------- | ------------------------------------ |
| Factory Method | `getInstance()`, `of()`, `valueOf()` |
| Encapsulamento | criação escondida                    |
| Polimorfismo   | retorno abstrato/interface           |
| Abstração      | `Calendar`, `List`, `Stream`         |
| Flexibilidade  | implementação interna pode mudar     |
| Reutilização   | `Integer.valueOf()`                  |

---

# Padrões de nomes comuns

O Java usa muitos nomes padrão para factory methods.

| Método          | Significado             |
| --------------- | ----------------------- |
| `of()`          | cria objeto rapidamente |
| `valueOf()`     | converte ou reutiliza   |
| `getInstance()` | retorna instância       |
| `newInstance()` | cria nova instância     |
| `from()`        | cria a partir de algo   |

---

# Visualização mental

```text
Cliente
   │
   ▼
Factory Method
(getInstance/of/valueOf)
   │
   ▼
Java decide implementação
   │
   ▼
Objeto concreto
```

---

# Resumo final

Esse exemplo mostra que:

* Factory Method está presente na API do Java
* métodos estáticos frequentemente funcionam como fábricas
* o Java esconde implementações concretas
* abstrações tornam o código flexível
* o cliente não precisa conhecer a classe real
* frameworks modernos usam intensamente esse conceito

Também mostra uma ideia extremamente importante:

```text
Factory Method não é apenas um padrão acadêmico.
```

Ele está profundamente presente no ecossistema Java moderno.
