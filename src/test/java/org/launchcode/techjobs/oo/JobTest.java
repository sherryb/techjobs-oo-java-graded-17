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

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Devops Engineer", new Employer("The Devops Company"), new Location("Baldur's Gate"), new PositionType("Engineer"), new CoreCompetency("Python"));

        assertTrue(job.toString().startsWith(System.lineSeparator()));
        assertTrue(job.toString().endsWith(System.lineSeparator()));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Devops Engineer", new Employer("The Devops Company"), new Location("Baldur's Gate"), new PositionType("Engineer"), new CoreCompetency("Python"));

        String compare = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Devops Engineer" + System.lineSeparator() +
                "Employer: The Devops Company" + System.lineSeparator() +
                "Location: Baldur's Gate" + System.lineSeparator() +
                "Position Type: Engineer" + System.lineSeparator() +
                "Core Competency: Python" + System.lineSeparator();

        assertEquals(compare, job.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobA = new Job("Devops Engineer", new Employer("The Devops Company"), new Location(null), new PositionType(""), new CoreCompetency("Python"));

        String compare = System.lineSeparator() +
                "ID: " + jobA.getId() + System.lineSeparator() +
                "Name: Devops Engineer" + System.lineSeparator() +
                "Employer: The Devops Company" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Python" + System.lineSeparator();

        assertEquals(compare, jobA.toString());


    }
}
