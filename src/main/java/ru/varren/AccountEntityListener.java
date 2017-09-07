package ru.varren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.varren.model.Account;

import javax.persistence.PrePersist;
import java.util.List;

public class AccountEntityListener {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private AccountRepository repository;

    @PrePersist
    public void prePersist(Account ob) {
        AutowireHelper.autowire(this, this.repository);
        List<Account> accounts = repository.findAll();
        StringBuilder items = new StringBuilder();

        items.append("New Item:").append(ob);
        items.append(" SIZE: ").append(accounts.size());

        for(Account ac: accounts) {
            items.append(ac);
            items.append(" ");
        }

        LOGGER.error("LIST: " + items);
    }
}
