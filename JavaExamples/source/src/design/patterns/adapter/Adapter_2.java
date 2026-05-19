package design.patterns.adapter;

import java.math.BigDecimal;
// Usando Composição

// Adapter ou Wrapper (embrulho)
// Essa forma não está no livro GoF (é uma simplificação)


public class Adapter_2 {

    // Client (método main)
    // Adapter MeuPagamentoCredito
    // Adaptee -> Quem está sendo adaptado -> SdkPagamentoCredito
    // -> Target -> Alvo (Implementação que quero fazer)

    public static void main(String[] args) {
        // Define a interface
        ProcessorPagamento2 credito = new MeuPagamentoCredito2();
        credito.debitar(new BigDecimal("100"));
    }
}
// -----------------------------------------------------------
// Interface é um contrato
interface ProcessorPagamento2 {
    void debitar(BigDecimal valor);
    void creditar(BigDecimal valor);
}


// -----------------------------------------------------------

class MeuPagamentoCredito2 implements ProcessorPagamento2 { // você tem acesso (com se fosse .jar ou lib no maven)

    SdkPagamentoCredito2 sdkPagamentoCredito = new SdkPagamentoCredito2();

    // Está embrulhando
    public void debitar(BigDecimal valor) {
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkPagamentoCredito.creditar(valor);
    }

}

// -----------------------------------------------------------

class SdkPagamentoCredito2 { // sdk fechada! você não tem acesso!
    // posso ate ter acesso, mas não convém alterar
    public void autorizar(BigDecimal valor) {
        // autoriza
    }

    public void capturar(BigDecimal valor) {
        // captura
    }

    public void creditar(BigDecimal valor) {
        // credita
    }

}