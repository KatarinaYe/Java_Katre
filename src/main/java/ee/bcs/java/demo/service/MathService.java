package ee.bcs.java.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public int multiply(int x, int y){
        return x*y;
    }
}