package vn.cmc.global.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

    private String name;

    private String desciption;

    private List<Leader> manager;

    private List<Department> listChild;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public List<Leader> getManager() {
        return manager;
    }

    public void setManager(List<Leader> manager) {
        this.manager = manager;
    }

    public List<Department> getListChild() {
        return listChild;
    }

    public void setListChild(List<Department> listChild) {
        this.listChild = listChild;
    }
}
