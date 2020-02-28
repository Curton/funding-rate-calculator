package com.liukedun.okex.fundingratecalculator.model;

import lombok.Data;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/28/2020 10:09 AM
 */
@Data
public class ContractInformation {

    private String base_currency;

    private String contract_val_currency;

    private String delivery;

    private String is_inverse;

    private String underlying;

    private String instrument_id;

    private String quote_currency;

    private String tick_size;

    private String underlying_index;

    private String settlement_currency;

    private String contract_val;

    private String size_increment;

    private String listing;

    private String coin;

}
