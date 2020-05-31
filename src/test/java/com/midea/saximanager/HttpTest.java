package com.midea.saximanager;

import com.midea.saximanager.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpTest {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            Map hashMap=new HashMap();
            hashMap.put("deviceid","861428040106743");
            hashMap.put("content","{\"action\":\" attrQuery\",\"param\":[\"20ga01\",\"20gw00\",\"60gw00\"]}");
            String res=HttpClientUtils.post("http://localhost:8099/saximanager/sendPushMsg",hashMap);
            System.out.println(res);
            TimeUnit.SECONDS.sleep(60);
        }
    }
}
