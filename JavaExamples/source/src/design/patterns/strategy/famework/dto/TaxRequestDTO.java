package design.patterns.strategy.famework.dto;

import java.math.BigDecimal;

public class TaxRequestDTO {

    String taxType;
    BigDecimal amount;
    int tax;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
}
