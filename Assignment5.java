
import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5 {
    public static void main(String[] args) {
        
        char input1;
        String inputInfo, line; 
        boolean operation;

        // ArrayList object is used to store student objects
        ArrayList studentList = new ArrayList();
        
        try {
            printMenu(); //print out menu

            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1) {
           switch (input1)
            {
             case 'A':   //Add Student
               System.out.print("Please enter a student information to add:\n");
               inputInfo = stdin.readLine().trim();
               studentList.add(StudentParser.parseStringToStudent(inputInfo));
               break;
             case 'C':   //Compute Tuition
                for (int i=0; i<studentList.size();i++)
                   ((Student) studentList.get(i)).computeTuition();
                System.out.print("tuition computed\n");
               break;
             case 'D':   //Count certain students
               System.out.print("Please enter a number of credits:\n");
               inputInfo = stdin.readLine().trim();
               int credits = Integer.parseInt(inputInfo);

               int count = 0;
               for (int i=0; i<studentList.size();i++)
                {
                 if (credits ==  ((Student)studentList.get(i)).getCreditNum())
                  {
                   count++;
                  }
                }

                System.out.println("The number of students who are taking " + credits
                                   + " credits is: " + count);
               break;
             case 'L':   //List Students
               if (studentList.isEmpty())
                System.out.print("no student\n");
               else
                for (int i=0; i < studentList.size(); i++)
                  System.out.print(studentList.get(i).toString());
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
            } while (input1 != 'Q');

        } catch (IOException exception) {
            System.out.println("IO Exception");
        }

    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                         "------\t\t------\n" +
                         "A\t\tAdd Student\n" +
                         "C\t\tCompute Tuition\n" +
                         "D\t\tCount Certain Students\n" +
                         "L\t\tList Students\n" +
                         "Q\t\tQuit\n" +
                         "?\t\tDisplay Help\n\n");
 }  
}
