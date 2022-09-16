#include <iostream>
#include "Tessi.cpp"

using namespace std;

int main()
{
    int x;
    cin >> x;

    int* arr = new int[x];

    for (int i = 0; i < x; i++){
        arr[i] = i;
    }
   //3,3 cout << sizeof(arr) / sizeof(int);

    for (int i = 0; i < x; i++){
        cout << arr[i];
    }

    cout << sizeof(arr) / sizeof(int);

    delete arr;
}