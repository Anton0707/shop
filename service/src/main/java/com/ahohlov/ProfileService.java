package com.ahohlov;

import com.ahohlov.dao.model.Profile;
import com.ahohlov.dto.ProfileDTO;

import java.util.List;

/**
 * Created by admin on 9/7/18.
 */
public interface ProfileService {

    ProfileDTO update(ProfileDTO profileDTO);

    ProfileDTO save(ProfileDTO profileDTO);

    Profile findProfileById(Long id);

    List<Profile> findAll();

    void deleteById(Long id);

}
