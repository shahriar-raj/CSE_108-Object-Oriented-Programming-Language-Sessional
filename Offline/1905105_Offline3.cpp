#include<iostream>
#include<cstring>
using namespace std;

class Vector
{
    char *name;
    int x,y,z;
public:
    Vector(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=0;
        y=0;
        z=0;
    }
    Vector(char *n, int a, int b, int c)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=a;
        y=b;
        z=c;
    }
    Vector();
    Vector (const Vector& a);

    int setX(int a){x=a;}
    int setY(int b){y=b;}
    int setZ(int c){z=c;}

    void setName(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
    }

    int getX(){return x;}
    int getY(){return y;}
    int getZ(){return z;}

    char *getName(){return name;}

    ~Vector()
    {
        delete []name;
    }

    void print();
    Vector operator^(Vector);
    Vector operator=(Vector);
    int operator==(Vector);
    Vector operator*(int);
    friend Vector operator*(int,Vector);
    Vector operator*(Vector);
};

Vector::Vector()
{
    setName("/0");
}

Vector::Vector(const Vector& a)
{
    int l = strlen(a.name);
    name = new char[l+1];
    strcpy(name,a.name);
    x = a.x;
    y = a.y;
    z = a.z;
}

void Vector::print()
{
    cout << getName() << ": " << getX() << "x" ;
    if(getY()>=0)
        cout << "+";
    cout << getY() << "y";
    if(getZ()>=0)
        cout << "+";
    cout << getZ() << "z" << endl;
}

Vector Vector::operator^(Vector a)
{
    Vector temp;
    temp.x = (y*a.z)-(z*a.y);
    temp.y = (z*a.x)-(x*a.z);
    temp.z = (x*a.y)-(y*a.x);
    return temp;
}

Vector Vector::operator=(Vector a)
{
    x = a.x;
    y = a.y;
    z = a.z;
    return *this;
}

int Vector::operator==(Vector a)
{
    return((x==a.x)&&(y==a.y)&&(z==a.z));
}

Vector Vector::operator*(int n)
{
    Vector temp;
    temp.x = x*n;
    temp.y = y*n;
    temp.z = z*n;
    return temp;
}

Vector operator*(int n,Vector a)
{
    Vector temp;
    temp.x = a.x*n;
    temp.y = a.y*n;
    temp.z = a.z*n;
    return temp;
}

Vector Vector::operator*(Vector a)
{
    Vector temp;
    temp.x = x * a.x;
    temp.y = y * a.y;
    temp.z = z * a.z;
    return temp;
}

int main()
{
    Vector v1("v1", 1,2,3), v2("v2", 4, 5, -6), v3("Result1"),v4("Result2",-27,18,-3);

    v1.print();     ///Print the components of vector v1
    v2.print();     ///Print the components of vector v2

    v3=v1^v2;       ///Calculate the cross product of vector v1 and vector v2 (Consider ^ as cross product for this assignment)
    v3.print();     ///Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    v1= v1*2;       ///Multiply each component of vector v1 with the given value
    v1.print();     ///Print the modified components of vector v1

    v2=2*v2;        ///Multiply each component of vector v2 with the given value
    v2.print();     ///Print the modified components of vector v2

    v3=v1*v2;       ///Multiply each component of vector v1 with the corresponding component of vector v2.
    v3.print();     ///Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    return 0;
}
