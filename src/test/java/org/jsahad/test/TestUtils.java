package org.jsahad.test;

import java.util.List;
import java.util.UUID;

import org.assertj.core.util.Lists;
import org.jsahad.model.Feature;

public class TestUtils {
    
    public static Feature buildFeature(String missionName) {
        UUID featureUUID = UUID.randomUUID();
        long timestamp = 1554831167697L;
        long beginViewingDate = 1554831167697L;
        long endViewingDate = 1554831167990L;
        String quicklook = "someQuicklook";
        
        return new Feature(featureUUID, timestamp, beginViewingDate, endViewingDate, missionName, quicklook);
    }

    public static Feature buildFeature(UUID featureUUID, String missionName) {
        long timestamp = 1554831167697L;
        long beginViewingDate = 1554831167697L;
        long endViewingDate = 1554831167990L;
        String quicklook = "someQuicklook";
        
        return new Feature(featureUUID, timestamp, beginViewingDate, endViewingDate, missionName, quicklook);
    }

    public static Feature buildFeature(UUID featureUUID, String missionName, String quicklook) {
        long timestamp = 1554831167697L;
        long beginViewingDate = 1554831167697L;
        long endViewingDate = 1554831167990L;
        
        return new Feature(featureUUID, timestamp, beginViewingDate, endViewingDate, missionName, quicklook);
    }

    public static List<Feature> buildFeatureList() {
        return Lists.newArrayList(TestUtils.buildFeature("mission1"), TestUtils.buildFeature("mission2"));
    }

    public static String buildImageQuicklookString() {
        return "iVBORw0KGgoAAAANSUhEUgAAAgAAAAHRCAIAAACTkJa6AAEAAElEQVR4nOz9SZMkSZImivEmIqpm5ktE5FZZW1d3T/dMD703jwDCDSDccMNfwB/AX8IPwAVXnHF5B9ADARjM0Cxd1VvWkktsvpjpIsILDmLm7hHhkZVRVTnd011ckV7uamqqomqmvHzM/DHCH+Wft+B7ttP3dUJywPi+Dv6BIh+ycwD8DuvGN2/xu7e732j77kf03+P037JjQGP4mODzFX4N8ArYYQRQgHoGsYFQgAlwBjzdhgCAH56Wc7fp0X99JRKPrR0BASDeuLcBkBAYIQAiwAA0IE7n6neMAQiACISAFOrpjf7gpAEACYqCBqBANlCGnIBnmAAQARHQwQkQIBwcAAgoIE7rQYAVAAFGgHQ6dQNYAFZgB1OgEfgcWgZIABVgfnDL+80yAAJQADhdQl+kIJQAQyABQUAF9dMtIiB/43YFwBUAEQwMQwMnGBC4LzVgBXAAJXCHFSAAKojBALCebtWUC5wRtAQTgDqAAjQAgwJgp+W9++n8Uf55y/s+4e/tk6f4p2MAPsDKPVAK313eVb+PnhE/yAB80CI+5GN0hBGw0LgvZ4wJQSAMAQAMogUGQALgfhsQCKDF8RLvtCWflnh34ojjS13J3O1JeHy1byEAwr5bWPQj4HG3OB7z/iynVVlAADIAI3hQQknYWngN8MBC0AIEQBEEEMGXAISIICIe0TV8DQCgBMAYDcIDEJABAk+rOq0w8H4BCCQIAtHC1cMCHCELRiBFNwRhJ8t3d7EA91/9o3HEbrMiAgCw34STSY0IJAQ+XilvCATRwyaPABICBK8OjNg9GTt9HAihHATIgA4A6C3ajUfbpDCGiUANoB0/kAGg//WIfJCL9Ef571DiPUrie9PRv4Me/acgv9Oa3w0a7nw6es/27yAfotTjQ9YduECa/zf/+8//T//n/8PHf7adY61NlkMSH8GU4pDygqQKATSmXMD2bq6u4QaAiEDUNXcwswgCYISpmbuFiHuYO0AICxEhIgAw87quZpZSyjlHRNWmq7sTMbAAIQQYgEVESgkQIbDVMI8IBIeUEhGubdludpvNsKz7m5sbtfb0yWWtisQEzJwi4Pnz5xCUMp+fX+Scl2WepikikGgcCjHN00xEIn15QCTebsABfADICBwAETUP9oPPn6SMr16//PLXL69er3VJ2/Hp7iwPI4vk1uphujXTnHNOwkLQbxC4R7irWUNKXM4QIgBU1VQBkJhEBCKaqpklkZxzrXWpyw8+3+WyEUkvnr/++uuXJQ2b7ZmqImIp2V3NqwgSkcG0/Orfvb46OO53u+GTpz/+h/989X/9v/zf//r/9XdtDQDshtgQAhCCvuXr90cD8C9A7vyaNzZ";
    }
}
