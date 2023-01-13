package concurrentSolution;

import sequentialSolution.Courses;
import sequentialSolution.StudentVle;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader {

    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        try {

            List<Courses> courses = readBooksFromCSV("E:\\oulad1\\courses.csv", "course");

            // let's print all the courses read from CSV file
            for (Courses c : courses) {
                System.out.println(c);
            }

            List<StudentVle> studentVles = readVleFromCSV("E:\\oulad1\\studentvle.csv", "vle");
            Integer countin13J = 0, datein13J = 0, countin14J = 0, datein14J = 0, countInB13B = 0, countInB13J = 0, dateInB13B = 0, dateInB13J =0;
            for(StudentVle stVle: studentVles){
                if(stVle.getCodeModule().contains("AAA")){
                    if(stVle.getCodePresentation().contains("2013J")){
                        countin13J = countin13J + Integer.parseInt(stVle.getSumClick());
                        datein13J =  Integer.parseInt(stVle.getDate());
                    }
                    if(stVle.getCodePresentation().contains("2014J")){
                        countin14J = countin14J + Integer.parseInt(stVle.getSumClick());
                        datein14J =  Integer.parseInt(stVle.getDate());
                    }
                }
//                if(stVle.getCodeModule().contains("BBB")){
//                    if(stVle.getCodePresentation().contains("2013J")){
//                        countInB13J = countInB13J + Integer.parseInt(stVle.getSumClick());
//                        dateInB13J =  Integer.parseInt(stVle.getDate());
//                    }
//                    if(stVle.getCodePresentation().contains("2013B")){
//                        countInB13B = countInB13B + Integer.parseInt(stVle.getSumClick());
//                        dateInB13B =  Integer.parseInt(stVle.getDate());
//                    }
//                }
                //System.out.println(stVle);
            }
            System.out.print("Date and number of clicks in AAA 2013J code Presentation\n");
            System.out.print(datein13J+ " " + countin13J+ "\n");
            System.out.print("Date and number of clicks in AAA 2014J code Presentation\n");
            System.out.print(datein14J+ " " + countin14J + "\n");
            SummaryData summaryData = new SummaryData(datein13J, countin13J);
            writeToCSV(summaryData, "AAA_2013J.csv");
            SummaryData summaryData1 = new SummaryData(datein14J, countin14J);
            writeToCSV(summaryData1, "AAA_2014J.csv");
//            SummaryData summaryData2 = new SummaryData(countInB13J, dateInB13J);
//            writeToCSV(summaryData2, "BBB_2013J.csv");
//            SummaryData summaryData3 = new SummaryData(countInB13B, dateInB13B);
//            writeToCSV(summaryData3, "BBB_2013B.csv");

        }
        catch (Exception ex){
            throw ex;
        }
    }

    private static void writeToCSV(SummaryData summaryData, String fileName)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

                StringBuffer oneLine = new StringBuffer();
                oneLine.append(summaryData.getDate());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(summaryData.getTotalClicks());
                bw.write(oneLine.toString());
                bw.newLine();
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]
                { "countinAAA", "Doe", "38", "Comment Data\nAnother line of comment data" });
        File csvOutputFile = new File("AAA_2013J.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    private static List<StudentVle> readVleFromCSV(String fileName, String type) {
        List<StudentVle> stdVles = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();
            //line.replaceAll(""," ");
            while (line != null) {
                String[] attributes = line.split(",");
                StudentVle sdtVle = createStudentVle(attributes);
                stdVles.add(sdtVle);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return stdVles;
    }

    private static StudentVle createStudentVle(String[] metadata) {
        String codeModule = metadata[0];
        String codePresentation = metadata[1];
        String idStudent = metadata[2];
        String idSite = metadata[3];
        String date = metadata[4];
        String sumClick = metadata[5];


        return new StudentVle(codeModule,codePresentation, idStudent, idSite, date, sumClick);

    }

    private static List<Courses> readBooksFromCSV(String fileName, String type) {
        List<Courses> courses = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Courses course = createCourse(attributes);
                // adding courses into ArrayList
                courses.add(course);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return courses;
    }

    private static Courses createCourse(String[] metadata) {

        String codeModule = metadata[0];
        String codePresentation = metadata[1];
        String modulePresentation = metadata[2];

        return new Courses(codeModule,codePresentation, modulePresentation);
    }
}
