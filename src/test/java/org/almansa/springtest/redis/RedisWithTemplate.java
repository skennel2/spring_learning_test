package org.almansa.springtest.redis;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.almansa.springtest.testobject.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RedisConfiguration.class })
public class RedisWithTemplate {

	@Autowired
	private RedisTemplate<Long, Employee> template;

	@Test
	public void 제대로세팅되었나() {
		assertEquals(true, template != null);
	}

	@Test
	public void 객체저장하기() {
		Employee employee = new Employee();
		employee.setId(new Long(1));
		employee.setName("NaYunsu");
		employee.setJoinDate(new Date());

		template.opsForValue().set(new Long(1), employee);
		Employee employeeGet = template.opsForValue().get(new Long(1));
		
		assertEquals("NaYunsu", employeeGet.getName());
	}

}
