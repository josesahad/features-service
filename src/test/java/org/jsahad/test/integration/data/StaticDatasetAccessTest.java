package org.jsahad.test.integration.data;

import static org.junit.Assert.assertEquals;

import org.jsahad.data.access.StaticDatasetAccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticDatasetAccessTest {
    
    @Autowired
    private StaticDatasetAccess staticDatasetAccess;

    @Test
    public void testListFeaturesInDataset() {
        assertEquals(2, this.staticDatasetAccess.getDataMap().size());
    }
}
