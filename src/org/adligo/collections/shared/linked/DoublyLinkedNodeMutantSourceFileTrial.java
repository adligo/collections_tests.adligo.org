package org.adligo.collections.shared.linked;

import org.adligo.collections.linked.DoublyLinkedNodeMutant;
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

public class DoublyLinkedNodeMutantSourceFileTrial extends JjSourceFileTrial {

	@Test
	public void testMethodsOnSingleNode() {
		DoublyLinkedNodeMutant<String> h = new DoublyLinkedNodeMutant<>();
		h.setValue("a");
		equals("a", h.getValue());
		isFalse(h.hasNext());
		isFalse(h.hasPrevious());
		isNull(h.getNext());
		isNull(h.getNextMutant());
		isNull(h.getPrevious());
		isNull(h.getPreviousMutant());
		
	}
	
	@Test
	public void testAbcChain() {
		DoublyLinkedNodeMutant<String> h = new DoublyLinkedNodeMutant<>();
		h.setValue("a");
		
		DoublyLinkedNodeMutant<String> b = new DoublyLinkedNodeMutant<>();
		b.setValue("b");
		
		DoublyLinkedNodeMutant<String> c = new DoublyLinkedNodeMutant<>();
		c.setValue("c");
		
		h.setNext(b);
		b.setPrevious(h);
		b.setNext(c);
		c.setPrevious(b);
		
		equals("a", h.getValue());
		isFalse(h.hasPrevious());
		isTrue(h.hasNext());
		isNull(h.getPrevious());
		same(b, h.getNext());
		
		equals("b", b.getValue());
		isTrue(b.hasPrevious());
		isTrue(b.hasNext());
		same(h,b.getPrevious());
		same(c, b.getNext());
		
		equals("c", c.getValue());
		isTrue(c.hasPrevious());
		isFalse(c.hasNext());
		same(b,c.getPrevious());
		isNull(c.getNext());
	}
}
