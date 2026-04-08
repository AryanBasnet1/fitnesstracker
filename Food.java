package projectcode;

import java.util.HashMap;
import java.util.Map;


public class Food 
{
private double totalCalories;
private Map<FoodList, Double> selectedFood;

public Food()
{ //normal constructor with some defaults
	this.totalCalories = 0;
	 selectedFood = new HashMap<>();
	
}


public void selectFood(FoodList food, double amount)
{
	amount = Math.round(amount * 10.0)/10.0;
	if(food == null || amount < 0.0)
	{
		return;
	}
	
	selectedFood.put(food,  (selectedFood.getOrDefault(food,  0.0) + amount));
	this.totalCalories += (amount * food.getCaloriesPerGram());
	
}


public boolean removeFood(FoodList food, double amountToRemove)
{
	amountToRemove = Math.round(amountToRemove * 10.0)/10.0;
	if(food == null || amountToRemove < 0.0)
	{
		return false;
	}
	
	 double currentAmount = selectedFood.getOrDefault(food, 0.0);
     if (currentAmount == 0.0) 
     {
    	return false; 
     }
    	 
     if (amountToRemove > currentAmount) 
     {
         return false;
     }
     else if(amountToRemove == currentAmount)
     {
    	 selectedFood.put(food, currentAmount - amountToRemove);
    	 selectedFood.remove(food);
         totalCalories -= food.getCaloriesPerGram() * amountToRemove;
     }
     else 
     {
    	 selectedFood.put(food, currentAmount - amountToRemove);
         totalCalories -= food.getCaloriesPerGram() * amountToRemove;
     }
	return true;
}



public double getTotalCalories()
{ //round to 1 decimal place
	return (Math.round(this.totalCalories * 10.0) / 10.0);
}


public Map<FoodList, Double> getAllFood()
{ //returns the list of all the food
	return this.selectedFood;
}

}