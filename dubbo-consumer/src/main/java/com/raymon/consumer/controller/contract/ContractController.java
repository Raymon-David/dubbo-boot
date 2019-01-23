package com.raymon.consumer.controller.contract;

import com.raymon.api.pojo.contract.ContractInfoPojo;
import com.raymon.api.service.contract.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ContractController {

    private static final Logger log =  LoggerFactory.getLogger(ContractController.class);

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private ContractService contractService;

    /**
     * 查询合同信息
     * @return
     */
    @RequestMapping(value ="/contract/queryContractInfo" ,method = RequestMethod.GET)
    public ContractInfoPojo queryContractInfo(){
        return contractService.queryContractInfo();
    }

    /**
     * 根据合同号查询合同信息
     * @return
     */
    @RequestMapping(value ="/contract/queryContractInfoByContractNO" ,method = RequestMethod.GET)
    public ContractInfoPojo queryContractInfoByContractNO(@RequestParam(defaultValue = "") String contract_no){
        ContractInfoPojo record = new ContractInfoPojo();
        record.setCntrtNo(contract_no);
        return contractService.queryContractInfoByContractNO(record);
    }

    /**
     * 通过redis查询合同信息
     * @return
     */
    @RequestMapping(value ="/contract/queryContractInfoByRedis" ,method = RequestMethod.GET)
    public ContractInfoPojo queryContractInfoByRedis(){

        return contractService.queryContractInfoByRedis();
    }
}
