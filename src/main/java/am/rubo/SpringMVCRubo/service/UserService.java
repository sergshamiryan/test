package am.rubo.SpringMVCRubo.service;

import am.rubo.SpringMVCRubo.model.User;
import am.rubo.SpringMVCRubo.model.exceptions.DublicateDataException;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;

public interface UserService {


    User login(String username, String password) throws NotFoundException;

    void register(User user) throws DublicateDataException;

    User changePassword(String username, String oldPassword, String newPassword) throws NotFoundException;

    void deleteUser(String username, String Password) throws NotFoundException;


}
