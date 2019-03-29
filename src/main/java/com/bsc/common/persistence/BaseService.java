package com.bsc.common.persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service基类
 * @author huke
 * @version 2018/10/22
 */
public abstract class BaseService {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

}