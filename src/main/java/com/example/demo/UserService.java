package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.getCaseById(id);
    }

    public List<User> getAll() {
        List<String> tenants = new ArrayList<>();
        tenants.add("schema_1");
        tenants.add("schema_2");
        return userMapper.selectAllCases(tenants);
    }

    public List<CountOfSchemas> getAllByCount() {
        List<String> tenants = new ArrayList<>();
        tenants.add("soar_poc");
        tenants.add("soar_poc_2");
        return userMapper.selectAllCasesCount(tenants);
    }

    public void save(User c) {
        userMapper.insertUser(c);
    }

    public void save(User c, String tenant) {
        userMapper.insertUserIntoSchema(c, tenant);
    }


}
