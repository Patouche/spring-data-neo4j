/*
 * Copyright (c) 2019 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.neo4j.core.schema;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;

/**
 * @author Michael J. Simons
 */
class SchemaTest {

	@Test
	void shouldGetNodeDescription() {
		NodeDescription description = NodeDescription.builder().primaryLabel("aLabel")
			.properties(Collections.emptyList()).relationships(Collections.emptyList()).build();

		Schema schema = new Schema().registerNodeDescription(description);
		assertThat(schema.getNodeDescription("aLabel")).isPresent().contains(description);
		assertThat(schema.getNodeDescription("anotherLabel")).isNotPresent();
	}
}
