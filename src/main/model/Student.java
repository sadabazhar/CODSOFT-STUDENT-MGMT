package main.model;

public class Student {
    private String rollNo;
    private String name;
    private String grade;
    private String email;
    private String phone;
    private String address;

    public Student(String rollNo, String name, String grade, String email, String phone, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return String.format("Roll No: %s | Name: %s | Grade: %s | Email: %s | Phone: %s | Address: %s",
                rollNo, name, grade, email, phone, address);
    }
}
