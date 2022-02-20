package org.adligo.collections.shared;

import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.println;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.NumberOfDocuments;

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
public class CompressedIndexNodeSourceFileTrial extends JjSourceFileTrial {

  
  @SuppressWarnings("unchecked")
  @Test
  public void testConstructorEmpty() {
    CompressedIndexNode<Character> n = new CompressedIndexNode<>(new Numbered[0], 8);
    equals(0, n.size());
    equals(8, n.capacity());
    
    isFalse(n.has(0));
    empty(n.find(0));
    empty(n.findItemIndex(0));  
    equals(n.get(0));  
    
    isFalse(n.has(1));
    empty(n.find(1));
    empty(n.findItemIndex(1));  
    equals(n.get(0));  
    
    isFalse(n.has(2));
    empty(n.find(2));
    empty(n.findItemIndex(2));  
    equals(n.get(0));  
    
    isFalse(n.has(3));
    empty(n.find(3));
    empty(n.findItemIndex(3));  
    equals(n.get(3));  
    
    isFalse(n.has(4));
    empty(n.find(4));
    empty(n.findItemIndex(4));  
    equals(n.get(4));  
    
    isFalse(n.has(5));
    empty(n.find(5));
    empty(n.findItemIndex(5));  
    equals(n.get(5));  
    
    isFalse(n.has(6));
    empty(n.find(6));
    empty(n.findItemIndex(6)); 
    equals(n.get(6));  
    
    isFalse(n.has(7));
    empty(n.find(7));
    empty(n.findItemIndex(7));  
    equals(n.get(7));  
  }
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Test
  public void testConstructorEight() {
    Numbered<Character>[] array = new Numbered[] { new Numbered('a',0), 
        new Numbered('b',1), new Numbered('c',2), new Numbered('d',3),
        new Numbered('e',4), new Numbered('f',5), new Numbered('g',6), new Numbered('h',7)};
    CompressedIndexNode<Character> n = new CompressedIndexNode<>(array, 8);
    equals(8, n.size());
    equals(8, n.capacity());
    println(n.getItemIdxs().toString(2));
    
    isTrue(n.has(0));
    equals('a',n.find(0).get());
    equals(0,n.findItemIndex(0).get());  
    equals('a', n.get(0));  
    
    isTrue(n.has(1));
    equals('b', n.find(1).get());
    equals(1,n.findItemIndex(1).get());  
    equals('b', n.get(1));  
    
    isTrue(n.has(2));
    equals('c', n.find(2).get());
    equals(2, n.findItemIndex(2).get());  
    equals('c', n.get(2));  
    
    isTrue(n.has(3));
    equals('d', n.find(3).get());
    equals(3, n.findItemIndex(3).get());  
    equals('d', n.get(3));  
    
    isTrue(n.has(4));
    equals('e', n.find(4).get());
    equals(4, n.findItemIndex(4).get());  
    equals('e', n.get(4));  
    
    isTrue(n.has(5));
    equals('f', n.find(5).get());
    equals(5, n.findItemIndex(5).get());  
    equals('f', n.get(5));  
    
    isTrue(n.has(6));
    equals('g', n.find(6).get());
    equals(6, n.findItemIndex(6).get()); 
    equals('g', n.get(6));  
    
    isTrue(n.has(7));
    equals('h', n.find(7).get());
    equals(7, n.findItemIndex(7).get());  
    equals('h', n.get(7));  
  }
}
