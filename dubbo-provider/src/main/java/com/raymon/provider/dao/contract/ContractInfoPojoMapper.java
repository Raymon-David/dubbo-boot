package com.raymon.provider.dao.contract;

import com.raymon.api.pojo.contract.ContractInfoPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ContractInfoPojoMapper {
    int insert(ContractInfoPojo record);

    int insertSelective(ContractInfoPojo record);

    ContractInfoPojo queryData();

    ContractInfoPojo queryDataByContractNO(ContractInfoPojo record);
}