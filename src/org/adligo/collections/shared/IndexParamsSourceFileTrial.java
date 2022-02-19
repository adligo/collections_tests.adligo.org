package org.adligo.collections.shared;

//import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.println;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

public class IndexParamsSourceFileTrial extends JjSourceFileTrial {

  public static void main(String [] args) {
    BigInteger maxInt = new BigInteger("" + Integer.MAX_VALUE);
    for (long i = 1; i < Integer.MAX_VALUE; i++) {
      BigInteger base = new BigDecimal(2).pow((int) i).toBigInteger();
      //println("p.setBase(" + base + ");");
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
    thrown(
        new IllegalArgumentException(IndexParams.THE_BASE + 3 + IndexParams.IS_NOT_SUPPORETED),
        () -> p.setBase(3));
  }
}
