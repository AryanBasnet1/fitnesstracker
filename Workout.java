import java.util.ArrayList;

public class Workout {
    String workoutName;
    int caloriesBurned;
    private static ArrayList<Workout> completedWorkouts = new ArrayList<>();

    public Workout(String workoutName, int caloriesBurned) {
        this.workoutName = workoutName;
        this.caloriesBurned = caloriesBurned;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public static ArrayList<Workout> getWorkouts() {
        ArrayList<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout("Running", 300));
        workouts.add(new Workout("Cycling", 250));
        workouts.add(new Workout("Swimming", 400));
        workouts.add(new Workout("Weightlifting", 200));
        workouts.add(new Workout("Yoga", 150));
        return workouts;
    }

    public void showWorkoutList(ArrayList<Workout> workouts) {
        System.out.println("------- Available Workouts are:");
        for (Workout w : workouts) {
            System.out.println(w.getWorkoutName() + " - " + w.getCaloriesBurned() + " cal burned");
        }
    }

    public void selectWorkout(Workout w) {
        completedWorkouts.add(w);
        System.out.println(w.getWorkoutName() + " added!");
    }

    public int getTotalCaloriesBurned() {
        int total = 0;
        for (Workout w : completedWorkouts) total += w.getCaloriesBurned();
        return total;
    }

    public static ArrayList<Workout> getCompletedWorkouts() {
        return completedWorkouts;
    }
}
