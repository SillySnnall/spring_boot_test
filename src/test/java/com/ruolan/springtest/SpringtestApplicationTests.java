package com.ruolan.springtest;

import com.ruolan.springtest.bean.User;
import com.ruolan.springtest.controller.HelloController;
import com.ruolan.springtest.property.NeoProperties;
import com.ruolan.springtest.redis.RedisService;
import com.ruolan.springtest.spring_data_jpa.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringtestApplicationTests {

    protected static final Logger logger = LoggerFactory.getLogger(SpringtestApplicationTests.class);

    @Test
    public void contextLoads() {
        NeoProperties neoProperties = new NeoProperties();
        ConfigurableApplicationContext context = SpringApplication.run(SpringtestApplicationTests.class);

        String str1 = context.getEnvironment().getProperty("neo");
        System.out.println(str1);
    }


    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/helloJson").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisTest() {
        stringRedisTemplate.opsForValue().set("name", "guanguan");
        String val = stringRedisTemplate.opsForValue().get("name");
        System.out.println(val);
    }

    @Autowired
    private RedisService redisService;

    @Test
    public void redisTest1() {
        User user3 = new User();
        user3.setName("张飒");
        user3.setAge(18);
        redisService.set("user3", user3, 60);
    }


    @Autowired
    UserRepository userRepository;

    @Test
    public void dbTest() {
        List<com.ruolan.springtest.spring_data_jpa.User> all = userRepository.findAll();
        logger.error("来的撒娇了的骄傲了：" + all);
        Optional<com.ruolan.springtest.spring_data_jpa.User> byId = userRepository.findById(1);

        logger.error("来的撒娇了的骄傲了：" + byId);

        com.ruolan.springtest.spring_data_jpa.User qwe = userRepository.findByAccount("qwe");
        logger.error(qwe.toString());
    }
}
