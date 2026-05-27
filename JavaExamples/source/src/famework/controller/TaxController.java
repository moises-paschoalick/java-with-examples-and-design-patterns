package famework.controller;

import famework.dto.TaxRequestDTO;
import famework.service.TaxCalculator;

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

         BigDecimal tax = serviceTaxCalculator.calculate(amount, taxType);

        System.out.println("---- response ----");
        System.out.println(taxType);
        System.out.println(tax);

    }


}
