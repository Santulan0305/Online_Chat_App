package com.goldencat.chatapp.service;

import com.goldencat.chatapp.model.Account;
import com.goldencat.chatapp.model.Status;
import com.goldencat.chatapp.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository,
                          PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 🔐 LOGIN (SPRING SECURITY)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new org.springframework.security.core.userdetails.User(
                account.getUsername(),
                account.getPassword(),
                getAuthorities()
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_USER")
        );
    }

    // 🟢 REGISTER USER
    public Account registerAccount(String username, String password) {

        if (accountRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setStatus(Status.OFFLINE);

        return accountRepository.save(account);
    }

    // 🟢 ONLINE USERS
    public List<Account> getConnectedUsers() {
        return accountRepository.findAllByStatus(Status.ONLINE);
    }

    // 🟢 LOGIN STATUS
    public void saveUser(Account user) {
        accountRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    u.setStatus(Status.ONLINE);
                    accountRepository.save(u);
                });
    }

    // 🔴 LOGOUT STATUS
    public void disconnect(Account user) {
        accountRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    u.setStatus(Status.OFFLINE);
                    accountRepository.save(u);
                });
    }
}