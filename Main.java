import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Food food = new Food("", 0);
        Workout workout = new Workout("", 0);

        ArrayList<Food> foodList = Food.getfFoods();
        ArrayList<Workout> workoutList = Workout.getWorkouts();

        int choice = -1;

        while (choice != 3) {
            System.out.println("\n======= Fitness Tracker =======");
            System.out.println("1. Food Menu");
            System.out.println("2. Workout Menu");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Food Menu
                    food.showFoodList(foodList);
                    System.out.print("Enter the food name to add: ");
                    String foodInput = scanner.nextLine().trim();

                    boolean foodFound = false;
                    for (Food f : foodList) {
                        if (f.getFoodName().equalsIgnoreCase(foodInput)) {
                            food.selectFood(f);
                            foodFound = true;
                            break;
                        }
                    }

                    if (!foodFound) {
                        System.out.println("Food not found. Please try again.");
                    }

                    System.out.println("Total Calories Consumed: " + food.getTotalCalories() + " cal");
                    break;

                case 2:
                    // Workout Menu
                    workout.showWorkoutList(workoutList);
                    System.out.print("Enter the workout name to add: ");
                    String workoutInput = scanner.nextLine().trim();

                    boolean workoutFound = false;
                    for (Workout w : workoutList) {
                        if (w.getWorkoutName().equalsIgnoreCase(workoutInput)) {
                            workout.selectWorkout(w);
                            workoutFound = true;
                            break;
                        }
                    }

                    if (!workoutFound) {
                        System.out.println("Workout not found. Please try again.");
                    }

                    int totalBurned = workout.getTotalCaloriesBurned();
                    System.out.println("Total Calories Burned: " + totalBurned + " cal");

                    // Use FitnessRank to rank the user
                    FitnessRank rank = new FitnessRank(totalBurned);
                    System.out.println("Fitness Rank: " + rank.getRank());
                    break;

                case 3:
                    // Summary on exit
                    System.out.println("\n======= Session Summary =======");
                    System.out.println("Foods consumed:");
                    for (Food f : Food.getfFoods()) {
                        // just show selected ones via total
                    }
                    System.out.println("Total Calories Consumed: " + food.getTotalCalories() + " cal");
                    System.out.println("Total Calories Burned:   " + workout.getTotalCaloriesBurned() + " cal");
                    int net = food.getTotalCalories() - workout.getTotalCaloriesBurned();
                    System.out.println("Net Calories:            " + net + " cal");
                    FitnessRank finalRank = new FitnessRank(workout.getTotalCaloriesBurned());
                    System.out.println("Final Fitness Rank: " + finalRank.getRank());
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
