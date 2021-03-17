package acre.follower;

import java.util.*;
import java.util.stream.Collectors;

public class FollowerDemo {

  List<User> allUsers = new ArrayList<>();

  public List<User> getAllUsers() {
    // be aware of encapsulation
    return Collections.unmodifiableList(allUsers);
  }

  public List<User> getFollowedBy(User user) {
    return user.getFollowBy();
  }

  public boolean isFollowing(User userA, User userB) {
    return userA.getFollowing().contains(userB) && userB.getFollowBy().contains(userA);
  }

  public void setFollowing(User userA, User userB) {
    userA.addFollowing(userB);
    userB.addFollowBy(userA);
  }

  public boolean isFamous(User user) {
    for (User u : allUsers) {
      if (!u.getFollowing().contains(user)) {
        return false;
      }
    }

    return user.getFollowing().size() == 0;
  }

}

class User {

  String firstName;
  String lastName;
  String email;

  private final Set<User> following = new HashSet<>();
  private final Set<User> followBy = new HashSet<>();

  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public void addFollowing(User user) {
    this.following.add(user);
  }

  public void addFollowBy(User user) {
    this.followBy.add(user);
  }

  public List<User> getFollowing() {
    return following.stream().collect(Collectors.toList());
  }

  public List<User> getFollowBy() {
    return following.stream().collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return email.equals(user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }
}
