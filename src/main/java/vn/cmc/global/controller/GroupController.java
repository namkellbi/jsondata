package vn.cmc.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.cmc.global.common.Constants;
import vn.cmc.global.common.Enums;
import vn.cmc.global.common.ResponseData;
import vn.cmc.global.model.Department;
import vn.cmc.global.model.Group;
import vn.cmc.global.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/get-json-data")
    public ResponseData getJsonData() {
        try {
            List<Group> groups = groupService.getJsonData();
            return new ResponseData(Enums.ResponseStatus.SUCCESS, Constants.CALL_API_SUCCESS, (Department) groups);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(String.valueOf(Enums.ResponseStatus.ERROR), e.getMessage());
        }
    }

    @GetMapping("/get-leader-by-dept-name")
    public ResponseData getLeaderByDeptName(@RequestParam(value = "deptName", defaultValue = "") String deptName) {
        try {
            Department dept = groupService.getLeaderByDeptName(deptName.toUpperCase());
            if (dept.getName()==null){
                return new ResponseData(Enums.ResponseStatus.SUCCESS, Constants.CALL_API_FAILED, dept);
            }
            return new ResponseData(Enums.ResponseStatus.SUCCESS, Constants.CALL_API_SUCCESS, dept);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(String.valueOf(Enums.ResponseStatus.ERROR), e.getMessage());
        }
    }

    @GetMapping("/get-leader-by-group-name")
    public ResponseData getLeaderByGroupName(@RequestParam(value = "groupName", defaultValue = "") String groupName) {
        try {
            Department dept = groupService.getLeaderByGroupName(groupName.toUpperCase());
            if (dept.getName()==null){
                return new ResponseData(Enums.ResponseStatus.SUCCESS, Constants.CALL_API_FAILED, dept);
            }
            return new ResponseData(Enums.ResponseStatus.SUCCESS,Constants.CALL_API_SUCCESS, dept);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(String.valueOf(Enums.ResponseStatus.ERROR), e.getMessage());
        }
    }

    @GetMapping("/get-group-leader-by-dept-name")
    public ResponseData getGroupLeaderByDeptName(@RequestParam(value = "deptName", defaultValue = "") String deptName) {
        try {
            Department dept = groupService.getGroupLeaderByDeptName(deptName.toUpperCase());
            if (dept.getName()==null){
                return new ResponseData(Enums.ResponseStatus.SUCCESS, Constants.CALL_API_FAILED, dept);
            }
            return new ResponseData(Enums.ResponseStatus.SUCCESS, Constants.CALL_API_SUCCESS, dept);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(String.valueOf(Enums.ResponseStatus.ERROR), e.getMessage());
        }
    }
}
