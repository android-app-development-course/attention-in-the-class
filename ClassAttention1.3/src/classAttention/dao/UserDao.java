package classAttention.dao;

import classAttention.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import yong.tool.jdbc.TxQueryRunner;

import java.sql.SQLException;

/*
    持久层
 */
public class UserDao {
    private QueryRunner qr = new TxQueryRunner();

    //username query
    public User findByUsername(String username) {
        try {
            String sql = "select * from userinfo where username=?";
            return qr.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByEmail(String email) {
        try {
            String sql = "select * from userinfo where email=?";
            return qr.query(sql, new BeanHandler<>(User.class), email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByPhone(String phone) {
        try {
            String sql = "select * from userinfo where phone=?";
            return qr.query(sql, new BeanHandler<>(User.class), phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public User findByCode(String code) {
        try {
            String sql = "select * from userinfo where code=?";
            return qr.query(sql, new BeanHandler<>(User.class), code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String uid, boolean state) {
        try {
            String sql = "update userinfo set state=? where uid=?";
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTrueName(String uid, String trueName) {
        try {
            String sql = "update userinfo set trueName=? where uid=?";
            qr.update(sql, uid, trueName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateSchoolNumber(String uid, String schoolNumber) {
        try {
            String sql = "update userinfo set schoolNumber=? where uid=?";
            qr.update(sql, uid, schoolNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user) {
        try {
            String sql = "insert into userinfo value(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUid(), user.getUsername(), user.getPassword(),
                    user.getEmail(), user.getCode(), user.isState(),
                    user.getPhone(), user.getUclassNumber(), user.getTrueName(), user.getSchoolNumber()};
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User checkPassword(String username, String password) {
        try {
            String sql = "select password from userinfo where username=?";
            User user = qr.query(sql, new BeanHandler<>(User.class), username);
            if (password.equals(user.getPassword()))
                return user;
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUid(String username) {
        try {
            String sql = "select * from userinfo where username=?";
            return qr.query(sql, new BeanHandler<>(User.class), username).getUid();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
