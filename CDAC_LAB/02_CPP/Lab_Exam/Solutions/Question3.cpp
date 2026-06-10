#include<iostream>
using namespace std;

void bubbleSort(int arr[],int size){

    for(int i=0;i<size;i++){

        for(int j =i+1;j<size;j++){
            if(arr[i]>arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
    }
    cout<<"[ ";
    for(int i=0;i<size;i++){
   cout<<arr[i] <<"  ";
}
cout<<" ]";
}



int main (){

     int size ;
cout<<"========================Bubble Sort============================"<<endl;
    cout<<"Enter Array Size : "<<endl;
    cin>>size;

int arr[size];

for(int i=0;i<size;i++){
cout<<"Enter Array Element "<<i+1<<" : "<<endl;
    cin>> arr[i];
}

bubbleSort(arr,size);



    return 0;
}