package DashboardsPack;

import UsersPack.User;

public abstract class UserDash {

    private User user;
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
