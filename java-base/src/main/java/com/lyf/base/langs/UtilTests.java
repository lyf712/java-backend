/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.base.langs;

import org.junit.Test;

import java.net.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @authorliyunfei
 * @date2022/11/14
 **/
public class UtilTests {
    @Test
    public void test(){
        String str =  String.format("com.lyf.%s","ok");
        System.out.println(str);
        // 字符拼接
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        str = stringBuilder.toString();
        // interface--
        CharSequence charSequence = new String();

        Properties properties = new Properties();
        properties.getProperty("val","default-value");

    }

    @Test
    public void testNet(){
        InetAddress result  = null;
        int lowest = Integer.MAX_VALUE;
        try {
            for (Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();
                 nics.hasMoreElements(); ) {
                NetworkInterface ifc = nics.nextElement();
                if (ifc.isUp()) {
                    if (ifc.getIndex() < lowest || result == null) {
                        lowest = ifc.getIndex();
                    } else {
                        continue;
                    }
                    for (Enumeration<InetAddress> addrs = ifc.getInetAddresses(); addrs.hasMoreElements(); ) {
                        InetAddress address = addrs.nextElement();
                        boolean isLegalIpVersion =
                                Boolean.parseBoolean(System.getProperty("java.net.preferIPv6Addresses"))
                                        ? address instanceof Inet6Address : address instanceof Inet4Address;
                        if (isLegalIpVersion && !address.isLoopbackAddress()) {
                            result = address;
                        }
                    }

                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}
