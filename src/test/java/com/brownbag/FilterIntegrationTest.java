package com.brownbag;

import com.brownbag.domain.Article;
import com.brownbag.domain.filter.ArticleFilter;
import com.brownbag.repository.ArticleFilterRepository;
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
 * Date: 7/20/2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
public class FilterIntegrationTest {

    @Resource
    private ArticleFilterRepository articleFilterRepository;

    @Resource
    private MainController mainController;

    @Test
    public void testSample1() throws Exception {
        ArticleFilter articleFilter = mainController.deserialize("/com/brownbag/sample1.json");
        articleFilter = articleFilterRepository.save(articleFilter);
        Assert.assertNotNull(articleFilter.getId());
    }

    @Test
    public void testSample2() throws Exception {
        ArticleFilter articleFilter = mainController.deserialize("/com/brownbag/sample2.json");
        articleFilter = articleFilterRepository.save(articleFilter);
        Assert.assertNotNull(articleFilter.getId());
    }

    @Test
    public void testSample3() throws Exception {
        ArticleFilter articleFilter = mainController.deserialize("/com/brownbag/sample3.json");
        articleFilter = articleFilterRepository.save(articleFilter);
        Assert.assertNotNull(articleFilter.getId());
    }

    @Test
    public void testSample4() throws Exception {
        ArticleFilter articleFilter = mainController.deserialize("/com/brownbag/sample4.json");
        articleFilter = articleFilterRepository.save(articleFilter);
        Assert.assertNotNull(articleFilter.getId());
    }
}
