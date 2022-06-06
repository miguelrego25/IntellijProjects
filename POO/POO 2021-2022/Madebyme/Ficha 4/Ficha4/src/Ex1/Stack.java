package Ex1;

import Ex1.*;

import java.util.ArrayList;
import java.util.Objects;

public class Stack {

    ArrayList<String> stack;

    //CONSTRUTORES//
    public Stack(){
        ArrayList<String> stack= new ArrayList<>();
    }
    public Stack(ArrayList<String> stack){
        this.stack = stack;
    }
    public Stack(Stack stack){
        setStack((ArrayList<String>) stack.getStack());
    }


    // GETTER & SETTER 'S //
    public ArrayList<String> getStack() {
        return stack;
    }
    public void setStack(ArrayList<String> stack) {
        this.stack = stack;
    }

    //METODOS//
    public String top(){
        if(this.stack.isEmpty()){
            return null;
        }
        else{
            return this.stack.get(stack.size()-1);
        }
    }

    public void push(String s){
        stack.add(s);
    }
    public boolean empty(){
        if(stack.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    int length(){
        int counter = 0;
        for(String s : stack){
            counter += 1;
        }
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stack)) return false;
        Stack stack1 = (Stack) o;
        return Objects.equals(getStack(), stack1.getStack());
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                '}';
    }
}