package net.bigpoint.platform.jmx.configuration;

import net.bigpoint.platform.jmx.connection.JMXServiceURLProvider;
import net.bigpoint.platform.jmx.connection.RemoteServerConnectionProvider;
import org.jminix.console.application.MiniConsoleApplication;
import org.jminix.console.tool.StandaloneMiniConsole;
import org.jminix.server.ServerConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

/**
 * Date: 5/23/13
 * Time: 11:23 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Configuration
@PropertySource("classpath:jmx-service.properties")
public class MainConfig {

    @Inject
    private Environment env;

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

    @Bean
    public StandaloneMiniConsole standaloneMiniConsole() {
        int port = env.getRequiredProperty("port", Integer.class);
        return new StandaloneMiniConsole(port, miniConsoleApplication());
    }

}
