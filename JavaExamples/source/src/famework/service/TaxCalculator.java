package famework.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    public BigDecimal calculate(BigDecimal amount, String taxType) {

        //Fere os princípios SOLID
        // S -> Single responsability
        //      Princípio da responsabilidade única
        //      Uma classe tem que ter um único motivo para mudar
        //      Essa classe tem vários motivos para mudar, precisa alterar toda vez que alterar um percentual, vai
        //      precisar mudar

        // O - > Open Close Principle
        //       Princípio aberto fechado
        //       Uma classe tem que estar aberta para extensão e fechada para modificação
        //       Cada vez que precisar adicionar mais um if (no imposto), isso é um codesmell
        //       Está aberta para modificação e não para extensão

        if (taxType.equals("ICMS")) {
            return calculatePercent(amount, 4);
        }

        if (taxType.equals("ISS")) {
            return calculatePercent(amount, 11);
        }

        if (taxType.equals("IPI")) {
            return calculatePercent(amount, 15);
        }

        throw new IllegalArgumentException("Invalid tax type");

    }

    private static BigDecimal calculatePercent(BigDecimal amount, int percent) {
        return amount
                .multiply(BigDecimal.valueOf(percent))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

}
