package com.brownbag.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.brownbag.domain.Article;
import com.brownbag.domain.filter.ArticleFilter;
import com.brownbag.repository.ArticleRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;


@Controller
public class MainController {

    @Resource
    private ArticleRepository articleRepository;

    @RequestMapping("/sample1")
    @ResponseBody
    @Transactional(readOnly = true)
    public List sample1() throws Exception {
        return findByFilter("/com/brownbag/sample1.json");
    }

    @RequestMapping("/sample2")
    @ResponseBody
    @Transactional(readOnly = true)
    public List sample2() throws Exception {
        return findByFilter("/com/brownbag/sample2.json");
    }

    @RequestMapping("/sample3")
    @ResponseBody
    @Transactional(readOnly = true)
    public List sample3() throws Exception {
        return findByFilter("/com/brownbag/sample3.json");
    }

    @RequestMapping("/sample4")
    @ResponseBody
    @Transactional(readOnly = true)
    public List sample4() throws Exception {
        return findByFilter("/com/brownbag/sample4.json");
    }

    public List<Article> findByFilter(String jsonFilename) throws Exception {
        ArticleFilter articleFilter = deserialize(jsonFilename);
        return articleRepository.findByFilter(articleFilter);
    }

    private ArticleFilter deserialize(String jsonFilename) throws Exception {
        InputStream inputStream = getClass().getResourceAsStream(jsonFilename);
        String json = IOUtils.toString(inputStream, "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, ArticleFilter.class);
    }
}
