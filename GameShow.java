/************************************************************
* Author: Filip Matic
* Title: GameShow.java
* Description: This program simulates a game show where the user
* answers multiple choice questions. The program will choose
* a random question from the question bank, meaning no two
* games will be the same. 
 ************************************************************/
import java.util.*;

public class GameShow
{
String questions[];
String options[][];
int answers[];
long money[];
int history[];

public int getRandomQuestion()
{
int i=(int)((Math.random()*15));
return i;
}

public GameShow()
{
questions=new String[]
{
"Who discovered Uranus? ",
"Robert Koch worked on ",
"The telephone was invented by ",
"The velocity of light was first measured by",
"Study of life in outer space is known as",
"Oncology is the study of ",
"Who invented the ball point pen? ",
"The credit of developing the polio vaccine goes to",
"The credit of inventing the television goes to",
"The scientist who first discovered that the earth revolves round the sun was",
"Centigrade & Fahrenheit scales give same reading at",
"The unit of energy in MKS system is",
"Which of the following instruments is used to measure pressure of gases?",
"Where is the headquarters of Microsoft located?",
"'.BAT' extension refers usually to what kind of file?",
};
options=new String[][]
{
{"1. Herschel ", "2. Ganleo", "3. Copernicus ", "4. None of these "},
{"1. Tuberculosis ", "2. Cholera ", "3. Malaria ", "4. Diabetes"},
{"1. John Logie Baird ", "2. Alexander Graham Bell ", "3. Thomas Elva Edison ", "4. James Watt "},
{"1. Einstein", "2. Newton ", "3. Romer ", "4. Galileo "},
{"1. Endobiology ", "2. Exobiology", "3. Enterobiology ", "4. Neobiology "},
{"1. Birds", "2. Cancer", "3. Mammals", "4. Soil"},
{"1. Waterman", "2. Oscar", "3. Wilson", "4. Lazlo Biro"},
{"1. Jonas Salk ", "2. Alb E. Sabin ", "3. Selman Waksman ", "4. None of these "},
{"1. Faraday ", "2. Baird", "3. Edison", "4. Marconi"},
{"1. Newton", "2. Dalton", "3. Copernicus", "4. Einstein"},
{"1. -40 degree", "2. -32 degree", "3. -273 degree", "4. -100 degree"},
{"1. Volt", "2. Erg", "3. Ohm", "4. Joule"},
{"1. Barometer ", "2. Manometer ", "3. Saccharimeter ", "4. Lactometer "},
{"1. Santa Clara, California ", "2. Tucson, Arizona ", "3. Richmond, Virginia ", "4. Redmond, Washington"},
{"1. Compressed Archive file ", "2. System file ", "3. Audio file ", "4. Backup file "},

};
answers=new int[]{1,1,2,3,2,2,4,1,2,3,1,4,2,4,2};
money=new long[]{1000,2000,3000,5000,10000,20000,40000,75000,100000,250000,500000,1000000};
history=new int[15];
}
public static void main(String args[])
{
Scanner sc= new Scanner(System.in);
int choice= 0;
System.out.println("Welcome to GameShow\n\nYour First Question is :\n");
GameShow k= new GameShow();


for(int i=0;i!=k.questions.length;i++)
{
int r;
do
{
r= k.getRandomQuestion();

}while(k.history[r]==1);

System.out.println(k.questions[r]);
System.out.println(k.options[r][0]);
System.out.println(k.options[r][1]);
System.out.println(k.options[r][2]);
System.out.println(k.options[r][3]);
System.out.println("Press 1,2,3 or 4");
choice= Integer.parseInt(sc.nextLine());

if(choice==k.answers[r])
{
System.out.println("\nCorrect answer\nYou Won ."+k.money[i]+"\n");
}
else
{
System.out.println("\nYou Lost\nCorrect Answer is : "+k.answers[r]+"\nGame Over !!");
break;
}
k.history[r]=1;
}
}
}