//  Jose Jimenez
// Class (CECS 282-04)
// Project Name (Prog 2 – myDate)
//  Due Date (03/01/2022)
// 
// I certify that this program is my own original work. I did not copy any part of this program from any other source. I further certify that I typed each and every line of code in this program.
#include <iostream>
#include "myDate.h"
#include <string>
using namespace std;

int Greg2Julian(int month, int day, int year){
  int julian = day - 32075 + 1461 * (year+4800+(month-14)/12)/4 + 367*(month-2-(month-14)/12*12)/12-3*((year+4900+(month-14)/12)/100)/4;
    return julian;
} // pass in the Month, Day, Year and return Julian number

void Julian2Greg(int JD, int &month, int &day, int &year){
  int L= JD+68569;                                 
  int N= 4*L/146097;                                  
  L= L-(146097*N+3)/4;                                
  int I= 4000*(L+1)/1461001;                          
  L= L-1461*I/4+31;                                         
  int J= 80*L/2447;                                               
  int K= L-2447*J/80;                                             
  L= J/11;                                                    
  J= J+2-12*L;                                                
  I= 100*(N-49)+I+L;                                                 

  year = I;
  month = J;
  day = K;
} // pass in the Julian Date, and get the correct Month, Day and Year through the parameter list – pass by reference

myDate::myDate(){
  month = 5;
  day = 11;
  year = 1959;
}//set the date to May 11, 1959

myDate::myDate(int M, int D, int Y){
  month = M;
  day = D;
  year = Y;
  
}//set the date to the values passed in through the parameter

void myDate::display(){
  cout << month <<" "<< day<<", " << year;
}//display the date 
void myDate::increaseDate(int N){
  int jd = Greg2Julian(month,day,year);
  jd += N;
  Julian2Greg(jd, month, day, year);
}//increment days by N

void myDate::decreaseDate(int N){
  int jd = Greg2Julian(month,day,year);
  jd -= N;
  Julian2Greg(jd, month, day, year);
}//decrease days by N

void myDate::addMonth(){
  if(day == 31 && month == 1){
    month++;
    int year = Greg2Julian(month,day,year);
    int yearDiff = Greg2Julian(month,day,year+1);
    if((yearDiff - year) == 366){
      day = 28;
    }
    else{
      day = 29;
    }
  }
  else if(day == 31 && month != 1){
    month++;
    day = 30;
  }
  else{
    month++;
  }
}//add one month to the date #look at instructions

int myDate::daysBetween(myDate D){
  int day1 = Greg2Julian(month,day,year);
  int day2 = Greg2Julian(D.month,D.day,D.year);
  int sub = day2 - day1;
  return sub;
}//return the number of days inbetween #look at instuctions

int myDate::getMonth(){
  return month;
}//return month in int form

int myDate::getDay(){
  return day;
}//return day in int form

int myDate::getYear(){
  return year;
}//return the day

int myDate::dayOfYear(){
  int monthnum = 0;
  int dayOfYear = 0;
  for(int i = 0; i < 12; i++){
    if(months[i] == month){
      monthnum += monthsend[i];
      int monthDiff = monthsend[i] - day;
      dayOfYear = monthnum - monthDiff;
      break;
    }
    else{
      monthnum += monthsend[i];
    }
  }
  if(month > 2){
    if((Greg2Julian(1,1,year+1)-Greg2Julian(1,1,year))==366){
      dayOfYear+=1;
    }
  }
  return dayOfYear;
  
}//return how many days its been since Jan 1 starting at 1

string myDate::dayName(){
  int newDay = Greg2Julian(month,day,year);
  for(int i = 0; i < 15; i++){
    newDay %= 7;
    if(newDay < 7){
      break;
    }
  }
  int num = newDay;
  for(int i = 0; i < 7; i++){
    if(i == num){
      return daysNames[i];
    }
  }
  }//returns day of the week
string myDate::getDate(){
  string newMonth;
  for(int i = 0; i <12; i++){
    newMonth = monthNames[i];
    if(i == month){
      break;
    }
  }
  string DATE = newMonth +" "+ to_string(day)+", " + to_string(year);
  return DATE;
  

}