package com.deeplaxmi.SpringBoot.tutorial.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//created a endpoint feature and this will send back the list of features available for this application


@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    private final Map<String, Feature> featuremMap = new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featuremMap.put("Department",new Feature(true));
        featuremMap.put("User",new Feature(false));
        featuremMap.put("Authentication",new Feature(false));
    }

    @ReadOperation
    public Map<String,Feature> features(){
        return featuremMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){
        return  featuremMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;

    }
}
