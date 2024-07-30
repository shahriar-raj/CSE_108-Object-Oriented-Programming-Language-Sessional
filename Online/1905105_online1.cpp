#include <iostream>
#include <cstdlib>

using namespace std;

class Random
{
    int row,col,maximum,minimum;
    int **p;
public:
    Random( int, int, int, int);
    ~Random();
    void randomize();
    int get( int, int);
    void add(int);
    int add();
    void print();
};

Random::Random(int r,int c,int mn,int mx)
{
    row=r;
    col=c;
    maximum = mx;
    minimum = mn;
    p=(int**)malloc(r*sizeof(int*));
    for(int i=0;i<r;i++)
        p[i]=(int*)malloc(c*sizeof(int));
}

Random::~Random()
{
    for(int i=0;i<row;i++)
        free(p[i]);
    free(p);
}

void Random::randomize()
{
    for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
            p[i][j]= (rand()%(maximum-minimum+1))+minimum;
}

int Random::get(int r,int c)
{
    return p[r][c];
}

void Random::add(int n)
{
    for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
            p[i][j]+=n;
}

int Random::add()
{
    int sum=0;
    for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
            sum+=p[i][j];
    return sum;
}

void Random::print()
{
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++)
            cout<<p[i][j]<<" ";
        cout<<endl;
    }
}

int main()
{

    cout<<"Hello World"<<'\n';
    Random m(3,3,100,200);
    m.randomize();
    m.print();
    cout<<m.get(0,0)<<'\n';
    m.add(100);
    m.print();
    cout<<m.add()<<'\n';

    return 0;
}
