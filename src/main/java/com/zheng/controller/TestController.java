package com.zheng.controller;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * @author: ZhengTianLiang
     * @date: 2022/05/18 23:24
     * @desc: biao.ftl 是正常的结果
     */
    @GetMapping(value = "/test3")
    public void testExport3(HttpServletResponse response){
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("id", "1901030121212001");
        dataModel.put("date", "2019年 08 1月11 日");
        dataModel.put("company", "国网山东123省电力公司XXX供电公司");
        dataModel.put("bbb", "转账2123");
        dataModel.put("amount", "壹仟贰佰陆123123123拾捌元零贰分");
        dataModel.put("price", "1268.02");
        dataModel.put("content", "2019年7月XXXXX");
        dataModel.put("ddd", "转账2");
//        dataModel.put("id", "1");
//        dataModel.put("date", "1");
//        dataModel.put("company", "1");
//        dataModel.put("bbb", "1");
//        dataModel.put("amount", "1");
//        dataModel.put("price", "1");
//        dataModel.put("content", "1");
//        dataModel.put("aaa", "1");

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=books.doc");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        //加载模板
        Template template = null;
        try {
//            template = wordConfiguration.getTemplate("document.ftl", "utf-8");
//            template = wordConfiguration.getTemplate("test5.ftl", "utf-8");
            template = wordConfiguration.getTemplate("biao.ftl", "utf-8");
//            template = wordConfiguration.getTemplate("msg.ftl", "utf-8");
            template.process(dataModel, response.getWriter());//response的Writer不需要我们手动关，tomcat会帮我们关的
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("出错了");
            System.out.println("有何错了");
        }

    }

    @GetMapping(value = "/test4")
    public void testExport4(HttpServletResponse response){
//        KVObject bizObject = KVObject.newKVObject();
//        bizObject.with("id", receiptNo)
//                .with("date", new SimpleDateFormat("yyyy年MM月dd日").format(new Date()))
//                .with("company", vo.getOrgName()).with("style", "转账")
//                .with("amount", money)
//                .with("price", new DecimalFormat("0.00#").format(totalAmount))
//                .with("content", content)
//                .with("fil56eName", fileName);
//        Configuration configuration = new Configuration(new freemarker.template.Version("2.3.23"));
//        configuration.setDefaultEncoding("utf-8");
//        configuration.setTemplateLoader(new ClassTemplateLoader(WebMonthlyBillEnclosureController.class.getClassLoader(), "/files/"));
//        Template template = configuration.getTemplate("receipt.ftl", "utf-8");
    }
}
