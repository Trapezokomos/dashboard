package net.trapezokomos.dashboard.utils;


import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.StoreDayHour;
import net.trapezokomos.dashboard.resources.StoreDayHourResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StoreDayHourConverter implements AttributeConverter<StoreDayHourResource, StoreDayHour> {
    @Override

    public StoreDayHour convertToDatabaseColumn(StoreDayHourResource storeDayHourResource) {
        return StoreDayHour.builder()
                .id(storeDayHourResource.getId())
                .store_id(storeDayHourResource.getStore_id())
                .dayofweek(storeDayHourResource.getDayofweek())
                .start_time(storeDayHourResource.getStart_time())
                .end_time(storeDayHourResource.getEnd_time())
                .cloded(storeDayHourResource.isCloded())
                .createdAt(storeDayHourResource.getCreatedAt())
                .updatedAt(storeDayHourResource.getUpdatedAt())
                .build();
    }

    @Override
    public StoreDayHourResource convertToEntityAttribute(StoreDayHour storeDayHour) {
        return StoreDayHourResource.builder()
                .id(storeDayHour.getId())
                .store_id(storeDayHour.getStore_id())
                .dayofweek(storeDayHour.getDayofweek())
                .start_time(storeDayHour.getStart_time())
                .end_time(storeDayHour.getEnd_time())
                .cloded(storeDayHour.isCloded())
                .createdAt(storeDayHour.getCreatedAt())
                .updatedAt(storeDayHour.getUpdatedAt())
                .build();
    }

    public StoreDayHourResource createStoreDayHourResource(int store_id, int dayofweek, String start_time, String end_time, boolean cloded, Date createdAt, Date updatedAt) {
        return StoreDayHourResource.builder()
                .store_id(store_id)
                .dayofweek(dayofweek)
                .start_time(start_time)
                .end_time(end_time)
                .cloded(cloded)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }


}
