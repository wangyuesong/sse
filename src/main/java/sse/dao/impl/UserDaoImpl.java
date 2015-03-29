package sse.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import sse.dao.base.GenericDao;
import sse.dao.inter.UserDaoInterface;
import sse.model.User;

@Repository("UserDao")
public class UserDaoImpl extends GenericDao<Integer, User> implements
		UserDaoInterface {

	@Override
	public User findUserByAccount(String account) {
		String queryStr = "select u from User u where u.account = :account";
		List<User> users = this.getEntityManger()
				.createQuery(queryStr, User.class)
				.setParameter("account", account).getResultList();
		if (users.size() != 0)
			return users.get(0);
		else
			return null;
	}

}
