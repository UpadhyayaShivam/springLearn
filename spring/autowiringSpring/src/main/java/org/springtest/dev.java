package org.springtest;

public class dev {


    public dev() {
        System.out.println("dev contructor");
    }

    public computer getComp() {
        return comp;
    }

    public void setComp(computer comp) {
        this.comp = comp;
    }

    private computer comp;


    public  void build(){
        System.out.println("building a project for testing ...");
        comp.complie();
    }
}
