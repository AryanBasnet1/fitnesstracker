public class Workout {
    String name;
    int calories;
    String effort;
    public Workout(String name , int calories , String effort){
this.name= name;
this.calories=calories;
this.effort = effort;
    }
    public String getName(){
        return name;

    }
    public int getCalories(){
        return calories;

    }
    public String getEffort(){
        return effort;
    }
}
