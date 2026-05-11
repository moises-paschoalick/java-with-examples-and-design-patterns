package design.patterns.adapter;

import java.math.BigDecimal;

// Adapter ou Wrapper

// Essa forma não está no livro GoF (é uma simplificação)
public class Adapter_1 {
    public static void main(String[] args) {
        MeuPagamentoCredito credito = new MeuPagamentoCredito();
        credito.debitar(new BigDecimal("100"));
    }
}

// -----------------------------------------------------------

class MeuPagamentoCredito { // você tem acesso

    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();

    public void debitar(BigDecimal valor) {
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkPagamentoCredito.creditar(valor);
    }

}

// -----------------------------------------------------------

class SdkPagamentoCredito { // sdk fechada! você não tem acesso!
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