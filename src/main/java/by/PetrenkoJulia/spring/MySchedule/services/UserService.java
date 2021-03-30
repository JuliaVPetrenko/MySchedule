package by.PetrenkoJulia.spring.MySchedule.services;

import by.PetrenkoJulia.spring.MySchedule.entities.Role;
import by.PetrenkoJulia.spring.MySchedule.entities.Task;
import by.PetrenkoJulia.spring.MySchedule.entities.User;
import by.PetrenkoJulia.spring.MySchedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    public List<Task> FindTaskForUser(String username){
//        User
//        List<Task> tasks = user
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }
        String s1 = user.getUsername();
        System.out.println(s1);
        String s2 = user.getPassword();
        System.out.println(s2);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities (Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

//    public String TasksByUser(String username){
    public Collection<Task> TasksByUser(String username){
        User user = findByUsername(username);
        Collection<Task> tasks = user.getTasks();
//            return tasks.stream().map(task -> task.getName()).reduce((t, s) -> s + "<br>" + t).get();
        return tasks;
    }

    public Iterable<User> ShowAllUsers (){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
