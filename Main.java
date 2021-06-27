import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsumableList cList = new ConsumableList();
        ConsumableFactory cFactory = new ConsumableFactory();

        String empty;

        outerloop:
        while (true) {
  
            System.out.println("\n\nMY CONSUMED PIECES OF ART\n");
            System.out.println("Enter “1”, to add a consumable.");
            System.out.println("Enter “2”, to edit a consumable.");
            System.out.println("Enter “3”, to delete a consumable.");
            System.out.println("Enter “4”, to see the consumables.");
            System.out.println("Enter “5” to see overall info.");
    
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
    
            switch (input) {
                case 1:
                    System.out.println("Enter the type of the consumable(Book/Series/Movie): ");
                    String type = sc.next();
                    empty = sc.nextLine();

                    System.out.println("Enter "+type+" name: ");
                    String name = sc.nextLine();
                    Consumable c = cFactory.getConsumable(type, name);
                    cList.addNewConsumable(c);

                    System.out.println("Enter starting date(YYYY-MM-DD/press enter to ignore): ");
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
                    
                    System.out.println("Enter ending date(YYYY-MM-DD/press enter to ignore): ");
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

                    System.out.println("Enter rating out of 10(press enter to ignore): ");
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
                    break;
                
                case 2:
                    System.out.println("Enter Consumable Name: ");
                    name = sc.nextLine();
                    Consumable consumable = cList.findConsumable(name);
                    
                    if(consumable.getEndingDate()==null){
                        System.out.println("Press 1 to add time in hours.");
                        System.out.println("Press 2 to add days.");
                        System.out.println("Press 3 to update rating.");
                        System.out.println("Press 4 to to enter ending date.");
                        String in = sc.nextLine();
                        if(in.equals("1")){
                            System.out.println("Add time in hours: ");
                            int time = sc.nextInt();
                            consumable.updateTime(time);
                            cList.updateTotalTime(consumable, time);
                        }
                        else if(in.equals("2")){
                            System.out.println("Add days: ");
                            int days = sc.nextInt();
                            consumable.updateDays(days);
                            cList.updateTotalDays(consumable, days);
                        }
                        else if(in.equals("3")){
                            System.out.println("Enter updated rating: ");
                            double ratings = sc.nextDouble();
                            empty = sc.nextLine();
                            consumable.setRating(ratings);                      
                        }
                        else if(in.equals("4")){
                            System.out.println("Enter ending date(YYYY-MM-DD): ");
                            endingDate = sc.nextLine();
                            if(!endingDate.isBlank()){
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                                try {
                                    consumable.setEndingDate(dateFormat.parse(endingDate));
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
                
                case 3:
                    System.out.println("Enter the consumable name: ");
                    name = sc.nextLine();
                    cList.delConsumable(name);
                
                case 4:
                    System.out.println("Enter the type of the consumables(Book/Series/Movie): ");
                    type = sc.nextLine();
                    cList.displaySameConsumables(type);

                    System.out.println("Pick individual one consumable: ");
                    name = sc.nextLine();
                    if(!name.isBlank()){
                        Consumable consumable2 = cList.findConsumable(name);
                        consumable2.displayDetails();
                    }
                
                case 5:
                    cList.displayOverall();
                case 0:
                    break outerloop;
                default:
                System.out.println("Invalid Input");
                    break;
            }
        }            
    }
}
