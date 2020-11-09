package org.jsahad.test.integration.api;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = 
  SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FeatureAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testListAllFeatures() throws Exception {
        mvc.perform(get("/api/features")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(equalTo(2))))
        .andExpect(jsonPath("$[0].id", is("cf5dbe37-ab95-4af1-97ad-2637aec4ddf0")))
        .andExpect(jsonPath("$[0].timestamp", is(1556904743783L)))
        .andExpect(jsonPath("$[0].beginViewingDate", is(1556904743783L)))
        .andExpect(jsonPath("$[0].endViewingDate", is(1556904768781L)))
        .andExpect(jsonPath("$[0].missionName", is("Sentinel-1A")))
        .andExpect(jsonPath("$[1].id", is("39c2f29e-c0f8-4a39-a98b-deed547d6aea")))
        .andExpect(jsonPath("$[1].timestamp", is(1554831167697L)))
        .andExpect(jsonPath("$[1].beginViewingDate", is(1554831167697L)))
        .andExpect(jsonPath("$[1].endViewingDate", is(1554831202043L)))
        .andExpect(jsonPath("$[1].missionName", is("Sentinel-1B")));
    }

    @Test
    public void testGetASingleFeature() throws Exception {
        mvc.perform(get("/api/features/cf5dbe37-ab95-4af1-97ad-2637aec4ddf0")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is("cf5dbe37-ab95-4af1-97ad-2637aec4ddf0")))
        .andExpect(jsonPath("$.timestamp", is(1556904743783L)))
        .andExpect(jsonPath("$.beginViewingDate", is(1556904743783L)))
        .andExpect(jsonPath("$.endViewingDate", is(1556904768781L)))
        .andExpect(jsonPath("$.missionName", is("Sentinel-1A")));
    }

    @Test
    public void testGetANonExistingFeature() throws Exception {
        mvc.perform(get("/api/features/cf5dbe37-ab95-4af1-97ad-2637aec4ddf4")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.error", is("Not Found")));
    }

    @Test
    public void testGetQuicklook() throws Exception {
        mvc.perform(get("/api/features/cf5dbe37-ab95-4af1-97ad-2637aec4ddf0/quicklook")
        .contentType(MediaType.IMAGE_PNG))
        .andExpect(status().isOk());
    }

    @Test
    public void testGetQuicklookForNonExistingFeature() throws Exception {
        mvc.perform(get("/api/features/cf5dbe37-ab95-4af1-97ad-2637aec4ddf3/quicklook")
        .accept(MediaType.APPLICATION_JSON, MediaType.IMAGE_PNG))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.error", is("Not Found")));
    }

    @Test
    public void testGet400Exception() throws Exception {
        mvc.perform(get("/api/features/BAD-UUID")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
    }
    
}
