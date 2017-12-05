package classAttention.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import yong.tool.jdbc.TxQueryRunner;


public class ClassDao {
    private QueryRunner qr = new TxQueryRunner();
    UserDao userDao = new UserDao();

    public String getUid(String username) {
        return userDao.getUid(username);
    }
}
