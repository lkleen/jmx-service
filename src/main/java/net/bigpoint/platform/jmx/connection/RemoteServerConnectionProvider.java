package net.bigpoint.platform.jmx.connection;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.bidimap.AbstractDualBidiMap;
import org.jminix.server.ServerConnectionProvider;
import org.springframework.beans.factory.annotation.InjectionMetadata;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 5/23/13
 * Time: 12:31 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class RemoteServerConnectionProvider implements ServerConnectionProvider {

    private final JMXServiceURLProvider jmxServiceURLProvider;
    private final RemoteServerConnector remoteServerConnector = new RemoteServerConnector();

    private Map<String, MBeanServerConnection> connectionsMap;
    private List<String> keys;
    private List<MBeanServerConnection> connections;

    public RemoteServerConnectionProvider(JMXServiceURLProvider jmxServiceURLProvider) {
        this(jmxServiceURLProvider, true);
    }

    public RemoteServerConnectionProvider(JMXServiceURLProvider jmxServiceURLProvider, boolean autoConnect) {
        this.jmxServiceURLProvider = jmxServiceURLProvider;
        if(autoConnect) {
            connect();
        }
    }

    public void connect() {
        connectionsMap = remoteServerConnector.connect(jmxServiceURLProvider.getJMXServiceURLs());
        keys = new ArrayList<>(connectionsMap.keySet());
        connections = new ArrayList<>(connectionsMap.values());
    }

    @Override
    public List<MBeanServerConnection> getConnections() {
        return connections;
    }

    @Override
    public List<String> getConnectionKeys() {
        return keys;
    }

    @Override
    public MBeanServerConnection getConnection(String name) {
        return connectionsMap.get(name);
    }
}
