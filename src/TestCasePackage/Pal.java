package TestCasePackage;
import java.io.*;
import java. util.Scanner;

public class Pal{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
int a;
System.out.println("Enter number of names you want to enter");
a = in.nextInt();
a = a;
String[] number = new String[a];
for(int e=0; e <= a; e++){
System.out.println("Enter the String ");
number[e] = in.nextLine();
}
System.out.println("The names are ");
for(int i=0;i<a;i++){
System.out.println(number[i]);
}

for(int j=1;j<number.length;j++){
String nm=number[j];
for(int r=1;r<nm.length();r++){
char letter = nm.charAt(0);
System.out.println(letter);
}
}

}
}
