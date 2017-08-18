package ru.icl.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.icl.dao.UserDao;
import ru.icl.models.User;
import ru.icl.service.AccountService;
import ru.icl.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;

    @Autowired
    private AccountService accountService;
	
	public void saveUser(User user) {
       // userDao.save(user);
    }

    public User findByUsername(String username) {
        return null;//userDao.findByUsername(username);
    }

}
