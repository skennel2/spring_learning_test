package org.almansa.springtest.redis;

import org.almansa.springtest.testobject.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("localhost", 6379);
		
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisConfig);
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<Long, Employee> memberRedisTemplate(){
		RedisTemplate<Long, Employee> redisTemplate = new RedisTemplate<>();
		redisTemplate.setEnableTransactionSupport(true); // 트랜젝션 적용여부
		redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class));
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		
		return redisTemplate;
	}
}
