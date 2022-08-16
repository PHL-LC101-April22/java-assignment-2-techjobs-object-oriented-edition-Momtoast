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
}
