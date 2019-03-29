package com.bsc.modules.mail.service;

import com.bsc.common.persistence.CrudService;
import com.bsc.modules.mail.dao.MailMapper;
import com.bsc.modules.mail.entity.Mail;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class MailService extends CrudService<MailMapper,Mail> {
    @Autowired
    private MailMapper mailMapper;
    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @Override
    public Mail get(int id) {
        Mail mail = mailMapper.get(id);
        User user = mail.getSender();
        user = userService.get(user.getId());
        mail.setSender(user);
        mail.setReceiver(userService.get(mail.getReceiver().getId()));
        //mail.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(mail.getTime()));
        return mail;
    }


    @Override
    public Mail getT(Mail entity) {
        return super.getT(entity);
    }

    @Override
    public List<Mail> findList(Mail entity) {
        List<Mail> mailList = mailMapper.findList(entity);
        for(int i = 0; i < mailList.size(); i ++){
            //mailList.get(i).setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(mailList.get(i).getTime()).toString());
            mailList.set(i, mailService.get(mailList.get(i).getId()));
        }
        return mailList;
    }

    @Override
    public int insert(Mail entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Mail entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) { return super.delete(id); }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }
}
