package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 50)
    private String location;

    @OneToMany(mappedBy = "employer")
//    @JoinColumn(name = "jobId")
    private List<Job> jobs = new ArrayList<>();


//    Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship
//    between data tables. Recall that this annotation needs a name parameter. What should its value be?

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employer(String location) {
        this.location = location;
    }

    public Employer() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

}
