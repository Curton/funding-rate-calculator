package com.liukedun.okex.fundingratecalculator;

import com.liukedun.okex.fundingratecalculator.model.ContractInformationListType;
import com.liukedun.okex.fundingratecalculator.model.FundingRateSum;
import com.okcoin.commons.okex.open.api.bean.futures.result.ServerTime;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/27/2020 3:31 PM
 */
@RestController
@AllArgsConstructor
public class Controller {

    private ServerTimeService serverTimeService;

    private FundingRateService fundingRateService;

    @GetMapping("/server-time")
    public ServerTime getServerTime() {
        return serverTimeService.getServerTime();
    }

    @GetMapping("/contract-info")
    public ContractInformationListType getContractInformationListType() {
        return fundingRateService.getContractInformationListType();
    }

    @GetMapping("/list{limit}")
    public List<FundingRateSum> f(@PathVariable int limit) {
        return fundingRateService.getFundingRateSumList(limit);
    }
}
