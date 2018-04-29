package TestDubbo.TestDubboServer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.alibaba.dubbo.demo.TestDubboProviderApplication;
import com.alibaba.dubbo.demo.repository.mysql.CityMapper;
import com.alibaba.dubbo.entity.mysql.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDubboProviderApplication.class)
public class AppTest {
	@Autowired 
	private  ApplicationContext ctx;
	
	@Test
	public void testAdd() {
		CityMapper cityMapper = ctx.getBean(CityMapper.class);
		Assert.assertNotNull(cityMapper);
		City city = cityMapper.selectById(1);
		Assert.assertNotNull(city);
	}
}
