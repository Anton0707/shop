package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.Profile;
import com.ahohlov.dao.model.User;
import com.ahohlov.dto.ProfileDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 9/7/18.
 */
public class ProfileConverter implements Converter<ProfileDTO,Profile>{
    @Override
    public Profile toEntity(ProfileDTO dto) {
        UserConverter userConverter = new UserConverter();
        User user = userConverter.toEntity(dto.getUserDTO());

        Profile profile = new Profile();
        profile.setAddress(dto.getAddress());
        profile.setTelephone(dto.getTelephone());
        profile.setUserId(dto.getUserId());

        return profile;
    }

    @Override
    public List<Profile> toEntityList(List<ProfileDTO> list) {
        List<Profile> profileList = new ArrayList<>();
        for(ProfileDTO ls: list){
            profileList.add(toEntity(ls));
        }
        return profileList;
    }
}
