package com.inmotion.chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * {@link GroupingAndSegmentation}のテスト。
 */
public class GroupingAndSegmentationTest {

    GroupingAndSegmentation target = new GroupingAndSegmentation();

    @Test
    public void testCoutryToLocales() throws Exception {
        // execute
        List<Locale> actural = target.coutryToLocales().get("CH");

        // assert
        Assert.assertEquals("[fr_CH, de_CH, it_CH]", actural.toString());
    }

    @Test
    public void testEnglishAndOtherLocales() throws Exception {
        // execute
        List<Locale> actural = target.englishAndOtherLocales().get(true);

        // assert
        Assert.assertEquals("[en_US, en_SG, en_MT, en, en_PH, en_NZ, en_ZA, en_AU, en_IE, en_CA, en_IN, en_GB]", actural.toString());
    }

}
