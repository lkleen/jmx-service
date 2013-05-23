package net.bigpoint.platform.jmx.configuration;

import net.bigpoint.platform.jmx.connection.JMXServiceURLProvider;
import net.bigpoint.platform.jmx.connection.RemoteServerConnectionProvider;
import net.bigpoint.platform.jmx.test.TestBean;
import org.jminix.console.application.MiniConsoleApplication;
import org.jminix.server.ServerConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 5/23/13
 * Time: 11:23 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Configuration
public class MainConfig {

    @Bean
    public JMXServiceURLProvider jmxServiceURLProvider() {
        return new JMXServiceURLProvider();
    }

    @Bean
    public ServerConnectionProvider serverConnectionProvider() {
        return new RemoteServerConnectionProvider(jmxServiceURLProvider());
    }

    @Bean
    public MiniConsoleApplication miniConsoleApplication() {
        MiniConsoleApplication app = new MiniConsoleApplication();
        app.setServerConnectionProvider(serverConnectionProvider());
        return app;
    }

}
