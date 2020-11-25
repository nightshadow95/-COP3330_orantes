import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class ContactList {
    public ContactItem e;
    ArrayList<ContactItem> contacts = new ArrayList<>();

    public void SetContactList(ContactItem contact) {
        contacts.add(contact);
        this.e = contact;
    }

    public void EditItems(ContactItem items, int index){
        if(items.toString().isBlank()){
            throw new IllegalArgumentException("No information was entered. At least one item has to have information.");
        }
        if(index<contacts.size()-1 || index >contacts.size()-1){
            throw new ArrayIndexOutOfBoundsException("Index was not valid. Please enter a valid number of the contact item");
        }
        contacts.get(index).EditItems(items.getFirstName(), items.getLastName(), items.getPhoneNumber(), items.getEmailAddress());
    }


    public void SaveContactList(String filename) {
        try (Formatter output = new Formatter(filename)) {
            for (int i=0; i<contacts.size(); i++){
                output.format("%s%n",contacts.get(i).getFirstName());
                output.format("%s%n",contacts.get(i).getLastName());
                output.format("%s%n",contacts.get(i).getPhoneNumber());
                output.format("%s%n", contacts.get(i).getEmailAddress());
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public ArrayList<ContactItem> LoadContactList(String filename) {
        ArrayList<ContactItem> newlist = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found. \n");
        }
        String line;

        try{ while (true) {
            assert br != null;
            if ((line = br.readLine()) == null) break;
            ContactItem contact = new ContactItem();
            contact.setFirstName(line);
            line= br.readLine();
            contact.setLastName(line);
            line =br.readLine();
            contact.setPhoneNumber(line);
            line = br.readLine();
            contact.setEmailAddress(line);
            newlist.add(contact);
        }
            br.close();

        } catch(FileNotFoundException e){
            System.out.println("Please enter a valid file\n");
        }
        catch (NullPointerException e) {
            System.out.printf("No file found. ");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if(newlist.isEmpty()) {
            throw new IllegalArgumentException("The list was empty. Please provide a file with contacts.");
        }
        System.out.println("The file was successfully added.\n");
        return newlist;
    }

    @Override
    public String toString() {

        return e.toString();
    }
}
