package com.raymon.provider.service.impl.contract;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.raymon.api.pojo.contract.ContractInfoPojo;
import com.raymon.api.service.contract.ContractService;
import com.raymon.provider.dao.contract.ContractInfoPojoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

@Service(version = "${dubbo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ContractServiceImpl implements ContractService {

    private static final Logger log =  LoggerFactory.getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractInfoPojoMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<ContractInfoPojo> queryContractInfo() {
        return mapper.queryData();
    }

    @Override
    public ContractInfoPojo queryContractInfoByContractNO(ContractInfoPojo record) {
        return mapper.queryDataByContractNO(record);
    }

    @Override
    public List<Map<String, Object>> querySchedule(String contractNo) {
        return mapper.querySchedule(contractNo);
    }

    public ContractInfoPojo queryContractInfoByRedis() {
        log.info(" ------ ContractServiceImpl queryContractInfoByRedis start -----");

        ContractInfoPojo contractInfo = null;

        if(redisTemplate.opsForValue().get("queryContractInfoByRedis") != null){
                String str = JSON.toJSONString(redisTemplate.opsForValue().get("queryContractInfoByRedis"));
                 JSONObject userJson = JSONObject.parseObject(str);
            contractInfo = JSON.toJavaObject(userJson, ContractInfoPojo.class);
        }else{
            redisTemplate.opsForValue().set("queryContractInfoByRedis", mapper.queryData());
            List<ContractInfoPojo> ll = mapper.queryData();
        }

        log.info(" ------ ContractServiceImpl queryContractInfoByRedis end -----");
        return contractInfo;
    }
}
