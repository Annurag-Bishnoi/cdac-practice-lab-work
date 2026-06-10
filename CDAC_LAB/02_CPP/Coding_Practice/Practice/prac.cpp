#include <iostream>
using namespace std;

double calBill(int units){
  double bill =units*4;
return bill;
}
double calBill(int units ,double fixCharge){
double bill = units*8+fixCharge;
return bill;
}
double calBill(int units,double fixCharge,double discount){
double bill = units*10+fixCharge-discount;
return bill;
}


int main() {
bool x = true;
int units;
double fixCharge,discount;
while(x){
  cout<<endl;
  cout<< "Select Your Option "<<endl;
  cout<<"1. Domestic Customer"<<endl;
  cout<<"2. Commercial Customer"<<endl;
  cout<< "3. Industrial Customer"<<endl;
int choice ;
cin>> choice;
switch(choice){
  case 1 :
    cout<<"Enter Bill Units :"<<endl;
    cin>> units;
    cout<< calBill(units);
  break;
   case 2 :
   cout<<"Enter Bill Units :"<<endl;
    cin>> units;
    cout<< "Enter FixCharge :" <<endl;
    cin>> fixCharge;
    cout<< calBill(units,fixCharge);
   break;
   case 3 :
   cout<<"Enter Bill Units :"<<endl;
    cin>> units;
    cout<< "Enter FixCharge :" <<endl;
    cin>> fixCharge;
    cout<< "Enter Discount :" <<endl;
    cin>> discount;
    cout<< calBill(units,fixCharge,discount);
   break;
   case 4 :
   x=false;
   break;
   default :
   cout<<"Invalid Syntax";
   break;
}
}


  return 0;
}