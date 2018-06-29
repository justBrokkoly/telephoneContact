import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }


    public boolean addNewContact(Contact contact){

        if(findContact(contact.getName())>=0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;

    }

    public boolean removeContact(Contact contact){
        int findpos = findContact(contact);
        if (findpos<0){
            System.out.println(contact.getName()+ " wasnt find");
            return false;
        }
        System.out.println(contact.getName()+" was deleted");
        this.myContacts.remove(findpos);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newConatct){
        int findpos = findContact(oldContact);
        if(findpos<0){
            System.out.println(oldContact.getName() + " ,wasn't find");
            return false;
        }else  if (findContact(newConatct.getName())!=-1){
            System.out.println("Contact with name " + newConatct.getName()+ " already exist. Not updated");
            return false;
        }
        this.myContacts.set(findpos,newConatct);
        System.out.println(oldContact.getName()+ " was replaced with " + newConatct.getName());
        return true;
    }

    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){

        for(int i=0;i<this.myContacts.size();i++){
          Contact contact = this.myContacts.get(i);
          if(contact.getName().equals(contactName)){
              return i;
          }
        }
        return -1;
    }

    public void printContacts(){
        for(int i = 0; i<this.myContacts.size();i++){

            System.out.println((i+1) + "." + this.myContacts.get(i).getName() + " ---" + this.myContacts.get(i).getPhonenumber());
        }
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return  this.myContacts.get(position);
        }
       return null;
    }


}
