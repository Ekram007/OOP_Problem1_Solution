import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsumableList cList = new ConsumableList();
        ConsumableFactory cFactory = new ConsumableFactory();

        String empty;

        while (true) {
  
            System.out.println("\n\nMY CONSUMED PIECES OF ART\n");
            System.out.println("Enter “1”, to add a consumable.");
            System.out.println("Enter “2”, to edit a consumable.");
            System.out.println("Enter “3”, to delete a consumable.");
            System.out.println("Enter “4”, to see te consumables.");
            System.out.println("Enter “5” to see overall info.");
    
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
    
            if (input.equals("1")) {
                System.out.println("Enter the type of the consumable(Book/Series/Movie): ");
                String type = sc.next();
                empty = sc.nextLine();

                System.out.println("Enter "+type+" name: ");
                String name = sc.nextLine();
                Consumable c = cFactory.getConsumable(type, name);
                cList.addNewConsumable(c);

                System.out.println("Enter starting date(YYYY-MM-DD/press enter to skip): ");
                String startingDate = sc.nextLine();
                if(!startingDate.isBlank()){
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    try {
                        c.setStartingDate(dateFormat.parse(startingDate));
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
                System.out.println("Enter ending date(YYYY-MM-DD/press enter to skip): ");
                String endingDate = sc.nextLine();
                if(!endingDate.isBlank()){
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    try {
                        c.setEndingDate(dateFormat.parse(endingDate));
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                System.out.println("Enter total consumption time in  hours: ");
                int totalTime = sc.nextInt();
                empty = sc.nextLine();
                c.setTotalTime(totalTime);
                cList.updateTotalTime(c, totalTime);

                System.out.println("Enter rating out of 10(press enter to skip): ");
                String sRating = sc.nextLine(); //To take blank input
                if(!sRating.isBlank()){
                    double rating = Double.parseDouble(sRating);
                    c.setRating(rating);
                }
                cList.setAvgRatingAndTotalNumber(); 

                System.out.println("Enter total days of consumption");
                int totalDays = sc.nextInt();
                empty = sc.nextLine();
                c.setTotalDays(totalDays);
                cList.updateTotalDays(c, c.getTotalDays());
            }
            else if(input.equals("2")) {
                System.out.println("Enter Consumable Name: ");
                String name = sc.nextLine();
                Consumable c = cList.findConsumable(name);
                
                if(c.getEndingDate()==null){
                    System.out.println("Press 1 to add time in hours.");
                    System.out.println("Press 2 to add days.");
                    System.out.println("Press 3 to update rating.");
                    System.out.println("Press 4 to to enter ending date.");
                    String in = sc.nextLine();
                    if(in.equals("1")){
                        System.out.println("Add time in hours: ");
                        int time = sc.nextInt();
                        c.updateTime(time);
                        cList.updateTotalTime(c, time);
                    }
                    else if(in.equals("2")){
                        System.out.println("Add days: ");
                        int days = sc.nextInt();
                        c.updateDays(days);
                        cList.updateTotalDays(c, days);
                    }
                    else if(in.equals("3")){
                        System.out.println("Enter updated rating: ");
                        double ratings = sc.nextDouble();
                        empty = sc.nextLine();
                        c.setRating(ratings);                      
                    }
                    else if(in.equals("4")){
                        System.out.println("Enter ending date(YYYY-MM-DD): ");
                        String endingDate = sc.nextLine();
                        if(!endingDate.isBlank()){
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                            try {
                                c.setEndingDate(dateFormat.parse(endingDate));
                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
                else{
                    System.out.println("Cannot update. Ending date already defined.");
                }
                
            } 
            else if (input.equals("3")) {
                System.out.println("Enter the consumable name: ");
                String name = sc.nextLine();
                cList.delConsumable(name);
    
            } 
            else if (input.equals("4")) {
                System.out.println("Enter the type of the consumables(Book/Series/Movie): ");
                String type = sc.nextLine();
                cList.displaySameConsumables(type);

                System.out.println("Pick individual one consumable: ");
                String name = sc.nextLine();
                if(!name.isBlank()){
                    Consumable c = cList.findConsumable(name);
                    c.displayDetails();
                }
                
            } 
            else if (input.equals("5")) {
                cList.displayOverall();
            }
            else if (input.equals("0")){
                break;
            }
        }
    }
}
