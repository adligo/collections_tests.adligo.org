package org.adligo.collections.shared;

import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.println;

import java.math.BigInteger;

import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

/**
 * Tests of the CompressedIndexNodeMutant
 * 
 * @author scott
 *
 * <pre><code>
 * ---------------- Apache ICENSE-2.0 --------------------------
 *
 * Copyright 2022 Adligo Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </code><pre>
 */
public class IntMaskSourceFileTrial extends JjSourceFileTrial {

  public static void main(String [] args) {
    for (int i = 0; i < 33; i++) {    
      StringBuilder ones = new StringBuilder();
      for (int j = 0; j < i; j++) {
        ones.append("1");
      }
      println("  case " + i + ": return new BigInteger(\"" + ones.toString() + "\");");
    }
  }
  
  @Test
  public void testGetMask() {
    equals(new BigInteger("1",2), IntMask.getMask(1));
    equals(new BigInteger("11",2), IntMask.getMask(2));
    equals(new BigInteger("111",2), IntMask.getMask(3));
    equals(new BigInteger("1111",2), IntMask.getMask(4));
    equals(new BigInteger("11111",2), IntMask.getMask(5));
    equals(new BigInteger("111111",2), IntMask.getMask(6));
    equals(new BigInteger("1111111",2), IntMask.getMask(7));
    equals(new BigInteger("11111111",2), IntMask.getMask(8));
    equals(new BigInteger("111111111",2), IntMask.getMask(9));
    equals(new BigInteger("1111111111",2), IntMask.getMask(10));
    
    equals(new BigInteger("11111111111",2), IntMask.getMask(11));
    equals(new BigInteger("111111111111",2), IntMask.getMask(12));
    equals(new BigInteger("1111111111111",2), IntMask.getMask(13));
    equals(new BigInteger("11111111111111",2), IntMask.getMask(14));
    equals(new BigInteger("111111111111111",2), IntMask.getMask(15));
    equals(new BigInteger("1111111111111111",2), IntMask.getMask(16));
    equals(new BigInteger("11111111111111111",2), IntMask.getMask(17));
    equals(new BigInteger("111111111111111111",2), IntMask.getMask(18));
    equals(new BigInteger("1111111111111111111",2), IntMask.getMask(19));
    equals(new BigInteger("11111111111111111111",2), IntMask.getMask(20));
    
    equals(new BigInteger("111111111111111111111",2), IntMask.getMask(21));
    equals(new BigInteger("1111111111111111111111",2), IntMask.getMask(22));
    equals(new BigInteger("11111111111111111111111",2), IntMask.getMask(23));
    equals(new BigInteger("111111111111111111111111",2), IntMask.getMask(24));
    equals(new BigInteger("1111111111111111111111111",2), IntMask.getMask(25));
    equals(new BigInteger("11111111111111111111111111",2), IntMask.getMask(26));
    equals(new BigInteger("111111111111111111111111111",2), IntMask.getMask(27));
    equals(new BigInteger("1111111111111111111111111111",2), IntMask.getMask(28));
    equals(new BigInteger("11111111111111111111111111111",2), IntMask.getMask(29));
    equals(new BigInteger("111111111111111111111111111111",2), IntMask.getMask(30));
    
    equals(new BigInteger("1111111111111111111111111111111",2), IntMask.getMask(31));
    equals(new BigInteger("11111111111111111111111111111111",2), IntMask.getMask(32));
  }
}
