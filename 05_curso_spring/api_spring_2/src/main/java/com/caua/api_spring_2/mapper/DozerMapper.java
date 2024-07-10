package com.caua.api_spring_2.mapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    public static <O,D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }
    public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationList = new ArrayList<>();
        for(O o:origin){
            destinationList.add(mapper.map(o,destination));

        };
        return destinationList;
    }
}
