package TestDubbo.TestDubboServer;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.alibaba.dubbo.demo.RedisService;
import com.alibaba.dubbo.demo.TestDubboProviderApplication;
import com.alibaba.dubbo.demo.repository.mysql.CityMapper;
import com.alibaba.dubbo.entity.mysql.City;
import com.alibaba.dubbo.entity.redis.Cityredis;

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
	public void testMysql() {
		CityMapper cityMapper = ctx.getBean(CityMapper.class);
		Assert.assertNotNull(cityMapper);
		City city = cityMapper.selectById(1);
		Assert.assertNotNull(city);
	}
	
	@Test
	public void testRedis() {
		RedisService redisService = ctx.getBean(RedisService.class);
		Assert.assertNotNull(redisService);
		String id = UUID.randomUUID().toString();
		Cityredis city = new Cityredis();
		city.setId(id);
		city.setName("sssssssssss");
		boolean isOk = redisService.insertCity(city);
		Assert.assertTrue(isOk);
		Cityredis cityRetrun = redisService.getCitybyId(id);
		Assert.assertNotNull(cityRetrun);
		
	}
}
