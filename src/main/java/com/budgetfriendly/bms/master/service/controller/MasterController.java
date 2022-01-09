package com.budgetfriendly.bms.master.service.controller;


import com.budgetfriendly.bms.master.service.dto.MasterCityDTO;
import com.budgetfriendly.bms.master.service.dto.MasterRelationshipDTO;
import com.budgetfriendly.bms.master.service.dto.MasterRoleDTO;
import com.budgetfriendly.bms.master.service.dto.MasterStateDTO;
import com.budgetfriendly.bms.master.service.response.BaseResponse;
import com.budgetfriendly.bms.master.service.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bms/master/")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @PostMapping("createState")
    public BaseResponse createState(@RequestBody MasterStateDTO masterStateDTO){
        return masterService.createState(masterStateDTO);
    }

    @PostMapping("createCity")
    public BaseResponse createCity(@RequestBody MasterCityDTO masterCityDTO){
        return masterService.createCity(masterCityDTO);
    }

    @PostMapping("createRelationship")
    public BaseResponse createRelationship(@RequestBody MasterRelationshipDTO masterRelationshipDTO){
        return masterService.createRelationship(masterRelationshipDTO);
    }

    @PostMapping("createRole")
    public BaseResponse createRole(@RequestBody MasterRoleDTO masterRoleDTO){
        return masterService.createRole(masterRoleDTO);
    }

}
