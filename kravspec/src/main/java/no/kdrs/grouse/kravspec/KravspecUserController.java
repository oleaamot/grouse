package no.kdrs.grouse.kravspec;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class KravspecUserController {

	private List<KravspecUser> users = new ArrayList();

	KravspecUserController() {
		this.users = buildUsers();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<KravspecUser> getUsers() {
		return this.users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public KravspecUser getUser(@PathVariable("id") Integer id) {
		return this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	@RequestMapping(method = RequestMethod.POST)
	public KravspecUser saveUser(@RequestBody KravspecUser user) {
		Integer nextId = 0;
		if (this.users.size() != 0) {
			KravspecUser lastUser = this.users.stream().skip(this.users.size() - 1).findFirst().orElse(null);
			nextId = lastUser.getId() + 1;
		}

		user.setId(nextId);
		this.users.add(user);
		return user;

	}

	@RequestMapping(method = RequestMethod.PUT)
	public KravspecUser updateUser(@RequestBody KravspecUser user) {
		KravspecUser modifiedUser = this.users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
		modifiedUser.setFirstName(user.getFirstName());
		modifiedUser.setLastName(user.getLastName());
		modifiedUser.setEmail(user.getEmail());
		return modifiedUser;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Integer id) {
		KravspecUser deleteUser = this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		if (deleteUser != null) {
			this.users.remove(deleteUser);
			return true;
		} else  {
			return false;
		}


	}

	List<KravspecUser> buildUsers() {
		List<KravspecUser> users = new ArrayList<>();

		KravspecUser user1 = buildUser(1, "Thomas", "Sødring", "tsodring@gmail.com");
		KravspecUser user2 = buildUser(2, "Tor Eivind", "Johansen", "tej@kdrs.no");
		KravspecUser user3 = buildUser(3, "Ole", "Aamot", "ole.aamot@gmail.com");

		users.add(user1);
		users.add(user2);
		users.add(user3);

		return users;

	}

	KravspecUser buildUser(Integer id, String fname, String lname, String email) {
		KravspecUser user = new KravspecUser();
		user.setId(id);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(email);
		return user;
	}

}
