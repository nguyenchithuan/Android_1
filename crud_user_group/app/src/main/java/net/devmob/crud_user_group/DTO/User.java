package net.devmob.crud_user_group.DTO;

public class User {
    int id_user;
    String username;
    String password;
    String email;
    String fullname;
    int id_group;
    String group_name;

    // khai báo tên các cột trong bảng csdl vào thuộc tính tĩnh để gọi tên cho nhanh
    public static final String TB_NAME = "tb_user";
    public static final String COL_ID = "id_user";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_EMAIL = "email";
    public static final String COL_FULLNAME = "fullname";
    public static final String COL_ID_GROUP = "id_group";
    public static final String COL_GROUP_NAME = "group_name";

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String toString(){
        return "ID: "+ id_user + "\n" +
                "Username: "+ username + "\n" +
                "Password: "+ password + "\n" +
                "Email: "+ email + "\n" +
                "ID Group: "+ id_group + "\n" +
                "Group: "+ group_name ;
    }
}
