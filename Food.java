/*

Create a list of foods
Add each food with its name and calories into the list
User types a food name
Loop through the list and find the matching food
Display its calories

*/

public class Food {
String foodName;
int calories;

public Food(String foodName , int calories){
    this.foodName = foodName;
    this.calories = calories;
}
public String getFoodName(){
    return foodName;
}
public int getCalories(){
    return calories;
}

}

