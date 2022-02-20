package org.adligo.collections.shared;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.*;
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
public class BitsSourceFileTrial extends JjSourceFileTrial  {

  public static void main(String [] args) {
    Map<Integer,List<Byte>> bytesByCount = new HashMap<>();
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {    
      int count = countBits(i);
      List<Byte> bl = bytesByCount.get(count);
      if (bl == null) {
        bl = new ArrayList<>();
        bytesByCount.put(count, bl);
      } 
      bl.add(i);
    }
    for (int i : bytesByCount.keySet()) {
      List<Byte> bs = bytesByCount.get(i);
      for (Byte b: bs) {
        println("        case (byte) 0x" + toHex(b) + ": //no break");
      }
      println("          return " + i + ";");
    }
    countBits((byte) 0xBF);
  }
  
  public static int countBits(byte b) {
    int count = 0;
    for (int i = 0; i < 8; i++) {
      int set = b & (1 << i);
      boolean sb = set >= 1;
      if (sb) {
        count++;
      }
//      println("byte " + b + " " + sb + " i " + i  + 
//          " " + toHex(b));
    }
    return count;
  }
  
  public static String toHex(byte b) {
    String s = Integer.toHexString(b);
    if (s.length() >= 2) {
      return s.substring(s.length() - 2, s.length());
    }
    return "0" + s;
  }
  
  @Test
  public void testGetBitCount() {
    for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {    
      int count = countBits(i);
      equals(count, Bits.countBits(i));
    }
  }
  
}
