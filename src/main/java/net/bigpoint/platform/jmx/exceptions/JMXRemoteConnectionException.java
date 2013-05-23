package net.bigpoint.platform.jmx.exceptions;

import javax.management.remote.JMXServiceURL;

/**
 * Date: 5/23/13
 * Time: 12:36 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class JMXRemoteConnectionException extends JMXServiceException {

    public JMXRemoteConnectionException(JMXServiceURL jmxServiceURL, Throwable cause) {
        super("could not connect to " + jmxServiceURL, cause);
    }

}
