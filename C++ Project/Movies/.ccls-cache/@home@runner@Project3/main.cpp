#include <iostream>
#include <cstring>
using namespace std;
#include <iomanip>
#include "myDate.h"

struct Movie{
    char name[50];
    int rt;
    double rating;
    myDate releasedate;
    string mainActor;
};//end of struct

void sortByName(Movie *m[]){
  for(int i = 0; i < 10-1; i++){
    for(int j = 0; j < 10-i-1;j++){
      if(strcmp(m[j]->name, m[j+1]->name)>0){//comparing
        swap(m[j+1],m[j]);
      }
    }
  }
}

void sortByRunTime(Movie *m[]){
  for(int i = 0; i < 10-1; i++){
    for(int j = 0; j < 10-i-1; j++){
      if(m[j]->rt > m[j+1]->rt){
        swap(m[j+1],m[j]);
      }
    }
  }
}


void sortByImbdMovie (Movie *m[]){
  for(int i = 0; i < 10-1; i++){
    for(int j = 0; j < 10-i-1; j++){
      if(m[j]->rating > m[j+1]->rating){
        swap(m[j+1],m[j]);
      }
    }
  }
}


void sortByRD(Movie *m[]){
  for(int i = 0; i < 10-1; i++){
    for(int j = 0; j < 10-i-1; j++){
      if(m[j]->releasedate.dayOfYear() > m[j+1]->releasedate.dayOfYear()){
        swap(m[j+1],m[j]);
      }
    }
  }

  for(int i = 0; i < 10-1; i++){
    for(int j = 0; j < 10-i-1; j++){
      if(m[j]->releasedate.getYear() > m[j+1]->releasedate.getYear()){
        swap(m[j+1],m[j]);
      }
    }
  }
}


void sortByActor(Movie *m[]){
  for(int i = 0; i < 10-1; i++){
    for(int j = 0; j < 10-i-1; j++){
      if(m[j]->mainActor> m[j+1]->mainActor){
        swap(m[j+1],m[j]);
      }
    }
  }
}


void display(Movie *m[]){
  cout << "Name \t\t\t\t\t\t\tRunning Time \t\tIMBD Rating\t\t\tRelease Date\t\t\tMain Actor" << endl;

  for(int i = 0; i < 10; i ++){
    cout << setw(32)<<left<< m[i]->name;
    cout << left<<(m[i]->rt) / 60 <<"h ";//hours
    cout << (m[i]->rt) % 60 <<"m"<<"\t\t\t\t";//mins
    cout << setw(20)<<m[i]->rating;
    cout << setw(19)<<m[i]->releasedate.getDate()<<"\t\t";
    cout << m[i]->mainActor<<endl;
    
  }
}

void populate(Movie *m[]){
  m[0] = new Movie;
  strcpy(m[0]-> name,"John Wick");
  m[0] -> rt = 101;
  m[0] -> rating = 8.6;
  myDate JW(10,24,2014);
  m[0] -> releasedate = JW;
  m[0] -> mainActor = "Keanu Reeves";

  m[1] = new Movie;
  strcpy(m[1]-> name,"Sandlot");
  m[1] -> rt = 101;
  m[1] -> rating = 6.4;
  myDate SL(4,7,1993);
  m[1] -> releasedate = SL;
  m[1] -> mainActor = "Mike Vitar";

  m[2] = new Movie;
  strcpy(m[2]-> name,"Talladega Nights");
  m[2] -> rt = 110;
  m[2] -> rating = 7.1;
  myDate TN(8,4,2006);
  m[2] -> releasedate = TN;
  m[2] -> mainActor = "Will Ferrel";

  m[3] = new Movie;
  strcpy(m[3]-> name,"Cars");
  m[3] -> rt = 117;
  m[3] -> rating = 7.1;
  myDate cars(6,9,2006);
  m[3] -> releasedate = cars;
  m[3] -> mainActor = "Owen wilson";

  m[4] = new Movie;
  strcpy(m[4]-> name,"The Matrix");
  m[4] -> rt = 136;
  m[4] -> rating = 8.7;
  myDate mat(3,31,1999);
  m[4] -> releasedate = mat;
  m[4] -> mainActor = "Keanu Reeves";

  m[5] = new Movie;
  strcpy(m[5]-> name,"Grown Ups");
  m[5] -> rt = 102;
  m[5] -> rating = 7.1;
  myDate GU(6,25,2010);
  m[5] -> releasedate = GU;
  m[5] -> mainActor = "Adam Sandler";

  m[6] = new Movie;
  strcpy(m[6]-> name,"The Batman");
  m[6] -> rt = 176;
  m[6] -> rating = 8.4;
  myDate bat(3,4,2022);
  m[6] -> releasedate = bat;
  m[6] -> mainActor = "Robert Pattinson";

  m[7] = new Movie;
  strcpy(m[7]-> name,"Spider-man No Way Home");
  m[7] -> rt = 148;
  m[7] -> rating = 8.6;
  myDate SPN(12,17,2021);
  m[7] -> releasedate = SPN;
  m[7] -> mainActor = "Will Ferrel";

  m[8] = new Movie;
  strcpy(m[8]-> name,"Iron Man");
  m[8] -> rt = 126;
  m[8] -> rating = 7.9;
  myDate IR(5,2,2008);
  m[8] -> releasedate = IR;
  m[8] -> mainActor = "Robert Downey Jr.";

  m[9] = new Movie;
  strcpy(m[9]-> name,"Captain America: First Avenger");
  m[9] -> rt = 124;
  m[9] -> rating = 6.9;
  myDate CA(7,19,2011);
  m[9] -> releasedate = CA;
  m[9] -> mainActor = "Chris Evans";
  }

int main() {
  Movie *mov[10];
  bool running = true;
  int choice = 0;
  populate(mov);
  while(running != false){
    //the menu
    cout << "1) Display list sorted by Name"<<endl<<
            "2) Display list sorted by Running Time"<<endl<<
            "3) Display list sorted by IMDB Rating"<<endl<<
            "4) Display list sorted by Release Date"<<endl<<
            "5) Display list sorted by Main Actor"<<endl<<
            "6) Exit"<<endl;
    cout<<"What would you like to do?"<<endl;
    cin >> choice;
    //options
    if(choice == 1){
      sortByName(mov);
    }
    else if(choice ==2){
      sortByRunTime(mov);
    }
    else if(choice == 3){
      sortByImbdMovie(mov);
    }
    else if(choice == 4){
      sortByRD(mov);
    }
    else if(choice == 5){
      sortByActor(mov);
    }
    else{//exit option
      break;
    }
    
    //displaying
    display(mov);
  }//end of while loop
}//end of main