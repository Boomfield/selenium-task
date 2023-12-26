package tests.data.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@JsonDeserialize(contentAs = Filter.class)
public class TelevisionsSearchData {
    @JsonProperty("assertParameters")
    private AssertParameters assertParameters;
    @JsonProperty("filter")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Filter> filters = new ArrayList<>();

    public LinkedHashMap<String, String> toMap() {
        LinkedHashMap<String, String> filtersMap = new LinkedHashMap<>();

        if (filters != null) {
            for (Filter filter : filters) {
                filtersMap.put(filter.getLabel(), filter.getCategory());
            }
        }

        return filtersMap;
    }

    public AssertParameters getTestParameters() {
        return assertParameters;
    }
}

