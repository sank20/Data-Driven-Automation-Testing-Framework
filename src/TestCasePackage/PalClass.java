package TestCasePackage;

import java.io.*;
import java.util.Scanner;

public class PalClass{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
int a,k=0,e=0;
System.out.println("Enter number of names you want to enter");
a = in.nextInt();
String[] number = new String[a];

for( e=0; e < a; e++){
System.out.print("Enter the String"+(k));
number[e] = in.next();
k=k+1;
}
System.out.println("The names are ");
for(int i=0;i<a;i++){
System.out.println(number[i]);
}

for(int j=0;j<number.length;j++){
String nm=number[j];
nm.length();
char letter = nm.charAt(0);
System.out.print(letter);

}

}
}

