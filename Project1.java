import java.util.Scanner;
import javax.swing.JOptionPane;
public class Project1{
   public static void main(String[] args){
   		Scanner kb  = new Scanner(System.in);
   		JOptionPane.showMessageDialog(null, "hello world");
   		System.out.println("Please enter the initial sequence of values:");
   		String response = kb.nextLine();
   		String[] array = response.split(" ");  //put into string array, seperate by space
   		int[] numArray = new int[array.length];//put into numArray
   		for(int i = 0; i < numArray.length; i++){
   			try{
   				numArray[i] = Integer.parseInt(array[i]);
   			}
   			catch(NumberFormatException e){     //in case a non-number is inputted
   				System.out.println("Not a number!");
   			}
   			
   		}
   		BST bst = new BST();
   		for(int e: numArray){
   			bst.add(e);
   		}
   		bst.gogogadgetString();	
   		while(true){
   			
   			System.out.println("Command? ");
   			String command = kb.nextLine();
   			switch(command){
   			case "I":
   					System.out.print("Enter a number: ");
   					int insert = 0;
   					try{
   						insert = kb.nextInt();
   						if(bst.add(insert))
   							System.out.println(bst.inOrder());
   						kb.nextLine();
   					}
   					catch(NumberFormatException e){
   						System.out.println("Not a number!");
   					}
   					
   					//System.out.println(bst.inOrder());
   					break;
   			case "D":
   					System.out.println("Delete a value");
   					break;
   			case "P":
   					System.out.print("Enter a number: ");
   					int pred = 0;
   					try{
   						pred = kb.nextInt();
   						bst.findPred(pred);
   						kb.nextLine();
   					}
   					catch(NumberFormatException e){
   						System.out.println("Not a number!");
   					}
   					break;
   			case "S":
   					System.out.print("Enter a number: ");
   					int succ = 0;
   					try{
   						succ = kb.nextInt();
   						bst.findSuc(succ);
   						kb.nextLine();
   					}
   					catch(NumberFormatException e){
   						System.out.println("Not a number!");
   					}
   					break;
   			case "E":
   					System.exit(0);
   					break;
   			case "H":
   					bst.printMenu();
   					break;
   			default:
   					System.out.println("Invalid input");
   			}
   		}	
   	}
   }
