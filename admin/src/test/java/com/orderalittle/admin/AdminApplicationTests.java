package com.orderalittle.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orderalittle.admin.utils.EncryptUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void getPassWord() {
		String userName = "admin";
		String password = "1";
		System.out.println(EncryptUtils.shiroSHA256(userName, password));
	}

}
