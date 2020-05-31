package com.midea.saximanager;

import com.midea.saximanager.common.RedisUtils;
import com.midea.saximanager.service.CsEnterPriseService;
import com.midea.saximanager.service.TbAreaService;
import com.midea.saximanager.util.JacksonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IotserverApplicationTests {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    TbAreaService tbAreaService;
    @Autowired
    CsEnterPriseService csEnterPriseService;

    @Test
    void contextLoads() {
        System.out.println(JacksonUtils.toJSon(csEnterPriseService.getEp("合肥浦发银行")));
//        System.out.println(JacksonUtils.toJSon(xmgDeviceService.getDeviceByDid("898607b6121700337172")));
    }

}
