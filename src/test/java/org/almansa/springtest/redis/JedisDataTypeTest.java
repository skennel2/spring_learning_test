package org.almansa.springtest.redis;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class JedisDataTypeTest {
	
	/*
	 * String Type
	 */
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
	
	/*
	 * List Type
	 */
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
	 
	/*
	 * lpop과 rpop을 활용해서 레디스 List를 큐나 스택처럼 활용할 수 있다.
	 */
	@Test
	public void jedis_list_pop() {
		final String key = "list_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			jedis.rpush(key, "a", "b", "c");
			
			// 리스트의 끝점에서 아이템을 하나씩 꺼낸다.
			String value = jedis.rpop(key);
			assertEquals(value, "c");
			
			List<String> allValues = jedis.lrange(key, 0, -1);
			
			// c가 빠져서 사이즈가 2 
			assertEquals(2, allValues.size());
			
			// 리스트의 시작점에서 아이템을 하나씩 꺼낸다.
			String value2 = jedis.lpop(key);
			assertEquals(value2, "a");
			
			List<String> allValues2 = jedis.lrange(key, 0, -1);
			assertEquals(1, allValues2.size());
		}
	}
	
	@Test
	public void jedis_list_blocking_pop_is_deperecated() {
		final String key = "list_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			jedis.rpush(key, "a", "b", "c");
			
			//deprecated
			//jedis.brpop(key);
		}
	}
	
	// set은 정렬되지 않은 문자열 집합이다.
	@Test
	public void jedis_list_set() {
		final String key = "set_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			jedis.sadd(key, "a", "b", "c", "c");
			
			// key에 다음 요소가 들어있는지 여부 리턴
			boolean isExists = jedis.sismember(key, "c");
			assertEquals(true, isExists);
		}
	}
	
	@Test(expected = JedisDataException.class)
	public void jedis_list_set타입의_데이터를_lrange로_가져온다면() {
		final String key = "set_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			jedis.sadd(key, "a", "b", "c", "c");
			List<String> allValues2 = jedis.lrange(key, 0, -1); //JedisDataException
		}
	}
	
	@Test(expected = JedisDataException.class)
	public void jedis_list_set타입의_데이터를_pop으로_가져온다면 () {
		final String key = "set_test";
		try(Jedis jedis = new Jedis("localhost", 6379)){
			jedis.del(key);
			
			jedis.sadd(key, "a", "b", "c", "c");
			
			String value = jedis.rpop(key); // JedisDataException
			assertEquals("c", value);
		}
	}
}
