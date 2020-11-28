public class ContactItem
{
    private String fName;
    private String lName;
    private String phoneNum;
    private String email;

    public ContactItem(String fName, String lName, String phoneNum, String email){
        if (email.length() < 1
        && fName.length() < 1
        && lName.length() < 1
        && phoneNum.length() < 1)
        {
            throw new IllegalArgumentException();
        }
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
    @Override
    public String toString()
    {
        return "Name: " + fName + " " + lName + "\nPhone: " + phoneNum + "\nEmail: " + email;
    }


    public void editItem(ContactItem c1, ContactItem c2) {
        try {
            if (c2.getFName().length() < 1
                    && c2.getLName().length() < 1
                    && c2.getEmail().length() < 1
                    && c2.getPhoneNum().length() < 1) {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e)
        {
            System.out.println("Invalid input. Please try again.");
        }
        c1.setFName(c2.getFName());
        c1.setLName(c2.getLName());
        c1.setPhoneNum(c2.getPhoneNum());
        c1.setEmail(c2.getEmail());
    }

}
