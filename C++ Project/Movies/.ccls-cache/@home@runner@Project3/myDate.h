//  Jose Jimenez
// Class (CECS 282-04)
// Project Name (Prog 2 – myDate)
//  Due Date (03/01/2022)
// 
// I certify that this program is my own original work. I did not copy any part of this program from any other source. I further certify that I typed each and every line of code in this program.
#ifndef myDate_h
#define myDate_h
#include <string>
using namespace std;

class myDate{
  private:
  int month;
  int day;
  int year;
  int months[12] = {1,2,3,4,5,6,7,8,9,10,11,12};
  int monthsend[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
  string daysNames[7] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
  string monthNames[12] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
  public:
    myDate();//constructor
    myDate(int M,int D,int Y);//overload constructor
    void display();//display the date
    void increaseDate(int N);//increment days by N
    void decreaseDate(int N);//decrease days by N
    void addMonth();//add one month to the date #look at instructions
    int daysBetween(myDate D);//return the number of days inbetween #look at instuctions
    int getMonth();//return month in int form
    int getDay();//return day in int form
    int getYear();//return the day
    int dayOfYear();//return how many days its been since Jan 1 starting at 1
    string dayName();//returns day of the week
    string getDate();
};
#endif