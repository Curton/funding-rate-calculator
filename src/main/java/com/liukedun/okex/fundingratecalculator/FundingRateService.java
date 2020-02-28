package com.liukedun.okex.fundingratecalculator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liukedun.okex.fundingratecalculator.model.ContractInformation;
import com.liukedun.okex.fundingratecalculator.model.ContractInformationListType;
import com.liukedun.okex.fundingratecalculator.model.FundingRateListType;
import com.liukedun.okex.fundingratecalculator.model.FundingRateSum;
import com.okcoin.commons.okex.open.api.service.swap.SwapMarketAPIService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/27/2020 3:42 PM
 */
@Service
@AllArgsConstructor
public class FundingRateService {

    private final SwapMarketAPIService swapMarketAPIService;

    @Cacheable("contractInfoString")
    public String getContractInformationString() {
        return swapMarketAPIService.getContractsApi();
    }

    @Cacheable("contractInfoListType")
    public ContractInformationListType getContractInformationListType() {
        String contractInformationString = getContractInformationString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<ContractInformation> contractInformationList = null;
        try {
            contractInformationList = objectMapper.readValue(contractInformationString, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, ContractInformation.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ContractInformationListType contractInformationListType = new ContractInformationListType();
        contractInformationListType.setContractInformationList(contractInformationList);
        return contractInformationListType;
    }

    public List<String> getContractIdList() {
        ContractInformationListType contractInformationListType = getContractInformationListType();
        return contractInformationListType.getContractInformationList()
                .stream()
                .map(ContractInformation::getInstrument_id)
                .collect(Collectors.toList());
    }

    public List<FundingRateSum> getFundingRateSumList() {
        return getFundingRateSumList(null);
    }

    public List<FundingRateSum> getFundingRateSumList(Integer limit) {
        List<String> contractIdList = getContractIdList();
        List<FundingRateSum> fundingRateSumList = new ArrayList<>();
        contractIdList.forEach(o -> fundingRateSumList.add(getFundingRateSum(o, limit)));
        fundingRateSumList.sort(Comparator.comparing(FundingRateSum::getSum).reversed());
        return fundingRateSumList;
    }

    public FundingRateListType getFundingRate(String contractId, Integer limit) {
        String limitString = (String) Optional.ofNullable(limit)
                .map((Function<Integer, Object>) Object::toString)
                .orElse(null);
        String stringResult = swapMarketAPIService.getHistoricalFundingRateApi(contractId, null, null, limitString);
        ObjectMapper objectMapper = new ObjectMapper();
        List<FundingRateListType.FundingRate> o = null;
        try {
            o = objectMapper.readValue(stringResult, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, FundingRateListType.FundingRate.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        FundingRateListType fundingRateListType = new FundingRateListType();
        fundingRateListType.setFundingRateList(o);
        return fundingRateListType;
    }

    public FundingRateListType getFundingRate(String contractId) {
        return getFundingRate(contractId, null);
    }

    public FundingRateSum getFundingRateSum(String contractId, Integer limit) {
        FundingRateListType fundingRate = getFundingRate(contractId, limit);
        BigDecimal sum = new BigDecimal("0");
        for (FundingRateListType.FundingRate rate : fundingRate.getFundingRateList()) {
            String realized_rate = rate.getRealized_rate();
            sum = sum.add(new BigDecimal(realized_rate));
        }
        FundingRateSum fundingRateSum = new FundingRateSum();
        fundingRateSum.setContractId(contractId);
        fundingRateSum.setPeriod(limit);
        fundingRateSum.setSum(sum);
        return fundingRateSum;
    }

    public FundingRateSum getFundingRateSum(String contractId) {
        return getFundingRateSum(contractId, null);
    }

}
