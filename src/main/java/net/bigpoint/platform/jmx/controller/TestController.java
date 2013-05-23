package net.bigpoint.platform.jmx.controller;

import lombok.extern.slf4j.Slf4j;
import net.bigpoint.platform.jmx.connection.JMXServiceURLProvider;
import net.bigpoint.platform.jmx.connection.RemoteServerConnectionProvider;
import org.jminix.console.application.MiniConsoleApplication;
import org.jminix.console.tool.StandaloneMiniConsole;
import org.jminix.server.ServerConnectionProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.management.MBeanServerConnection;
import java.util.List;

/**
 * Date: 5/23/13
 * Time: 11:48 AM
 *
 * @author lkleen
 * @version version?
 */
@Controller
@RequestMapping("/services")
@Slf4j
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        //StandaloneMiniConsole smc = new StandaloneMiniConsole(1234, consoleApplication);
        return "hello";
    }

}
