package com.bsc.modules.mail.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.mail.entity.Mail;


import java.util.List;

@MybatisDao
public interface MailMapper extends CrudDao<Mail> {
    Mail get(int id);

    Mail getT(Mail entity);

    List<Mail> findList(Mail entity);

    List<Mail> findAllList(Mail entity);

    int insert(Mail entity);

    int update(Mail entity);

    int delete(int id);

}
