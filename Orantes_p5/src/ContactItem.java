public class ContactItem {

    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String EmailAddress;

    public ContactItem(String Firstname, String LastName, String PhoneNumber, String EmailAddress){
        if(Firstname.isBlank() && LastName.isBlank() && PhoneNumber.isBlank() && EmailAddress.isBlank()){
            throw new IllegalArgumentException();
        }
        this.FirstName = Firstname;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.EmailAddress = EmailAddress;
    }

    public ContactItem() {

    }

    public void EditItems(String Firstname, String LastName, String PhoneNumber, String EmailAddress){
        if(Firstname.isBlank() && LastName.isBlank() && PhoneNumber.isBlank() && EmailAddress.isBlank()){
            throw new IllegalArgumentException();
        }
        this.FirstName = Firstname;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.EmailAddress = EmailAddress;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    @Override
    public String toString() {

        return "Name: "+FirstName+" "+LastName+ "\nPhone: "+PhoneNumber+ "\nEmail: "+ EmailAddress;
    }
}
