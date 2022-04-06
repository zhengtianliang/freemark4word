package com.zheng.config;

import freemarker.template.Configuration;
import org.springframework.context.annotation.Bean;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

/**
 * @author: ZhengTianLiang
 * @date: 2022/04/06 22:22
 * @desc:
 */

@org.springframework.context.annotation.Configuration
public class WordConfig {

    @Bean
    public Configuration wordConfiguration(){
        Configuration config = new Configuration();

        Configuration result = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        result.setDefaultEncoding("utf-8");
        //设置模板加载器
        result.setClassForTemplateLoading(this.getClass(), "/wordtemp");
        return result;
    }
}
