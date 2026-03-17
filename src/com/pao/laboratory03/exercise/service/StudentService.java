package com.pao.laboratory03.exercise.service;

import com.pao.laboratory03.exercise.exception.StudentNotFoundException;
import com.pao.laboratory03.exercise.model.Student;
import com.pao.laboratory03.exercise.model.Subject;
import java.util.*;

public class StudentService {
    private static StudentService instance;
    private List<Student> students = new ArrayList<>();

    private StudentService() {}

    public static StudentService getInstance() {
        if (instance == null) instance = new StudentService();
        return instance;
    }

    public void addStudent(String name, int age) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                throw new RuntimeException("Studentul cu numele " + name + " exista deja!");
            }
        }
        students.add(new Student(name, age));
    }

    public Student findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Studentul " + name + " nu a fost gasit"));
    }

    public void addGrade(String studentName, Subject subject, double grade) {
        findByName(studentName).addGrade(subject, grade);
    }

    public void printAllStudents() {
        if (students.isEmpty()) System.out.println("Nu exista studenti");
        students.forEach(s -> System.out.println(s + " Note: " + s.getGrades()));
    }

    public void printTopStudents() {
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()))
                .forEach(System.out::println);
    }

    public Map<Subject, Double> getAveragePerSubject() {
        Map<Subject, Double> sums = new HashMap<>();
        Map<Subject, Integer> counts = new HashMap<>();

        for (Student s : students) {
            for (Map.Entry<Subject, Double> entry : s.getGrades().entrySet()) {
                sums.put(entry.getKey(), sums.getOrDefault(entry.getKey(), 0.0) + entry.getValue());
                counts.put(entry.getKey(), counts.getOrDefault(entry.getKey(), 0) + 1);
            }
        }

        Map<Subject, Double> averages = new HashMap<>();
        sums.forEach((subj, sum) -> averages.put(subj, sum / counts.get(subj)));
        return averages;
    }
}