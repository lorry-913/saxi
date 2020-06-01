package com.midea.saximanager.service.impl;

import com.midea.saximanager.basedao.BaseDao;
import com.midea.saximanager.baseservice.impl.BaseServiceImpl;
import com.midea.saximanager.dao.TPermissionDao;
import com.midea.saximanager.dao.TRolePermissionDao;
import com.midea.saximanager.dao.TUserDao;
import com.midea.saximanager.dao.TUserRoleDao;
import com.midea.saximanager.model.*;
import com.midea.saximanager.service.TUserService;
import com.midea.saximanager.util.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class TUserServiceImpl  extends BaseServiceImpl<TUser> implements TUserService {
    @Autowired
    TUserDao tUserDao;
    @Autowired
    TUserRoleDao tUserRoleDao;
    @Autowired
    TPermissionDao tPermissionDao;
    @Autowired
    TRolePermissionDao tRolePermissionDao;


    @Override
    protected BaseDao<TUser> getDao() {
        return tUserDao;
    }

    @Override
    public TUser getUser(TUser tUser) {
        TUser tu= tUserDao.selectOne(tUser);
        return tu;
    }

    @Override
    public List<TPermission> getPermissionList(TUser tUser) {
        TUser tUser1=getUser(tUser);
        TUserRole tUserRole=tUserRoleDao.selectByPrimaryKey(tUser1.getId());
        Example example=new Example(TRolePermission.class);
        example.createCriteria().andEqualTo("roleId",tUserRole.getRoleId());
        List<TRolePermission> list= tRolePermissionDao.selectByExample(example);

        List list1=new ArrayList();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i).getPermissionId());
        }
//
        Example example2=new Example(TPermission.class);
        Example.Criteria criteria=example2.createCriteria();
        criteria.andIn("id",list1);
        List<TPermission> list2=tPermissionDao.selectByExample(example2);
        return list2;
    }
}
