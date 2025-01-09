import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class TaskManager {
    List<Task> tasks;
    List<Task> completedTasks;
    Random random;

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
        this.completedTasks = new ArrayList<>();
        this.random = new Random();
    }

    public String getRandomTask(int timeAvailable) {
        List<Task> validTasks = new ArrayList<>();

        // Filter tasks that can be completed within the given time and are not completed today
        for (Task task : tasks) {
            if (task.timeRequired <= timeAvailable && !completedTasks.contains(task)) {
                validTasks.add(task);
            }
        }

        if (validTasks.isEmpty()) {
            return "No tasks can be completed in the given time.";
        }

        // Select a random task from the filtered list
        int randomIndex = random.nextInt(validTasks.size());
        Task selectedTask = validTasks.get(randomIndex);

        // Mark the selected task as completed for the day
        completedTasks.add(selectedTask);

        return "You can complete: " + selectedTask.name;
    }
}
