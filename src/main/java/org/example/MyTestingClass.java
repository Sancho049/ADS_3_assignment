package org.example;

import java.util.Random;

public class MyTestingClass {
    private int attribute1;
    private int attribute2;


    public MyTestingClass(int attribute1,int attribute2) {
        this.attribute1 = attribute1;
        this.attribute2= attribute2;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + attribute1;
        result = prime * result + attribute2;

        return result;
    }

    // For testing, let's also override equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return attribute1 == other.attribute1 && attribute2 == other.attribute2;
    }
}
