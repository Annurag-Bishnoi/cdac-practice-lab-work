#include <iostream>
using namespace std;

class Product{
    private :
   int productId;
string productName;
int quantity;
double price;
double discount;
double totalBill;
static int productCount;
int id;

public :
 Product(){
    productCount++;
    id=productCount;
}
void accept(){

    cout<<"Product Id :"<<endl;
    cin>>productId;

    cout<<"Product Name :"<<endl;
    cin>>productName;

    cout<<"Product Quantity :"<<endl;
    cin>>quantity;

    cout<<"Product Price :"<<endl;
    cin>>price;

    cout<<"Product Discount :"<<endl;
    cin>>discount;

}
double calBill(){
totalBill= price*quantity;
return totalBill;


}
double getDiscount(){
    return discount;
}
double calBill(double discount){
    totalBill=price*quantity - discount;
    return totalBill;
}

void display(){
    cout<<"______________________________________________________________________"<<endl;

    cout<<"Product Id :   "<<productId<<endl;
    

    cout<<"Product Name :    "<<productName<<endl;
    

    cout<<"Product Quantity :    "<<quantity<<endl;


    cout<<"Product Price :      "<<price<<endl;
    

    cout<<"Product Discount :     "<<discount<<endl;
    
    
}
 void displayCount(){
    
cout << "Product Count :      "<<id<<endl;
}

    
};


int Product::productCount=0;

int main (){
int n=2;
    Product p[n];
    // Product::displayCount()  ;
    for(int i=0;i<n;i++){
    p[i].accept();

    }

    for(int i=0;i<n;i++){
        p[i].display();
        p[i].displayCount();
       
        cout<<"Total Bill :  "<< p[i].calBill()<<endl;
       

        cout << "Total Bill With Discount :  "<< p[i].calBill(p[i].getDiscount())<<endl;
    }

    int maxBill=0;
    for (int i=0;i<n;i++){
        if(p[i].calBill()>maxBill){
            maxBill=p[i].calBill();
        }
    }

    cout<<"Maximum Bill :  "<<maxBill<<endl;
    return 0;
}