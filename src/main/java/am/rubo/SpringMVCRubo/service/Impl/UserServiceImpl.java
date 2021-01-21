package am.rubo.SpringMVCRubo.service.Impl;

import am.rubo.SpringMVCRubo.model.User;
import am.rubo.SpringMVCRubo.model.exceptions.DublicateDataException;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;
import am.rubo.SpringMVCRubo.repository.UserRepository;
import am.rubo.SpringMVCRubo.service.UserService;
import am.rubo.SpringMVCRubo.util.Messages;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import static am.rubo.SpringMVCRubo.util.Messages.*;
import static am.rubo.SpringMVCRubo.util.Messages.ACCOUNT_MISSING;


@Data
@Transactional
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User login(String username, String password) throws NotFoundException {
       User user;
           user = userRepository.getByUsernameAndPassword(username,password);
           NotFoundException.check(user == null,ACCOUNT_MISSING);
           return user;
   }


        @Override
        public void register(User user) throws DublicateDataException {

              User dublicate =  userRepository.getByUsername(user.getUsername());

              DublicateDataException.check(dublicate != null, USERNAME_EXISTS);
                userRepository.save(user);
                   user.setStatus(0);
        }

        @Override
        public User changePassword(String username, String oldPassword, String newPassword) throws NotFoundException {
            User user;
                user = userRepository.getByUsername(username);
                NotFoundException.check(user == null, ACCOUNT_MISSING);
                user.setPassword(newPassword);
                userRepository.save(user);
                return user;
        }


        @Override
        public void deleteUser(String username, String Password) throws NotFoundException {
                User user = userRepository.getByUsernameAndPassword(username,Password);
                NotFoundException.check(user == null, ACCOUNT_MISSING);
                userRepository.delete(user);
       }





}
