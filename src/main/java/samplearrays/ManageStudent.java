package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];  // initial value for the variable
        for (Student s: students){
            if (s.getAge() > oldest.getAge()) oldest = s;  // comparing the age of current oldest with other students
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student s: students){
            if (s.isAdult()) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length == 0) return Double.NaN;  // there are no students

        int sum = 0;
        for (Student s: students){
            sum += s.getGrade();  // compute the sum of all grades
        }

        return (double) sum / students.length;  // compute the average
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s: students){
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparingInt(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s: students){
            if (s.getGrade() >= 15) System.out.println(s.getName());
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s: students){
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;  // student found and the grade got modified
            }
        }
        return false;  // student not found
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; i++){
            for (int j = i+1; j < students.length; j++){
                if (students[i].getName().equals(students[j].getName())){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length+1];  // creating new array with an additional slot

        // copying the elements of the old array
        for (int i = 0; i < students.length; i++){
            newStudents[i] = students[i];
        }
        newStudents[students.length] = newStudent;  // adding the new student

        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "Ahmed");
        arr[1] = new Student(2, "Imad", 19);
        arr[2] = new Student(3, "Sara", 17, 14);
        arr[3] = new Student(4, "Narjiss", 18, 17);
        arr[4] = new Student(5, "Adam", 20, 15);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("\nOldest student: " + oldest);

        // 3) Count adults
        int adultsCount = countAdults(arr);
        System.out.println("\nThe number of adults: " + adultsCount);

        // 4) Average grade
        double avg = averageGrade(arr);
        System.out.println("\nThe average grade: " + avg);

        // 5) Find by name
        Student found = findStudentByName(arr, "Adam");
        System.out.println("\nFound: " + found);

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 16);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        boolean duplicates = hasDuplicateNames(arr);
        System.out.println("\nDuplicates found ? " + duplicates);

        // 10) Append new student
        Student newStudent = new Student(5, "Yassine", 18, 13);
        arr = appendStudent(arr, newStudent);
        System.out.println("\n== After append ==");
        for (Student s: arr){
            System.out.println(s);
        }

        // School representation with 2D array
        Student[][] school = new Student[2][3];

        // Filling the array with student objects
        school[0][0] = new Student(1, "Adam", 18, 16);
        school[0][1] = new Student(2, "Imad", 20, 17);
        school[0][2] = new Student(3, "Sara", 18, 15);
        school[1][0] = new Student(4, "Imad", 18, 13);
        school[1][1] = new Student(5, "Hamza", 19, 18);
        school[1][2] = new Student(6, "Narjiss", 17, 16);

        //Printing the names of students class by class
        for (int i = 0; i < school.length; i++){
            System.out.println("\n== The students of the class " + (i+1) + " ==");
            for (int j = 0; j < school[0].length; j++){
                System.out.println(school[i][j].getName());
            }
        }

        // Finding the top student in each class
        for (int i = 0; i < school.length; i++){
            Student topStudent = school[i][0];
            for (int j = 1; j < school[0].length; j++){
                if (topStudent.getGrade() < school[i][j].getGrade()){
                    topStudent = school[i][j];
                }
            }
            System.out.println("\nThe top student in class " + (i+1) + " is: " + topStudent);
        }
    }
}

