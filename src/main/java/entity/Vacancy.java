package entity;

import java.util.List;

public class Vacancy {

    private String name;
    private int candidatesQuantity;
    private List<Competence> requiredCompetence;

    public Vacancy(String name, int candidatesQuantity, List<Competence> requiredCompetence) {
        this.name = name;
        this.candidatesQuantity = candidatesQuantity;
        this.requiredCompetence = requiredCompetence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCandidatesQuantity() {
        return candidatesQuantity;
    }

    public void setCandidatesQuantity(int candidatesQuantity) {
        this.candidatesQuantity = candidatesQuantity;
    }

    public List<Competence> getRequiredCompetence() {
        return requiredCompetence;
    }

    public void setRequiredCompetence(List<Competence> requiredCompetence) {
        this.requiredCompetence = requiredCompetence;
    }

    @Override
    public String toString() {
        return "entity.Vacancy{" +
                "name='" + name + '\'' +
                ", candidatesQuantity=" + candidatesQuantity +
                ", requiredCompetence=" + requiredCompetence +
                '}';
    }
}
