package com.muks.oopsandjava.concepts.annotationsCustom.eg2;

/**
 * Created by 300000511 on 18/04/17.
 */
@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "muks.com",
        tags = {"sales","test" }
)
public class TestExample {
    @Test
    void testA() {
        if (true)
            throw new RuntimeException("This test always failed");
    }

    @Test(enabled = false)
    void testB() {
        if (false)
            throw new RuntimeException("This test always passed");
    }

    @Test(enabled = true)
    void testC() {
        if (10 > 1) {
            // do nothing, this test always passed.
        }
    }

}