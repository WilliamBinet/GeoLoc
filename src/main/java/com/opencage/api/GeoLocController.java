package com.opencage.api;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.opencage.api.exception.NoTownFoundExeption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoLocController {

    @GetMapping("/location")
    public Location getLocation(@RequestParam String town ,@RequestParam String key) throws Exception {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(key);
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(town);
        request.setMinConfidence(1);
        request.setNoAnnotations(false);
        request.setNoDedupe(true);
        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        if (response.getResults().size() > 0) {
            return new Location(response.getResults().get(0).getGeometry().getLat(), response.getResults().get(0).getGeometry().getLng());
        }
        throw new NoTownFoundExeption("No town have been found with this name");
    }
}
