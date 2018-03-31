package org.quetzaco.archives.util.boot;

public enum RoleType {
    MANAGER(1l),ARRANGE(2l),DEPT_MANAGER(3l),DEPT_ARRANGE(4l),UPLOAD(5l),EVERYMAN(7l);
    RoleType(Long type){
        this.type= type;
    }
    private Long type;
    public Long getType(){
        return type;
    }
}
