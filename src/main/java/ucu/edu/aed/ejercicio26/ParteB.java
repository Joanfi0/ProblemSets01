package ucu.edu.aed.ejercicio26;


import java.util.Stack;

public class ParteB {
    public boolean controlCorchetes(String texto){
        if(!texto.contains("{") || !texto.contains("}")) return false;

        Stack<String> corchetes = new Stack<>();
        for(char letra: texto.toCharArray()){
            if(letra == '{') corchetes.push("{");
            if(letra == '}'){
                if(!corchetes.contains("{")) {
                    return false;
                }
                corchetes.pop();
            }
        }

        if(corchetes.capacity() > 0){
            return false;
        }

        return true;
    }
}
