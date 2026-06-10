#include <iostream>
using namespace std;

class Employee {
private :
int empId;
string empName;
double salary;
public :
double getsalary(){
    return salary;
}
void acceptEmp(){
    cout<<"Enter Employee Id : "<<endl;
    cin>>empId;
    cout<<"Enter Employee Name : "<<endl;
    cin>>empName;
    cout<<"Enter Employee Salary : "<<endl;
    cin>>salary;
}
void displayEmployee(){
    cout<<"Employee Id : "<<empId<<endl;
    cout<<"Employee Name : "<<empName<<endl;
    cout<<"Employee Salary : "<<salary<<endl;

}
};

class Manager : public Employee {
private :
double hra;
double grossSal;
public :
double getHRA(){
    hra=0.20*getsalary();
    return hra;
}
void acceptManager (){
    
     cout<<"____________________Manager Details ___________"<<endl;
acceptEmp();

}
void displayManager(){
     cout<<"____________________Manager Details ___________"<<endl;
displayEmployee();
cout<<"Employee HRA Is : "<<getHRA()<<endl;
cout<<"Employee Gross Salary : " <<getsalary()+getHRA()<<endl;
}

};

class Engineer : public Employee{
private :
double techAllowance;
public :
double gettechAll(){
    techAllowance=0.20*getsalary();
    return techAllowance;
}
void acceptEngineer(){
     cout<<"____________________Engineer Details ___________"<<endl;
    acceptEmp();
}
void displayEngineer(){
    cout<<"____________________Engineer Details ___________"<<endl;
    displayEmployee();
    cout<<"Employee Technical Allowance Is : "<<gettechAll()<<endl;
cout<<"Employee Gross Salary : " <<getsalary()+gettechAll()<<endl;
}
};


class Clerk : public Employee {
    private :
int fixedAllowance=5000;
public:
void acceptClerk(){
    cout<<"____________________Clear Details ___________"<<endl;
    acceptEmp();
}
void displayClerk(){
    cout<<"____________________Clear Details ___________"<<endl;
    displayEmployee();
    cout<<"Clerk Fixed Allowance Is : "<<fixedAllowance<<endl;
cout<<"Clerk Gross Salary : " <<getsalary()+fixedAllowance<<endl;
}

};



int main (){
Manager m;
Engineer e;
Clerk c;
    bool x =true;
    int choice ;
    while (x){
        cout<<"Choose Employee : "<<endl;
        cout<< "1. Manager"<<endl;
        cout<<"2. Engineer"<<endl;
        cout<<"3. Clerk"<<endl;
        cin>>choice;

        switch(choice){
            case 1 :
                    
            
                     m.acceptManager();
                    m.displayManager();
            break;
            case 2 :
            e.acceptEngineer();
            e.displayEngineer();
            break;
            case 3 :
            c.acceptClerk();
            c.displayClerk();
            break;
            case 4 :
            x=false ;
            cout<<"Thank You :)"<<endl;
            break;
            default :
            cout<<"Invalid Input !!!!"<<endl;
            break;
        }
    }

    return 0;
}