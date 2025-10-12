package com.geek;

import java.util.List;

public interface UserRepository {
User findById(int id);
List<User> getAllUsers();
}
