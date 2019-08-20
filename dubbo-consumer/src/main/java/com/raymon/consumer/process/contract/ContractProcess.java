package com.raymon.consumer.process.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.aspect.WebLog;
import com.raymon.api.pojo.contract.ContractInfoPojo;
import com.raymon.api.service.contract.ContractService;
import com.raymon.api.utils.IrrUtil;
import com.raymon.consumer.process.common.BaseProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: raymon
 * Date: 2019/6/13
 * Description:合同相关process
 */
@Service
public class ContractProcess extends BaseProcess{

    private static final Logger log =  LoggerFactory.getLogger(ContractProcess.class);

    @Reference(version = "${dubbo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private ContractService contractService;

    /**
     * 查询合同信息
     * @return
     */
    @WebLog(description = "查询合同信息")
    public List<ContractInfoPojo> queryContractInfo(){

        return contractService.queryContractInfo();
    }

    /**
     * 根据合同号查询合同信息
     * @return
     */
    @WebLog(description = "根据合同号查询合同信息")
    public ContractInfoPojo queryContractInfoByContractNO(@RequestParam(defaultValue = "") String contract_no){
        ContractInfoPojo record = new ContractInfoPojo();
        record.setCntrtNo(contract_no);
        return contractService.queryContractInfoByContractNO(record);
    }

    /**
     * 通过redis查询合同信息
     * @return
     */
    @WebLog(description = "通过redis查询合同信息")
    public ContractInfoPojo queryContractInfoByRedis(){

        return contractService.queryContractInfoByRedis();
    }

    /**
     * 计算irr
     * @return
     */
    @WebLog(description = "计算irr----process")
    public void computeIrr(){

        //1。查询合同号
        List list = new ArrayList();
        List<ContractInfoPojo> ll = contractService.queryContractInfo();
        for(int j = 0; j < ll.size(); j++){
            list.add(ll.get(j).getCntrtNo().toString());
        }
        System.out.println(list);

        //2。通过合同号查询日程
        Map<String, Object> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            String contractNo = list.get(i).toString();
            map.put(contractNo, contractService.querySchedule(contractNo));
            System.out.println(map);
        }

        //3。计算irr

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            List li = new ArrayList();
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            List<Map<String, Object>> lo = (List<Map<String, Object>>) entry.getValue();
            for(int i = 0; i < lo.size(); i++){
                li.add(Double.parseDouble(lo.get(i).get("new_obtn").toString()));
            }
            double irr = IrrUtil.getIrr(li);
            System.out.println("contract_no is :"  + entry.getKey() + ", irr is : " + irr);
        }
    }
}
