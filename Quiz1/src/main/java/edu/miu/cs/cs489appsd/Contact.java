package edu.miu.cs.cs489appsd;

import java.util.List;

public class Contact {
    private int contact_id;
    private String first_name;
    private String last_name;
    private String company_field;
    private String job_title_field;
    private List<EmailAddress> email_addresses;
    private List<PhoneNumber> phone_numbers;
    public Contact() {
    }
    public Contact(int contact_id, String first_name, String last_name, String company_field, String job_title_field) {
        this.contact_id = contact_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_field = company_field;
        this.job_title_field = job_title_field;
    }

    public Contact(int contact_id, String first_name, String last_name, String company_field, String job_title_field, List<EmailAddress> email_addresses, List<PhoneNumber> phone_numbers) {
        this.contact_id = contact_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_field = company_field;
        this.job_title_field = job_title_field;
        this.email_addresses = email_addresses;
        this.phone_numbers = phone_numbers;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCompany_field() {
        return company_field;
    }

    public void setCompany_field(String company_field) {
        this.company_field = company_field;
    }

    public String getJob_title_field() {
        return job_title_field;
    }

    public void setJob_title_field(String job_title_field) {
        this.job_title_field = job_title_field;
    }

    public List<EmailAddress> getEmail_addresses() {
        return email_addresses;
    }

    public void setEmail_addresses(List<EmailAddress> email_addresses) {
        this.email_addresses = email_addresses;
    }

    public List<PhoneNumber> getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(List<PhoneNumber> phone_numbers) {
        this.phone_numbers = phone_numbers;
    }
}
