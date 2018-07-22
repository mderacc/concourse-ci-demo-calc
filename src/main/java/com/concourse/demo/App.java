package com.concourse.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class App 
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            System.out.print("# ");
            String op = keyboard.next();
            List<String> tokens = splitOperation(op);
            if(!tokens.isEmpty()) {
                int pos = 1;
                String currentOp = "";
                int res = 0;
                for(String token : tokens) {
                    if(pos == 1) {
                        res = Integer.parseInt(token);
                    } else if(pos % 2 == 0) {
                        currentOp = token;
                    } else {
                        switch(currentOp) {
                            case "+":
                                res += Integer.parseInt(token);
                                break;
                            case "-":
                                res -= Integer.parseInt(token);
                                break;
                            case "*":
                                res *= Integer.parseInt(token);
                                break;
                            case "/":
                                res /= Integer.parseInt(token);
                                break;
                        }
                    }
                    pos++;
                }
                System.out.println(res);
            } else {
                System.out.println("Bad token");
            }
        }
    }

    static List<String> splitOperation(String operation) {
        String regex = "^(\\d+)([\\+\\-\\*\\/]{1})+(\\d+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(operation);
        if(m.matches()){
            List<String> tokens = new ArrayList<>();
            for(int i=1 ; i <= m.groupCount() ; i++) {
                tokens.add(m.group(i)); 
            }
            return tokens;
            
        } 
        return new ArrayList<>();
    }
}
