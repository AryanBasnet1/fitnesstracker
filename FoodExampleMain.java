package projectcode;

import javax.swing.*;








public class FoodExampleMain 
{
	private static Food foodManager = new Food();
	private static JComboBox<FoodList> foodListBox;
	private static JTextField foodAmount;
	private static JTextArea displayArea;
	
	public static void main(String[] args)
	{
	    JFrame frame = new JFrame("Food Manager"); //make a new j frame
	    frame.setSize(600, 500);
	
	    JLabel amountLabel = new JLabel("Amount (In Grams):");
	    amountLabel.setBounds(20, 18, 130, 20);
	    frame.add(amountLabel);
	    
	    JLabel selectFood = new JLabel("Select Food:");
	    selectFood.setBounds(20, 50, 130, 20);
	    frame.add(selectFood);
	    
	    JLabel foodList = new JLabel("Food List:");
	    foodList.setBounds(20, 145, 130, 20);
	    frame.add(foodList);
	    
	    foodAmount = new JTextField(); 
	    foodAmount.setBounds(140, 20, 80, 20);
	    frame.add(foodAmount);
	    
	    foodListBox = new JComboBox<>(FoodList.values()); 
	    foodListBox.setBounds(100, 50, 200, 20);
	    frame.add(foodListBox);
	    
	    
	    JButton addButton = new JButton("Add Food"); //add the add button
	    addButton.setBounds(10, 110, 100, 30);
	    frame.add(addButton);
	    
	    JButton removeButton = new JButton("Remove Food"); //add the add button
	    removeButton.setBounds(140, 110, 130, 30);
	    frame.add(removeButton);
	    
	    
	    displayArea = new JTextArea(); //define the display area 
	    displayArea.setEditable(false); //make it so user cant edit it
	    JScrollPane scrollPane = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //create a scroll panel so that the text can be scrolled through
	    //make the scroll bar always appear as well
	    frame.add(scrollPane); //add it to ui
	    scrollPane.setBounds(10, 170, 250, 250); //set the bounds of it
	    
	    
	    
	    
	    addButton.addActionListener(e -> addFood()); //update what the buttons do
	    removeButton.addActionListener(e -> removeFood());
	    
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
	    frame.setVisible(true); //now make the frame visable
	}
	
	
	
	
	
	
	
	private static void addFood() 
	{	
		
		
		String amountText = foodAmount.getText(); //get the name from the name box
		 if (amountText.isEmpty()) 
		  {
		        JOptionPane.showMessageDialog(null, "food amount cannot be empty.");
		        return; //leave the function and notify the user if they didnt add anything
		   }
	
		FoodList selectedFood = (FoodList) foodListBox.getSelectedItem(); //get the selected food
	
		double amountSelected; 
		try 
		{
		 
		    amountSelected = Double.parseDouble(amountText);
		} 
		catch (NumberFormatException e) 
		{
		    JOptionPane.showMessageDialog(null, 
		        "Invalid input: please enter in valid numbers for grams");
		    return;
		}
		
		  if(amountSelected < 0)
		  {
			  JOptionPane.showMessageDialog(null, 
				        "Invalid input: please enter in valid numbers for grams");
				    return;
		  }
		  
		foodManager.selectFood(selectedFood, amountSelected);
	     updateDisplayFood(); //update the state of the textbox

		return;
	}
	
	
	
	private static void removeFood() 
	{	
		
		
		 
		String amountText = foodAmount.getText(); //get the name from the name box
		 if (amountText.isEmpty()) 
		  {
		        JOptionPane.showMessageDialog(null, "food amount cannot be empty.");
		        return; //leave the function and notify the user if they didnt add anything
		   }
	
		FoodList selectedFood = (FoodList) foodListBox.getSelectedItem(); //get the selected food
	
		double amountSelected; //get the weight from the weight box
		try //check if the user input in a number for the age and weight fields
		{
		 
		    amountSelected = Double.parseDouble(amountText);
		} 
		catch (NumberFormatException e) 
		{
		    JOptionPane.showMessageDialog(null, 
		        "Invalid input: please enter in valid numbers for grams");
		    return;
		}
		
		  if(amountSelected < 0)
		  {
			  JOptionPane.showMessageDialog(null, 
				        "Invalid input: please enter in valid numbers for grams");
				    return;
		  }
		  
		if(!(foodManager.removeFood(selectedFood, amountSelected)))
		{
			  JOptionPane.showMessageDialog(null, 
				        "Invalid input: The number you entered is greater then the current amount of that food (or there is none of that food)");
				    return;
		}
		
	     updateDisplayFood(); //update the state of the textbox

		return;
	}
	
	
	
	private static void updateDisplayFood() 
	{
	    displayArea.setText(""); 
	    displayArea.append("Total Calories: " + foodManager.getTotalCalories() + "\n\n");
	    for (FoodList food : foodManager.getAllFood().keySet()) 
	    {
	        if (food != null) 
	        {
	        	double grams = Math.round(foodManager.getAllFood().get(food) * 10.0) / 10.0; //round to 1 decimal place
	        	 displayArea.append(food.name() + "(" + grams + " grams)\n");
	        }
	    }
	   
}
}
