package org.almansa.springtest.redis;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisDataTypeTest {
	@Test
	public void jedis_string() {
		final String key = "set_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			// 키에 대한 문자열을 저장한다. 
			// 해당하는 키는 하나의 벨류에만 매핑된다.
			jedis.set(key, "01");
			jedis.set(key, "02"); // 01을 덮어쓴다.
			jedis.set(key, "03"); // 02을 덮어쓴다.
			
			String value = jedis.get(key);
			assertEquals("03", value);
		}
	}
	
	@Test
	public void jedis_list() {
		final String key = "list_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			// 리스트의 끝점부터 아이템을 하나씩 넣는다.
			
			jedis.rpush(key, "a", "b", "c");
			// lrange로 범위를 지정해 값을 가져올 수 있다.
			String value1 = jedis.lrange(key, 0, 0).get(0);
			assertEquals("a", value1);
			
			// 리스트의 시작점부 아이템을 하나씩 넣는다.
			// 마지막에 넣은 것이 리스트의 시작점이 된다.
			jedis.lpush(key, "1", "2", "3"); 
			String value2 = jedis.lrange(key, 0, 0).get(0);
			assertEquals("3", value2);
			
			// 마지막 인수로 -1을 넣으면 모든 아이템들을 다 가져온다.
			List<String> allValues = jedis.lrange(key, 0, -1);
			assertEquals(6, allValues.size());
		}
	}
}
