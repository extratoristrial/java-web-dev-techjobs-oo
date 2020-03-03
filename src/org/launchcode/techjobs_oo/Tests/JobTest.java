package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;

    @Before
    public void createJobObjects() throws Exception {
        job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {

    assertTrue(job1.getId() != job2.getId());
    assertTrue(job1.getId() < job2.getId());
    assertTrue(job2.getId() == job1.getId() + 1);
}

    @Test
    public void testJobConstructorSetsAllField() {
        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof  Employer);
        assertTrue(job3.getLocation() instanceof  Location);
        assertTrue(job3.getPositionType() instanceof  PositionType);
        assertTrue(job3.getCoreCompetency() instanceof  CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringFirstReq() {
        assertThat(job3.toString(), startsWith("\n"));
        assertThat(job3.toString(), endsWith("\n"));
    }

    @Test
    public void testToStringSecondReq() {
        assertThat(job3.toString(), containsString("ID: " + job3.getId() + "\n"));
        assertThat(job3.toString(), containsString("Name: " + job3.getName() + "\n"));
        assertThat(job3.toString(), containsString("Employer: " + job3.getEmployer() + "\n"));
        assertThat(job3.toString(), containsString("Location: " + job3.getLocation() + "\n"));
        assertThat(job3.toString(), containsString("Position Type: " + job3.getPositionType() + "\n"));
        assertThat(job3.toString(), containsString("Core Competency: " + job3.getCoreCompetency() + "\n"));
    }

    @Test
    public void testToStringThirdReq() {
          assertThat(job1.toString(), containsString("Data not available"));
    }
}
