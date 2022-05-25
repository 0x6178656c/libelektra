package org.libelektra.key

import org.junit.Test
import org.libelektra.dsl.keyOf
import org.libelektra.keyExt.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class KeyBuilderTest {

    @Test
    fun `keyOf with name and value, returns correct key`() {
        val key = keyOf("/test") {
            value = "1234"
        }

        assertEquals(key.name, "/test")
        assertEquals(key.string, "1234")
    }

    @Test
    fun `keyOf with name and value and meta keys, returns correct key including meta keys`() {
        val key = keyOf("/test") {
            value = "1234"
            metaKey("meta:/meta1", "value1")
            metaKey("meta:/meta2", "value2")
        }

        assertEquals(key.getMeta("/meta1").orNull()!!.string, "value1")
        assertEquals(key.getMeta("meta2").orNull()!!.string, "value2")
    }

    @Test
    fun `keyOf with wrong meta key, throws IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            keyOf("/test") {
                metaKey("/meta")
            }
        }
    }
}
