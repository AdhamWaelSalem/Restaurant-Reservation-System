package Z.Old.Dashboards;

import Users.User;

public abstract class UserDash {

    protected User user;
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
