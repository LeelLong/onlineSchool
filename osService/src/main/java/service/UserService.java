package service;

import entity.User;

public interface UserService {
    public User getByUsername(String username);
    public void createSelectivity(User user);
}
