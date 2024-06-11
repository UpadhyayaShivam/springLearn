package org.springtest;

public class dev {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public dev(int age) {
        this.age = age;
        System.out.println("single parametric constructor");
    }

    private int age;

    public dev(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("double parametric constructor");
    }
    public dev(String name) {
        this.name = name;

        System.out.println("single parametric constructor for name");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public org.springtest.laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(org.springtest.laptop laptop) {
        this.laptop = laptop;
        System.out.println("setter laptop");
    }

    public dev(org.springtest.laptop laptop) {
        this.laptop = laptop;
        System.out.println("dev consrucotr with other class");
    }

    private laptop laptop;
    public dev(){
        System.out.println(" dev consntructor");
    }
    public void compile(){
        System.out.println("we are compiling here the project .....");
    }
}
