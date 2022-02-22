package org.adligo.collections.shared.indices.compression;

import static org.adligo.i_ctx4jse.shared.I_PrintMixinStatic.println;

import org.adligo.collections.shared.common.Numbered;
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

  private void assertA0(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(0));
    equals('a',n.find(0).get());
    equals(internalIdx,n.findItemIndex(0).get());  
    equals('a', n.get(0));
  }

  private void assertB1(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(1));
    equals('b', n.find(1).get());
    equals(internalIdx,n.findItemIndex(1).get());  
    equals('b', n.get(1));
  }

  private void assertC2(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(2));
    equals('c', n.find(2).get());
    equals(internalIdx, n.findItemIndex(2).get());  
    equals('c', n.get(2));
  }
  
  private void assertD3(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(3));
    equals('d', n.find(3).get());
    equals(internalIdx, n.findItemIndex(3).get());  
    equals('d', n.get(3));
  }

  private void assertE4(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(4));
    equals('e', n.find(4).get());
    equals(internalIdx, n.findItemIndex(4).get());  
    equals('e', n.get(4));
  }

  private void assertF5(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(5));
    equals('f', n.find(5).get());
    equals(internalIdx, n.findItemIndex(5).get());  
    equals('f', n.get(5));
  }

  private void assertG6(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(6));
    equals('g', n.find(6).get());
    equals(internalIdx, n.findItemIndex(6).get()); 
    equals('g', n.get(6));
  }

  private void assertH7(CompressedIndexNode<Character> n, int internalIdx ) {
    isTrue(n.has(7));
    equals('h', n.find(7).get());
    equals(internalIdx, n.findItemIndex(7).get());  
    equals('h', n.get(7));
  }

  private void assertZ(CompressedIndexNode<Character> n, int idx, int internalIdx ) {
    isTrue(n.has(idx));
    equals('z',n.find(idx).get());
    equals(internalIdx,n.findItemIndex(idx).get());  
    equals('z', n.get(idx));
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private CompressedIndexNode<Character> getA_H() {
    Numbered<Character>[] array = new Numbered[] { new Numbered('a',0), 
        new Numbered('b',1), new Numbered('c',2), new Numbered('d',3),
        new Numbered('e',4), new Numbered('f',5), new Numbered('g',6), new Numbered('h',7)};
    CompressedIndexNode<Character> n = new CompressedIndexNode<>(array, 8);
    return n;
  }
  
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
  
  @Test
  public void testConstructorEight() {
    CompressedIndexNode<Character> n = getA_H();
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1);  
    assertC2(n,2);  
    assertD3(n,3);  
    assertE4(n,4);  
    assertF5(n,5);  
    assertG6(n,6);  
    assertH7(n,7);  
  }

  @Test
  public void testRemoveA0() {
    CompressedIndexNode<Character> n = getA_H().remove(0);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    isFalse(n.has(0));
    empty(n.find(0));
    empty(n.findItemIndex(0));  
    equals(n.get(0));  
    
    assertB1(n,0);  
    assertC2(n,1);  
    assertD3(n,2);  
    assertE4(n,3);  
    assertF5(n,4);  
    assertG6(n,5);  
    assertH7(n,6);  
  }

  @Test
  public void testRemoveB1() {
    CompressedIndexNode<Character> n = getA_H().remove(1);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    
    isFalse(n.has(1));
    empty(n.find(1));
    empty(n.findItemIndex(1));  
    equals(n.get(1));  
    
    assertC2(n,1);  
    assertD3(n,2);  
    assertE4(n,3);  
    assertF5(n,4);  
    assertG6(n,5);  
    assertH7(n,6);  
  }
  
  @Test
  public void testRemoveC2() {
    CompressedIndexNode<Character> n = getA_H().remove(2);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    
    isFalse(n.has(2));
    empty(n.find(2));
    empty(n.findItemIndex(2));  
    equals(n.get(2));  
    
    assertD3(n,2);  
    assertE4(n,3);  
    assertF5(n,4);  
    assertG6(n,5);  
    assertH7(n,6);  
  }
  
  @Test
  public void testRemoveD3() {
    CompressedIndexNode<Character> n = getA_H().remove(3);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    
    isFalse(n.has(3));
    empty(n.find(3));
    empty(n.findItemIndex(3));  
    equals(n.get(3));  
    
    assertE4(n,3);  
    assertF5(n,4);  
    assertG6(n,5);  
    assertH7(n,6);  
  }
  
  
  @Test
  public void testRemoveE4() {
    CompressedIndexNode<Character> n = getA_H().remove(4);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    
    isFalse(n.has(4));
    empty(n.find(4));
    empty(n.findItemIndex(4));  
    equals(n.get(4));  
    
    assertF5(n,4);  
    assertG6(n,5);  
    assertH7(n,6);  
  }
  
  @Test
  public void testRemoveF5() {
    CompressedIndexNode<Character> n = getA_H().remove(5);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    assertE4(n,4); 
    
    isFalse(n.has(5));
    empty(n.find(5));
    empty(n.findItemIndex(5));  
    equals(n.get(5));  
    
    assertG6(n,5);  
    assertH7(n,6);  
  }
  
  
  @Test
  public void testRemoveG6() {
    CompressedIndexNode<Character> n = getA_H().remove(6);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    assertE4(n,4); 
    assertF5(n,5);  
    
    isFalse(n.has(6));
    empty(n.find(6));
    empty(n.findItemIndex(6));  
    equals(n.get(6));  
    
    assertH7(n,6);  
  }
  
  @Test
  public void testRemoveF7() {
    CompressedIndexNode<Character> n = getA_H().remove(7);
    equals(7, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    assertE4(n,4); 
    assertF5(n,5);  
    assertG6(n,6);  
    
    isFalse(n.has(7));
    empty(n.find(7));
    empty(n.findItemIndex(7));  
    equals(n.get(7));  
  }
  

  @SuppressWarnings("unchecked")
  @Test
  public void testReplaceA0() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered('z', 0));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertZ(n,0,0);  
    
    assertB1(n,1);  
    assertC2(n,2);  
    assertD3(n,3);  
    assertE4(n,4);  
    assertF5(n,5);  
    assertG6(n,6);  
    assertH7(n,7);  
  }

  @Test
  public void testReplaceB1() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 1));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    
    assertZ(n,1,1);  
    
    assertC2(n,2);  
    assertD3(n,3);  
    assertE4(n,4);  
    assertF5(n,5);  
    assertG6(n,6);  
    assertH7(n,7);  
  }
  
  @Test
  public void testReplaceC2() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 2));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    
    assertZ(n,2,2);  
    
    assertD3(n,3);  
    assertE4(n,4);  
    assertF5(n,5);  
    assertG6(n,6);  
    assertH7(n,7);  
  }
  
  @Test
  public void testReplaceD3() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 3));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    
    assertZ(n,3,3);  
    
    assertE4(n,4);  
    assertF5(n,5);  
    assertG6(n,6);  
    assertH7(n,7);  
  }
  
  
  @Test
  public void testReplaceE4() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 4));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    
    assertZ(n,4,4);  
    
    assertF5(n,5);  
    assertG6(n,6);  
    assertH7(n,7);  
  }
  
  @Test
  public void testReplaceF5() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 5));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    assertE4(n,4); 
    
    assertZ(n,5,5); 
    
    assertG6(n,6);  
    assertH7(n,7);  
  }
  
  
  @Test
  public void testReplaceG6() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 6));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    assertE4(n,4); 
    assertF5(n,5);  
    
    assertZ(n,6,6);
    
    assertH7(n,7);  
  }
  
  @Test
  public void testReplaceF7() {
    CompressedIndexNode<Character> n = getA_H().replace(new Numbered<Character>('z', 7));
    equals(8, n.size());
    equals(8, n.capacity());
//    println(n.getItemIdxs().toString(2));
//    
    assertA0(n,0);  
    assertB1(n,1); 
    assertC2(n,2); 
    assertD3(n,3);  
    assertE4(n,4); 
    assertF5(n,5);  
    assertG6(n,6);  
    assertZ(n,7,7);
  }
}
