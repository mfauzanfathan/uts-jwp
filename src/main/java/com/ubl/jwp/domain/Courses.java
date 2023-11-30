package com.ubl.jwp.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Courses {
     @NotBlank(message = "course name is required")
    @Pattern(regexp = "^PG.*", message = ("Course code must begin with 'PG'"))
    private String courseCode;

    @NotBlank(message = "course code is required")
    @Size(min = 5, max = 10)
    private String courseName;

    @NotNull(message = "TotSKS is required")
    @Min(value = 1, message = "Minimal 1 SKS")
    @Max(value = 3, message = "Maximal 3 SKS")
    private Integer totSKS;

    @NotBlank(message = "faculty is required")
    @Pattern(regexp = "^(FE|FTI|FT)$", message = ("Faculty must be one of (FE, FTI, FT)"))
    private String faculty;

    public Courses() {

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getTotSKS() {
        return totSKS;
    }

    public void setTotSKS(Integer totSKS) {
        this.totSKS = totSKS;
    }
}
