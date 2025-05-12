package org.adligo.collections.shared.linked;

import org.adligo.collections.linked.DoublyLinkedList;
import org.adligo.collections.linked.DoublyLinkedListMutant;
import org.adligo.collections.linked.DoublyLinkedNode;
import org.adligo.i_collections.shared.linked.I_DoublyLinkedNode;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;


/**
 * Tests for DoublyLinkedList.
 * <br/>
 * 
 * @author scott<br/>
 *         <br/>
 * 
 * <pre><code>
 * ---------------- Apache LICENSE-2.0 --------------------------
 *
 * Copyright 2025 Adligo Inc
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

@SourceFileScope (sourceClass = DoublyLinkedList.class, minCoverage = 100, allowedCircularDependencies = CircularDependencies.Na)

public class DoublyLinkedListSourceFileTrial extends JjSourceFileTrial {

	@Test
	public void testMethodsOnSingleNode() {
		DoublyLinkedListMutant<String> list = new DoublyLinkedListMutant<>();
		list.add("a");
		DoublyLinkedList<String> imList = new DoublyLinkedList<>(list);
		I_DoublyLinkedNode<String> h = imList.getHead();
		
		equals("a", h.getValue());
		isFalse(h.hasNext());
		isFalse(h.hasPrevious());
		isNull(h.getNext());
		isNull(h.getPrevious());
		equals(DoublyLinkedNode.class, h.getClass());
		
	}
	
	@Test
	public void testAbcChain() {
		DoublyLinkedListMutant<String> list = new DoublyLinkedListMutant<>();
		list.add("a","b","c");
		DoublyLinkedList<String> imList = new DoublyLinkedList<>(list);
		I_DoublyLinkedNode<String> h = imList.getHead();
		I_DoublyLinkedNode<String> b = h.getNext();
		I_DoublyLinkedNode<String> c = b.getNext();
		
		equals("a", h.getValue());
		isFalse(h.hasPrevious());
		isTrue(h.hasNext());
		isNull(h.getPrevious());
		I_DoublyLinkedNode<String> b1 = h.getNext();
		equals("b", b1.getValue());
		equals(DoublyLinkedNode.class, h.getClass());
		
		equals("b", b.getValue());
		isTrue(b.hasPrevious());
		isTrue(b.hasNext());
		I_DoublyLinkedNode<String> h1 = b.getPrevious();
		equals("a",h1.getValue());
		I_DoublyLinkedNode<String> c1 = b.getNext();
		equals("c", c1.getValue());
		equals(DoublyLinkedNode.class, b.getClass());
		
		equals("c", c.getValue());
		isTrue(c.hasPrevious());
		isFalse(c.hasNext());
		I_DoublyLinkedNode<String> b2 = c.getPrevious();
		equals("b", b2.getValue());
		isNull(c.getNext());
		equals(DoublyLinkedNode.class, c.getClass());
	}
}
