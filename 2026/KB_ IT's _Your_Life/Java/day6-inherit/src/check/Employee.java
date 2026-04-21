package com.kb.chap07n.makeclass.d_instanceofcheck;



public  class Employee extends Person {
    public Employee(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("일하고 걷기");
    }
}
