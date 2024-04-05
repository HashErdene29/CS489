package edu.miu.cs.cs489appsd;

public class EmailAddress {
    private int email_id;
    private String email_address;
    private String email_label;

    public EmailAddress() {
    }

    public EmailAddress(int email_id, String email_address, String email_label) {
        this.email_id = email_id;
        this.email_address = email_address;
        this.email_label = email_label;
    }

    public int getEmail_id() {
        return email_id;
    }

    public void setEmail_id(int email_id) {
        this.email_id = email_id;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getEmail_label() {
        return email_label;
    }

    public void setEmail_label(String email_label) {
        this.email_label = email_label;
    }
}
