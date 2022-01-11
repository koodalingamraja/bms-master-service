package com.budgetfriendly.bms.master.service.service;


import com.budgetfriendly.bms.master.service.dto.*;
import com.budgetfriendly.bms.master.service.response.BaseResponse;

public interface MasterService {


    //master insert operations

    BaseResponse createState(MasterStateDTO masterStateDTO);

    BaseResponse createCity(MasterCityDTO masterCityDTO);

    BaseResponse createRelationship(MasterRelationshipDTO relationshipDTO);

    BaseResponse createRole(MasterRoleDTO roleDTO);

    BaseResponse createExpenseCategory(MasterExpenseCategoryDTO masterExpenseCategoryDTO);

    //master update operations

    BaseResponse updateState(Long stateId,MasterStateDTO masterStateDTO);

    BaseResponse updateCity(Long cityId,MasterCityDTO masterCityDTO);

    BaseResponse updateRelationship(Long relationshipId,MasterRelationshipDTO masterRelationshipDTO);

    BaseResponse updateRole(Long roleId,MasterRoleDTO masterRoleDTO);

    BaseResponse updateExpenseCategory(Long categoryId,MasterExpenseCategoryDTO masterExpenseCategoryDTO);

   //master data get by id

    BaseResponse getStateById(Long stateId);

    BaseResponse getCityById(Long cityId);

    BaseResponse getRelationshipById(Long relationshipId);

    BaseResponse getRoleById(Long roleId);

    BaseResponse getExpenseCategoryById(Long expenseCategoryId);

    //master data delete by id

    BaseResponse deleteByStateId(Long stateId);

    BaseResponse deleteByCityById(Long cityId);

    BaseResponse deleteByRelationshipById(Long relationshipId);

    BaseResponse deleteByRoleById(Long roleId);

    BaseResponse deleteByExpenseCategoryById(Long expenseCategoryId);
}
