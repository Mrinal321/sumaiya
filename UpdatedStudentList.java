
import java.io.*;
import java.text.*;
import java.util.*;

public class UpdatedStudentList 
{
    public static void main(String[] args) 
    {
        if (args.length != 1)   // handle invalid number of arguments.
        {                 
            System.err.println(Constant.invalid); 
            System.err.println(Constant.message);
            System.err.println(Constant.exit);
            System.exit(1);
        }
        
        if (args[0].equals(Constant.printAll))   // case: print all
        {   
            System.out.println(Constant.load);
            try 
            {
                for (String student : readFile().readLine().split(",")) 
                {
                    System.out.println(student);
                }
            } 
            catch (Exception e) 
            {
            }
            System.out.println(Constant.loaded);
        } 
        
        else if (args[0].equals(Constant.random))   // case: print random data
        {   
            System.out.println(Constant.load);
            try 
            {
                String nameOfStudents[] = readFile().readLine().split(Constant.comma);
                System.out.println(nameOfStudents[new Random().nextInt(nameOfStudents.length)]);
            } 
            catch (Exception e) 
            {
            }
            System.out.println(Constant.loaded);
        } 
        
        else if (args[0].contains(Constant.add))   // case: add new data
        {    
            System.out.println(Constant.load);
            try 
            {
                BufferedWriter bufferedWriter = writeFile();
                String inputData = args[0].substring(1);
                String dateFormat = new SimpleDateFormat(Constant.df).format(new Date());
                bufferedWriter.write(Constant.comma + inputData + Constant.lastUpdate + dateFormat);
                bufferedWriter.close();
            } catch (Exception e) 
            {
            }
            System.out.println(Constant.loaded);
        } 
        
        else if (args[0].contains(Constant.search))   // case: search data
        {     
            System.out.println(Constant.load);
            try 
            {
                String nameOfStudents[] = readFile().readLine().split(Constant.comma);
				boolean found = false;
                for (String name : nameOfStudents) 
                {
                    if (name.equals(args[0].substring(1))) {
                        System.out.println(Constant.found + args[0].substring(1));
						found = true;
                        break;
                    }
                }
                
				if (!found) 
				{
					System.out.println(Constant.notFound + args[0].substring(1));
				}
            } catch (Exception e) 
            {
            }
            System.out.println(Constant.loaded);
        } 
        
        else if (args[0].contains(Constant.count))   // case: count data
        {      
            System.out.println(Constant.load);
            try 
            {
                System.out.println(readFile().readLine().split(Constant.comma).length + Constant.wordFound);
            } catch (Exception e) {
            }
            System.out.println(Constant.loaded);
        } 
        
        else   // handle invalid arguments.
        {                
            System.err.println(Constant.invalid);
            System.err.println(Constant.exit);
            System.exit(2);
        }

    }

    // Static method called: readFile() --> File Read Object
    private static BufferedReader readFile() throws FileNotFoundException 
    {
        BufferedReader bufferedReader = new BufferedReader(
        		new InputStreamReader
        				(new FileInputStream(Constant.studentsList)));
        
        return bufferedReader;
    }

    // Static method called: writeFile() --> File Write Object
    private static BufferedWriter writeFile() throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter(
        		new FileWriter(
        				Constant.studentsList, true));
        
        return bufferedWriter;
    }
}









