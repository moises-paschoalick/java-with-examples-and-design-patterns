package design.patterns.strategy.famework;

import design.patterns.strategy.famework.controller.TaxController;
import design.patterns.strategy.famework.dto.TaxRequestDTO;

import java.math.BigDecimal;

public class TestController {

    public static void main(String[] args) {

        TaxRequestDTO request = new TaxRequestDTO();
        request.setAmount(new BigDecimal(100.00));
        //request.setTaxType("ICMS");
        //request.setTaxType("IPI");
        request.setTaxType("ISS");
        //request.setTaxType("NAOEXISTE");

        TaxController taxController = new TaxController();
        taxController.calculate(request);

    }

}
