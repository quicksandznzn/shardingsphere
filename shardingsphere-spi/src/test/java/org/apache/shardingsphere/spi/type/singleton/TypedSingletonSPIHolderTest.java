/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.spi.type.singleton;

import org.apache.shardingsphere.spi.ShardingSphereServiceLoader;
import org.apache.shardingsphere.spi.type.singleton.fixture.SingletonSPIFixture;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class TypedSingletonSPIHolderTest {
    
    static {
        ShardingSphereServiceLoader.register(SingletonSPIFixture.class);
    }
    
    @Test
    public void assertGetOnType() {
        TypedSingletonSPIHolder<SingletonSPIFixture> spiHolder = new TypedSingletonSPIHolder<>(SingletonSPIFixture.class);
        assertTrue(spiHolder.get("SINGLETON_FIXTURE").isPresent());
        assertFalse(spiHolder.get("singleton_fixture").isPresent());
    }
}