package com.ahohlov.converter.impl;

import com.ahohlov.converter.DTOConverter;
import com.ahohlov.dao.model.Profile;
import com.ahohlov.dto.ProfileDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 9/7/18.
 */
public class ProfileDTOConverter implements DTOConverter<ProfileDTO,Profile>{
    @Override
    public ProfileDTO toDTO(Profile entity) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setAddress(entity.getAddress());
        profileDTO.setTelephone(entity.getTelephone());
        profileDTO.setUserId(entity.getUserId());

        return profileDTO;
    }

    @Override
    public List<ProfileDTO> toDTOList(List<Profile> list) {
        List<ProfileDTO> profileDTOList = new ArrayList<>();
        for(Profile ls: list){
            profileDTOList.add(toDTO(ls));
        }
        return profileDTOList;
    }
}
