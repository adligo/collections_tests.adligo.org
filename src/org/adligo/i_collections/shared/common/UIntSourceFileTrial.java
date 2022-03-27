package org.adligo.i_collections.shared.common;

import java.math.BigInteger;

import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

/**
 * A Test of BigUInts <br/>
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
public class UIntSourceFileTrial extends JjSourceFileTrial {

  @Test
  public void testConstructorAndGetAsInt() {
    UInt u = new UInt(0);
    equals(0, u.toInt());
    equals(BigInteger.ZERO, u.toBigInt());
    equals("0", u.toString());
    equals(0, u.hashCode());
    equals(u, u);
    
    UInt u1 = new UInt(1);
    equals(1, u1.toInt());
    equals(BigInteger.ONE, u1.toBigInt());
    equals("1", u1.toString());
    equals(1, u1.hashCode());
    equals(u1, u1);
    notEquals(u, u1);
    isFalse(u1.isBig());
  }
  
  @Test
  public void testConstructorException() {
    thrown(new IllegalArgumentException(UInt.A_UNSIGNED_INTEGER_U_INT_MUST_BE_GREATER_THAN_ZERO),
        () -> new UInt(-1));
  }


  @Test
  public void testEquals() {
    UInt u = new UInt(0);
    notEquals(u, null);
    notEquals(u, 1);
    notEquals(u, new UInt(Integer.MAX_VALUE));
    
    UInt u0 = new UInt(0);
    equals(u, u0);
    equals(u, 0L);
    float zf = new Float(0.0).floatValue();
    equals(u, zf);
    double d = 0.0;
    equals(u, d);
    equals(u, new BigUInt(0));
    notEquals(u, new BigUInt(1));
    notEquals(u, new BigUInt(BigInteger.valueOf(Integer.MAX_VALUE)
        .add(BigInteger.ONE)));
  }
}
