package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
  
  private TestDemo testDemo;

//This method will be executed before each test
  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo();
  }

//Parameterized test with four parameters
  @ParameterizedTest
  @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
    if (!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    } else {
      assertThatThrownBy(() ->
      testDemo.addPositive(a, b))
          .isInstanceOf(IllegalArgumentException.class);
    }
  }
  
//Static method to provide parameters for the parameterized test
  private static Stream<Arguments> argumentsForAddPositive() {
    return Stream.of(
        Arguments.arguments(2, 3, 5, false),
        Arguments.arguments(1, 1, 2, false),
        Arguments.arguments(0, 1, 0, true),
        Arguments.arguments(1, -1, 0, true),
        Arguments.arguments(-1, -1, 0, true),
        Arguments.arguments(0, 0, 0, true),
        Arguments.arguments(5, 5, 10, false),
        Arguments.arguments(100, 200, 300, false)
        );
  }
//Test for the addPositive method
  @Test
  void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
    assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
    assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
    assertThat(testDemo.addPositive(7, 3)).isEqualTo(10);
    assertThat(testDemo.addPositive(20, 30)).isEqualTo(50);
    assertThat(testDemo.addPositive(15, 25)).isEqualTo(40);
    }
  
//Test for the checkEvenOrOdd method
  @Test
  void testCheckEvenOrOdd() {
      assertEquals("Even", testDemo.checkEvenOrOdd(4), "4 should be Even");
      assertEquals("Odd", testDemo.checkEvenOrOdd(7), "7 should be Odd");
      assertEquals("Even", testDemo.checkEvenOrOdd(0), "0 should be Even");
      assertEquals("Odd", testDemo.checkEvenOrOdd(-5), "-5 should be Odd");
   }
  
//Test for randomNumberSquared method
   @Test
   void assertThatNumberSquaredIsCorrect() {
     TestDemo mockDemo = spy(testDemo);
     doReturn(5).when(mockDemo).getRandomInt();
     int fiveSquared = mockDemo.randomNumberSquared();
     assertThat(fiveSquared).isEqualTo(25);
   }
  }