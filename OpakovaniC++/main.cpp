#include <iostream>
#include <string>
#include <vector>

int main()
{
    // int arraySize;
    // std::cout << "Enter size of the array";
    // std::cin >> arraySize;
    std::vector<int> array{0, 1, 0, 2, 5}; //(arraySize) arraySize vector

    int number = 0;
    std::cin >> number;
    array.insert(array.end() - 1, 500);
    for (size_t i = 0; i < array.size(); i++)
    {
        std::cout << array[i] << " ";
    }
    std::cout << &number;
    std::cout << &number;
}
/*int size;
cout<<"Enter desired size of the array";
cin >> size;
std::vector<int> array(size);*/
