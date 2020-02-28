package com.liukedun.okex.fundingratecalculator;

import com.okcoin.commons.okex.open.api.bean.futures.result.ServerTime;
import com.okcoin.commons.okex.open.api.service.GeneralAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Covey Liu, covey@liukedun.com
 * Date: 2/27/2020 2:50 PM
 */
@Service
public class ServerTimeService {

    private final GeneralAPIService generalAPIService;

    public ServerTimeService(GeneralAPIService generalAPIService) {this.generalAPIService = generalAPIService;}

    public ServerTime getServerTime() {
        return generalAPIService.getServerTime();
    }
}
