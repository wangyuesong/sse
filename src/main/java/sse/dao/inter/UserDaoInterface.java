package sse.dao.inter;

import sse.model.User;


public interface UserDaoInterface {

    User findUserByAccount(String account);

}
