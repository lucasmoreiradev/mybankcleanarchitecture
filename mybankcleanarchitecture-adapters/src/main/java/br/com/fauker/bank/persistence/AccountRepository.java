package br.com.fauker.bank.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {

	Optional<AccountJpaEntity> findByCpf(String cpf);

}
