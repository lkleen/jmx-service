package net.bigpoint.platform.jmx;

import net.bigpoint.platform.jmx.configuration.MainConfig;
import net.bigpoint.platform.jmx.configuration.WebMvc;
import org.jminix.console.tool.StandaloneMiniConsole;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ContextConfiguration(classes = {MainConfig.class}, loader = AnnotationConfigContextLoader.class)
public class AppTests extends AbstractTestNGSpringContextTests {

    @Inject
    private StandaloneMiniConsole console;

    @Test
    public void test() throws Exception {
        Assert.notNull(console);
    }
}
