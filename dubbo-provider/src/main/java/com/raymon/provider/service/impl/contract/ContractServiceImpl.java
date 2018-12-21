package com.raymon.provider.service.impl.contract;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.pojo.contract.ContractInfoPojo;
import com.raymon.api.service.contract.ContractService;
import com.raymon.provider.dao.contract.ContractInfoPojoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ContractServiceImpl implements ContractService {

    private static final Logger log =  LoggerFactory.getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractInfoPojoMapper mapper;

    public ContractInfoPojo queryContractInfo() {
        return mapper.queryData();
    }

    @Override
    public ContractInfoPojo queryContractInfoByContractNO(ContractInfoPojo record) {
        return mapper.queryDataByContractNO(record);
    }
}
