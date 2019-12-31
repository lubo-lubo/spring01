package com.lubo.pojo;


import java.sql.Date;

public class User {

  private Long id;
  private String userCode;
  private String userName;
  private String userPassword;
  private Long gender;
  private java.sql.Date birthday;

  public User() {
  }

  public User(Long id, String userCode, String userName, String userPassword, Long gender, Date birthday) {
    this.id = id;
    this.userCode = userCode;
    this.userName = userName;
    this.userPassword = userPassword;
    this.gender = gender;
    this.birthday = birthday;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Long getGender() {
    return gender;
  }

  public void setGender(Long gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userCode='" + userCode + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", gender=" + gender +
            ", birthday=" + birthday +
            '}';
  }
}
