//package com.example.users.projectUsers.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//
//@Entity
//public class Users {
//
//    @Id
//    @GeneratedValue
//    private Long user_id;
//    private String first_name;
//    private String last_name;
//
//    public Users() {
//    }
//
//    public Users(Long user_id, String first_name, String last_name) {
//        this.user_id = user_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//    }
//
//    public Users( String first_name, String last_name) {
//
//        this.first_name = first_name;
//        this.last_name = last_name;
//    }
//
//    @Override
//    public String toString() {
//        return "Users{" +
//                "user_id=" + user_id +
//                ", first_name='" + first_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                '}';
//    }
//
//    public Long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Long user_id) {
//        this.user_id = user_id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//}
