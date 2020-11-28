public class ContactItem
{
    private String fName;
    private String lName;
    private String phoneNum;
    private String email;

    public ContactItem(String fName, String lName, String phoneNum, String email){
        this.fName = fName;
        this.lName = lName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    // default constructor
    public ContactItem(){
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        if (fName.length() < 1)
        {
            throw new IllegalArgumentException();
        }
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
        if (lName.length() < 1)
        {
            throw new IllegalArgumentException();
        }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if (phoneNum.length() < 1)
        {
            throw new IllegalArgumentException();
        }
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        if (email.length() < 1)
        {
            throw new IllegalArgumentException();
        }
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
