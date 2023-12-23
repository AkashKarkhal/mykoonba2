package com.example.mykoonba;

public class UserProfiledata {
    String fullname,daeofbirth,phnnumber;


    public UserProfiledata() {

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDaeofbirth() {
        return daeofbirth;
    }

    public void setDaeofbirth(String daeofbirth) {
        this.daeofbirth = daeofbirth;
    }

    public String getPhnnumber() {
        return phnnumber;
    }

    public void setPhnnumber(String phnnumber) {
        this.phnnumber = phnnumber;
    }

    public UserProfiledata(String fullname, String daeofbirth, String phnnumber) {
        this.fullname = fullname;
        this.daeofbirth = daeofbirth;
        this.phnnumber = phnnumber;


    }
}
