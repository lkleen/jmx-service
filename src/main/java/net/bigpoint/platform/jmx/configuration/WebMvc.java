package net.bigpoint.platform.jmx.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Date: 5/23/13
 * Time: 11:30 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.bigpoint.platform.jmx.controller")
public class WebMvc {
}
