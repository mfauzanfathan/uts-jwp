package com.ubl.jwp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ubl.jwp.domain.Courses;

public class CoursesController {
    public static Map<String, Courses> coursesMap = new HashMap<>();

    @GetMapping("/courses")
    public List<Courses> getCourses() {
        return coursesMap.values().stream().toList();
    }
    @PostMapping("/courses")
    public ResponseEntity<String> addCourses(@RequestBody Courses courses) {
        coursesMap.put(courses.getcoursesCode(), courses);
        Courses savedCourses = coursesMap.get(courses.getcoursesCode());
        return new ResponseEntity<>("Courses with courses code: " + savedCourses.getcoursesCode() +
                "has been created", HttpStatus.OK);
    }
    @GetMapping(value = "/courses/{coursesCode}")
    public ResponseEntity<Courses> findCourses(@PathVariable("codeCourses") String coursesCode) {
        final Courses courses = coursesMap.get(coursesCode);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    @PutMapping(value = "/courses/{coursesCode}")
    public ResponseEntity<String> updateCourses(@PathVariable("coursesCode") String coursesCode,
            @RequestBody Courses courses) {
        final Courses coursesToBeUpdated = coursesMap.get(courses.getcoursesCode());
        coursesToBeUpdated.setcoursesName(courses.getcoursesName());
        coursesToBeUpdated.setfaculty(courses.getfaculty());
        coursesToBeUpdated.setsumSKS(courses.getsumSKS());

        coursesMap.put(courses.getcoursesCode(), coursesToBeUpdated);
        return new ResponseEntity<>("Courses with Code: " + coursesToBeUpdated.getcoursesCode() +
                "has been updated", HttpStatus.OK);
    }
    @DeleteMapping(value = "/courses/{coursesCode}")
    public ResponseEntity<Void> deleteCourses(@PathVariable("coursesCode") String coursesCode) {
        coursesMap.remove(coursesCode);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
