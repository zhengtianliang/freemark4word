package com.zheng.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author: ZhengTianLiang
 * @date: 2022/04/06 22:32
 * @desc:
 *      todo: 注意，这个  document.ftl 是将docx文件的模板(其实就是把内容换成${变量})，另存为 .ftl 形成的
 */

@RestController
@Slf4j
public class TestController {

    Logger logger = Logger.getLogger(TestController.class.toString());

    @Autowired
    private Configuration wordConfiguration;

    @GetMapping(value = "/test")
    public void testExport(HttpServletResponse response){
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "陈大大出版社asdfasdfasdf");
        dataModel.put("tel", "booksasdf121231231231231231231231231231233");

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=books.doc");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        //加载模板
        Template template = null;
        try {
//            template = wordConfiguration.getTemplate("document.ftl", "utf-8");
            template = wordConfiguration.getTemplate("dddd3copy.ftl", "utf-8");
            template.process(dataModel, response.getWriter());//response的Writer不需要我们手动关，tomcat会帮我们关的
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("出错了");
            System.out.println("有何错了");
        }

    }
}
