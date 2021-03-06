/*
 * #%L
 * P6Spy
 * %%
 * Copyright (C) 2013 P6Spy
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.p6spy.engine.proxy;

import com.p6spy.engine.test.BaseTestCase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Quinton McCombs
 * @since 09/2013
 */
public class MethodNameAndParameterLikeMatcherTest extends BaseTestCase {

  @Test
  public void testParameterMatches() throws Exception {
    assertTrue("should have matched", new MethodNameAndParameterLikeMatcher("setA", String.class)
        .matches(TestInterface2.class.getMethod("setA", String.class, String.class)));

    assertTrue("should have matched", new MethodNameAndParameterLikeMatcher("setA", String.class)
        .matches(TestInterface2.class.getMethod("setA", String.class)));

    assertFalse("should not have matched", new MethodNameAndParameterLikeMatcher("setA", String.class, String.class)
        .matches(TestInterface2.class.getMethod("setA", String.class)));


  }

  interface TestInterface {
    void setA(String a);
    void setB(String b);
    void clear();
  }
  interface TestInterface2 extends TestInterface {
    void setA(String a, String x);
    void setB(String b, String x);
  }

}
