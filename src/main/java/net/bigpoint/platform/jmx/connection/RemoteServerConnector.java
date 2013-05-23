package net.bigpoint.platform.jmx.connection;

import lombok.extern.slf4j.Slf4j;
import net.bigpoint.platform.jmx.exceptions.JMXRemoteConnectionException;
import org.apache.commons.collections.MapUtils;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.*;

/**
 * Date: 5/23/13
 * Time: 12:51 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class RemoteServerConnector {

    public Map<String, MBeanServerConnection> connect(Map<String, JMXServiceURL> jmxServiceURLs) {
        Map<String, MBeanServerConnection> connections = new HashMap<>();
        for (Map.Entry<String, JMXServiceURL> jmxServiceURL : jmxServiceURLs.entrySet()) {
            try {
                RemoteServerConnectionEntry conn = connect(jmxServiceURL.getKey(), jmxServiceURL.getValue());
                connections.put(conn.key, conn.value);
            } catch (JMXRemoteConnectionException e) {
                log.error(e.getMessage(), e);
            }
        }
        return connections;
    }

    public RemoteServerConnectionEntry connect(String connectionKey, JMXServiceURL jmxServiceURL) {
        try {
            JMXConnector jc = JMXConnectorFactory.connect(jmxServiceURL);
            return new RemoteServerConnectionEntry(connectionKey, jc.getMBeanServerConnection());
        } catch (IOException e) {
            throw new JMXRemoteConnectionException(jmxServiceURL, e);
        }
    }

}
