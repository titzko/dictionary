package com.titzko.backend.domain;

import com.titzko.backend.converter.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
public class DictEntry {

    @GeneratedValue
    @Id
    Long id;
    String description;
    @Convert(converter = StringListConverter.class)
    private List<String> frameworks;
    String gitlink;
    String exampleLink;
    String blogPostLink;

}
