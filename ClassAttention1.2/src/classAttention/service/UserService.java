package classAttention.service;

import classAttention.dao.UserDao;
import classAttention.domain.User;
import classAttention.exception.UserException;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if (user !=null)
            throw new UserException("The username is exist");

        user = userDao.findByEmail(form.getEmail());

        if (user !=null)
            throw new UserException("The username is exist");

        user = userDao.findByPhone(form.getPhone());
        if (user !=null)
            throw new UserException("The phone is exist");

        userDao.add(form);

    }

    public void activate(String code) throws UserException {
        User user = userDao.findByCode(code);
        if (user == null) throw new UserException("激活失败");
        if (user.isState()) throw new UserException("???激活了哟");

        userDao.updateState(user.getUid(),true);
    }

    public User login(String username,String password) throws SQLException {
         User user = userDao.findByUsername(username);
         if (user==null) {
             return null;
         }
         if (userDao.checkPassword(username,password)!=null)
             return user;
         return null;
    }

    public User getUser(String username){
        return userDao.findByUsername(username);
    }
}
