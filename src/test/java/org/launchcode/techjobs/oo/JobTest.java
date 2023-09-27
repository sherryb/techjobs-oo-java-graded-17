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

        assertEquals(System.lineSeparator(), job.toString().substring(0,1));
        assertEquals(System.lineSeparator(), job.toString().substring(job.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Devops Engineer", new Employer("The Devops Company"), new Location("Baldur's Gate"), new PositionType("Engineer"), new CoreCompetency("Python"));

        String id = "ID";
        String name = "Name:";
        String employer = "Employer:";
        String location = "Location";
        String positionType = "Position Type:";
        String coreCompetency = "Core Competency:";


        int idValue = job.getId();
        String nameValue = "Devops Engineer";
        String employerValue = "The Devops Company";
        String locationValue = "Baldur's Gate";
        String positionTypeValue = "Engineer";
        String coreCompetencyValue = "Python";

        // Tests themselves
        assertTrue(job.toString().contains(id));
        assertTrue(job.toString().contains(String.valueOf(idValue)));
        assertTrue(job.toString().contains(name));
        assertTrue(job.toString().contains(nameValue));
        assertTrue(job.toString().contains(employer));
        assertTrue(job.toString().contains(employerValue));
        assertTrue(job.toString().contains(location));
        assertTrue(job.toString().contains(locationValue));
        assertTrue(job.toString().contains(positionType));
        assertTrue(job.toString().contains(positionTypeValue));
        assertTrue(job.toString().contains(coreCompetency));
        assertTrue(job.toString().contains(coreCompetencyValue));
    }

}
