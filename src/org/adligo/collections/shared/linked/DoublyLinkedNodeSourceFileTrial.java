package org.adligo.collections.shared.linked;

import org.adligo.collections.linked.DoublyLinkedNode;
import org.adligo.collections.linked.DoublyLinkedNodeMutant;
import org.adligo.i_collections.shared.linked.I_DoublyLinkedNode;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j4jj.JjSourceFileTrial;
import org.junit.jupiter.api.Test;

/**
 * Tests for DoublyLinkedNodeMutant.
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

@SourceFileScope (sourceClass = DoublyLinkedNodeMutant.class, minCoverage = 100, allowedCircularDependencies = CircularDependencies.Na)
public class DoublyLinkedNodeSourceFileTrial extends JjSourceFileTrial {


	@Test
	public void testMethodsOnSingleNode() {
		DoublyLinkedNodeMutant<String> h1 = new DoublyLinkedNodeMutant<>();
		h1.setValue("a");
		DoublyLinkedNode<String> h = new DoublyLinkedNode<>(h1);

		equals("a", h.getValue());
		isFalse(h.hasNext());
		isFalse(h.hasPrevious());
		isNull(h.getNext());
		isNull(h.getPrevious());
	}
	
	@Test
	public void testOwnerMutation() {
		DoublyLinkedNodeMutant<String> h1 = new DoublyLinkedNodeMutant<>();
		h1.setValue("a");
		
		DoublyLinkedNodeMutant<String> b1 = new DoublyLinkedNodeMutant<>();
		b1.setValue("b");
		
		DoublyLinkedNodeMutant<String> c1 = new DoublyLinkedNodeMutant<>();
		c1.setValue("c");
		
		h1.setNext(b1);
		b1.setPrevious(h1);
		b1.setNext(c1);
		c1.setPrevious(b1);
		

		DoublyLinkedNode<String> h = new DoublyLinkedNode<>(h1);
		equals("a", h.getValue());
		isFalse(h.hasPrevious());
		isTrue(h.hasNext());
		isNull(h.getPrevious());
		
		I_DoublyLinkedNode<String> b = h.getNext();
		equals("b", b.getValue());
		equals(DoublyLinkedNode.class, b.getClass());
		isTrue(b.hasNext());
		isTrue(b.hasPrevious());
		
		I_DoublyLinkedNode<String> c = b.getNext();
		equals("c", c.getValue());
		equals(DoublyLinkedNode.class, c.getClass());
		isFalse(c.hasNext());
		isTrue(c.hasPrevious());
		
		 b = c.getPrevious();
		 equals("b", b.getValue());
		 I_DoublyLinkedNode<String> h2 = b.getPrevious();
		 equals("a", h2.getValue());
		 
		 //mutate the input
		 b1.setValue("b1");
		 b1.setNext(null);
		 
		 equals("a", h.getValue());
		isFalse(h.hasPrevious());
		isTrue(h.hasNext());
		isNull(h.getPrevious());
		
		b = h.getNext();
		equals("b1", b.getValue());
		equals(DoublyLinkedNode.class, b.getClass());
		isFalse(b.hasNext());
		isTrue(b.hasPrevious());
	}
	
	@Test
	public void testAbcChain() {
		DoublyLinkedNodeMutant<String> h1 = new DoublyLinkedNodeMutant<>();
		h1.setValue("a");
		
		DoublyLinkedNodeMutant<String> b1 = new DoublyLinkedNodeMutant<>();
		b1.setValue("b");
		
		DoublyLinkedNodeMutant<String> c1 = new DoublyLinkedNodeMutant<>();
		c1.setValue("c");
		
		h1.setNext(b1);
		b1.setPrevious(h1);
		b1.setNext(c1);
		c1.setPrevious(b1);
		
		DoublyLinkedNode<String> h = new DoublyLinkedNode<>(h1);
		equals("a", h.getValue());
		isFalse(h.hasPrevious());
		isTrue(h.hasNext());
		isNull(h.getPrevious());
		
		I_DoublyLinkedNode<String> b = h.getNext();
		equals("b", b.getValue());
		equals(DoublyLinkedNode.class, b.getClass());
		isTrue(b.hasNext());
		isTrue(b.hasPrevious());
		
		I_DoublyLinkedNode<String> c = b.getNext();
		equals("c", c.getValue());
		equals(DoublyLinkedNode.class, c.getClass());
		isFalse(c.hasNext());
		isTrue(c.hasPrevious());
		
		 b = c.getPrevious();
		 equals("b", b.getValue());
		 I_DoublyLinkedNode<String> h2 = b.getPrevious();
		 equals("a", h2.getValue());
	}
}
