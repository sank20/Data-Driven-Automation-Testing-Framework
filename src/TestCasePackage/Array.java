package TestCasePackage;
import java.io.*;
import java.util.Scanner;
public class Array{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
int a;
int c=0;
System.out.println("Enter length of the array");
a = in.nextInt();
int[] number = new int[a] ;
if(a==1){
System.out.println("Enter the number 1");
number[0] = in.nextInt();
System.out.println("XOR on "+number[0]+" is "+number[0]);
}
else{
for(int e = 0; e < a; e++){
System.out.println("Enter the number "+(e+1));
number[e] = in.nextInt();
}
for(int e = 0; e < a; e++){

c = (number[e] ^ c);
 }
System.out.println("XOR is "+c);
}
 }
}