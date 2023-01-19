
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public  static  String filename="database.txt";
    public static void main(String[] args) throws Exception {
        createNewFileWithHeaders();
        displayServices();
    }
   
    // Mathods

    public static void createNewFileWithHeaders(){
        File database=new File(filename);

        try {

            if( database.createNewFile()==true){

                try {
                    FileWriter writer=new FileWriter(filename,true);
                    writer.append("User ID"+","+"User Name"+","+","+"Job"+","+"Address");
                    writer.append("\n");
                    writer.close();
                    System.out.println("file created succefully!");
                } catch (IOException e) {
                    System.out.println(e);
                }

            }
            else {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createAddNewPerson( Scanner input){
        System.out.println("Enter Alumni's ID :  ");
        int id=input.nextInt();
        input.nextLine();
        System.out.println("Enter your name :");
        String name=input.nextLine();
        System.out.println("Enter your job : ");
        String job=input.nextLine();
        System.out.println("Enter your address");
        String address=input.nextLine();
        Person person=new Person(id,name,job,address);

        try {
            FileWriter writer=new FileWriter(filename,true);
            writer.append(person.getUserData());
            writer.append("\n");
            writer.close();
            System.out.println("person added succefully!");
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void  deleteRecordById(ArrayList<String> arrayList,Scanner input){
        System.out.println("enter any id or word to delete a record");
        String searchKey=input.next();
        String line;
        try {

            BufferedReader reader=new BufferedReader(new FileReader(filename));
            while ((line=reader.readLine())!=null){
                if(line.contains(searchKey)){
                    System.out.println(line);
                    continue;
                }else {
                    arrayList.add(line);
                }



            }

        }catch (Exception e){

        }
        try {
            FileWriter writer=new FileWriter(filename);
            for (int i=0;i<arrayList.size();i++){
                writer.append( arrayList.get(i));
                writer.append("\n");


            }
            writer.close();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("done!");
        }}

        public static void updateRecord(ArrayList<String>arrayList,Scanner input){
            try {
                BufferedReader reader=new BufferedReader(new FileReader(filename));
                System.out.println("please enter any key to update the record");
                String searchKey=input.nextLine();
                String line;
                while ((line=reader.readLine())!=null){
                    if(   line.contains(searchKey)){
                        System.out.println("enter the text you want to change");
                        String oldValue=input.next();
                        System.out.println("enter the new text you want to change");
                        String newValue=input.next();
                        arrayList.add(line.replace(oldValue,newValue));
    
    
                    }else {
                        arrayList.add(line);
                    }
    
                }
    
    
            }catch (Exception e){
                System.out.println(e);
            }
    
            try {
                FileWriter writer=new FileWriter(filename);
                for(int i=0;i<arrayList.size();i++){
                    writer.append(arrayList.get(i));
                    writer.append("\n");
                }
                writer.close();
            }catch (Exception e){
                System.out.println(e);
            }
    
        }

        public static void getUserById(Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            System.out.println("please enter Alumni ID to get the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if(   line.contains(searchKey)){
                    System.out.println(line);

                }

            }


        }catch (Exception e){
            System.out.println(e);
        }


    }
 
    public static void getAllPersons(){

        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));


            String line;
            while ((line=reader.readLine())!=null){

                System.out.println(line);

            }

        }catch (Exception e){
            System.out.println(e);
        }





    }



    public static void  displayServices(){
        Scanner input = new Scanner(System.in);

        while(true){
            ArrayList<String> arrayList=new ArrayList<String>();

            System.out.println("====================================================");
            System.out.println("Alumni's Record System in Java Using Text File" +
                    "");
            System.out.println("====================================================");
            System.out.println("[1] Add New Alumnis Record");
            System.out.println("[2] Delete Alumnis Record");
            System.out.println("[3] Update Alumnis Record");
            System.out.println("[4] View Alumnis Record");
            System.out.println("[5] Quit Program");
            System.out.println("====================================================");
            System.out.print("Select a Number : ");
            int x= input.nextInt();
            if(x==5) {
                System.out.println();
                System.out.print("Thank you for using this program.");
                System.out.println();
                break;
            }
            else if(x==1){
                createAddNewPerson(input);
            }
            else  if(x==2){

                deleteRecordById(arrayList,input);
            }
            else  if(x==3){
                updateRecord(arrayList,input);
            }
            else if(x==4){
                getUserById(input);

            }
             else {
                System.out.println("please enter a vaild number");
            }




        }
    }





}
 class Person {
    // attributes
    public int id;
    public String name;
    public  String job;
    public   String address;

    Person(int id , String name,String job, String address){
        this.id=id;
        this.name=name;
        this.job=job;
        this.address=address;

    }

    public  String getUserData(){

return   id+"," + name +","  + job+"," +address;
    }


    // methods



}
