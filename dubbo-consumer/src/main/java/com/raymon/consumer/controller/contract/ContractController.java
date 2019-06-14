package com.raymon.consumer.controller.contract;

import com.raymon.api.aspect.WebLog;
import com.raymon.api.pojo.contract.ContractInfoPojo;
import com.raymon.consumer.process.contract.ContractProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ContractController {

    private static final Logger log =  LoggerFactory.getLogger(ContractController.class);

    @Resource
    private ContractProcess contractProcess;

    /**
     * 查询合同信息
     * @return
     */
    @RequestMapping(value ="/contract/queryContractInfo" ,method = RequestMethod.GET)
    @WebLog(description = "查询合同信息")
    public List<ContractInfoPojo> queryContractInfo(){

        return contractProcess.queryContractInfo();
    }

    /**
     * 根据合同号查询合同信息
     * @return
     */
    @RequestMapping(value ="/contract/queryContractInfoByContractNO" ,method = RequestMethod.GET)
    @WebLog(description = "根据合同号查询合同信息")
    public ContractInfoPojo queryContractInfoByContractNO(@RequestParam(defaultValue = "") String contract_no){

        return contractProcess.queryContractInfoByContractNO(contract_no);
    }

    /**
     * 通过redis查询合同信息
     * @return
     */
    @RequestMapping(value ="/contract/queryContractInfoByRedis" ,method = RequestMethod.GET)
    @WebLog(description = "通过redis查询合同信息")
    public ContractInfoPojo queryContractInfoByRedis(){

        return contractProcess.queryContractInfoByRedis();
    }

    /**
     * 计算irr
     * @return
     */
    @RequestMapping(value ="/contract/computeIrr" ,method = RequestMethod.GET)
    @WebLog(description = "计算irr")
    public void computeIrr(){

        contractProcess.computeIrr();
    }
}
