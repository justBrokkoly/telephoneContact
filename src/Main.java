import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("21312 12312  32");

    public static void main(String[] args) {

        boolean quite = false;
        startPhone();
        printActions();
        while(!quite){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nShutting down...");
                    quite = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }


        }
    }
    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new contact phonenumber: ");
        String phonenumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phonenumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added:name =  " + name + " phone = "+phonenumber);
        }else {
            System.out.println("Cannot added");
        }

    }

    private static void queryContact(){
        System.out.println(" Enter contact name");
        String name = scanner.nextLine();
        Contact br = mobilePhone.queryContact(name);
        if(br == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + br.getName() + " phone "+br.getPhonenumber());
    }
    private static void removeContact(){
            System.out.println(" Enter contact name");
            String name = scanner.nextLine();
            Contact br = mobilePhone.queryContact(name);
            if(br == null){
                System.out.println("Contact not found");
                return;
            }
            if(mobilePhone.removeContact(br)){
                System.out.println("Successfully deleted");
            }else{
                System.out.println("ERROR DEL");
            }
    }

    private static void updateContact(){
        System.out.println(" Enter contact name");
        String name = scanner.nextLine();
        Contact br = mobilePhone.queryContact(name);
        if(br == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(br,newContact)){
            System.out.println("Successfully uppdated");
        } else {
            System.out.println("ERROR");
        }

    }



    private static void startPhone(){
        System.out.println("Starting phone...");
    }



    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to off\n"+
                           "1 - to print contacts:\n" +
                           "2 - to add new contact:\n" +
                           "3 - to update:\n" +
                           "4 - to remove a contact:\n" +
                           "5 - query if an existing contact exist:\n" +
                            "6 - to print a list of actions.");
        System.out.println("Choose ur action: ");
    }
}
