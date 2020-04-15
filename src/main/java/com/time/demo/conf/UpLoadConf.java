package com.time.demo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置图片访问虚拟路径
 * <p>
 * Description: mi-mall
 * Created by time on 2020/3/12 下午8:47
 *
 * @author time
 */
@Configuration
public class UpLoadConf extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("file:/media/time/C14D581BDA18EBFA/WorkSpace/IDEAWorkSpace/mi-mall/src/main/resources/static/");
        super.addResourceHandlers(registry);
    }
}
