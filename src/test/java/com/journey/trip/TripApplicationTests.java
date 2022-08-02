package com.journey.trip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TripApplicationTests {

    // @Value会自动读取application.properties配置文件中的内容
    // ${name} 为配置文件中=前面的内容
    @Value("${name}")
    private String name;

    @Test
    void contextLoads() {
        System.out.println("name:"+name);
    }

}
