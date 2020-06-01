package com.midea.saximanager.service.impl;

import com.midea.saximanager.basedao.BaseDao;
import com.midea.saximanager.baseservice.impl.BaseServiceImpl;
import com.midea.saximanager.dao.TPermissionDao;
import com.midea.saximanager.dao.TRolePermissionDao;
import com.midea.saximanager.dao.TUserRoleDao;
import com.midea.saximanager.model.*;
import com.midea.saximanager.service.TUserRoleService;
import com.midea.saximanager.service.TbAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserRoleServiceImpl extends BaseServiceImpl<TUserRole> implements TUserRoleService {
    @Autowired
    TUserRoleDao tUserRoleDao;
    @Autowired
    TPermissionDao tPermissionDao;
    @Autowired
    TRolePermissionDao tRolePermissionDao;



    @Override
    protected BaseDao<TUserRole> getDao() {
        return tUserRoleDao;
    }

    @Override
    public Integer getroleid(TUser tUser) {
        return tUserRoleDao.selectByPrimaryKey(tUser.getId()).getRoleId();
    }
}
