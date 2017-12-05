package classAttention.service;

import classAttention.dao.ClassDao;


public class ClassService {
    ClassDao classDao = new ClassDao();

    public String startClassUid(String username) {
        //查询username是否存在若存在 则返回一个uid 然后sevlet根据uid生成一个字符串
        String uid = classDao.getUid(username);
        return uid;
    }

}
