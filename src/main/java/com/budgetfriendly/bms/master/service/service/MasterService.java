package com.budgetfriendly.bms.master.service.service;


import com.budgetfriendly.bms.master.service.dto.*;
import com.budgetfriendly.bms.master.service.response.BaseResponse;

public interface MasterService {

    BaseResponse createState(MasterStateDTO masterStateDTO);

    BaseResponse createCity(MasterCityDTO masterCityDTO);

    BaseResponse createRelationship(MasterRelationshipDTO relationshipDTO);

    BaseResponse createRole(MasterRoleDTO roleDTO);

    BaseResponse createExpenseCategory(MasterExpenseCategoryDTO masterExpenseCategoryDTO);
}
