package com.raymon.provider.service.impl.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.pojo.user.URolePojo;
import com.raymon.api.service.user.RoleService;
import com.raymon.api.utils.LoggerUtils;
import com.raymon.provider.dao.user.URolePermissionMapper;
import com.raymon.provider.dao.user.URolePojoMapper;
import com.raymon.provider.dao.user.UserPojoMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class RoleServiceImpl implements RoleService{

    @Autowired
    URolePojoMapper roleMapper;
    @Autowired
    UserPojoMapper userMapper;
    @Autowired
    URolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(URolePojo record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(URolePojo record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public URolePojo selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(URolePojo record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(URolePojo record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }


//    @Override
//    public Pagination<URolePojo> findPage(Map<String, Object> resultMap,
//                                      Integer pageNo, Integer pageSize) {
//        return super.findPage(resultMap, pageNo, pageSize);
//    }

//    @Override
//    public Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(
//            Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
//        return super.findPage("findRoleAndPermission", "findCount", resultMap, pageNo, pageSize);
//    }

    @Override
    public Map<String, Object> deleteRoleById(String ids) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            int count=0;
            String resultMsg = "删除成功。";
            String[] idArray = new String[]{};
            if(StringUtils.contains(ids, ",")){
                idArray = ids.split(",");
            }else{
                idArray = new String[]{ids};
            }

            c:for (String idx : idArray) {
                Long id = new Long(idx);
                if(new Long(1).equals(id)){
                    resultMsg = "操作成功，But'系统管理员不能删除。";
                    continue c;
                }else{
                    count+=this.deleteByPrimaryKey(id);
                }
            }
            resultMap.put("status", 200);
            resultMap.put("count", count);
            resultMap.put("resultMsg", resultMsg);
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
            resultMap.put("status", 500);
            resultMap.put("message", "删除出现错误，请刷新后再试！");
        }
        return resultMap;
    }

    @Override
    public Set<String> findRoleByUserId(Long userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public List<URolePojo> findNowAllPermission() {
        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("userId", TokenManager.getUserId());
        return roleMapper.findNowAllPermission(map);
    }
    /**
     * 每20分钟执行一次
     */
    @Override
    public void initData() {
        roleMapper.initData();
    }
}
