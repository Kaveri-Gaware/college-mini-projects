#include <iostream>
using namespace std;

class Calculator {
public:
    void calculate() {
        int a, b;
        char op;

        cout << "Enter calculation (a + b): ";
        cin >> a >> op >> b;

        if (op == '+')
            cout << "Result: " << a + b;
        else if (op == '-')
            cout << "Result: " << a - b;
        else if (op == '*')
            cout << "Result: " << a * b;
        else if (op == '/')
            cout << "Result: " << a / b;
        else
            cout << "Invalid operator";
    }
};

class GuessGame {
public:
    void play() {
        int guess;
        int number = 5;

        cout << "\nGuess a number between 1 and 10: ";
        cin >> guess;

        if (guess == number)
            cout << "Correct guess!";
        else
            cout << "Wrong guess!";
    }
};

int main() {
    Calculator c;
    GuessGame g;

    c.calculate();
    cout << endl;
    g.play();

    return 0;
}
