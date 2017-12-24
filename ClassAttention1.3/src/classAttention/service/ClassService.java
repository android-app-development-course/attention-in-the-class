package classAttention.service;

import classAttention.dao.ClassDao;
import classAttention.domain.ClassInfo;

import java.sql.Timestamp;


public class ClassService {
    ClassDao classDao = new ClassDao();

    public void startClass(ClassInfo classForm) {
        //使用uid以及deteid创建数据库
        classForm.setClassOrder(classDao.createClassOrder(classForm.getUid()));
        classDao.add(classForm);
    }

    public ClassInfo getClassInfo(String uid, Timestamp timestamp) {
        ClassInfo classInfo= classDao.getByUidAndTime(uid, timestamp);
        return classInfo;
    }

}
