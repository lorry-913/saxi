package com.midea.saximanager.service;

import com.midea.saximanager.model.TPermission;
import com.midea.saximanager.model.TUser;

import java.util.List;

public interface TUserService {
    public TUser getUser(TUser tUser);

    public List<TPermission> getPermissionList(TUser tUser);
}
