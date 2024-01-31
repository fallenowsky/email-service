package pl.kurs.mailservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyExchangePackage {
    private String from;
    private String to;
    private double amount;
    private BigDecimal result;
    private String email;
}
