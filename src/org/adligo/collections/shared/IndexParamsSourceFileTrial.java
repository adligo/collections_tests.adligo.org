package org.adligo.collections.shared;

//import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.println;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

/**
 * Tests of the IndexParams
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
public class IndexParamsSourceFileTrial extends JjSourceFileTrial {

  public static void main(String [] args) {
    BigInteger maxInt = new BigInteger("" + Integer.MAX_VALUE);
    for (long i = 1; i < Integer.MAX_VALUE; i++) {
      BigInteger base = new BigDecimal(2).pow((int) i).toBigInteger();
      //println("p.setLeafBase(" + base + ");");
      if (base.bitLength() <= maxInt.bitLength()) {
      //rintln("public static final int BASE_" + base + " = " + base + ";");
      //println("case BASE_" + base + ": base2Exponent = " + i + "; break;");
        //println("p.setBas" + base + ": base2Exponent = " + i + "; break;");
      } else {
        break;
      }
    }
    
  }
  
  
  @Test
  public void testSetBase() {
    IndexParams p = new IndexParams();
    p.setBase(2);
    equals(1, p.getBase2Exponent());
    p.setBase(4);
    p.setBase(8);
    p.setBase(16);
    p.setBase(32);
    p.setBase(64);
    p.setBase(128);
    p.setBase(256);
    p.setBase(512);
    p.setBase(1024);
    p.setBase(2048);
    p.setBase(4096);
    p.setBase(8192);
    p.setBase(16384);
    p.setBase(32768);
    p.setBase(65536);
    p.setBase(131072);
    p.setBase(262144);
    p.setBase(524288);
    p.setBase(1048576);
    p.setBase(2097152);
    p.setBase(4194304);
    p.setBase(8388608);
    p.setBase(16777216);
    p.setBase(33554432);
    p.setBase(67108864);
    p.setBase(134217728);
    p.setBase(268435456);
    p.setBase(536870912);
    p.setBase(1073741824);
    equals(30, p.getBase2Exponent());
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE + 3 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setBase(3));
  }
  
  @Test
  public void testSetBase2Exponent() {
    IndexParams p = new IndexParams();
    p.setBase2Exponent(1);
    equals(1, p.getBase2Exponent());
    equals(2, p.getBase());
    
    p.setBase2Exponent(30);
    equals(30, p.getBase2Exponent());
    equals(1073741824, p.getBase());
    
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE_2_EXPONENT + 0 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setBase2Exponent(0));
    
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE_2_EXPONENT + 31 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setBase2Exponent(31));
  }
  

  @Test
  public void testSetLeafBase() {
    IndexParams p = new IndexParams();
    p.setLeafBase(2);
    equals(1, p.getLeafBase2Exponent());
    p.setLeafBase(4);
    p.setLeafBase(8);
    p.setLeafBase(16);
    p.setLeafBase(32);
    p.setLeafBase(64);
    p.setLeafBase(128);
    p.setLeafBase(256);
    p.setLeafBase(512);
    p.setLeafBase(1024);
    p.setLeafBase(2048);
    p.setLeafBase(4096);
    p.setLeafBase(8192);
    p.setLeafBase(16384);
    p.setLeafBase(32768);
    p.setLeafBase(65536);
    p.setLeafBase(131072);
    p.setLeafBase(262144);
    p.setLeafBase(524288);
    p.setLeafBase(1048576);
    p.setLeafBase(2097152);
    p.setLeafBase(4194304);
    p.setLeafBase(8388608);
    p.setLeafBase(16777216);
    p.setLeafBase(33554432);
    p.setLeafBase(67108864);
    p.setLeafBase(134217728);
    p.setLeafBase(268435456);
    p.setLeafBase(536870912);
    p.setLeafBase(1073741824);
    equals(30, p.getLeafBase2Exponent());
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE + 3 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setLeafBase(3));
  }
  
  @Test
  public void testSetLeafBase2Exponent() {
    IndexParams p = new IndexParams();
    p.setLeafBase2Exponent(3);
    equals(3, p.getBase2Exponent());
    equals(8, p.getLeafBase());
    
    
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE_2_EXPONENT + 0 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setLeafBase2Exponent(0));
    
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE_2_EXPONENT + 31 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setLeafBase2Exponent(31));
    
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE_2_EXPONENT + 2 + IndexParams.IS_NOT_SUPPORETED_YET),
        () -> p.setLeafBase2Exponent(2));
    
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE_2_EXPONENT + 4 + IndexParams.IS_NOT_SUPPORETED_YET),
        () -> p.setLeafBase2Exponent(4));
  }
}
