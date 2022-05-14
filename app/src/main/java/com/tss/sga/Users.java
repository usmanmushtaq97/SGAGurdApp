package com.tss.sga;
public class Users {
    private String id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    private String date;
    private String status;
    private String image_id;
    private String image_url;
    private String verificationcode;
    private String age;
    private String phone;
    public Users(String id, String name, String username, String email, String password, String role, String date, String status, String image_id, String image_url, String verificationcode, String age, String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.date = date;
        this.status = status;
        this.image_id = image_id;
        this.image_url = image_url;
        this.verificationcode = verificationcode;
        this.age = age;
        this.phone = phone;
    }

// Getter Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getImage_id() {
        return image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    // Setter Methods

    public void setId( String id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public void setImage_id( String image_id ) {
        this.image_id = image_id;
    }

    public void setImage_url( String image_url ) {
        this.image_url = image_url;
    }

    public void setVerificationcode( String verificationcode ) {
        this.verificationcode = verificationcode;
    }

    public void setAge( String age ) {
        this.age = age;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }
}