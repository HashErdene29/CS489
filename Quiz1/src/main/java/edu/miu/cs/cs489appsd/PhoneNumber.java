package edu.miu.cs.cs489appsd;

public class PhoneNumber {
    private int phone_id;
    private long phone_number;
    private String phone_label;

    public PhoneNumber() {
    }

    public PhoneNumber(int phone_id, long phone_number, String phone_label) {
        this.phone_id = phone_id;
        this.phone_number = phone_number;
        this.phone_label = phone_label;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_label() {
        return phone_label;
    }

    public void setPhone_label(String phone_label) {
        this.phone_label = phone_label;
    }
}
