package org.almansa.springtest.redis;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.almansa.springtest.testobject.Employee;
import org.junit.Test;
import org.springframework.util.SerializationUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.BasicCommands;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisWithoutSpringTest {

	@Test
	public void 문자열_set_get() {
		final String key = "test_01";

		try (Jedis jedis = new Jedis("localhost", 6379)) {
			jedis.del(key);

			jedis.set(key, "Hello World");
			assertEquals("Hello World", jedis.get(key));
		}
	}

	@Test
	public void 문자열_set_get_중복키() {
		final String key = "test_01";

		try (Jedis jedis = new Jedis("localhost", 6379)) {
			jedis.del(key);

			jedis.set(key, "Hello World");
			jedis.set(key, "Hello Redis"); // set 메소드는 키에 해당하는 value를 덮어씌운다.
			assertEquals("Hello Redis", jedis.get(key));
		}
	}

	@Test
	public void 문자열_rpush() {
		final String key = "list";

		try (Jedis jedis = new Jedis("localhost", 6379)) {
			jedis.del(key);

			jedis.rpush(key, "1", "2", "3"); // 리스트의 오른쪽에 인수를 삽입하라
			List<String> list = jedis.lrange(key, 0, -1); // 마지막 인수 -1은 전부가져오라는 의미

			assertEquals(3, list.size());

			jedis.lpush(key, "0");
			list = jedis.lrange(key, 0, -1); 
			
			assertEquals(4, list.size());
			assertEquals("0", jedis.lrange(key, 0, 0).get(0));

		}
	}

	@Test
	public void 객체_직렬화로_저장하기() {
		final String key = "employee";

		try (Jedis jedis = new Jedis("localhost", 6379)) {
			jedis.del(key);

			Employee employee = new Employee();
			employee.setId(new Long(1));
			employee.setName("NaYunsu");
			employee.setJoinDate(new Date());

			jedis.set(key.getBytes(), SerializationUtils.serialize(employee)); // 바이트를 저장하면 키도 바이트여야 한다 왜..?

			byte[] employeeByte = jedis.get(key.getBytes());
			Employee employeeGet = (Employee) SerializationUtils.deserialize(employeeByte);

			assertEquals(employeeGet.getName(), "NaYunsu");
		}
	}

	@Test
	public void 객체_json_직렬화로_저장하기() throws IOException {
		final String key = "employee";

		try (Jedis jedis = new Jedis("localhost", 6379)) {
			jedis.del(key);

			Employee employee = new Employee();
			employee.setId(new Long(1));
			employee.setName("NaYunsu");
			employee.setJoinDate(new Date());

			ObjectMapper mapper = new ObjectMapper();

			String employeeJson = mapper.writeValueAsString(employee);

			jedis.set(key, employeeJson);

			Employee employeeGet = mapper.readValue(jedis.get(key), Employee.class);

			assertEquals(employeeGet.getName(), "NaYunsu");
		}
	}

	@Test
	public void jedis_풀링사용하기() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

		try (JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379)) {
			try (Jedis jedis = jedisPool.getResource()) {
				final String key = "pooltest";
				
				jedis.del(key);
				jedis.set(key, "hello");

				assertEquals("hello", jedis.get(key));
			}
		}
	}
	
	@Test
	public void jedis_객체의_basic_commends() {
		final String key = "employee";

		try (Jedis jedis = new Jedis("localhost", 6379)) {
			jedis.del(key);
			
			BasicCommands basicCommands = jedis;
			
			basicCommands.flushAll();
		}
	}
}
