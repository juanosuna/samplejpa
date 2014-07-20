package com.brownbag;

import com.brownbag.domain.Article;
import com.brownbag.web.MainController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
public class JSonQueryIntegrationTest {

    @Resource
    private MainController mainController;

    @Test
    public void testSample1() throws Exception {
        List<Article> articles = mainController.findByFilter("/com/brownbag/sample1.json");
        Assert.assertEquals(3, articles.size());
    }

    @Test
    public void testSample2() throws Exception {
        List<Article> articles = mainController.findByFilter("/com/brownbag/sample2.json");
        Assert.assertEquals(3, articles.size());
    }

    @Test
    public void testSample3() throws Exception {
        List<Article> articles = mainController.findByFilter("/com/brownbag/sample3.json");
        Assert.assertEquals(4, articles.size());
    }

    @Test
    public void testSample4() throws Exception {
        List<Article> articles = mainController.findByFilter("/com/brownbag/sample4.json");
        Assert.assertEquals(0, articles.size());
    }
}
