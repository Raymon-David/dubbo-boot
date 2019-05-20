package com.raymon.api.service.contract;

import com.raymon.api.pojo.contract.ContractInfoPojo;

import java.util.List;
import java.util.Map;

/**
 * 查询合同信息
 * Created by raymon.
 */
public interface ContractService {
    List<ContractInfoPojo> queryContractInfo();

    ContractInfoPojo queryContractInfoByRedis();

    ContractInfoPojo queryContractInfoByContractNO(ContractInfoPojo record);

    List<Map<String, Object>> querySchedule(String contractNo);
}
