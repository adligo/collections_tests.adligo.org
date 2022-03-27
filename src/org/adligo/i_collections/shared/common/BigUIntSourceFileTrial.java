package org.adligo.i_collections.shared.common;

import java.math.BigInteger;

import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

/**
 * A Test of BigBigUInts <br/>
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
public class BigUIntSourceFileTrial extends JjSourceFileTrial {


  @Test
  public void testConstructorIntAndGetAsInt() {
    BigUInt u = new BigUInt(0);
    equals(0, u.toInt());
    isFalse(u.isBig());
    equals(BigInteger.ZERO, u.toBigInt());
    equals("0", u.toString());
    equals(BigInteger.ZERO.hashCode(), u.hashCode());
    equals(u, u);
    
    BigUInt u1 = new BigUInt(1);
    equals(1, u1.toInt());
    isFalse(u1.isBig());
    equals(BigInteger.ONE, u1.toBigInt());
    equals("1", u1.toString());
    equals(BigInteger.ONE.hashCode(), u1.hashCode());
    equals(u1, u1);
    notEquals(u, u1);
    isFalse(u1.isBig());
  }

  @Test
  public void testConstructorBigIntAndGetAsInt() {
    BigInteger mipo = BigInteger.valueOf(Integer.MAX_VALUE)
        .add(BigInteger.ONE);
    BigUInt u = new BigUInt(mipo);
    equals(mipo, u.toBigInt());
    isTrue(u.isBig());
    equals("2147483648", u.toString());
    equals(mipo.hashCode(), u.hashCode());
    equals(u, u);
    
    BigInteger mipt = BigInteger.valueOf(Integer.MAX_VALUE)
        .add(BigInteger.ONE).add(BigInteger.ONE);
    BigUInt u1 = new BigUInt(mipt);
    isTrue(u1.isBig());
    equals(mipt, u1.toBigInt());
    equals("2147483649", u1.toString());
    equals(mipt.hashCode(), u1.hashCode());
    equals(u1, u1);
    notEquals(u, u1);
    isTrue(u1.isBig());
  }
  
  @Test
  public void testConstructorExceptions() {
    thrown(new IllegalArgumentException(BigUInt.A_UNSIGNED_INTEGER_U_INT_MUST_BE_GREATER_THAN_ZERO),
        () -> new BigUInt(-1));
    thrown(new NullPointerException(BigUInt.A_NON_NULL_BIG_INTEGER_I_IS_REQUIRED),
        () -> new BigUInt(null));
    thrown(new IllegalArgumentException(UInt.A_UNSIGNED_INTEGER_U_INT_MUST_BE_GREATER_THAN_ZERO),
        () -> new BigUInt(BigInteger.ZERO.subtract(BigInteger.ONE)));
  }
  
  @Test
  public void testEquals() {
    BigUInt u = new BigUInt(0);
    notEquals(u, null);
    notEquals(u, 1);
    notEquals(u, new BigUInt(Integer.MAX_VALUE));
    
    BigUInt u0 = new BigUInt(0);
    equals(u, u0);
    equals(u, u0);
    isTrue(BigInteger.ZERO.equals(BigInteger.valueOf(0)));
    equals(u, 0L);
    float zf = new Float(0.0).floatValue();
    equals(u, zf);
    double d = 0.0;
    equals(u, d);
    equals(u, new BigUInt(0));
    notEquals(u, new BigUInt(1));
    BigInteger mipo = BigInteger.valueOf(Integer.MAX_VALUE)
        .add(BigInteger.ONE);
    notEquals(u, new BigUInt(mipo));
    equals(u, new UInt(0));
    notEquals(u, new UInt(1));
    
    BigUInt u3 = new BigUInt(mipo);
    equals(u3, new BigUInt(mipo));
    notEquals(u3, new BigUInt(mipo.add(BigInteger.ONE)));
  }

}
