package com.qc.itaojin.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by fuqinqin on 2018/7/5.
 */
public class InetAddressUtil {

    public static InetAddress getLocalHostLANAddress() {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            return jdkSuppliedAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHostAddress(){
        InetAddress address = getLocalHostLANAddress();
        if(address == null){
            return null;
        }

        return address.getHostAddress();
    }

    public static String getHostName(){
        InetAddress address = getLocalHostLANAddress();
        if(address == null){
            return null;
        }

        return address.getHostName();
    }

    public static void main(String[] args){
        InetAddress address = getLocalHostLANAddress();
        System.out.println(address.getHostAddress());
        System.out.println(address.getAddress());
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostName());
    }

}
