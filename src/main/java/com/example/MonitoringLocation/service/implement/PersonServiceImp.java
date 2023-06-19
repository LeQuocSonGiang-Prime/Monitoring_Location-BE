package com.example.MonitoringLocation.service.implement;

import com.example.MonitoringLocation.model.Person;
import com.example.MonitoringLocation.repositories.LocationRepositoryCustom;
import com.example.MonitoringLocation.repositories.PersonRepository;
import com.example.MonitoringLocation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LocationRepositoryCustom locationRepositoryCustom;

    @Override
    public List<Person> getAllByUser(Long userId) {
        return personRepository.findAllByUser(userId);
    }

    @Override
    public String insert(Person person) {
        String token = createRandomString();
        personRepository.insert(person.getUser().getId(), person.getName(), token, person.getAvatar());
        Person result = personRepository.findByToken(token);
        locationRepositoryCustom.createLocationTableForPerson(result.getId());
        return token;
    }


    @Override
    public Person checkPersonByToken(String token) {
        return personRepository.findByToken(token);
    }

    @Override
    public int deletePerson(Long id) {
        String tableName = "person_" + id + "_locations";
        if (personRepository.findById(id) == null)
            return 1;
        if (!locationRepositoryCustom.isTableExist(tableName))
            return 2;
        personRepository.deleteById(id);
        locationRepositoryCustom.removeTable(tableName);
        return 0;
    }


    private static String createRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder(40);
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(createRandomString());
    }
}
