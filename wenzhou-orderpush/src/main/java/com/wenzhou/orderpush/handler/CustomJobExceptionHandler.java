package com.wenzhou.orderpush.handler;

import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;
import org.apache.log4j.Logger;

/**
 * @author Administrator
 */
public class CustomJobExceptionHandler implements JobExceptionHandler {

    private Logger logger = Logger.getLogger(CustomJobExceptionHandler.class);

    @Override
    public void handleException(String jobName, Throwable cause) {
        logger.error(String.format("Job '%s' exception occur in job processing", jobName), cause);
        logger.error("handleException==>" + jobName);
    }

}