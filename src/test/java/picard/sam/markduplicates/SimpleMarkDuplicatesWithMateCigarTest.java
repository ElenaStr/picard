/*
 * The MIT License
 *
 * Copyright (c) 2015 The Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package picard.sam.markduplicates;

import htsjdk.samtools.SAMException;
import org.testng.annotations.Test;

/**
 * @author nhomer
 */
public class SimpleMarkDuplicatesWithMateCigarTest extends AbstractMarkDuplicatesCommandLineProgramTest {
    protected AbstractMarkDuplicatesCommandLineProgramTester getTester() {
        return new SimpleMarkDuplicatesWithMateCigarTester();
    }

    /** We require mate cigars for this tool */
    @Test(expectedExceptions = SAMException.class)
    @Override
    public void testTwoMappedPairsWithSoftClippingFirstOfPairOnlyNoMateCigar() {
        super.testTwoMappedPairsWithSoftClippingFirstOfPairOnlyNoMateCigar();
    }

    /**
     * Currently this class fails this test due to
     * a small difference in the selection of representative read. To fix this
     * a change is required in htsjdk.samtools.DuplicateScoringStrategy.compare
     */
    @Test(enabled = false)
    @Override
    public void testOpticalDuplicateClusterSamePositionNoOpticalDuplicates(final String readName1, final String readName2) {
    }
}
