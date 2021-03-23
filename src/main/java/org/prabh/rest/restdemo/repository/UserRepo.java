package org.prabh.rest.restdemo.repository;

import org.prabh.rest.restdemo.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String> {
}
