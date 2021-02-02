package com.chen.api.plugin.annotation;


import com.chen.api.plugin.ChenApiSpringBootAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ChenApiSpringBootAutoConfiguration.class)
@Inherited
public @interface EnableChenServer {
}
