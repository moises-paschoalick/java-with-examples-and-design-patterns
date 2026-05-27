package famework;

import famework.controller.TaxController;
import famework.dto.TaxRequestDTO;

import java.math.BigDecimal;

public class TestController {

    public static void main(String[] args) {

        TaxRequestDTO request = new TaxRequestDTO();
        request.setAmount(new BigDecimal(100.00));
        request.setTaxType("ICMS");

        TaxController taxController = new TaxController();
        taxController.calculate(request);

    }

}
