#include <iostream>
using namespace std;

 void bookFine(int del_days,double price,int isDamaged){

int add_day;
double totalprice;
double Fine;
int damage_amount =450;

       
    if(del_days<=10){
     // Fine 
     
      Fine=5*del_days;
    cout<<"Fine Amount : "<<Fine<<endl;
    if(isDamaged ==1){
        cout<<"Damage Charge : "<<damage_amount<<endl;
          cout<<"Total Amount : "<<price+Fine+damage_amount<<endl;
    }else{
        damage_amount=0;
        cout<<"Damage Charge : "<<damage_amount<<endl;
    cout<<"Total Amount : "<<price+Fine<<endl;
    }
    
    }
    else{
        add_day=del_days-10; 
        double newFine=10*add_day;


        cout<<"Fine Amount : "<<newFine+Fine<<endl;

        if(isDamaged==1){
            cout<<"Damage Charge : "<<damage_amount<<endl;
         cout<<"Total Amount : "<<price+Fine+newFine+damage_amount<<endl;
        }
        else{
            damage_amount=0;
             cout<<"Damage Charge : "<<damage_amount<<endl;
             cout<<"Total Amount : "<<price+Fine+newFine<<endl;
        }
    }

 }

  void bookFine(int del_days,double price,int isDamaged,char category){
double Fine ;
int damage_amount=350;

    if(category=='A'||category=='a'){
        Fine=8*del_days;
        cout<<"Fine Amount : "<<Fine<<endl;

         if(isDamaged ==1){
        cout<<"Damage Charge : "<<damage_amount<<endl;
          cout<<"Total Amount : "<<price+Fine+damage_amount<<endl;
    }else{
        damage_amount=0;
        cout<<"Damage Charge : "<<damage_amount<<endl;
    cout<<"Total Amount : "<<price+Fine<<endl;
    }


    }
     else if (category=='N'||category=='n'){
  Fine=12*del_days;
        cout<<"Fine Amount : "<<Fine<<endl;

         if(isDamaged ==1){
        cout<<"Damage Charge : "<<damage_amount<<endl;
          cout<<"Total Amount : "<<price+Fine+damage_amount<<endl;
    }else{
        damage_amount=0;
        cout<<"Damage Charge : "<<damage_amount<<endl;
    cout<<"Total Amount : "<<price+Fine<<endl;
    }
    }

  }

  void bookFine(int del_days,double price,int isDamaged,double rate){
double Fine;
int damage_amount=140;
    if(del_days<=15){
        Fine=del_days*rate;
        cout<<"Fine : "<<Fine<<endl;
        if(isDamaged==1){
             cout<<"Damage Charge : "<<damage_amount<<endl;
          cout<<"Total Amount : "<<price+Fine+damage_amount<<endl;
        }
        else{
             damage_amount=0;
        cout<<"Damage Charge : "<<damage_amount<<endl;
    cout<<"Total Amount : "<<price+Fine<<endl;
        }

    }
    else{
       double penalty=Fine+Fine*0.20;
        cout<<"Fine : "<<Fine<<endl;
        cout<<"Penalty : "<<penalty<<endl;

          if(isDamaged==1){
             cout<<"Damage Charge : "<<damage_amount<<endl;
          cout<<"Total Amount : "<<price+Fine+damage_amount+penalty<<endl;
        }
        else{
             damage_amount=0;
        cout<<"Damage Charge : "<<damage_amount<<endl;
    cout<<"Total Amount : "<<price+Fine+penalty<<endl;
        }

    }

  }

int main (){
    
        bool x = true;
        int choice;
        int del_days;
        double price;
        int isDamaged;
        char category;
        double rate;
        while(x){
            cout<<"====================Library Fine Management ==================="<<endl;
            cout<<"1.Book"<<endl;
            cout<<"2.Magazines"<<endl;
            cout<<"3. DVD"<<endl;
            cout<<"4. Exit"<<endl;
            cin>>choice;


            switch(choice){
                case 1 : 

                cout<<"Enter Delayed Days : "<<endl;
                cin>>del_days;
                cout<<"Enter Book Cost : "<<endl;
                cin>>price;
                cout<<"Is Book Damaged(1/0) : "<<endl;
                cin>>isDamaged;
                
                bookFine(del_days,price,isDamaged);

                break;
                case 2 :
                cout<<"Enter Delayed Days : "<<endl;
                cin>>del_days;
                cout<<"Enter Magazine Cost : "<<endl;
                cin>>price;
                cout<<"Is Magazine Damaged(1/0) : "<<endl;
                cin>>isDamaged;
                cout<<"Enter Magazine Category ('A'-Academic)/('N'-NonAcademic)"<<endl;
                cin>>category;
                bookFine(del_days,price,isDamaged,category);

                break;
                 case 3 :
                 cout<<"Enter Delayed Days : "<<endl;
                cin>>del_days;
                cout<<"Enter DVD Cost : "<<endl;
                cin>>price;
                cout<<"Is DVD Damaged(1/0) : "<<endl;
                cin>>isDamaged;
                cout<<"Enter Rate Per Day : "<<endl;
                cin>>rate;
                bookFine(del_days,price,isDamaged,rate);
                 break;
               
                 case 4 :
                 x=false ;
                 cout<<"Thank You :)"<<endl;
                 break;
                 default :
                 cout<<"Invalid Input!!!!"<<endl;
                 break;
            }
        }



    return 0;
}