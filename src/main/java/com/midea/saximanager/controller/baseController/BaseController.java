package com.midea.saximanager.controller.baseController;

import com.midea.saximanager.response.BaseResponseView;
import com.midea.saximanager.util.IPUtil;
import com.midea.saximanager.util.JacksonUtils;
import com.midea.saximanager.util.PropertiesLoader;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//各种参数效验
public class BaseController {
    protected Logger logger = Logger.getLogger(this.getClass());

    // 首字母转小写
    protected String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    // 首字母转大写
    protected String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    //基本参数效验
    protected BaseResponseView basicParamsCheck(HttpServletRequest request) {
        BaseResponseView baseResponseView = new BaseResponseView();
        String module_name = request.getParameter("module");
        String ver = request.getParameter("ver");
        if (!StringUtils.hasText(module_name)) {
            baseResponseView.setCode("1002");
            baseResponseView.setMsg("模块名称不可为空");
            return baseResponseView;
        }
        if (!StringUtils.hasText(ver)) {
            baseResponseView.setCode("1001");
            baseResponseView.setMsg("模块版本不可为空");
            return baseResponseView;
        }
        return baseResponseView;
    }

    /**
     * 本地模块是否存在校验
     *
     * @param module
     *            模块名
     * @param ver
     *            版本
     * @param properties_name
     *            模块配置文件名
     * @return
     */
    protected BaseResponseView moduleBaseChecked(String module, String ver, String properties_name) {
        BaseResponseView baseResponseView = new BaseResponseView();
        String moduleResult = PropertiesLoader.getProperties(properties_name).getProperty((module));
        if (!StringUtils.hasText(moduleResult)) {
            baseResponseView.setCode("4001");
            baseResponseView.setMsg("访问模块不存在");
            return baseResponseView;
        }
        @SuppressWarnings("unchecked")
        Map<String, Object> map = JacksonUtils.readValue(moduleResult, Map.class);
        // 访问module对应版本是否存在
        String verStr = String.valueOf(map.get("ver"));
        if (!verStr.contains(ver)) {
            baseResponseView.setCode("4002");
            baseResponseView.setMsg("版本号错误");
            return baseResponseView;
        }
        baseResponseView.setData(map);
        return baseResponseView;
    }

    /**
     * api调用权限校验   自己填充
     *
     * @param request
     * @return
     */
    public BaseResponseView authorization( HttpServletRequest request) {
        BaseResponseView baseResponseView = new BaseResponseView();
        // 客户端ip
        String clientIp = IPUtil.getIpAddr(request);
        return baseResponseView;
    }

    private boolean ipCheck(String[] addres, String clientIp) {
        boolean flag = false;
        for (String ip : addres) {
            if (ip.equals(clientIp) || ip.contains(clientIp)) {
                flag = true;
                break;
            }
            if (ip.contains("/")) {
                if (isInRange(clientIp, ip)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean isInRange(String network, String mask) {
        logger.info("network:" + network + "----mask:" + mask);
        String[] networkips = network.split("\\.");
        int ipAddr = (Integer.parseInt(networkips[0]) << 24) | (Integer.parseInt(networkips[1]) << 16)
                | (Integer.parseInt(networkips[2]) << 8) | Integer.parseInt(networkips[3]);
        int type = Integer.parseInt(mask.replaceAll(".*/", ""));
        int mask1 = 0xFFFFFFFF << (32 - type);
        String maskIp = mask.replaceAll("/.*", "");
        String[] maskIps = maskIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(maskIps[0]) << 24) | (Integer.parseInt(maskIps[1]) << 16)
                | (Integer.parseInt(maskIps[2]) << 8) | Integer.parseInt(maskIps[3]);
        return (ipAddr & mask1) == (cidrIpAddr & mask1);
    }

    /**
     * 参数校验
     *
     * @param request
     * @return
     */
    public BaseResponseView paramsCheck( HttpServletRequest request) {
        BaseResponseView baseResponseView = new BaseResponseView();
        return baseResponseView;
    }

    //接口调用次数限制
    @SuppressWarnings("deprecation")
    public BaseResponseView dayNumCheck(String appid, String module, String day_num) {
        BaseResponseView baseResponseView = new BaseResponseView();
//        // 获取当前日期yyyyMMdd
//        String currentDate = DateUtil.getDateYYYYMMdd(new Date());
//        String key = appid + module + currentDate;
//        // api当日调用次数
//        int apiCallCount = 0;
//        Object obj = RedisUtils.get(key);
//        if (null != obj) {
//            apiCallCount = (int) obj;
//        }
//        if (apiCallCount > Integer.parseInt(day_num)) {
//            baseResponseView.setCode("1007");
//            baseResponseView.setMsg("api调用次数超过每日上限");
//            return baseResponseView;
//        }
//        RedisUtils.set(key, apiCallCount + 1, 24 * 3601);
        return baseResponseView;
    }
}
