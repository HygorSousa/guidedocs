package com.unitins.guideDocs.security;

import com.unitins.guideDocs.models.Pessoa;
import com.unitins.guideDocs.repository.PessoaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private final PessoaRepository pessoaRepository;

    public ImplementsUserDetailsService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Pessoa pessoa = pessoaRepository.findByCpf(login);

        if (pessoa == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return new User(pessoa.getUsername(), pessoa.getPassword(), true, true, true, true, pessoa.getAuthorities());
    }
}
