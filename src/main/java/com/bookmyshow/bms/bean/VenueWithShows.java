package com.bookmyshow.bms.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VenueWithShows extends Venue{
    private Map<String, List<Show>> eventShowList;


    public VenueWithShows(String name, String cityName, Integer id, Map<String, List<Show>> eventShowList) {
        super(name, cityName);
        this.eventShowList = eventShowList;
    }

    public VenueWithShows(Venue venue,Map<String, List<Show>> eventShowList)
    {
        super(venue);
        this.eventShowList = eventShowList;
    }

    public Map<String, List<Show>> getEventShowList() {
        return eventShowList;
    }

    public void setEventShowList(Map<String, List<Show>> eventShowList) {
        this.eventShowList = eventShowList;
    }
}
