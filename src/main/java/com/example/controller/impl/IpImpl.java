package com.example.controller.impl;

import com.example.pojo.Location;
import com.example.util.IpToAddressUtil;
import com.example.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Zenglin.Fang
 * @ClassName IpImpl
 * @Description:
 * @Data: 2021/9/23 15:09
 **/
@Component
@Slf4j
public class IpImpl {
    public void getLocation(HttpServletRequest request, String info, Device device) {
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
        log.warn("(时间):"+ date +"|(使用设备):"+mobile+"|(操作):"+ result +"在"+cityInfo+":"+info+"|(是否为内网IP):"+b);
    }
}
