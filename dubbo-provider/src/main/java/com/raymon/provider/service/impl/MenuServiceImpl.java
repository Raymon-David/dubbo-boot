package com.raymon.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.pojo.Menu;
import com.raymon.api.service.MenuService;
import com.raymon.provider.dao.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class MenuServiceImpl implements MenuService{

    private static final Logger log =  LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper mapper;

    @Override
    public List<Menu> selectAll() {
        HashMap<Integer,ArrayList<Menu>> map = new HashMap<Integer, ArrayList<Menu>>();
        List<Menu> menus = mapper.selectByExample(null);
        for(Menu menu : menus){
            int parentid = menu.getParentId();
            if(map.containsKey(parentid)){
                map.get(parentid).add(menu);
            }else{
                ArrayList<Menu> temp = new ArrayList<Menu>();
                temp.add(menu);
                map.put(menu.getParentId(),temp);
            }
        }
        for(Menu menu : menus){
            int id = menu.getId();
            if(map.containsKey(id)){
                menu.setType("folder");
                menu.setChildren(map.get(id));
            }else{
                menu.setType("item");
            }
        }
        return map.get(0);
    }

//    @Override
//    public List<Menu> selectByUser(int userId) {
//        HashMap<Integer,ArrayList<Menu>> map = new HashMap<Integer, ArrayList<Menu>>();
//        List<Menu> tempMenus = null;
//        if(userId == -1){
//            MenuCriteria criteria = new MenuCriteria();
//            criteria.createCriteria().andStatusEqualTo("1").andMenuTypeNotEqualTo("2");
//            tempMenus = mapper.selectByExample(criteria);
//        }else {
//            tempMenus = mapper.selectByUser(userId);
//        }
//        for(Menu menu : tempMenus){
//            int parentid = menu.getParentId();
//            if(map.containsKey(parentid)){
//                map.get(parentid).add(menu);
//            }else{
//                ArrayList<Menu> temp = new ArrayList<Menu>();
//                temp.add(menu);
//                map.put(menu.getParentId(),temp);
//            }
//        }
//        for(Menu menu : tempMenus){
//            int id = menu.getId();
//            if(map.containsKey(id)){
//                menu.setType("folder");
//                menu.setChildren(map.get(id));
//            }else{
//                menu.setType("item");
//            }
//        }
//        return map.get(0);
//    }
//

    @Override
    public List<String> selectAuthorities(int userId) {
        if(userId == -1){
            return mapper.selectAuthoritiesByRoot();
        }
        return mapper.selectAuthorities(userId);
    }

//    public boolean addMenu(Menu menu) {
//        return mapper.insertSelective(menu) > 0;
//    }
//
//    @Override
//    public boolean updateMenu(Menu menu) {
//        return mapper.updateByPrimaryKeySelective(menu) > 0;
//    }
//
//    @Override
//    @Transactional
//    public boolean delete(int id) {
//        HashMap<String,Object> map = new HashMap<String, Object>();
//        map.put("menuid",id);
//        mapper.deleteMenuById(map);
//        return true;
//    }
}
