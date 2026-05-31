package design.patterns.strategy.famework.controller;

import design.patterns.strategy.famework.dto.TaxRequestDTO;
import design.patterns.strategy.famework.service.*;

import java.math.BigDecimal;

public class TaxController {

    private TaxCalculator serviceTaxCalculator = new TaxCalculator();

    public TaxController() {
    }

    public TaxController(TaxCalculator taxCalculator){
        this.serviceTaxCalculator = taxCalculator;
    }

    //Rota("/tax/calculate)
    public void calculate(TaxRequestDTO request) {

         String taxType = request.getTaxType();
         BigDecimal amount = request.getAmount();

         // Antes do Strategy
         // BigDecimal tax = serviceTaxCalculator.calculate(amount, taxType);

        /*
        Depois do Strategy
        https://refactoring.guru/design-patterns/strategy

        Importante
        O código cliente (neste caso o controller) escolhe uma estratégia concreta e passa ela
        para o contexto. O cliente deve estar ciente das diefenças
        entre as estratégia para que faça a escolha certa.


        Importante, o Strategy não resolve os problemas dos IF em sim.
        Depois de desenvolvido vc vai perceber que vai precisar dos if, (ISS, ICMS e etc).
        Ele resolve o problema:
         - Open Close principal
         - Single Responsability
         - Obsessão por tipos primitivos.

        Existe outro padrão que resolve esse problema dos IFs que é o Factory
       */

        /*
        O Fluxo correto do Strategy
        Controller
            ↓
        switch
            ↓
        TaxCalculator.setStrategy()
            ↓
        TaxCalculator.calculate()
            ↓
        ISS.calculate()
        */

        TaxTypeStrategy taxStrategy = switch (taxType) {
           case "ISS" -> new ISS();
           case "ICMS" -> new ICMS();
           case "IPI" -> new IPI();
           default -> {
               System.out.println("Tipo desconhecido:" + taxType);
               throw new IllegalArgumentException("Invalid tax type");
           }
        };

        serviceTaxCalculator.setTaxType(taxStrategy);
        BigDecimal tax = taxStrategy.calculate(amount);

        System.out.println("---- response ----");
        System.out.println(taxType);
        System.out.println(tax);

    }


}
