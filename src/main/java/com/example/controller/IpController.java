package com.example.controller;

import com.example.pojo.Location;
import com.example.util.IpToAddressUtil;
import com.example.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Zenglin.Fang
 * @ClassName IpController
 * @Description:
 * @Data: 2021/4/9 14:54
 **/
@SuppressWarnings("all")
@Controller
@Slf4j
public class IpController {
    @RequestMapping("/getIp")
    @ResponseBody
    public String login(HttpServletRequest request, Device device){
        String mobile = "";

        if (device.isMobile()) {
            mobile = "手机";
        } else if (device.isTablet()) {
            mobile = "平板";
        } else if(device.isNormal()){
            mobile = "电脑";
        }else {
            mobile = "其他";
        }
        Date date = new Date();
        Location result=new Location();
        String ipAddress = IpUtil.getIpAddr(request);
        String cityInfo = IpToAddressUtil.getCityInfo(ipAddress);
        boolean b = IpUtil.internalIp(ipAddress);
        result.setIp(ipAddress);
        log.warn(result.toString()+":"+cityInfo);
        return "(时间):"+ date +"|(使用设备):"+mobile+"|(操作):"+ result +"在"+cityInfo+":"+"进入getIp"+"|(是否为内网IP):"+b;

    }
}
