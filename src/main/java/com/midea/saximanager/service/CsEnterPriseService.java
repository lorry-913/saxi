package com.midea.saximanager.service;

import com.midea.saximanager.model.CsEnterprise;
import com.midea.saximanager.params.EpParams;

import java.util.List;

public interface CsEnterPriseService {
    public boolean addEp(EpParams epParams);

    public CsEnterprise getEp(String name);

    public List<CsEnterprise> getEpList(String epname);
}
