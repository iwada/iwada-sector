package io.iwada.service;

import io.iwada.model.User;

public interface UserService {

	User getCurrentUser();

	User saveCurrentUser(User user);

}
