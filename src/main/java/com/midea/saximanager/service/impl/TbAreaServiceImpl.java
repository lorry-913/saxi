package com.midea.saximanager.service.impl;

import com.midea.saximanager.basedao.BaseDao;
import com.midea.saximanager.baseservice.impl.BaseServiceImpl;
import com.midea.saximanager.dao.TbAreaDao;
import com.midea.saximanager.model.TbArea;
import com.midea.saximanager.service.TbAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbAreaServiceImpl extends BaseServiceImpl<TbArea> implements TbAreaService {
    @Autowired
    TbAreaDao tbAreaDao;
    @Override
    protected BaseDao<TbArea> getDao() {
        return tbAreaDao;
    }

    @Override
    public List<TbArea> getAreaList(Integer id) {
        TbArea tbArea=new TbArea();
        tbArea.setParentId(id);
        List<TbArea> list=tbAreaDao.select(tbArea);
        return list;
    }
}
