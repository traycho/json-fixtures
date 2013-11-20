package com.greencode.fixtures.io;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import java.util.TreeMap;

import static org.fest.assertions.api.Assertions.assertThat;

public class DefaultFixtureReaderTest {

    @Test
    public void testRead() throws Exception {
        ClassPathResource resource = new ClassPathResource("test2.fixtures.json");

        DefaultFixtureReader reader = new DefaultFixtureReader();

        TreeMap<String, JsonNode> fixtures = new TreeMap<String, JsonNode>(reader.read(resource));

        assertThat(fixtures.toString()).isEqualTo(
                "{fixture1={\"stringProperty\":\"property\",\"intProperty\":1}, " +
                        "fixture2={\"stringProperty\":\"property2\"}, " +
                        "fixture3={\"listProperty\":[\"element1\",\"element2\",\"element3\"]}, " +
                        "fixture4={\"invalidProperty\":\"test3\"}, " +
                        "fixture5={\"nested\":{\"prop1\":\"value\"}}}");
    }
}
