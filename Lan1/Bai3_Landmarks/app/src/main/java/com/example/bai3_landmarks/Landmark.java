package com.example.bai3_landmarks;

public class Landmark {

    private int stt;
    private String name;
    private String address;
    private String url;

    public Landmark(int stt, String name, String address, String url) {
        this.stt = stt;
        this.name = name;
        this.address = address;
        this.url = url;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
