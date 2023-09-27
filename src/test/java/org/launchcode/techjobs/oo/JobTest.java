package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here


    // Because IntelliJ config will not recognize an empty test file as valid for some reason
    @Test
    public void alwaysPasses() {
        assertEquals(0,0);
    }

    @Test
    public void testSettingJobId() {
        Job jobA = new Job();
        Job jobB = new Job();
        assertNotEquals(jobA.getId(), jobB.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job jobA = new Job("Devops Engineer", new Employer("The Devops Company"), new Location("Baldur's Gate"), new PositionType("Engineer"), new CoreCompetency("Python"));
        Job jobB = new Job("Devops Engineer", new Employer("The Devops Company"), new Location("Baldur's Gate"), new PositionType("Engineer"), new CoreCompetency("Python"));

        assertFalse(jobA.equals(jobB));
    }
}
