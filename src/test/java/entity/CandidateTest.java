package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Theories.class)
public class CandidateTest {

    @DataPoints("positive")
    public static List<String> names = Arrays.asList("Пупкин", "Gdfsdf", "23123123");

    @DataPoints("negative")
    public static List<Integer> namesV2 = Arrays.asList(1, 2, 3);

    private Candidate candidate;

    List<Competence> competences = new ArrayList<>();

    Competence competence;

    @Before
    public void setUp() {
        candidate = new Candidate("QWE", competences);
        competence = new Competence(CompetenceNameType.Influence, CompetencePriorityType.OBLIGATORY, 10);
    }

    @Test
    public void createCandidate() {
        String str = "qwe";
        List<Competence> competences1 = new ArrayList<>();
        Candidate candidate = new Candidate(str, competences1);
        Assert.assertEquals(candidate.getSurname(), str);
        Assert.assertEquals(candidate.getCandidateCompetence(), competences1);
    }

    @Test
    @Theory
    public void setSurname(@FromDataPoints("positive") String str) {
        candidate.setSurname(str);
        Assert.assertEquals(candidate.getSurname(), str);
    }

    @Test
    public void getCandidateCompetence() {
    }

    @Test
    public void setCandidateCompetence() {
        candidate.setCandidateCompetence(competences);
        Assert.assertEquals(candidate.getCandidateCompetence(), competences);
    }

}