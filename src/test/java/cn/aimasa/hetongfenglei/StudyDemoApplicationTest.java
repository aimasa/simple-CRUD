package cn.aimasa.hetongfenglei;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudyDemoApplication.class)
@WebAppConfiguration
public class StudyDemoApplicationTest {
    @Test
    public void contextLoads() {
    }
}