import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class q1 {
    public static void main(String[] args) {
    FileInputStream input_stream =null;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    File file= new File("./file1.txt");
    File op_file= new File("./file2.txt");
    byte[] msg=null;
    try{
    input_stream = new FileInputStream(file);
    int data;
    while((data=input_stream.read())!=-1)
    {
        outputStream.write(data);
        msg=outputStream.toByteArray();
        System.out.print((char)data);
    }
    }
    catch(IOException e)
    {
        System.out.println("Error while creating input stream: ");
    }
    finally{
        try {
            input_stream.close();
        } catch (IOException e) {
            System.out.println("Error closing the file");
        }
    }
    FileOutputStream output_stream=null;
    try{
        output_stream = new FileOutputStream(op_file);
        output_stream.write(msg);
        }
        catch(IOException e)
        {
            System.out.println("Error while creating output stream: "+e.getMessage());
        }
        finally{
           try {
               output_stream.close();
           } catch (IOException e) {
            System.out.println("Error closing the output stream");
           }
        }

    
    
}
}
