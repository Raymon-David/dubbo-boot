package com.raymon.api.pojo;
import java.io.Serializable;

public class User implements Serializable{
        private String username;

        private String phone;

        private String email;

        private Integer age;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username == null ? null : username.trim();
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone == null ? null : phone.trim();
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email == null ? null : email.trim();
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

}
