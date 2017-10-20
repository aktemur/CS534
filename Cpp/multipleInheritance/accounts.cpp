#include <iostream>

using namespace std;

class Account {
protected:
  int number;
  double balance;

public:
  Account(int number, double balance) {
    this->number = number;
    this->balance = balance;
  }

  virtual double getYearlyIncome() = 0;
  
  virtual void toString() {
    cout << "Account\n"
         << "Number:" << number << "\n"
         << "Balance:" << balance << "\n"; 
  }

  void deposit(double d) {
    balance += d;
  }
};


class FixedAccount : public Account {
protected:
  double threshold;
  double fixedIncome;

public:
  FixedAccount(int number, double balance,
               double threshold, double fixedIncome):
    Account(number, balance) {
    this->threshold = threshold;
    this->fixedIncome = fixedIncome;
  }
    
  double getYearlyIncome() {
    if(balance > threshold)
      return fixedIncome;
    else 
      return 0;
  }

  void toString() {
    cout << "Fixed ";
    Account::toString();
    cout << "Threshold:" << threshold << "\n";
    cout << "FixedIncome:" << fixedIncome << "\n"; 
  }
};

class InterestAccount: public Account {
protected:
  double interestRate;

public:
  InterestAccount(int number,
                  double balance,
                  double interestRate) :
    Account(number, balance)
  {
    this->interestRate = interestRate;
  }

  double getYearlyIncome() {
    return balance * interestRate;
  }

  void toString() {
    cout << "Interest ";
    Account::toString();
    cout << "Interest rate:" << interestRate << "\n";
  }
};

class InterestPlusFixedAccount: public FixedAccount {
protected:
  double interestRate;

public:
  InterestPlusFixedAccount(int number,
                           double balance,
                           double threshold,
                           double fixedIncome,
                           double interestRate) :
    FixedAccount(number, balance, threshold, fixedIncome)
  {
    this->interestRate = interestRate;
  }
  
  double getYearlyIncome() {
    return balance*interestRate
      + FixedAccount::getYearlyIncome();
  }

  void toString() {
    cout << "Interest Plus ";
    FixedAccount::toString();
    cout << "Interest rate:" << interestRate << "\n";
  }
};


// MULTIPLE INHERITANCE
// We see a case of the well-known Diamond problem here
class InterestPlusFixedAccount2: public FixedAccount, InterestAccount {
public:
  InterestPlusFixedAccount2(int number,
                           double balance,
                           double threshold,
                           double fixedIncome,
                           double interestRate) :
    FixedAccount(number, balance, threshold, fixedIncome),
    InterestAccount(number, balance, interestRate)
  {

  }
  
  double getYearlyIncome() {
    // CAUTION: Which 'balance' field
    // do the methods below use?
    return FixedAccount::getYearlyIncome()
      + InterestAccount::getYearlyIncome();
  }

  void toString() {
    // Test: print the balance field.
    // cout << balance << "\n"; // Compiler ERROR!!!
    // cout << FixedAccount::balance << "\n";
    // cout << InterestAccount::balance << "\n";
    
    cout << "Interest Plus ";
    FixedAccount::toString();
    cout << "Interest rate:" << interestRate << "\n";
    // Could not reuse InterestAccount's toString()
  }
};


int main() {
  cout << "Account: " << sizeof(Account) << "\n";
  cout << "FixedAccount: " << sizeof(FixedAccount) << "\n";
  cout << "InterestAccount: " << sizeof(InterestAccount) << "\n";
  cout << "InterestPlusFixedAccount: " << sizeof(InterestPlusFixedAccount) << "\n";
  cout << "InterestPlusFixedAccount2: " << sizeof(InterestPlusFixedAccount2) << "\n";

  // What happens when you uncomment the following line?
  // How does this effect utilizing polymorphism?
  //Account *acc = new InterestPlusFixedAccount2(1234, 50.0, 20, 4, 0.05);

  // InterestPlusFixedAccount2 *anotherAcc = new InterestPlusFixedAccount2(1234, 50.0, 20, 4, 0.05);
  // What happens when you uncomment the line below?
  // anotherAcc->deposit(6.0);
  
  return 0;
}


