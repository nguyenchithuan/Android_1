package net.devmob.crud_user_group.DTO;

public class GroupUser {
    int id_group;
    String name;

    public static final String TB_NAME = "tb_group";
    public static final String COL_ID = "id_group";
    public static final String COL_GROUP_NAME = "name";

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
