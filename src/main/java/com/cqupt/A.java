package com.cqupt;

public class A extends B{
    public static void main(String[] args){
        new A();
        if (1==2)
            System.out.println(".....");
    }
}
class B{
    B(){
        System.out.print("B");
    }
}

