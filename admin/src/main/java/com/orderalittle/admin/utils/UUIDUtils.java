package com.orderalittle.admin.utils;

import java.util.UUID;

public class UUIDUtils {
	
    /**
     * UUID生成方法
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
   }

}
