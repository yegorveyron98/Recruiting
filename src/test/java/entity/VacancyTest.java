package entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VacancyTest {

    Competence competence = new Competence(CompetenceNameType.TeamWork, CompetencePriorityType.OBLIGATORY,12);

    @Test
    public void testToString() throws Exception {
        org.testng.Assert.assertEquals("entity.Competence{name=TeamWork, priority=OBLIGATORY, level=12}",competence.toString());
    }
}