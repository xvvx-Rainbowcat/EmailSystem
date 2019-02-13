package com.example.pc_96.emailsystem.data;

public class UserBean {
    private String mName;
    private String mAvaterUrl;
    private String mGrade;
    private String mGroup;
    private String mTelephone;
    private String mEmail;
    private String mSpecialtyClass;
    private String mSignature;

    public UserBean(String name, String avaterUrl, String grade, String group,
                    String telephone, String email, String specialtyClass, String signature) {
        mName = name;
        mAvaterUrl = avaterUrl;
        mGrade = grade;
        mGroup = group;
        mTelephone = telephone;
        mEmail = email;
        mSpecialtyClass = specialtyClass;
        mSignature = signature;
    }

    public String getName() {
        return mName;
    }

    public String getAvaterUrl() {
        return mAvaterUrl;
    }

    public String getGrade() {
        return mGrade;
    }

    public String getGroup() {
        return mGroup;
    }

    public String getTelephone() {
        return mTelephone;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getSignature() {
        return mSignature;
    }

    public String getSpecialtyClass() {
        return mSpecialtyClass;
    }
}
