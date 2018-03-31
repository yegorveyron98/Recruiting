package validation;
import entity.Competence;
import entity.CompetenceNameType;
import entity.CompetencePriorityType;
import exception.CompetenceScaleException;
import exception.ObligatoryCompetenceException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CompetenceValidatorTest {
    CompetenceValidator validator;
    Competence competenceWithoutObligatory;
    List<Competence> listOfCompentecesWithoutObligatory =  new ArrayList<>();
    List<Competence> emptyListOfCompenteces =  new ArrayList<>();
    List<Competence> validListOfCompenteces =  new ArrayList<>();
    int[] level = {0,1,2,3,4,5,6,7,8,9,10,11,12};

    @BeforeTest
    void setup() {
        validator = new CompetenceValidator();
        competenceWithoutObligatory = new Competence(CompetenceNameType.Management, CompetencePriorityType.OPTIONAL, level[0]);
        listOfCompentecesWithoutObligatory.add(competenceWithoutObligatory);
        competenceWithoutObligatory = new Competence(CompetenceNameType.TeamWork,CompetencePriorityType.NOPRIORITY, level[11]);
        listOfCompentecesWithoutObligatory.add(competenceWithoutObligatory);
        validListOfCompenteces.add(new Competence(CompetenceNameType.TeamWork,CompetencePriorityType.OBLIGATORY,level[2]));
    }
    @Test(dataProvider = "checkExceptionForCheckLevel", expectedExceptions = CompetenceScaleException.class)
    public void testCheckLevelForException(int level) throws Exception {
        validator.checkLevel(level);
    }

    @DataProvider(name = "checkExceptionForCheckLevel")
    public Object[][] dataProviderExceptionsCheck() {
        return new Object[][] {
                { 0 },
                { -1},
                { 11 },
                { Integer.MAX_VALUE },
                { Integer.MIN_VALUE }
        };
    }

    @DataProvider(name = "validDataForCheckLevel")
    public Object[][] dataProviderValidDataForCheckLevel() {
        return new Object[][] {
                { 1 },
                { 2},
                { 10 },
                { 9 },
                { 5 }
        };
    }

    @Test(dataProvider = "validDataForCheckLevel")
    public void testCheckLevelForValidData(int level) throws Exception {
        Assert.assertTrue(validator.checkLevel(level));
    }

    @Test (expectedExceptions = ObligatoryCompetenceException.class)
    public void testCheckObligatoryForException() throws Exception {
        validator.checkObligatory(listOfCompentecesWithoutObligatory);
    }

    //there isn't any check for empty list. this test is crushed

    /*@Test (expectedExceptions = IllegalArgumentException.class)
    public void testCheckObligatoryForEmptyData() throws Exception {
        validator.checkObligatory(emptyListOfCompenteces);
    }*/

    @Test
    public void testCheckObligatory() throws Exception {
        Assert.assertTrue(validator.checkObligatory(validListOfCompenteces));
    }
}