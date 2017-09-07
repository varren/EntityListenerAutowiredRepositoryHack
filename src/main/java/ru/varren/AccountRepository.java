package ru.varren;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.varren.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {

}