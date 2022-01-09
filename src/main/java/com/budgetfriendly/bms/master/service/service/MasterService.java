package com.budgetfriendly.bms.master.service.service;


import com.budgetfriendly.bms.master.service.dto.MasterCityDTO;
import com.budgetfriendly.bms.master.service.dto.MasterRelationshipDTO;
import com.budgetfriendly.bms.master.service.dto.MasterRoleDTO;
import com.budgetfriendly.bms.master.service.dto.MasterStateDTO;
import com.budgetfriendly.bms.master.service.response.BaseResponse;

public interface MasterService {

    BaseResponse createState(MasterStateDTO masterStateDTO);

    BaseResponse createCity(MasterCityDTO masterCityDTO);

    BaseResponse createRelationship(MasterRelationshipDTO relationshipDTO);

    BaseResponse createRole(MasterRoleDTO roleDTO);
}
