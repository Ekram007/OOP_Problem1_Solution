import java.util.Date;

public class Consumable {
    
    String name;
    Date startingDate = null ;
    Date endingDate = null ;
    double totalTime = 0;
    Double rating = null ;
    int totalDays = 0 ;
    
    Consumable(String name, Date startingDate , Date endingdDate ){
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingdDate;
        totalTime = calculateTime(startingDate, endingDate);
    }

    String getName(){
        return name;
    }

    double calculateTime(Date startingDate, Date endingDate){
        double diff = startingDate.getTime() - endingDate.getTime();
        return diff / (60 * 60 * 1000);
    }

    int

    void updateRating(double d){
        rating = d;
    }

    void display(){
        System.out.println(name+"\t"+totalDays+"\t"+totalTime+"\t"+rating);
    }

    void displayDetails(){
        display();
        System.out.println("Consumption Starting date: "+ startingDate );
        System.out.println("Consumption Starting date: "+ endingDate ) ;
    }

}
