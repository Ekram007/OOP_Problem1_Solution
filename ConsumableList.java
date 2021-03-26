import java.util.ArrayList;

public class ConsumableList {
    
    ArrayList<Consumable> consumables = new ArrayList<Consumable>();

    double totalTime;
    double bookTime, seriesTime, movieTime;

    double totalDays;
    double bookDays, seriesDays, movieDays;

    double avgRating;
    double avgBook, avgDays, avgTime;

    void addNewConsumable(Consumable c){
        consumables.add(c);
        updateTimeDate(Consumable c);
    }

    void delConsumable(String name){
        for(int i =0; i<consumables.size(); i++){
            if(consumables.get(i).getName().equals(name)){
                consumables.remove(i);
            }
        }
    }

    void updateTimeDate(Consumable c){
        totalTime = totalTime + c.totalTime;
        totalDays = totalDays + c.totalDays;

        if(c.getClass().getName().equals("Book")){
            bookTime = bookTime + c.totalTime;
            bookDays = bookDays + c.totalDays;
        }
        else if(c.getClass().getName().equals("Series")){
            seriesTime = seriesTime + c.totalTime;
            seriesDays = seriesDays + c.seriesDays;
        }
        else{
            movieTime = movieTime + c.totalTime;
            movieDays = movieDays = c.totalDays;
        }
    }

    double displayOverall(){
        System.out.println("The total consumption time in hours across all types: " + totalTime);
        System.out.println("The total consumption time for Book: "+ bookTime + ", Series: "+seriesTime +", Movies");
    }



    

}
