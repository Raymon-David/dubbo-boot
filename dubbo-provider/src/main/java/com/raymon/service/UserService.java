package com.raymon.service;

import com.raymon.pojo.DubboUser;
import com.raymon.pojo.UserKey;

public interface UserService {

    public DubboUser getUser(UserKey uk);
}
