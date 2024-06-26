package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.ToDoList;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for managing ToDoList objects.
 */
public class ToDoListRepository {

    private static List<ToDoList> toDoLists = new ArrayList<>();

    /**
     * Adds a ToDoList to the repository.
     *
     * @param toDoList The ToDoList to add.
     * @return An Optional containing the added ToDoList, or empty if failed to add.
     */
    public Optional<ToDoList> add(ToDoList toDoList) {
        Optional<ToDoList> newToDoList = Optional.of(toDoList.clone());
        toDoLists.add(newToDoList.get());
        return newToDoList;
    }

    /**
     * Retrieves all ToDoLists from the repository.
     *
     * @return A List containing all ToDoLists.
     */
    public static List<ToDoList> getAllToDoLists() {
        return List.copyOf(toDoLists);
    }

    /**
     * Updates an existing to-do list entry in the repository.
     *
     * @param updatedEntry The updated to-do list entry.
     */
    public static void updateToDoListEntry(ToDoList updatedEntry) {
        for (int i = 0; i < toDoLists.size(); i++) {
            if (toDoLists.get(i).getTaskDescription().equals(updatedEntry.getTaskDescription())) {
                toDoLists.set(i, updatedEntry);
                break;
            }
        }
    }

    /**
     * Retrieves all ToDoLists from the repository.
     *
     * @return A List containing all ToDoLists.
     */
    public static List<ToDoList> getAll() {
        return new ArrayList<>(toDoLists);
    }

    /**
     * Finds a ToDoList by task description.
     *
     * @param taskDescription The task description to search for.
     * @return An Optional containing the matching ToDoList, or empty if not found.
     */
    public Optional<ToDoList> findByTaskDescription(String taskDescription) {
        for (ToDoList toDoList : toDoLists) {
            for (ToDoEntry entry : toDoList.getEntries()) {
                if (entry.getTask().equals(taskDescription)) {
                    return Optional.of(toDoList);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Finds ToDoLists by user email and green space name.
     *
     * @param userEmail     The user email to search for.
     * @param greenSpaceName The green space name to search for.
     * @return A List containing the matching ToDoLists.
     */
    public List<ToDoList> findByUserEmailAndGreenSpaceName(String userEmail, String greenSpaceName) {
        List<ToDoList> filteredToDoLists = new ArrayList<>();
        for (ToDoList toDoList : toDoLists) {
            for (ToDoEntry entry : toDoList.getEntries()) {
                if (entry.getUserEmail().equals(userEmail) && entry.getGreenSpaceName().equals(greenSpaceName)) {
                    filteredToDoLists.add(toDoList);
                }
            }
        }
        return filteredToDoLists;
    }
}
