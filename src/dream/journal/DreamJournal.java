/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dream.journal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avivzohman
 */
public class DreamJournal {

    /**
     * @param args the command line arguments
     */
    
    static Scanner myObj = new Scanner(System.in);
    
     public static int sum(int a, int b) {
            return a + b; 
     }
     
     public static int doub(int a){
         return a * 2; 
     }
     
     public static int half(int a) {
         return a / 2; 
     }
     
     public static int minusTwo(int a) {
         return a - 2; 
     }
     
     public static int plusTwo(int a) {
         return a + 2; 
     }
     
//     public static String userInfo() {
//         Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//         System.out.print("Enter username: ");
//
//         String userName = myObj.nextLine();  // Read user input
//         return userName; 
//     }
//     
//     public static String date() {
//         Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//         System.out.print("Enter date (MM/DD/YYYY): ");
//
//         String date = myObj.nextLine();  // Read user input
//         return date;
//     }
//     
//     public String dream(Scanner obj) {
//         
//         myObj = obj;  // Create a Scanner object
//         System.out.print("Enter dream: ");
//
//         String dream = myObj.nextLine();  // Read user input
//         return dream; 
//         
//         
//        //List<String> dream = new ArrayList<>();
////        Scanner scanner = new Scanner(System.in);
////        
////        System.out.print("Enter dream: ");
////        while (scanner.hasNext()) {
////            dream.add(scanner.next());
////        }
//// 
////        scanner.close();
////        System.out.println(dream);
//
//        
//     }
//     
//     public static String viewDream(){
//         Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//         System.out.print("Enter date: ");
//
//         String date = myObj.nextLine();  // Read user input
//         return date; 
//     }
     
     
     
     
     
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        MainFrame myFrame = new MainFrame(); 
        myFrame.init(); 
        
        
//        System.out.println(sum(1,1));
//        userInfo();
//        date(); 
//        dream();
        
    }
    
    
    
    
    
}
