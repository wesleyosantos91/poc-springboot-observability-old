package io.github.wesleyosantos91.mapper;

import io.github.wesleyosantos91.domain.entity.Person;
import io.github.wesleyosantos91.domain.request.PersonRequest;
import io.github.wesleyosantos91.domain.response.PersonResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {


    PersonResponse parseResponse(Person response);
    Person parseDomain(PersonRequest request);

    default List<PersonResponse> parserToListResponse(List<Person> domains){
        List<PersonResponse> list = new ArrayList<>();
        domains.forEach(d-> list.add(parseResponse(d)));
        return list;
    }

    default Page<PersonResponse> parserToPageResponse(Page<Person> pages){
        List<PersonResponse> list = parserToListResponse(pages.getContent());
        return new PageImpl<>(list, pages.getPageable(), pages.getTotalElements());

    }
}
