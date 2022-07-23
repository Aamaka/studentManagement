package com.semicolon.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//@SpringBootTest
class StudentManagementApplicationTests {

    Calculate calculate = new Calculate();
    @Test
    void itShouldAddANumber() {
        int num = 40;
        int num4 = 6;
        int result = calculate.add(num, num4);
        int expected = 46;
        assertThat(result).isEqualTo(expected);
    }



}
class Calculate{
    int add(int a, int b){
        return a + b;
    }
}
