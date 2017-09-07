
package ru.varren;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.varren.model.Account;

@Component
public class DatabaseLoader implements CommandLineRunner {
	@Autowired
	private AccountRepository repository;


	@Override
	public void run(String... strings) throws Exception {
		String [] names = new String[]{"Frodo","Bilbo", "Gandalf", "Samwise","Meriadoc","Peregrin"};
		for (String name: names){
			repository.save(new Account(name));
			repository.flush();
		}


	}
}