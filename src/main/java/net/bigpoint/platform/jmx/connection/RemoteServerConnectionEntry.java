package net.bigpoint.platform.jmx.connection;

import javax.management.MBeanServerConnection;
import java.util.Map;

/**
 * Date: 5/23/13
 * Time: 1:06 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class RemoteServerConnectionEntry implements Map.Entry<String, MBeanServerConnection> {

    final String key;
    MBeanServerConnection value;

    public RemoteServerConnectionEntry(String key, MBeanServerConnection value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public MBeanServerConnection getValue() {
        return value;
    }

    @Override
    public MBeanServerConnection setValue(MBeanServerConnection value) {
        return this.value = value;
    }
}
