package net.bigpoint.platform.jmx.test;

import lombok.extern.slf4j.Slf4j;

/**
 * Date: 5/23/13
 * Time: 11:49 AM
 *
 * @author lkleen
 * @version version?
 */
@Slf4j
public class TestBean {

    public TestBean() {
        sayHello();
    }

    public void sayHello() {
        log.debug("hello");
    }

}
