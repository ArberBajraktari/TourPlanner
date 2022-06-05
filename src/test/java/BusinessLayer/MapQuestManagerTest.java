package BusinessLayer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapQuestManagerTest {

    @Test
    void testRequestRoute() {
        String resp = MapQuestManager.requestRoute("10", "20");
        assertEquals(resp, "{\"route\":{\"routeError\":{\"errorCode\":2,\"message\":\"\"}},\"info\":{\"statuscode\":402,\"copyright\":{\"imageAltText\":\"© 2022 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"text\":\"© 2022 MapQuest, Inc.\"},\"messages\":[\"We are unable to route with the given locations.\"]}}\r");
    }

    @Test
    void testGetRouteDistance(){
        assertEquals("81.566", MapQuestManager.getRouteDistance("koplik", "shkoder"));
        assertNotEquals("smth else", MapQuestManager.getRouteDistance("koplik", "shkoder"));
    }
}