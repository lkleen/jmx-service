package net.bigpoint.platform.jmx.exceptions;

/**
 * Date: 5/23/13
 * Time: 12:35 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class JMXServiceException extends RuntimeException {
    public JMXServiceException(String message) {
        super(message);
    }

    public JMXServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public JMXServiceException(Throwable cause) {
        super(cause);
    }
}
