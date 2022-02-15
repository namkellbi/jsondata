package vn.cmc.global.common;

import vn.cmc.global.model.Department;
import vn.cmc.global.model.Leader;

public class ResponseData {
    protected Department data;
    protected String status;
    protected String message;

    public ResponseData() {
    }


    public ResponseData(String status, Department data) {
        this.data = data;
        this.status = status;
    }

    public ResponseData(String status, String message, Department data) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public ResponseData(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData(Enums.ResponseStatus status, String message, Department data) {
        this.data = data;
        this.status = status.getStatus();
        this.message = message;
    }

    public ResponseData(Enums.ResponseStatus status, Department data) {
        this.data = data;
        this.status = status.getStatus();
    }

    public Object getData() {
        return data;
    }

    public ResponseData setData(Department data) {
        this.data = data;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ResponseData setStatus(String status) {
        this.status = status;
        return this;
    }

    public ResponseData setStatus(Enums.ResponseStatus status) {
        this.status = status.getStatus();
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
