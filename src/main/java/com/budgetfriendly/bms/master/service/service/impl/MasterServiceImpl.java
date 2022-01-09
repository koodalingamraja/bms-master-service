package com.budgetfriendly.bms.master.service.service.impl;


import com.budgetfriendly.bms.master.service.dto.MasterCityDTO;
import com.budgetfriendly.bms.master.service.dto.MasterRelationshipDTO;
import com.budgetfriendly.bms.master.service.dto.MasterRoleDTO;
import com.budgetfriendly.bms.master.service.dto.MasterStateDTO;
import com.budgetfriendly.bms.master.service.entity.MasterCity;
import com.budgetfriendly.bms.master.service.entity.MasterRelationship;
import com.budgetfriendly.bms.master.service.entity.MasterRole;
import com.budgetfriendly.bms.master.service.entity.MasterState;
import com.budgetfriendly.bms.master.service.repository.MasterCityRepository;
import com.budgetfriendly.bms.master.service.repository.MasterRealtionshipRepository;
import com.budgetfriendly.bms.master.service.repository.MasterRoleRepository;
import com.budgetfriendly.bms.master.service.repository.MasterStateRepository;
import com.budgetfriendly.bms.master.service.response.BaseResponse;
import com.budgetfriendly.bms.master.service.service.MasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterStateRepository stateRepository;

    @Autowired
    private MasterCityRepository cityRepository;

    @Autowired
    private MasterRealtionshipRepository realtionshipRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private MasterRoleRepository roleRepository;

    @Override
    public BaseResponse createState(MasterStateDTO masterStateDTO) {
        BaseResponse response = new BaseResponse();
        try {
            masterStateDTO.setStatus(Boolean.TRUE);
            masterStateDTO.setCreatedAt(new Date());
            MasterState masterStateData = modelMapper.map(masterStateDTO, MasterState.class);
            MasterState dbMasterState = stateRepository.save(masterStateData);
            response.setStatus("success");
            response.setMessage("state saved successfully");
            response.setData(dbMasterState);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse createCity(MasterCityDTO masterCityDTO) {
        BaseResponse response = new BaseResponse();
        try{
            MasterCity masterCity = new MasterCity();
            masterCity.setCityName(masterCityDTO.getCityName());
            masterCity.setCityCode(masterCityDTO.getCityCode());
            masterCity.setStatus(Boolean.TRUE);
            masterCity.setCreatedAt(new Date());
            Optional<MasterState> dbMasterState = stateRepository.findById(masterCityDTO.getMasterStateDTO().getId());
            if(dbMasterState.isPresent()){
                masterCity.setMasterState(dbMasterState.get());
            }
            MasterCity dbMasterCity = cityRepository.save(masterCity);
            response.setStatus("success");
            response.setMessage("city saved successfully");
            response.setData(dbMasterCity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse createRelationship(MasterRelationshipDTO relationshipDTO) {
        BaseResponse response = new BaseResponse();
        try{
            MasterRelationship masterRelationship = new MasterRelationship();
            masterRelationship.setRelationshipName(relationshipDTO.getRelationshipName());
            masterRelationship.setRelationshipCode(relationshipDTO.getRelationshipCode());
            masterRelationship.setStatus(Boolean.TRUE);
            masterRelationship.setCreatedAt(new Date());
            MasterRelationship dbMasterRelationship = realtionshipRepository.save(masterRelationship);
            response.setStatus("success");
            response.setMessage("relationship saved successfully");
            response.setData(masterRelationship);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse createRole(MasterRoleDTO roleDTO) {
        BaseResponse response = new BaseResponse();
        try{
            MasterRole masterRole = new MasterRole();
            masterRole.setRoleName(roleDTO.getRoleName());
            masterRole.setRoleDescription(roleDTO.getRoleDescription());
            masterRole.setStatus(Boolean.TRUE);
            masterRole.setCreatedAt(new Date());
            MasterRole dbMasterRole = roleRepository.save(masterRole);
            response.setStatus("success");
            response.setMessage("role saved successfully");
            response.setData(dbMasterRole);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
