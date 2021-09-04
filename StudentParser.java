public class StudentParser {

    /**
     * parse a student object using a single message line formatted correctly by /
     * @param lineToParse message formatted to make new student object
     * @return new student object either online or on campus with the required parameters
     */
    public static Student parseStringToStudent(String lineToParse) {
        String[] attributes; //array of strings used to store different parts of the line

        attributes = lineToParse.split("/"); //split the line by '/' and fill the array with the words betweem each '/'

        //if the message indicates the student is on campus
        if(attributes[0].equalsIgnoreCase("OnCampus")) {

            boolean residency; //temporary boolean for residency

            if(attributes[6].equalsIgnoreCase("Resident")) { //compare the message of student being a resident or not then make bool true or false
                residency = true;
            } else {
                residency = false;
            }
            
            return new OnCampusStudent(attributes[1], attributes[2], attributes[3], Integer.parseInt(attributes[4]), Double.parseDouble(attributes[5]), residency, Double.parseDouble(attributes[7]));
        }

        return new OnlineStudent(attributes[1], attributes[2], attributes[3], Integer.parseInt(attributes[4]), Double.parseDouble(attributes[5]), Double.parseDouble(attributes[6]));
    }

}
