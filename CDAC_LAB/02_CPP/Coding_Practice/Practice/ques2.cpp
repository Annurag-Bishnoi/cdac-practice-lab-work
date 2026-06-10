#include <iostream>
using namespace std;

class Staff{
protected :

    int staffId;
    string staffName;
    double basicSalary;

public :

    void acceptStaff(){
        cout <<"Staff Id :   "<<endl;
        cin>>staffId;
        cout<<"Staff Name : "<<endl;
        cin>>staffName;
        cout<<"Staff Basic Salary :"<<endl;
        cin>>basicSalary;

    }
    void displayStaff(){
cout <<"Staff Id :   "<<staffId <<endl;
        cout<<"Staff Name : "<<staffName <<endl;
        cout<<"Staff Basic Salary :    "<<basicSalary<<endl;
    }

};

class Professor : public Staff{
    protected:
    double hra;
    double da;
    double researchAllowance;
    double bonus;
    double grossSalary;
    static int professorCount;
int seqId;
public :
Professor(){
    professorCount++;
    seqId=professorCount;
    hra=0;
    da=0;
    researchAllowance=0;
    bonus=0;
}
void acceptProfessor(){
    acceptStaff();
cout<<"Professor Bonus : "<<endl;
cin>>bonus;
}

double getbonus(){
    return bonus;
}
void displayProfessor(){
    displayStaff();
    cout<<"Professor HRA : "<<hra<<endl;
    cout<<"Professor DA : "<<da<<endl;
    cout<<"Professor Research Allowance : "<<researchAllowance<<endl;
    cout<<"Professor Bonus : "<<bonus<<endl;
    cout<<"Professor Gross Salary : "<<grossSalary<<endl;

}
double calculateSalary(){
    hra=0.25*basicSalary;
    da=0.15*basicSalary;
    researchAllowance=0.10*basicSalary;
    grossSalary = basicSalary+hra+da+researchAllowance;
return grossSalary;
}
double calculateSalary(double bonus){
     hra=0.25*basicSalary;
    da=0.15*basicSalary;
    researchAllowance=0.10*basicSalary;
    grossSalary = basicSalary+hra+da+researchAllowance+bonus;
    return grossSalary;
}

 void displayProfessorCount(){
    cout<<"Total Professor : " <<seqId<<endl;
}
};



int Professor::professorCount=0;
int main (){
Professor p1[1];
for(int i=0;i<1;i++){
p1[i].acceptProfessor();
}
for(int i=0;i<1;i++){

p1[i].calculateSalary();
p1[i].calculateSalary(p1[i].getbonus());
p1[i].displayProfessor();
p1[i].displayProfessorCount();
}

    return 0;
}