package vn.cmc.global.service.impl;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import vn.cmc.global.common.Constants;
import vn.cmc.global.model.Department;
import vn.cmc.global.model.Group;
import vn.cmc.global.service.GroupService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public List<Group> getJsonData() {
        List<Group> result = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(Constants.JSON_DATA_PATH);
            Gson gson = new Gson();
            Type classOfT = new TypeToken<List<Group>>() {
            }.getType();

            result = gson.fromJson(fr, classOfT);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public Department getLeaderByDeptName(String deptName) {
        List<Group> result = getJsonData();
        Department department = new Department();

        for (Group group : result) {
            List<Department> departmentList = group.getListChild();
            if (departmentList != null) {
                for (Department dept : departmentList) {
                    if (StringUtils.equals(deptName, dept.getName())) {
                        department.setName(dept.getName());
                        department.setDesciption(dept.getDesciption());
                        department.setManager(dept.getManager());
                        return department;
                    }
                }
            }
        }
        return getLeaderByGroupName(deptName);
    }

    @Override
    public Department getLeaderByGroupName(String groupName) {
        List<Group> result = getJsonData();
        Department department = new Department();

        for (int i = 0; i < result.size(); i++) {
            if (groupName.equals(result.get(i).getName())) {
                department.setName(result.get(i).getName());
                department.setDesciption(result.get(i).getDesciption());
                department.setManager(result.get(i).getManager());
                return department;
            }
        }
        return null;
    }

    @Override
    public Department getGroupLeaderByDeptName(String deptName) {
        List<Group> result = getJsonData();
        Department department = new Department();

        for (Group group : result) {
            List<Department> departmentList = group.getListChild();
            if (departmentList != null) {
                for (Department dept : departmentList) {
                    if (StringUtils.equals(deptName, dept.getName())) {
                        department.setName(group.getName());
                        department.setDesciption(group.getDesciption());
                        department.setManager(group.getManager());
                    }
                }

            }
        }
        return department;
    }

    @Override
    public List<String> getListName() {
        List<Group> groupList = getJsonData();
        List <String> listName = new ArrayList<String>();
        for (Group group: groupList) {
            listName.add(group.getName());
            List<Department> departmentList = group.getListChild();
            for (Department dept : departmentList) {
                listName.add(dept.getName());
            }
        }
        return listName;
    }
}