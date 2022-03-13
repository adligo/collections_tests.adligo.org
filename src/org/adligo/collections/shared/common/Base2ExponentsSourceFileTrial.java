package org.adligo.collections.shared.common;


import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;
import static org.adligo.collections.shared.common.Base2Exponents.*;
import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.*;
/**
 * This tests the Base2Exponents class. <br/>
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
public class Base2ExponentsSourceFileTrial extends JjSourceFileTrial {

  public static final void main(String [] args) {
    int i = 1;
    while (true) {
      long il = i;
      long l = (long) Math.pow(2L, il);
      println("      case " + l + ": return " + i + ";");
      if (l >= Integer.MAX_VALUE) {
        break;
      }
      i++;
    }
  }
  
  @Test
  public void testToBase2to8() {
    equals(2, toBase2to8(1, false));
    equals(4, toBase2to8(2, false));
    equals(8, toBase2to8(3, false));
    equals(-1, toBase2to8(4, false));
    thrown(of(new IllegalArgumentException(THE_EXPONENT_MUST_BE_1_2_OR_3)),
        () -> { toBase2to8(7, true); });
  }
  
  @Test
  public void testToBase16to64() {
    equals(16, toBase16to64(4, false));
    equals(32, toBase16to64(5, false));
    equals(64, toBase16to64(6, false));
    equals(-1, toBase16to64(7, false));
    thrown(of(new IllegalArgumentException(THE_FOLLOWING_EXPONENT_IS_INVALID + 7)),
        () -> { toBase16to64(7, true); });
  }

  @Test
  public void testToBase() {
    equals(2, toBase(1, false));
    equals(4, toBase(2, false));
    equals(8, toBase(3, false));
    equals(16, toBase(4, false));
    equals(32, toBase(5, false));
    equals(64, toBase(6, false));
    equals(128, toBase(7, false));
    equals(256, toBase(8, false));
    equals(512, toBase(9, false));
    equals(1024, toBase(10, false));
    equals(2048, toBase(11, false));
    equals(4096, toBase(12, false));
    equals(8192, toBase(13, false));
    equals(16384, toBase(14, false));
    equals(32768, toBase(15, false));
    equals(-1, toBase(16, false));
    thrown(of(new IllegalArgumentException(THE_FOLLOWING_EXPONENT_IS_INVALID + -1)),
        () -> { toBase(-1, true); });
  }

  @Test
  public void testToExponent2to8() {
    equals(1, toExponent2to8(2, false));
    equals(2, toExponent2to8(4, false));
    equals(3, toExponent2to8(8, false));
    equals(-1, toExponent2to8(5, false));
    thrown(of(new IllegalArgumentException(THE_BASE_MUST_BE_2_4_OR_8)),
        () -> { toExponent2to8(5, true); });
  }

  @Test
  public void testToExponent16to64() {
    equals(4, toExponent16to64(16, false));
    equals(5, toExponent16to64(32, false));
    equals(6, toExponent16to64(64, false));
    equals(-1, toExponent16to64(5, false));
    thrown(of(new IllegalArgumentException(THE_FOLLOWING_BASE_IS_INVALID + 3)),
        () -> { toExponent16to64(3, true); });
  }

  @Test
  public void testToExponent() {
    equals(1, toExponent(2, false));
    equals(2, toExponent(4, false));
    equals(3, toExponent(8, false));
    equals(4, toExponent(16, false));
    equals(5, toExponent(32, false));
    equals(6, toExponent(64, false));
    equals(7, toExponent(128, false));
    equals(8, toExponent(256, false));
    equals(9, toExponent(512, false));
    equals(10, toExponent(1024, false));
    equals(11, toExponent(2048, false));
    equals(12, toExponent(4096, false));
    equals(13, toExponent(8192, false));
    equals(14, toExponent(16384, false));
    equals(15, toExponent(32768, false));
    equals(-1, toExponent(16123, false));
    thrown(of(new IllegalArgumentException(THE_FOLLOWING_BASE_IS_INVALID + -1)),
        () -> { toExponent(-1, true); });
  }
}
