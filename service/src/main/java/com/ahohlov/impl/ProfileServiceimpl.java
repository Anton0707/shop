package com.ahohlov.impl;

import com.ahohlov.ProfileService;
import com.ahohlov.converter.impl.OrderDTOConverter;
import com.ahohlov.converter.impl.ProfileConverter;
import com.ahohlov.converter.impl.ProfileDTOConverter;
import com.ahohlov.dao.ProfileDao;
import com.ahohlov.dao.impl.ProfileDaoImpl;
import com.ahohlov.dao.model.Profile;
import com.ahohlov.dao.util.HibernateUtil;
import com.ahohlov.dto.ProfileDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by admin on 9/7/18.
 */
public class ProfileServiceImpl implements ProfileService{

    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    private ProfileDao profileDao = new ProfileDaoImpl(Profile.class);
    private ProfileDTOConverter profileDTOConverter = new ProfileDTOConverter();
    private ProfileConverter profileConverter = new ProfileConverter();


    @Override
    public ProfileDTO update(ProfileDTO profileDTO) {
        return null;
    }

    @Override
    public ProfileDTO save(ProfileDTO profileDTO) {
        Session session = profileDao.getCurrentSession();
        try{
            Transaction transaction = session.getTransaction();
            if(!transaction.isActive()){
                session.beginTransaction();
            }

            Profile profile = profileConverter.toEntity(profileDTO);
            profileDao.create(profile);
            transaction.commit();
            return profileDTOConverter.toDTO(profile);
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            logger.error("Failed to save profile", e);
        }
        return profileDTO;
    }

    @Override
    public Profile findProfileById(Long id) {
        return null;
    }

    @Override
    public List<Profile> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
