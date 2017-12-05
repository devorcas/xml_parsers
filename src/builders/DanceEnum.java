/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;


public enum DanceEnum {

    DANCES("dances"),
    DANCE("dance"),
    ID("id"),
    TYPE("type"),
    SCENE("scene"),
    NUMBEROFDANCERS("numberOfDancers"),
    MUSIC("music"),
    NAME("name"),
    AGE("age"),
    EXPERIENCE("experience"),
    NUMBER("number"),
    DANCERS("dancers");

    private String value;

    private DanceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
