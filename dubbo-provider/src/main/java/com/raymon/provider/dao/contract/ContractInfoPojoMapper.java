package com.raymon.provider.dao.contract;

import com.raymon.api.pojo.contract.ContractInfoPojo;

public interface ContractInfoPojoMapper {
    int insert(ContractInfoPojo record);

    int insertSelective(ContractInfoPojo record);

    ContractInfoPojo queryData();

    ContractInfoPojo queryDataByContractNO(ContractInfoPojo record);
}