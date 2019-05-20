package com.raymon.provider.dao.contract;

import com.raymon.api.pojo.contract.ContractInfoPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface ContractInfoPojoMapper {
    int insert(ContractInfoPojo record);

    int insertSelective(ContractInfoPojo record);

    List<ContractInfoPojo> queryData();

    ContractInfoPojo queryDataByContractNO(ContractInfoPojo record);

    List<Map<String, Object>> querySchedule(String contractNo);
}