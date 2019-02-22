package com.raymon.api.service.contract;

import com.raymon.api.pojo.contract.ContractInfoPojo;

/**
 * 查询合同信息
 * Created by raymon.
 */
public interface ContractService {
    ContractInfoPojo queryContractInfo();

    ContractInfoPojo queryContractInfoByRedis();

    ContractInfoPojo queryContractInfoByContractNO(ContractInfoPojo record);
}
