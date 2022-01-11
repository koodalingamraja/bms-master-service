package com.budgetfriendly.bms.master.service.controller;


import com.budgetfriendly.bms.master.service.dto.*;
import com.budgetfriendly.bms.master.service.response.BaseResponse;
import com.budgetfriendly.bms.master.service.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bms/master/")
public class MasterController {

    @Autowired
    private MasterService masterService;

    //master insert operations

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

    @PostMapping("createExpenseCategory")
    public BaseResponse createExpenseCategory(@RequestBody MasterExpenseCategoryDTO masterExpenseCategoryDTO){
        return masterService.createExpenseCategory(masterExpenseCategoryDTO);
    }

    //master update operations

    @PostMapping("updateState")
    public BaseResponse updateState(@RequestParam (value = "stateId") Long stateId,@RequestBody MasterStateDTO masterStateDTO){
        return masterService.updateState(stateId,masterStateDTO);
    }

    @PostMapping("updateCity")
    public BaseResponse updateCity(@RequestParam (value = "cityId") Long cityId,@RequestBody MasterCityDTO masterCityDTO){
        return masterService.updateCity(cityId,masterCityDTO);
    }

    @PostMapping("updateRelationship")
    public BaseResponse updateRelationship(@RequestParam (value = "relationshipId") Long relationshipId,@RequestBody MasterRelationshipDTO masterRelationshipDTO){
        return masterService.updateRelationship(relationshipId,masterRelationshipDTO);
    }

    @PostMapping("updateRole")
    public BaseResponse updateRole(@RequestParam (value = "roleId") Long roleId,@RequestBody MasterRoleDTO masterRoleDTO){
        return masterService.updateRole(roleId,masterRoleDTO);
    }

    @PostMapping("updateExpenseCategory")
    public BaseResponse updateExpenseCategory(@RequestParam (value = "expenseCategoryId") Long expenseCategoryId,@RequestBody MasterExpenseCategoryDTO masterExpenseCategoryDTO){
        return masterService.updateExpenseCategory(expenseCategoryId,masterExpenseCategoryDTO);
    }

    //master data get by id

    @GetMapping("getStateById")
    public BaseResponse getStateById(@RequestParam (value = "stateId") Long stateId){
        return masterService.getStateById(stateId);
    }

    @GetMapping("getCityById")
    public BaseResponse getCityById(@RequestParam (value = "cityId") Long cityId){
        return masterService.getCityById(cityId);
    }

    @GetMapping("getRelationshipById")
    public BaseResponse getRelationshipById(@RequestParam (value = "relationshipId") Long relationshipId){
        return masterService.getRelationshipById(relationshipId);
    }

    @GetMapping("getRoleById")
    public BaseResponse getRoleById(@RequestParam (value = "roleId") Long roleId){
        return masterService.getRoleById(roleId);
    }

    @GetMapping("getExpenseCategoryById")
    public BaseResponse getExpenseCategoryById(@RequestParam (value = "expenseCategoryId") Long expenseCategoryId){
        return masterService.getExpenseCategoryById(expenseCategoryId);
    }

    //master data delete by id

    @GetMapping("deleteByStateId")
    public BaseResponse deleteByStateId(@RequestParam (value = "stateId") Long stateId){
        return masterService.deleteByStateId(stateId);
    }

    @GetMapping("deleteByCityById")
    public BaseResponse deleteByCityById(@RequestParam (value = "cityId") Long cityId){
        return masterService.deleteByCityById(cityId);
    }

    @GetMapping("deleteByRelationshipById")
    public BaseResponse deleteByRelationshipById(@RequestParam (value = "relationshipId") Long relationshipId){
        return masterService.deleteByRelationshipById(relationshipId);
    }

    @GetMapping("deleteByRoleById")
    public BaseResponse deleteByRoleById(@RequestParam (value = "roleId") Long roleId){
        return masterService.deleteByRoleById(roleId);
    }

    @GetMapping("deleteByExpenseCategoryById")
    public BaseResponse deleteByExpenseCategoryById(@RequestParam (value = "expenseCategoryId") Long expenseCategoryId){
        return masterService.deleteByExpenseCategoryById(expenseCategoryId);
    }
}
