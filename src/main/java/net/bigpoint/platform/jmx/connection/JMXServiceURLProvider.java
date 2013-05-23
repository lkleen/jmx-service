package net.bigpoint.platform.jmx.connection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.management.remote.JMXServiceURL;
import java.util.*;

/**
 * Date: 5/23/13
 * Time: 1:21 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class JMXServiceURLProvider {

    public static final List<String> keys;

    @Inject
    private Environment env;

    private Map<String, JMXServiceURL> urls;

    static {
        List<String> list = new ArrayList<>();
        list.add("auth-service");
        list.add("databag-service");
        list.add("decisiontree-service");
        list.add("tac-service");
        keys = Collections.unmodifiableList(list);
    }

    @PostConstruct
    private void init() {
        Map<String, JMXServiceURL> map = new HashMap<>();
        for (String key : keys) {
            map.put(key, env.getRequiredProperty(key, JMXServiceURL.class));
        }
        urls = Collections.unmodifiableMap(map);
    }

    public Map<String, JMXServiceURL> getJMXServiceURLs() {
        return urls;
    }

}
