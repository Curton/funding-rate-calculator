package com.liukedun.okex.fundingratecalculator.model;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/27/2020 4:53 PM
 */
@Data
public class FundingRateSum {

    private String contractId;

    private BigDecimal sum;

    @Getter(lazy = true)
    private final String sumInPercent = sumInPercent();

    private Integer period;

    String sumInPercent() {
        if (sum == null) {
            return null;
        }
        return sum.multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString() + "%";
    }

}
