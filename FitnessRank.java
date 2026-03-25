public class FitnessRank {
    String rank;
    public FitnessRank(int caloriesBurned){
   if(caloriesBurned>400){
    rank ="Excellent";
   }
   else if(caloriesBurned>200){
    rank = "Good";
   }else{
    rank ="Needs some work";
   }
    }
    public String getRank(){
        return rank;
    }
}
