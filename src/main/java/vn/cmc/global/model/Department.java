package vn.cmc.global.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Department {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("desciption")
    @Expose
    private String desciption;

    @SerializedName("manager")
    @Expose
    private List<Leader> manager;

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
}
