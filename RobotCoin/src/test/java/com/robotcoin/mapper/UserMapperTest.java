package com.robotcoin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.mapper.UserMapper;
import com.robotcoin.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	  @Autowired
	    private UserMapper userMapper;

	    @Test
	    public void test(){
	        User u = userMapper.findUserById("1");
	        System.err.println(u);
	 
	    }
}
