package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.Optional;

public class CreateSkillController {

    private SkillsRepository skillRepository;

    public CreateSkillController() {
        getSkillRepository();
    }

    public CreateSkillController(SkillsRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    private SkillsRepository getSkillRepository() {
        if (skillRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillRepository = repositories.getSkillRepository();
        }
        return skillRepository;
    }

    public Optional<Skill> createSkill(String name, String description) {
        Skill newSkill = new Skill(name, description);
        return skillRepository.add(newSkill);
    }
}
