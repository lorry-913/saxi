package com.midea.saximanager.service.impl;

import com.midea.saximanager.basedao.BaseDao;
import com.midea.saximanager.baseservice.impl.BaseServiceImpl;
import com.midea.saximanager.dao.CsEnterpriseDao;
import com.midea.saximanager.model.CsEnterprise;
import com.midea.saximanager.params.EpParams;
import com.midea.saximanager.service.CsEnterPriseService;
import com.midea.saximanager.util.UUIDUtil;
import com.midea.saximanager.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsEnterPriseServiceImpl extends BaseServiceImpl<CsEnterprise> implements CsEnterPriseService {
    @Autowired
    CsEnterpriseDao csEnterpriseDao;

    @Override
    protected BaseDao<CsEnterprise> getDao() {
        return csEnterpriseDao;
    }

    @Override
    public boolean addEp(EpParams epParams) {
        String name=epParams.getCsName();
        if(getEp(name)==null){
            CsEnterprise csEnterprise = new CsEnterprise();
            csEnterprise.setCsName(epParams.getCsName());
            csEnterprise.setCsAddressDetail(epParams.getCsAddressDetail());
            csEnterprise.setCsCarea(epParams.getCsCarea());
            csEnterprise.setCsConperson(epParams.getCsConperson());
            csEnterprise.setCsOffer(epParams.getCsOffer() == "0" ? true : false);
            csEnterprise.setCsPhone(epParams.getCsPhone());
            csEnterprise.setCsPname(epParams.getCsPname());
            csEnterprise.setCsRegisterMoney(Double.parseDouble(epParams.getCsRegisterMoney()));
            csEnterprise.setCsPhone(epParams.getCsPhone());
            csEnterprise.setCsStime(DateUtil.fomatDate(epParams.getCsStime()));
            csEnterprise.setCsEpid(UUIDUtil.generateUUID().substring(0,10));
            csEnterprise.setCsSqure(Double.parseDouble(epParams.getCsSqure()));
            csEnterprise.setCsPnum(Integer.parseInt(epParams.getCsPnum()));
            csEnterprise.setCsCname(epParams.getCsCname());
            csEnterpriseDao.insert(csEnterprise);
            return true;
        }else{
            return false;
        }
        }

    @Override
    public CsEnterprise getEp(String name) {
        CsEnterprise csEnterprise=new CsEnterprise();
        csEnterprise.setCsName(name);
        CsEnterprise res =csEnterpriseDao.selectOne(csEnterprise);
        return res;
    }

    @Override
    public List<CsEnterprise> getEpList(String epname) {
        return null;
    }
}
