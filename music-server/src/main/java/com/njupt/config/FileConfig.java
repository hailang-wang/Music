package com.njupt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/06/9:48
 * @Description:定位各种文件的地址
 */

@Configuration
public class FileConfig implements WebMvcConfigurer {
//webmvcConfigureAdapte

    /**
     * public class WebMvcConfig extends WebMvcConfigurerAdapter {
     *     @Override
     *     public void addCorsMappings(CorsRegistry registry) {
     *         registry.addMapping("/**")//所有的路径都可以访问
     *                 .allowedOrigins("*")//语序访问的与名
     *                 .allowedMethods("*")//允许访问的方法
     *                 .allowCredentials(true);//访问时是否需要验证
     *     }
     * }
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //歌手头像的地址
        registry.addResourceHandler("/img/singerPic/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"singerPic"+System.getProperty("file.separator")
        );

        //存放歌曲头像的地址
        registry.addResourceHandler("/img/songPic/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                        +System.getProperty("file.separator")+"songPic"+System.getProperty("file.separator")
        );
        //存放歌单头像的地址
        registry.addResourceHandler("/img/songListPic/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                        +System.getProperty("file.separator")+"songListPic"+System.getProperty("file.separator")
        );

        //存放歌曲的地址
        registry.addResourceHandler("/song/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"song"+System.getProperty("file.separator")
        );

        //存放前端用户的头像地址
        registry.addResourceHandler("/avatarImages/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"avatarImages"
                       +System.getProperty("file.separator")
        );

    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**")//所有的路径都可以访问
                                     .allowedOrigins("*")//语序访问的与名
                                     .allowedMethods("*")//允许访问的方法
                                     .allowCredentials(true);//访问时是否需要验证
    }
}
