package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.StoreDayHour;
import net.trapezokomos.dashboard.resources.StoreDayHourResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class StoreDayHourConverter implements AttributeConverter<StoreDayHourResource, StoreDayHour> {
    @Override

    public StoreDayHour convertToDatabaseColumn(StoreDayHourResource storeDayHourResource) {
        return StoreDayHour.builder()
                .id(storeDayHourResource.getId())
                .storeId(storeDayHourResource.getStoreId())
                .dayOfWeek(storeDayHourResource.getDayOfWeek())
                .startTime(storeDayHourResource.getStartTime())
                .endTime(storeDayHourResource.getEndTime())
                .isClosed(storeDayHourResource.isClosed())
                .createdAt(storeDayHourResource.getCreatedAt())
                .updatedAt(storeDayHourResource.getUpdatedAt())
                .build();
    }

    @Override
    public StoreDayHourResource convertToEntityAttribute(StoreDayHour storeDayHour) {
        return StoreDayHourResource.builder()
                .id(storeDayHour.getId())
                .storeId(storeDayHour.getStoreId())
                .dayOfWeek(storeDayHour.getDayOfWeek())
                .startTime(storeDayHour.getStartTime())
                .endTime(storeDayHour.getEndTime())
                .isClosed(storeDayHour.isClosed())
                .createdAt(storeDayHour.getCreatedAt())
                .updatedAt(storeDayHour.getUpdatedAt())
                .build();
    }

    public StoreDayHourResource createStoreDayHourResource(int storeId, int dayOfWeek, String startTime, String endTime, boolean isClosed) {
        return StoreDayHourResource.builder()
                .storeId(storeId)
                .dayOfWeek(dayOfWeek)
                .startTime(startTime)
                .endTime(endTime)
                .isClosed(isClosed)
                .build();
    }
}
