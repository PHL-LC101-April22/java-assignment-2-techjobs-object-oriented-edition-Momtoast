package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobID() {
        Job webDeveloper = new Job();
        Job softwareDesigner = new Job();
        assertNotEquals(webDeveloper.getId(), softwareDesigner.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.getName(), "Product tester");
        assertEquals(newJob.getEmployer().getValue(), "ACME");
        assertEquals(newJob.getLocation().getValue(), "Desert");
        assertEquals(newJob.getPositionType().getValue(), "Quality control");
        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(newJob1.equals(newJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String newJobString = newJob.toString();
        int lastChar = newJobString.length()-1;
        assertEquals(newJobString.charAt(0), '\n');
        assertEquals(newJobString.charAt(lastChar), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(newJob.toString(), "\nID: 1" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(newJob.toString(), "\nID: 1" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Data not available" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyJob() {
        Job newJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals(newJob.toString(), "OOPS! This job does not seem to exist.");
    }
}

