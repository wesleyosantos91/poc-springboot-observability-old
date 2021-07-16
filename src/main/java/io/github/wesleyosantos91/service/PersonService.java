package io.github.wesleyosantos91.service;

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException;
import io.github.wesleyosantos91.domain.entity.Person;
import io.github.wesleyosantos91.domain.request.PersonRequest;
import io.github.wesleyosantos91.domain.response.PersonResponse;
import io.github.wesleyosantos91.mapper.PersonMapper;
import io.github.wesleyosantos91.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    
    private final PersonRepository repository;
    private final PersonMapper mapper;
    
    public List<PersonResponse> findAll(){
        final List<Person> list = this.repository.findAll();
        return mapper.parserToListResponse(list);
    }

    public Page<PersonResponse> findAllPage(Pageable pageable) {
        final Page<Person> pages = repository.findAll(pageable);
        return mapper.parserToPageResponse(pages);
    }

    public PersonResponse findById(Long id){
        return mapper.parseResponse(exist(id));
    }

    @Transactional
    public PersonResponse save(PersonRequest request) throws Exception {
        Person domain = mapper.parseDomain(request);
        domain = this.repository.save(domain);
        return mapper.parseResponse(domain);
    }

    @Transactional
    public PersonResponse update(Long id, PersonRequest request) throws Exception {
        Person person = exist(id);
        BeanUtils.copyProperties(request, person, "id");
        person = this.repository.save(person);
        return mapper.parseResponse(person);
    }

    @Transactional
    public void delete(Long id) {
        Person person = exist(id);
        repository.delete(person);
    }

    private Person exist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(format("Not found Person with code %d", id)));
    }
    
}
