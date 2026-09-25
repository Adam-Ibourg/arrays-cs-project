package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int newCourse = 2210;  // the course we want to add
        // creating a new array that can copy the elements of registeredCourses and add a new course
        int[] updatedCourses = new int[registeredCourses.length + 1];

        for (int i = 0; i < registeredCourses.length; i++){
            updatedCourses[i] = registeredCourses[i];  // copying the registered courses
        }

        updatedCourses[updatedCourses.length - 1] = newCourse; // adding the new course

        for (int course: updatedCourses){
            System.out.println(course);  // printing the content of updatedCourses
        }

        // checking if updatedCourses contains a specific course number
        int courseNum = 3100;
        boolean found = false;
        for (int course : updatedCourses){
            if (course == courseNum){
                found = true;
                break;
            }
        }

        // displaying the result
        if (found) System.out.println("updatedCourses contains the course " + courseNum);
        else System.out.println("updatedCourses doesn't contain the course " + courseNum);
    }
}
