#include <iostream>
#include <cmath>

using namespace std;

class Point
{
// x and y coordinate
    int x, y;
    public:
//Add necessary constructor(s) to initialize x and y
    Point(void)
    {

    }

    Point( int a, int b)
    {
        x=a;
        y=b;
    }
//Add your set and get functions for x and y
    void set( int c, int d)
    {
        x=c;
        y=d;
    }

    void update( int c, int d)
    {
        x+=c;
        y+=d;
    }

    int get_x(void)
    {
        return x;
    }

    int get_y(void)
    {
        return y;
    }

    void print()
    {
        cout << "Coordinate: "<< x <<", " <<y <<endl;
    }
};

class Circle
{
    Point p;
    int radius;

    public:
// Add necessary constructor(s) to initialize p and radius

    Circle( int c_x, int c_y, int r)
    {
        p.set(c_x,c_y);
        radius = r;
    }
// Overload “upload” functions

    void update( int r)
    {
        radius+=r;
    }

    void update( int c_x, int c_y)
    {
        p.update(c_x,c_y);
    }

    void update( int c_x, int c_y, int r)
    {
        radius+=r;
        p.update(c_x,c_y);
    }

    void print()
    {
        cout << "Center ";
        p.print();
        cout << "Radius: " << radius << endl;
    }
};

class Line
{
    Point p1,p2;
    public:
//Line constructor
    Line( int a1, int b1, int a2, int b2)
    {
        p1.set(a1, b1);
        p2.set(a2, b2);
    }

    void print_length(void)
    {
        double length, t;
        int x1 = p1.get_x();
        int x2 = p2.get_x();
        int y1 = p1.get_y();
        int y2 = p2.get_y();

        t = ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1));
        length = sqrt(t);
        cout<<"Line length: "<<length<<endl;
    }
};

int main()
{
    Point p(5,5);
    Circle c(2, 3, 5);
    Line l(0,0,8,6);
    cout << endl << "Point Display" <<endl;
    p.print();
    cout << endl << "Circle Display" <<endl;
    c.print();
    cout << endl;
//First update
    cout << "First Update" << endl;
// call “update” function of Circle class to increase the center’s x coordinate by 5 and y coordinate by 5;
    c.update(5,5);
    c.print();
    cout <<endl;
//Second update
    cout << "Second Update" << endl;
// call “update” function of Circle class to increase the radius by 6;
    c.update(6);
    c.print();
    cout << endl;
//Third update
    cout << "Third Update" << endl;
// call “update” function of Circle class to increase the center’s x coordinate by 2 and y coordinate by 2 and the radius by 2;
    c.update(2,2,2);
    c.print();
    cout << endl;
// Length of the line
    l.print_length();
    return 0;
}
