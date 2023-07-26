package com.example.mbitconnect;

public class GrantByaAdminModel {

   private String time;
   private String adminGrant;
   private  String qrdate;

    public GrantByaAdminModel() {
    }

    public GrantByaAdminModel(String time, String adminGrant, String qrdate) {
        this.time = time;
        this.adminGrant = adminGrant;
        this.qrdate = qrdate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdminGrant() {
        return adminGrant;
    }

    public void setAdminGrant(String adminGrant) {
        this.adminGrant = adminGrant;
    }

    public String getQrdate() {
        return qrdate;
    }

    public void setQrdate(String qrdate) {
        this.qrdate = qrdate;
    }
}
