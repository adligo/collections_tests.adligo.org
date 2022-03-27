package org.adligo.collections.shared.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.adligo.i_collections.shared.streams.I_SizedSupplier;
import org.adligo.i_collections.shared.streams.I_Streamable;
import org.adligo.tests4j4jj.JjApiTrial;
import org.junit.jupiter.api.Test;


/**
 * Tests of the I_Streamable interface and usage.
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
public class StreamableApiTrial extends JjApiTrial {


  public I_Streamable<String> getStreamableABCD() {
    I_Streamable<String> s = new I_Streamable<String>() {
      String [] items = new String[] {"a", "b", "c", "d"};
      @Override
      public Stream<String> stream() {
        return Arrays.stream(items);
      }
      @Override
      public I_SizedSupplier<String> supply() {
        // TODO Auto-generated method stub
        return new I_SizedSupplier<String>() {
          
          @Override
          public int capacity() {
            return items.length;
          }
          
          @Override
          public String get(int idx) {
            return items[idx];
          }

          @Override
          public int size() {
            return items.length;
          }

          @Override
          public boolean isBig() {
            // TODO Auto-generated method stub
            return false;
          }
          
        };
      }
    };
    return s;
  }
  

  public I_Streamable<String> getStreamableANullCNull() {
    I_Streamable<String> s = new I_Streamable<String>() {
      String [] items = new String[] {"a", null, "c", null};
      @Override
      public Stream<String> stream() {
        return Arrays.stream(items);
      }
      @Override
      public I_SizedSupplier<String> supply() {
        // TODO Auto-generated method stub
        return new I_SizedSupplier<String>() {
          
          @Override
          public int capacity() {
            return items.length;
          }
          
          @Override
          public String get(int idx) {
            return items[idx];
          }

          @Override
          public int size() {
            return 2;
          }

          @Override
          public boolean isBig() {
            // TODO Auto-generated method stub
            return false;
          }
          
        };
      }
    };
    return s;
  }
  
  @Test
  public void testStreamConsumer() {
    
    Stream<String> st2 = Stream.generate(new Supplier<String>() {
      
      int i = 0;
      int j = 0;
      I_SizedSupplier<String> delegate;
      
      @Override
      public String get() {
        if (delegate == null) {
          delegate = getStreamableABCD().supply();
        } else if (i >= delegate.size()){
          if (j % 2 == 0) {
            delegate = getStreamableABCD().supply();
          } else {
            delegate = getStreamableANullCNull().supply();
          }
          j++;
          i = 0;
        } 
        String s = null;
        for (; i < delegate.capacity();) {
          s = delegate.get(i++);
          if (s != null) {
            return s;
          }
        }
        return null;
      }
      
    }).limit(12);
    
    Object[] asArray =  st2.toArray();
    equals("a", asArray[0]);
    equals("b", asArray[1]);
    equals("c", asArray[2]);
    equals("d", asArray[3]);
    equals("a", asArray[4]);
    equals("b", asArray[5]);
    equals("c", asArray[6]);
    equals("d", asArray[7]);
    equals("a", asArray[8]);
    equals("c", asArray[9]);
    equals("a", asArray[10]);
    equals("b", asArray[11]);
    
  }
}
