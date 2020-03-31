package co.antiqu.fallenheros.Util;

public enum Permissions {

    USE("fallenheros.admin")
    ;

    private String s;

     Permissions(String s) {
        this.s = s;
     }

     public String getPermission() {
         return s;
     }

}
