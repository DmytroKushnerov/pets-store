package org.example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private long id;
    private Map<String, Object> category;
    private String name;
    private List<String> photoUrls;
    private List<Map<String, Object>> tags;
    private String status;
}
