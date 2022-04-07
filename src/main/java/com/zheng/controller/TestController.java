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

    @GetMapping(value = "/test2")
    public void testExport2(HttpServletResponse response){
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("aaa", "陈大大出版社asdfasdfasdf");
        dataModel.put("bbb", "booksasdf121231231231231231231231231231233");
        dataModel.put("ccc", "booksasdf12133");
        dataModel.put("ddd", "boo1233");
        dataModel.put("eee", "bo231231233");
        dataModel.put("fff", "booksasdf121233");
        dataModel.put("ggg", "booksasdf3");
        dataModel.put("hhh", "bo3");

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=books.doc");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        //加载模板
        Template template = null;
        try {
//            template = wordConfiguration.getTemplate("document.ftl", "utf-8");
            template = wordConfiguration.getTemplate("shou3.ftl", "utf-8");
            template.process(dataModel, response.getWriter());//response的Writer不需要我们手动关，tomcat会帮我们关的
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("出错了");
            System.out.println("有何错了");
        }

    }

    @GetMapping(value = "/test3")
    public void testExport3(HttpServletResponse response){
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("id", "1901030001");
        dataModel.put("date", "2019年 08 月11 日");
        dataModel.put("company", "国网山东省电力公司XXX供电公司");
        dataModel.put("bbb", "转账");
        dataModel.put("amount", "壹仟贰佰陆拾捌元零贰分");
        dataModel.put("price", "1268.02");
        dataModel.put("content", "2019年7月XXXXXXXXXXXX供电公司公司XXXXXXXXXXXX供电公司公司上差旅费垫付款");
        dataModel.put("aaa", "d");

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=books.doc");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        //加载模板
        Template template = null;
        try {
//            template = wordConfiguration.getTemplate("document.ftl", "utf-8");
            template = wordConfiguration.getTemplate("zheng33.ftl", "utf-8");
            template.process(dataModel, response.getWriter());//response的Writer不需要我们手动关，tomcat会帮我们关的
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("出错了");
            System.out.println("有何错了");
        }

    }
}
