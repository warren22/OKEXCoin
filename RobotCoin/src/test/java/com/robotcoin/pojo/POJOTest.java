package com.robotcoin.pojo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.mapper.UserMapper;
import com.robotcoin.pojo.POJO;
import com.robotcoin.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class POJOTest {
	    @Autowired
	    private User bean;

	    @Test
	    public void get(){
	        User u = bean.get(1);
	        System.err.println(u);

	    }
//	    @Test
	    public void save(){
	    	bean.setAccount("123");
	    	bean.save();
	        User u = bean.get(2);
	        System.err.println(u);

	    }
	    @Test
	    public void list(){
	    	
	        List<? extends POJO> u = bean.list();
	        u.forEach(e->{System.err.println(e);});

	    }
}
