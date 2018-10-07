package com.ahohlov.impl;

import com.ahohlov.UserService;
import com.ahohlov.converter.impl.UserConverter;
import com.ahohlov.converter.impl.UserDTOConverter;
import com.ahohlov.dao.UserDao;
import com.ahohlov.dao.impl.UserDaoImpl;
import com.ahohlov.dao.model.User;
import com.ahohlov.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by admin on 9/4/18.
 */
public class UserServiceImpl implements UserService{

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private UserDao userDao = new UserDaoImpl(User.class);
    private UserDTOConverter userDTOConverter = new UserDTOConverter();
    private UserConverter userConverter = new UserConverter();

    @Override
    public User demoSave(User user) {
        Session session = userDao.getCurrentSession();
        try{
            Transaction transaction = session.getTransaction();
            if(!transaction.isActive()){
                session.beginTransaction();
            }
            userDao.create(user);
            transaction.commit();
            return user;
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            logger.error("Failed to demoSave user", e);
        }
        return user;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        Session session = userDao.getCurrentSession();
        try{
            Transaction transaction = session.getTransaction();
            if(!transaction.isActive()){
                session.beginTransaction();
            }
            User user = userConverter.toEntity(userDTO);
            userDao.create(user);
            transaction.commit();
            return userDTOConverter.toDTO(user);
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            logger.error("Failed to save user", e);
        }
        return userDTO;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        Session session = userDao.getCurrentSession();
        try{
            Transaction transaction = session.getTransaction();
            if(!transaction.isActive()){
                session.beginTransaction();
            }
            UserDTO userD = session.get(UserDTO.class, userDTO.getId());
            User user = userConverter.toEntity(userD);
            userDao.create(user);
            transaction.commit();
            return userDTOConverter.toDTO(user);
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            logger.error("Failed to update user", e);
        }
        return userDTO;
    }


    public User demoUpdate(User user, Long id) {
        Session session = userDao.getCurrentSession();
        try{
            Transaction transaction = session.getTransaction();
            if(!transaction.isActive()){
                session.beginTransaction();
            }
            user =  session.get(User.class, id);
            userDao.update(user);
            transaction.commit();
            return user;
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            logger.error("Failed to update user", e);
        }
        return user;
    }


    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }
}
