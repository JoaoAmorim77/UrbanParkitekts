package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AddNewEntryAgendaController;
import pt.ipp.isep.dei.esoft.project.domain.AgendaEntry;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.ToDoEntry;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;


public class AssignTeamToAgendaEntryUI implements Runnable {


        private final AddNewEntryAgendaController controller;
        private final Scanner scanner;

        public AssignTeamToAgendaEntryUI(AddNewEntryAgendaController controller) {
            this.controller = controller;
            this.scanner = new Scanner(System.in);
        }

        @Override
        public void run() {
            System.out.println("--- Assign Team to Agenda Entry ---");

            // Obter detalhes da entrada na agenda
            ToDoEntry toDoEntry = getToDoEntryDetails();

            // Obter detalhes da equipe
            Team team = getTeamDetails();

            // Criar a entrada na agenda
            AgendaEntry agendaEntry = createAgendaEntry(toDoEntry);

            // Atribuir equipe à entrada na agenda
            controller.assignTeamToAgenda(agendaEntry, team);

            System.out.println("Team successfully assigned to agenda entry.");
        }

        private ToDoEntry getToDoEntryDetails() {
            System.out.print("Enter task description: ");
            String taskDescription = scanner.nextLine();

            // Outros detalhes da entrada na agenda
            // ...

            return new ToDoEntry(taskDescription);
        }

        private Team getTeamDetails() {
            System.out.print("Enter team members' emails (comma-separated): ");
            String[] emails = scanner.nextLine().split(",");
            return new Team(List.of(Optional.of(emails)).toString());
        }

        private AgendaEntry createAgendaEntry(ToDoEntry toDoEntry) {
            // Criar a entrada na agenda com os detalhes fornecidos
            // ...
            return new AgendaEntry(toDoEntry, "vehicles", "time interval",  LocalDate.now(), "Planned");
        }


}
