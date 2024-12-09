public class Salary {
    private double monthlySalary[] = new double[12];
    private String[] months = {"January","February","March","April","May","June",
    "July","August","September","October","November","December"};

    public  Salary(double sal,int[] overtime){
        double rate=0;
        for(int i=0;i<overtime.length;i++){
            if(sal>10000) rate=25;
            if(sal>5000 && sal<10000) rate=20;
            if(sal>2000 && sal<5000) rate=15;
            if(sal<2000) rate=10;

            monthlySalary[i]=sal+rate*overtime[i];
        }
    }

    public double average(){
        double sum=0;
        for(int i=0;i<monthlySalary.length;i++){
            sum+=monthlySalary[i];
        }

        return sum/monthlySalary.length;
    }

    public  void display(){
        System.out.println("Average: "+average());
        for (int i=0;i<monthlySalary.length;i++){
            System.out.println(months[i]+": "+monthlySalary[i]+"\t"+(monthlySalary[i]-average()));
        }
    }

    public static void main(String[] args) {
        int[] t = {3,5,1,6,5,7,2,4,6,1,0,2};
        Salary salary = new Salary(25000,t);

        salary.display();
    }
}
