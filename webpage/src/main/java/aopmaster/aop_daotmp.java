package aopmaster;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class aop_daotmp implements aop_dao{
	
	
	@Override
	public void insertmethod() throws Exception {
		Thread.sleep(1000);
	
	
	}

	@Override
	public void updatemethod() throws Exception {
		Thread.sleep(1000);

	}

	@Override
	public void deletemethod() throws Exception {
		Thread.sleep(1000);

		
	}
	
	
}
