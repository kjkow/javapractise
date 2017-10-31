package chapter8;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kamil on 2017-10-31.
 */
public class Log4JLearningTests {

    private Logger logger;

    @Before
    public void initialize(){
        logger = Logger.getLogger("logger");
        logger.removeAllAppenders();
        Logger.getRootLogger().removeAllAppenders();
    }

    @Test
    public void basicLogger(){
        BasicConfigurator.configure();
        logger.info("hello there!");
    }

    @Test
    public void addAppenderWithStream(){
        logger.addAppender(new ConsoleAppender(
                new PatternLayout("%p %t %m%n"),
                ConsoleAppender.SYSTEM_OUT));
        logger.info("add appender with stream");
    }

    @Test
    public void addAppenderWithoutStream(){
        logger.addAppender(new ConsoleAppender(
                new PatternLayout("%p %t %m%n")));
        logger.info("add appender without stream");
    }

}
