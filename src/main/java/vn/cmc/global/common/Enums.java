package vn.cmc.global.common;

public class Enums {
    public enum ResponseStatus {
        SUCCESS("Success"), ERROR("Error");

        ResponseStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        private String status;

    }
}