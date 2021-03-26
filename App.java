public class App {
    public static void main(String[] args) {
        while(true){
            System.out.println("MY CONSUMED PIECES OF ART%n");
            System.out.println("Enter “1”, to add a consumable.");
            System.out.println("Enter “2”, to edit a consumable.");
            System.out.println("Enter “3”, to delete a consumable.");
            System.out.println("Enter “4”, to see te consumables.");
            System.out.println("Enter “5” to see overall info.");
            
            Scanner myObj = new Scanner(System.in);
            String input = myObj.nextLine();
            
            if(input.equals("1")){
              myBook.display();
            }
            else if(input.equals("2")){
              String name = myObj.nextLine();
              String num = myObj.nextLine();
              
              myBook.addNewNumber(name, num);
            }
            else if(input.equals("3")){
              String name = myObj.nextLine();
              String num = myObj.nextLine();
              
              myBook.updateNum(name, num);
            }
            else if(input.equals("4")){
              String name = myObj.nextLine();
              String num = myObj.nextLine();
              
              myBook.delRecord(name, num);
            }
            else if(input.equals("0")){
              break;
            }
          }
    }
}
