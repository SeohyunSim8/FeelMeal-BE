package feelmeal.api.coordinate.service;

import feelmeal.api.coordinate.service.dto.PostCoordinateServiceDto;

public interface GeocoderService {
    public void convertAddressToCoordinate(PostCoordinateServiceDto dto);
}
