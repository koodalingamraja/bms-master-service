package com.budgetfriendly.bms.master.service.service.impl;


import com.budgetfriendly.bms.master.service.dto.*;
import com.budgetfriendly.bms.master.service.entity.*;
import com.budgetfriendly.bms.master.service.repository.*;
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

    @Autowired
    private MasterExpenseCategoryRepository expenseCategoryRepository;

    //master insert operations

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

    @Override
    public BaseResponse createExpenseCategory(MasterExpenseCategoryDTO masterExpenseCategoryDTO) {
        BaseResponse response = new BaseResponse();
        try{
            MasterExpenseCategory masterExpenseCategory = new MasterExpenseCategory();
            masterExpenseCategory.setExpenseCategoryName(masterExpenseCategoryDTO.getExpensiveCategoryName());
            masterExpenseCategory.setExpenseCategoryCode(masterExpenseCategoryDTO.getExpensiveCategoryCode());
            masterExpenseCategory.setStatus(Boolean.TRUE);
            masterExpenseCategory.setCreatedAt(new Date());
            MasterExpenseCategory dbMasterExpenseCate = expenseCategoryRepository.save(masterExpenseCategory);
            response.setStatus("success");
            response.setMessage("expense saved successfully");
            response.setData(dbMasterExpenseCate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    //master update operations

    @Override
    public BaseResponse updateState(Long stateId, MasterStateDTO masterStateDTO) {
        BaseResponse response = new BaseResponse();
        try{
            if(stateId != null && stateId != 0){
                Optional<MasterState> dbMasterState = stateRepository.findByIdAndStatusTrue(stateId);
                if(dbMasterState.isPresent()){
                    MasterState masterState = dbMasterState.get();
                    if(masterStateDTO.getStateName() != null && !masterStateDTO.getStateName().isEmpty()){
                        masterState.setStateName(masterStateDTO.getStateName());
                    }
                    if(masterStateDTO.getStateCode() != null && !masterStateDTO.getStateCode().isEmpty()){
                        masterState.setStateCode(masterStateDTO.getStateCode());
                    }
                    if(masterStateDTO.getStatus() != null){
                        masterState.setStatus(masterStateDTO.getStatus());
                    }
                    masterState.setUpdatedAt(new Date());

                    MasterState saveData = stateRepository.save(masterState);
                    response.setMessage("success");
                    response.setMessage("state updated successfully");
                    response.setData(saveData);

                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid stateId");
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide stateId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse updateCity(Long cityId, MasterCityDTO masterCityDTO) {
        BaseResponse response = new BaseResponse();
        try{
            if(cityId != null && cityId != 0){
               Optional<MasterCity> dbMasterCity = cityRepository.findByIdAndStatusTrue(cityId);
               if(dbMasterCity.isPresent()){
                   MasterCity masterCity = dbMasterCity.get();
                   if(masterCityDTO.getCityName() != null && !masterCityDTO.getCityName().isEmpty()){
                       masterCity.setCityName(masterCityDTO.getCityName());
                   }
                   if(masterCityDTO.getCityCode() != null && !masterCityDTO.getCityCode().isEmpty()){
                       masterCity.setCityCode(masterCityDTO.getCityCode());
                   }
                   if(masterCityDTO.getStatus() != null ){
                       masterCity.setStatus(masterCityDTO.getStatus());
                   }

                   masterCity.setUpdatedAt(new Date());

                   MasterCity saveData = cityRepository.save(masterCity);
                   response.setMessage("success");
                   response.setMessage("city updated successfully");
                   response.setData(saveData);

               }else{
                   response.setStatus("failed");
                   response.setMessage("please provide valid cityId");
               }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide cityId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse updateRelationship(Long relationshipId, MasterRelationshipDTO masterRelationshipDTO) {
        BaseResponse response = new BaseResponse();
        try{
            if(relationshipId != null && relationshipId != 0){
                Optional<MasterRelationship> dbMasterRelationship = realtionshipRepository.findByIdAndStatusTrue(relationshipId);
                if(dbMasterRelationship.isPresent()){
                    MasterRelationship masterRelationship = dbMasterRelationship.get();
                    if(masterRelationshipDTO.getRelationshipName() != null && !masterRelationshipDTO.getRelationshipName().isEmpty()){
                        masterRelationship.setRelationshipName(masterRelationshipDTO.getRelationshipName());
                    }
                    if(masterRelationshipDTO.getRelationshipCode() != null && !masterRelationshipDTO.getRelationshipCode().isEmpty()){
                        masterRelationship.setRelationshipCode(masterRelationshipDTO.getRelationshipCode());
                    }
                    if(masterRelationshipDTO.getStatus() != null){
                        masterRelationship.setStatus(masterRelationshipDTO.getStatus());
                    }
                    masterRelationship.setUpdatedAt(new Date());

                    MasterRelationship saveData = realtionshipRepository.save(masterRelationship);
                    response.setMessage("success");
                    response.setMessage("relationship updated successfully");
                    response.setData(saveData);

                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid relationshipId");
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide relationshipId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse updateRole(Long roleId, MasterRoleDTO masterRoleDTO) {
        BaseResponse response = new BaseResponse();
        try{
            if(roleId != null && roleId != 0){
                Optional<MasterRole> dbMasterRole = roleRepository.findByIdAndStatusTrue(roleId);
                if(dbMasterRole.isPresent()){
                    MasterRole masterRole = dbMasterRole.get();
                    if(masterRoleDTO.getRoleName() != null && !masterRoleDTO.getRoleName().isEmpty()){
                        masterRole.setRoleName(masterRoleDTO.getRoleName());
                    }
                    if(masterRoleDTO.getRoleDescription() != null && !masterRoleDTO.getRoleDescription().isEmpty()){
                        masterRole.setRoleDescription(masterRoleDTO.getRoleDescription());
                    }
                    if(masterRoleDTO.getStatus() != null){
                        masterRole.setStatus(masterRoleDTO.getStatus());
                    }
                    masterRole.setUpdatedAt(new Date());

                    MasterRole saveData = roleRepository.save(masterRole);
                    response.setMessage("success");
                    response.setMessage("role updated successfully");
                    response.setData(saveData);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid roleId");
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide roleId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse updateExpenseCategory(Long categoryId, MasterExpenseCategoryDTO masterExpenseCategoryDTO) {
        BaseResponse response = new BaseResponse();
        try{
            if(categoryId != null && categoryId != 0){
                Optional<MasterExpenseCategory> dbMasterExpenseCategory = expenseCategoryRepository.findByIdAndStatusTrue(categoryId);
                if(dbMasterExpenseCategory.isPresent()){
                    MasterExpenseCategory masterExpenseCategory = dbMasterExpenseCategory.get();
                    if(masterExpenseCategoryDTO.getExpensiveCategoryName() != null && !masterExpenseCategoryDTO.getExpensiveCategoryName().isEmpty()){
                        masterExpenseCategory.setExpenseCategoryName(masterExpenseCategoryDTO.getExpensiveCategoryName());
                    }
                    if(masterExpenseCategoryDTO.getExpensiveCategoryCode() != null && !masterExpenseCategoryDTO.getExpensiveCategoryCode().isEmpty()){
                        masterExpenseCategory.setExpenseCategoryCode(masterExpenseCategoryDTO.getExpensiveCategoryCode());
                    }
                    if(masterExpenseCategoryDTO.getStatus() != null){
                        masterExpenseCategory.setStatus(masterExpenseCategoryDTO.getStatus());
                    }
                    masterExpenseCategory.setUpdatedAt(new Date());

                    MasterExpenseCategory saveData = expenseCategoryRepository.save(masterExpenseCategory);
                    response.setMessage("success");
                    response.setMessage("ExpenseCategory updated successfully");
                    response.setData(saveData);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid categoryId");
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide categoryId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    //master data get by id

    @Override
    public BaseResponse getStateById(Long stateId) {
        BaseResponse response = new BaseResponse();
        try{
            if(stateId != null && stateId != 0){
                Optional<MasterState> dbMasterState = stateRepository.findByIdAndStatusTrue(stateId);
                if(dbMasterState.isPresent()){
                    MasterState masterState = dbMasterState.get();
                    response.setMessage("success");
                    response.setMessage("state data get successfully");
                    response.setData(masterState);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid stateId" +" "+ stateId);
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide stateId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse getCityById(Long cityId) {
        BaseResponse response = new BaseResponse();
        try{
            if(cityId != null && cityId != 0){
                Optional<MasterCity> dbMasterCity = cityRepository.findByIdAndStatusTrue(cityId);
                if(dbMasterCity.isPresent()){
                    MasterCity masterCity = dbMasterCity.get();
                    response.setMessage("success");
                    response.setMessage("city data get successfully");
                    response.setData(masterCity);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid cityId" +" "+ cityId);
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide cityId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse getRelationshipById(Long relationshipId) {
        BaseResponse response = new BaseResponse();
        try{
            if(relationshipId != null && relationshipId != 0){
                Optional<MasterRelationship> dbMasterRelationship = realtionshipRepository.findByIdAndStatusTrue(relationshipId);
                if(dbMasterRelationship.isPresent()){
                    MasterRelationship masterRelationship = dbMasterRelationship.get();
                    response.setMessage("success");
                    response.setMessage("relationship data get successfully");
                    response.setData(masterRelationship);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid relationshipId" +" "+ relationshipId);
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide relationshipId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse getRoleById(Long roleId) {
        BaseResponse response = new BaseResponse();
        try{
            if(roleId != null && roleId != 0){
                Optional<MasterRole> dbMasterRole = roleRepository.findByIdAndStatusTrue(roleId);
                if(dbMasterRole.isPresent()){
                    MasterRole masterRole = dbMasterRole.get();
                    response.setMessage("success");
                    response.setMessage("role data get successfully");
                    response.setData(masterRole);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid roleId" +" "+ roleId);
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide roleId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse getExpenseCategoryById(Long expenseCategoryId) {
        BaseResponse response = new BaseResponse();
        try{
            if(expenseCategoryId != null && expenseCategoryId != 0){
                Optional<MasterExpenseCategory> dbMasterExpenseCategory = expenseCategoryRepository.findByIdAndStatusTrue(expenseCategoryId);
                if(dbMasterExpenseCategory.isPresent()){
                    MasterExpenseCategory masterExpenseCategory = dbMasterExpenseCategory.get();
                    response.setMessage("success");
                    response.setMessage("expenseCategory data get successfully");
                    response.setData(masterExpenseCategory);
                }else{
                    response.setStatus("failed");
                    response.setMessage("please provide valid expenseCategoryId" +" "+ expenseCategoryId);
                }
            }else{
                response.setStatus("failed");
                response.setMessage("please provide expenseCategoryId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    //master data delete by id

    @Override
    public BaseResponse deleteByStateId(Long stateId) {
        BaseResponse response = new BaseResponse();
        try{
            if(stateId != null && stateId != 0){
                stateRepository.deleteById(stateId);
                response.setMessage("success");
                response.setMessage("state successfully deleted");
            }else{
                response.setStatus("failed");
                response.setMessage("please provide stateId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse deleteByCityById(Long cityId) {
        BaseResponse response = new BaseResponse();
        try{
            if(cityId != null && cityId != 0){
                cityRepository.deleteById(cityId);
                response.setMessage("success");
                response.setMessage("city successfully deleted");
            }else{
                response.setStatus("failed");
                response.setMessage("please provide cityId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse deleteByRelationshipById(Long relationshipId) {
        BaseResponse response = new BaseResponse();
        try{
            if(relationshipId != null && relationshipId != 0){
                realtionshipRepository.deleteById(relationshipId);
                response.setMessage("success");
                response.setMessage("relationship successfully deleted");
            }else{
                response.setStatus("failed");
                response.setMessage("please provide relationshipId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse deleteByRoleById(Long roleId) {
        BaseResponse response = new BaseResponse();
        try{
            if(roleId != null && roleId != 0){
                roleRepository.deleteById(roleId);
                response.setMessage("success");
                response.setMessage("role successfully deleted");
            }else{
                response.setStatus("failed");
                response.setMessage("please provide roleId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BaseResponse deleteByExpenseCategoryById(Long expenseCategoryId) {
        BaseResponse response = new BaseResponse();
        try{
            if(expenseCategoryId != null && expenseCategoryId != 0){
                expenseCategoryRepository.deleteById(expenseCategoryId);
                response.setMessage("success");
                response.setMessage("expenseCategory successfully deleted");
            }else{
                response.setStatus("failed");
                response.setMessage("please provide expenseCategoryId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

}
