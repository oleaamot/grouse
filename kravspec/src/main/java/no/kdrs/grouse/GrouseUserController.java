package no.kdrs.grouse;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class GrouseUserController {

	private List<GrouseUser> users = new ArrayList();

	GrouseUserController() {
		this.users = buildUsers();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<GrouseUser> getUsers() {
		return this.users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GrouseUser getUser(@PathVariable("id") Integer id) {
		return this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	@RequestMapping(method = RequestMethod.POST)
	public GrouseUser saveUser(@RequestBody GrouseUser user) {
		Integer nextId = 0;
		if (this.users.size() != 0) {
			GrouseUser lastUser = this.users.stream().skip(this.users.size() - 1).findFirst().orElse(null);
			nextId = lastUser.getId() + 1;
		}

		user.setId(nextId);
		this.users.add(user);
		return user;

	}

	@RequestMapping(method = RequestMethod.PUT)
	public GrouseUser updateUser(@RequestBody GrouseUser user) {
		GrouseUser modifiedUser = this.users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
		modifiedUser.setFirstName(user.getFirstName());
		modifiedUser.setLastName(user.getLastName());
		modifiedUser.setEmail(user.getEmail());
		return modifiedUser;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Integer id) {
		GrouseUser deleteUser = this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		if (deleteUser != null) {
			this.users.remove(deleteUser);
			return true;
		} else  {
			return false;
		}


	}

	List<GrouseUser> buildUsers() {
		List<GrouseUser> users = new ArrayList<>();

		GrouseUser user1 = buildUser(1, "Thomas", "Sødring", "tsodring@gmail.com");
		GrouseUser user2 = buildUser(2, "Tor Eivind", "Johansen", "tej@kdrs.no");
		GrouseUser user3 = buildUser(3, "Ole", "Aamot", "ole.aamot@gmail.com");

		users.add(user1);
		users.add(user2);
		users.add(user3);

		return users;

	}

	GrouseUser buildUser(Integer id, String fname, String lname, String email) {
		GrouseUser user = new GrouseUser();
		user.setId(id);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(email);
		return user;
	}

}
