package vn.cmc.global.service;

import vn.cmc.global.model.Department;
import vn.cmc.global.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getJsonData();

    Department getLeaderByDeptName(String deptName);

    Department getLeaderByGroupName(String groupName);

    Department getGroupLeaderByDeptName(String deptName);

    List<String> getListName();
}
