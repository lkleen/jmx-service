package net.bigpoint.platform.jmx.connection;

import javax.management.remote.JMXServiceURL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 5/23/13
 * Time: 1:21 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class JMXServiceURLProvider {

    public List<JMXServiceURL> getJMXServiceURLs() {
        List<JMXServiceURL> urls = new ArrayList<>();
        try {
            urls.add(new JMXServiceURL("service:jmx:rmi://10.189.173.106/jndi/rmi://10.189.173.106:10991/jmxrmi"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return urls;
    }

}
