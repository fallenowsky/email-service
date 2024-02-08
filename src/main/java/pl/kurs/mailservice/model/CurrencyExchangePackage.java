package pl.kurs.mailservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CurrencyExchangePackage {

    private String from;
    private String to;
    private double amount;
    private BigDecimal result;
    private String email;
}
