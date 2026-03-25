/*
User types a food name
→ App finds that food and shows its calories
→ App shows a workout suggestion with how many calories it burns
→ App calculates how much is left unburned
→ App gives a fitness rank based on effort level of the workout
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
public static void main(String[] args) {
System.out.println("Hello");
ArrayList<Food> foods = new ArrayList<>();
foods.add(new Food("Eggs", 150));
foods.add(new Food("Daal", 300));
foods.add(new Food("Meat",450));
/*
for(Food f : foods){
f.getFoodName();
 f.getCalories();
}
*/
float  totalCalories=0;

Scanner tx = new Scanner(System.in);
System.out.println("Enter the food name:");
String userFood = tx.nextLine();
boolean foodFound = false;
for(Food f : foods){
  if(f.getFoodName().equalsIgnoreCase(userFood)){
    foodFound = true;
    System.out.println("Food:"+ f.getFoodName());
  System.out.println("Enter the quantity in grams:");
  float quantity = tx.nextInt();
  totalCalories= (quantity/100f)*f.getCalories();
  System.out.println("Total Calories:" + totalCalories);
  }
}
  if(!foodFound){
    System.out.println("Sorry"+userFood +"not found in database:");
    return;
  }
  
  

ArrayList<Workout> workouts = new ArrayList<>();
workouts.add(new Workout("Walking", 150,"Low"));
workouts.add(new Workout("Stairs",100,"Medium"));
//System.out.println("Enter the workout name:");
//String userworkout = tx.nextLine();
  float caloriesRemaining;
int caloriesBurned =0;
for(Workout w : workouts){
  
  caloriesBurned = w.getCalories();
if(totalCalories<1000){
  if(totalCalories<1000 && w.getEffort().equalsIgnoreCase("Low")){
System.out.println("Suggested Wokrout:"+ w.getName());
 System.out.println("Calories burned:"+ w.getCalories()); 
   caloriesRemaining = totalCalories - w.getCalories();
 if(caloriesRemaining>0){
System.out.println("Remaining calories" +":"+caloriesRemaining);  
  }else{
    System.out.println("Fully burned -_-");
  }
    
}
}
else if(totalCalories<3000){
  if(totalCalories>1000 && w.getEffort().equalsIgnoreCase("Medium")){
    System.out.println("Suggested Workout:"+ w.getName());
    System.out.println("Calories Burned:"+ w.getCalories());
  caloriesRemaining = totalCalories - w.getCalories();
  if(caloriesRemaining>0){
System.out.println("Remaining calories" +":"+caloriesRemaining);  
  }else{
    System.out.println("Fully burned -_-");
  }
    
}


}

FitnessRank fr = new FitnessRank(caloriesBurned);
System.out.println("Total Calories Consumed: " + totalCalories);
System.out.println("Calories Burned: " + caloriesBurned);
System.out.println("Net Calories: " + (totalCalories - caloriesBurned));
System.out.println("Fitness Rank: " + fr.getRank());
}
}
}
