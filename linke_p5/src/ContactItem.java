public class ContactItem
{
    private String fName;
    private String lName;
    private String phoneNum;
    private String email;


    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String toStringDisplay()
    {
        return "Name: " + fName + " " + lName + "\nPhone: " + phoneNum + "\nEmail:" + email;
    }
}
