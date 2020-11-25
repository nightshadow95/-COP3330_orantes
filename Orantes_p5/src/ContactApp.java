import java.util.Scanner;

public class ContactApp {

    ContactList Clist = new ContactList();
    Scanner scanner = new Scanner(System.in);

    public void Currentlist(){
        if(Clist.contacts.isEmpty()){
            System.out.print("No current Contacts\n\n");
        }
        else{
        System.out.println("Current Contacts\n____________\n\n");
        for(ContactItem items: Clist.contacts) {
            System.out.println(Clist.contacts.indexOf(items) + ") " + items.toString());
            System.out.println("\n");
        }
        }
    }

    public void AddContact() {
        try {
            ContactItem contact = new ContactItem();
            System.out.print("First name: ");
            contact.setFirstName(scanner.nextLine());
            System.out.print("Last Name: ");
            contact.setLastName(scanner.nextLine());
            System.out.print("Phone number (xxx-xxx-xxxx): ");
            contact.setPhoneNumber(scanner.nextLine());
            System.out.print("Email address (x@y.z): ");
            contact.setEmailAddress(scanner.nextLine());
            if (contact.getFirstName().isBlank() && contact.getLastName().isBlank()
                    && contact.getPhoneNumber().isBlank() && contact.getEmailAddress().isBlank()) {
                throw new IllegalArgumentException();
            }
            Clist.SetContactList(contact);
            System.out.println("\n");
        }
        catch(IllegalArgumentException e) {
            System.out.println("\nThe contact needs at least one field to be entered. Please try again. \n\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void EditContact() {
        int tasknumber;
        String FirstName;
        String LastName;
        String PhoneNumber;
        String Email;
        if(Clist.contacts.isEmpty()) {
            System.out.println("\nThere are no contacts to edit.\n\n");
        }
        else {
            System.out.println("Current Contacts\n____________\n\n");
            for (ContactItem items : Clist.contacts) {
                System.out.println(Clist.contacts.indexOf(items) + ") " + items.toString());
                System.out.println("\n");
            }
            System.out.println("Which contact will you edit? ");
            tasknumber = scanner.nextInt();
            while (tasknumber < 0 || tasknumber > Clist.contacts.size() - 1) {
                System.out.println("Please enter a valid index: ");
                tasknumber = scanner.nextInt();
            }
            scanner.nextLine();
            System.out.print("New first name: ");
            FirstName = scanner.nextLine();
            System.out.print("New last name: ");
            LastName = scanner.nextLine();
            System.out.print("New Phone number (xxx-xxx-xxxx): ");
            PhoneNumber = scanner.nextLine();
            System.out.print("New Email address (X@y.Z): ");
            Email = scanner.nextLine();
            if (FirstName.isBlank() && LastName.isBlank() && PhoneNumber.isBlank() && Email.isBlank()) {
                System.out.println("\nThe contact needs at least one field to be entered. Please try again.\n\n");
            } else {
                Clist.contacts.get(tasknumber).setFirstName(FirstName);
                Clist.contacts.get(tasknumber).setLastName(LastName);
                Clist.contacts.get(tasknumber).setPhoneNumber(PhoneNumber);
                Clist.contacts.get(tasknumber).setEmailAddress(Email);
                System.out.println("\n");
            }
        }

    }

    public void RemoveContact() {
        int tasknumber =0;
            if(Clist.contacts.isEmpty()){
                System.out.println("There are no Contacts to remove.\n\n");
            }
            else {
                System.out.println("Current Contacts\n____________\n\n");
                for (ContactItem items : Clist.contacts) {
                    System.out.println(Clist.contacts.indexOf(items) + ") " + items.toString());
                    System.out.println("\n");
                }
                System.out.println("Which contact do you wish to remove? ");
                tasknumber = scanner.nextInt();
                while (tasknumber < 0 || tasknumber > Clist.contacts.size() - 1) {
                    System.out.println("Please enter a valid index");
                    tasknumber = scanner.nextInt();
                }
                Clist.contacts.remove(tasknumber);
                System.out.println("\n");
                scanner.nextLine();
            }

    }

    public void SaveList() {
        String Filename;
        System.out.println("Enter the name of the file to be saved: ");
        Filename = scanner.nextLine();
        Clist.SaveContactList(Filename);
        System.out.println(Filename+ " has been saved successfully\n");
    }

    public void Loadlist() {
        String Filename;
        System.out.println("Enter the name of the file to load: ");
        Filename = scanner.nextLine();
         Clist.contacts.addAll(Clist.LoadContactList(Filename));
        System.out.println("new Contact list has been created\n\n");
    }

    public void clear() {
        Clist.contacts.clear();
    }

    public void create() {
        System.out.println("New Contact list has been created\n\n");
    }
}
