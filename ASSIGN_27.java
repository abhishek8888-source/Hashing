package assign.pkg27;

/* 
ABHISHEK SHARMA
ROLL NO 27
PROBLEM STATEMENT : Create a hash table in memory with suitable data , Hash function and Collision resolution technique
                    create a function search 
                    The function would return the location of key in Hash table along with no of comparisons .


*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ASSIGN_27 {
    public static Scanner in = new Scanner(System.in);
    public static int m=0;
    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        ArrayList<Integer> key=new ArrayList<Integer>();
        int ht[]={0};
        int choice;
        do{
         
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("        ENTER YOUR CHOICE :"
                + "    1.Create 2.Delete 3.Insert 4.Show 5.Search 6.Exit              ");
        
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        choice=in.nextInt();
        switch(choice)
        {
            case 1:ht=create(key);
                   break;
            case 2:delete(key,ht);
                   break;
            case 3:System.out.println("Enter token to insert: ");
                   int y=in.nextInt();
                   insert(ht,y);       
                   break;
            case 4:show(ht);
                   break;
            case 5:System.out.println("Enter token to search: ");
                   int x=in.nextInt(); 
                   search(ht,x);
                   break;
        }
        }while(choice!=6);
        
    }
    public static int [] create(ArrayList<Integer> key) throws FileNotFoundException, IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\ABHISHEK.txt"));
        String str="";
        
        while((str=br.readLine())!=null)
        {
            String s[]=str.split(",");
            for(int i=0;i<s.length;i++)
            {
                
                key.add(Integer.parseInt(s[i]));

            }
        }
        
        System.out.println("DATA VALUES ");
        System.out.println(key);
        System.out.println("");
     
        int i=0;
        // TAKING TO THE NEAREST PRIME NUMBER 
        while(m<=key.size())
        {
            m=(6*i)-1;
            i++;
        }
        System.out.println("SIZE OF TABLE IS ");
        System.out.println(m);
        System.out.println("");
        ArrayList<Integer> index=new ArrayList<Integer>();
        ArrayList<Integer> set=new ArrayList<Integer>();
        int a[]=new int[100];
        for(int j=0;j<key.size();j++)
        {
            int e=(key.get(j).intValue())/m;
            String w=String.valueOf(e);
            index.add(Integer.parseInt(String.valueOf(w.charAt(0))));
        }
        System.out.println("INDEX VALUES::");
        System.out.println(index);
        System.out.println("");
        
        for(int j=0;j<key.size();j++)
        {
            int k=index.get(j).intValue();
            int flag=1;
            while(a[k]!=0)
            {
                k++;
                if(k==m)
                {
                    k=0;
                }
                flag++;
            }
            a[k]=key.get(j);
            set.add(flag);
        }
        int q=0;
        for(int j=0;j<set.size();j++)
        {
            q=q+set.get(j).intValue();
        }
        
        System.out.println("SHOWING NO OF COMPARISONS FOR EACH ");
        System.out.println(set);
        System.out.println("Average search time= "+(float)q/set.size());
        System.out.println("");
        return a;
    }
    
    public static void delete(ArrayList<Integer> key,int ht[])
    {
        System.out.print("Enter token to Delete: ");
        int d=in.nextInt();       
        int e=d/m;
        
            String w=String.valueOf(e);
            int p=Integer.parseInt(String.valueOf(w.charAt(0)));
                int t=0;
                if(ht[p]==d)
                {
                    //System.out.println("ABHI");
                    ht[p]=0;
                    
                }
                else
                {
                    for(int j=p;j<m;j++)
                    {
                        //System.out.println("ABHI");
                        if(ht[j]==0)
                        {
                            
                        }
                        else if(ht[j]==d)
                        {
                            ht[j]=0;
                            break;
                        }
                        if(j==m-1)
                        {
                            j=-1;
                            t++;
                            if(t==2)
                            {
                                break;
                            }
                        }
                    }
                }
                if(t==2)
                {
                    System.out.println("!!!!!Token not found!!!!!");
                }
                else
                {
                    System.out.println("!!!!!Token Deleted!!!!!");
                }
                               
    }

    public static void insert(int ht[],int y)
    {
        

        int count=0;
        for(int j=0;j<m;j++)
        {
            if(ht[j]!=0)
            {
                count++;
            }
        }
        if(count!=m)
        {
            
            int e=y/m;
            String w=String.valueOf(e);
            int p=Integer.parseInt(String.valueOf(w.charAt(0)));
            while(ht[p]!=0)
            {
                p++;
                if(p==m)
                {
                    p=0;
                }
                
            }
            ht[p]=y;
        }
        else
        {
            m=m*2;
            System.out.println(m);
            ArrayList<Integer> l=new ArrayList<>();
            
            for(int j=0;j<m/2;j++)
            {
                l.add(ht[j]);
                
            }
            
            for(int j=0;j<m/2;j++)
            {
                ht[j]=0;
            }
            for(int j=0;j<m/2;j++)
            {
                

                int e=l.get(j).intValue()/m;
        
                String w=String.valueOf(e);
                int p=Integer.parseInt(String.valueOf(w.charAt(0)));
                //System.out.println("p= "+p);
                while(ht[p]!=0)
                {
                    p++;
                    if(p==m)
                    {
                        p=0;
                    }

                }
                ht[p]=l.get(j);
            
            }
            int e=y/m;
            String w=String.valueOf(e);
            int p=Integer.parseInt(String.valueOf(w.charAt(0)));
            while(ht[p]!=0)
            {
                p++;
                if(p==m)
                {
                    p=0;
                }
                
            }
            ht[p]=y;
        }
        
    }
    public static void show(int ht[])
    {
        for(int j=0;j<m;j++)
        {
            System.out.println(j+"--"+ht[j]);
        }
    }
    public static void search(int ht[],int d)
    {  
        int e=d/m;
        int s_t=1;
            String w=String.valueOf(e);
            int p=Integer.parseInt(String.valueOf(w.charAt(0)));
                //System.out.println("p="+p);
                int t=0;
                if(ht[p]==d)
                {
                    System.out.println("Token is present at index "+p);
                    System.out.println("Search Time: "+s_t);
                    
                }
                else
                {
                    for(int j=p;j<m;j++)
                    {
                        
                        //System.out.println("HI");
                        if(ht[j]==0)
                        {
                            
                        }
                        else if(ht[j]==d)
                        {
                            System.out.println("Token is present at index "+j);
                            System.out.println("Search Time: "+s_t);
                            break;
                        }
                        if(j==m-1)
                        {
                            j=-1;
                            t++;
                            if(t==2)
                            {
                                break;
                            }
                        }
                        s_t++;
                    }
                    if(t==2)
                    {
                        System.out.println("!!!!!Token not found!!!!!");
                    }
                }
    }

}




