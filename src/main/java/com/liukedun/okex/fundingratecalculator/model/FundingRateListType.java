package com.liukedun.okex.fundingratecalculator.model;

import lombok.Data;

import java.util.List;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/27/2020 3:59 PM
 */
@Data
public class FundingRateListType {

    private List<FundingRate> fundingRateList;

    @Data
    public static class FundingRate {

        String instrument_id;

        String funding_rate;

        String realized_rate;

        String interest_rate;

        String funding_time;
    }
}
