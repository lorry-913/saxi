package com.midea.saximanager.service;

import com.midea.saximanager.baseservice.BaseService;
import com.midea.saximanager.model.TbArea;

import java.util.List;

public interface TbAreaService extends BaseService<TbArea> {
    public List<TbArea> getAreaList(Integer id);
}
