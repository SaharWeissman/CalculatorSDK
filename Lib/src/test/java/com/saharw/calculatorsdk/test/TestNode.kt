package com.saharw.calculatorsdk.test

import com.saharw.calculatorsdk.core.Node
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by saharw on 29/05/2018.
 */
class TestNode {

    @Test
    fun testNodeCreation() {
        assertNotNull(Node("1", null, null))
        var node2 = Node("1", Node("2", null, null), Node("3", null, null))
        assertNotNull(node2.left)
        assertNotNull(node2.right)
    }
}