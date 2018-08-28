package org.almansa.springtest.environment;

import java.util.Map;

import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;

public class EnvironmentTest {
    @Test
    public void systemEnvironmentTest() {
        StandardEnvironment env = new StandardEnvironment();

        // 시스템 환경변수 데이터 조회
        Map<String, Object> se = env.getSystemEnvironment();
        for (Map.Entry<String, Object> entry : se.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(env.getProperty("USERPROFILE"));
    }
}
